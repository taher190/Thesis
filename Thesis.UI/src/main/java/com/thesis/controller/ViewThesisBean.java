package com.thesis.controller;

import com.thesis.controller.abstracts.AbstractBean;
import com.thesis.enums.OperationType;
import com.thesis.exception.StudentActivityNotFoundException;
import com.thesis.model.Student;
import com.thesis.model.StudentActivity;
import com.thesis.model.StudentActivityComment;
import com.thesis.model.Thesis;
import com.thesis.model.abstracts.User;
import com.thesis.service.interfaces.IStudentActivityService;
import com.thesis.service.interfaces.IThesisService;
import com.thesis.statics.URLUtil;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.DoubleRange;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.*;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Mustafa Tahir ARSLAN
 */
@ManagedBean
@ViewScoped
public class ViewThesisBean extends AbstractBean {

    private final Logger logger = LoggerFactory.getLogger(ViewThesisBean.class.getName());

    @ManagedProperty("#{thesisService}")
    private IThesisService thesisService;

    @ManagedProperty("#{studentActivityService}")
    private IStudentActivityService studentActivityService;

    private Thesis thesis;
    private StudentActivity selectedStudentActivity;

    private String currentCommentText;
    private UploadedFile file;
    private Double averageOfAllWeeks;

    public void init() {
        if(getThesis() != null) {
            return;
        }
        Map requestMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Long thesisId = Long.parseLong(requestMap.get("thesis_id").toString());
        setThesis(thesisService.retrieveById(thesisId));
        averageOfAllWeeks = thesisService.averageOfAllWeeks(thesis);
    }

    public void selectStudentActivity() {
        Map requestMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Long param = Long.parseLong(requestMap.get("studentActivityId").toString());
        setSelectedStudentActivity(findStudentActivityFromThesis(param));
    }

    private StudentActivity findStudentActivityFromThesis(Long studentActivityId) {
        for(StudentActivity studentActivity : getThesis().getStudentActivityList()) {
            if(studentActivity.getId().equals(studentActivityId)) {
                return studentActivity;
            }
        }
        throw new StudentActivityNotFoundException();
    }

    //FIXME : Comment eklendiğinde kapatılmazsa panel katlanarak gidiyor.
    public void putComment() {
        User user = getLoggedInUser();
        StudentActivityComment studentActivityComment = new StudentActivityComment();
        studentActivityComment.setText(currentCommentText);
        studentActivityComment.setStudentActivity(getSelectedStudentActivity());
        studentActivityComment.setUser(user);
        studentActivityComment.setSaw(false);
        studentActivityComment.setCreatedDate(new Date());

        getSelectedStudentActivity().getStudentActivityCommentList().add(studentActivityComment);
        studentActivityService.update(getSelectedStudentActivity());

        putNotificationRepo(getOtherUser(user), user, OperationType.NEW_COMMENT
                , currentCommentText);
        currentCommentText = StringUtils.EMPTY;
    }

    private User getOtherUser(User user) {
        if(user instanceof Student){
            return thesis.getThesisTemplate().getThesisManager();
        } else {
            return thesis.getStudent();
        }
    }

    public void evaluate(){
        studentActivityService.update(selectedStudentActivity);
        showMessage("Puan atama işlemi başarılı!");
    }

    public void fileUploadListener(FileUploadEvent fileUploadEvent) throws IOException {
        setFile(fileUploadEvent.getFile());
        try {
            String fileName = UUID.randomUUID().toString();
            copyFile(fileName, fileUploadEvent.getFile().getInputstream());
            String origFileName = fileUploadEvent.getFile().getFileName();
            String extension = FilenameUtils.getExtension(origFileName);
            if("JPEG".equalsIgnoreCase(extension) || "JPG".equalsIgnoreCase(extension)) {
                getSelectedStudentActivity().setPosterName(fileName);
            } else if ("ZIP".equalsIgnoreCase(extension)) {
                getSelectedStudentActivity().setCodeName(fileName);
            } else if ("PDF".equalsIgnoreCase(extension)) {
                getSelectedStudentActivity().setDocumentName(fileName);
            }
            studentActivityService.update(getSelectedStudentActivity());
            putNotificationRepo(thesis.getThesisTemplate().getThesisManager(), thesis.getStudent(), OperationType.UPLOAD_FILE
                    , "");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void copyFile(String fileName, InputStream in) {
        try {
            String appPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/");
            File file = new File(appPath + URLUtil.PDF_PATH + fileName);
            OutputStream out = new FileOutputStream(file);

            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = in.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }

            in.close();
            out.flush();
            out.close();
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    public void deleteDocument() {
        getSelectedStudentActivity().setDocumentName(null);
        studentActivityService.update(getSelectedStudentActivity());
    }

    public void deleteCode() {
        getSelectedStudentActivity().setCodeName(null);
        studentActivityService.update(getSelectedStudentActivity());
    }

    public void deletePoster() {
        getSelectedStudentActivity().setPosterName(null);
        studentActivityService.update(getSelectedStudentActivity());
    }

    public void performReadAllComments() {
        User user = getLoggedInUser();
        for(StudentActivityComment studentActivityComment : getSelectedStudentActivity().getStudentActivityCommentList()) {
            if(!studentActivityComment.getUser().equals(user)) {
                studentActivityComment.setSaw(true);
            }
        }
        studentActivityService.update(getSelectedStudentActivity());
    }

    public boolean isRenderSawMessage(StudentActivityComment studentActivityComment) {
        User user = getLoggedInUser();
        return !user.equals(studentActivityComment.getUser()) && studentActivityComment.getSaw();
    }

    public String getRowStyle(StudentActivity studentActivity, Boolean lastWeek) {
        if(lastWeek) {
            return "student_activity_last_week";
        }
        if(studentActivity.getLoadDocument()) {
            return "student_activity_enable";
        } else {
            return "student_activity_disable";
        }
    }

    public IThesisService getThesisService() {
        return thesisService;
    }

    public void setThesisService(IThesisService thesisService) {
        this.thesisService = thesisService;
    }

    public Thesis getThesis() {
        return thesis;
    }

    public void setThesis(Thesis thesis) {
        this.thesis = thesis;
    }

    public StudentActivity getSelectedStudentActivity() {
        return selectedStudentActivity;
    }

    public void setSelectedStudentActivity(StudentActivity selectedStudentActivity) {
        this.selectedStudentActivity = selectedStudentActivity;
    }

    public String getCurrentCommentText() {
        return currentCommentText;
    }

    public void setCurrentCommentText(String currentCommentText) {
        this.currentCommentText = currentCommentText;
    }

    public IStudentActivityService getStudentActivityService() {
        return studentActivityService;
    }

    public void setStudentActivityService(IStudentActivityService studentActivityService) {
        this.studentActivityService = studentActivityService;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public void setAverageOfAllWeeks(Double averageOfAllWeeks) {
        this.averageOfAllWeeks = averageOfAllWeeks;
    }

    public Double getAverageOfAllWeeks() {
        return averageOfAllWeeks;
    }
}
