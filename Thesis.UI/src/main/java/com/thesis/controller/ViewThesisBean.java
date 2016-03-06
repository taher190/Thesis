package com.thesis.controller;

import com.thesis.controller.abstracts.AbstractBean;
import com.thesis.exception.StudentActivityNotFoundException;
import com.thesis.model.StudentActivity;
import com.thesis.model.StudentActivityComment;
import com.thesis.model.Thesis;
import com.thesis.service.interfaces.IStudentActivityService;
import com.thesis.service.interfaces.IThesisService;
import com.thesis.statics.URLUtil;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
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

    public void init() {
        if(getThesis() != null) {
            return;
        }
        Map requestMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Long thesisId = Long.parseLong(requestMap.get("thesis_id").toString());
        setThesis(thesisService.retrieveById(thesisId));
    }

    public void selectStudentActivity() {
        Map requestMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Long param = Long.parseLong(requestMap.get("studentActivityId").toString());
        setSelectedStudentActivity(findStudentActivityFromThesis(param));
    }

    //TODO : Bu fonksiyonun mockito ile testini yaz.
    private StudentActivity findStudentActivityFromThesis(Long studentActivityId) {
        for(StudentActivity studentActivity : getThesis().getStudentActivityList()) {
            if(studentActivity.getId() == studentActivityId) {
                return studentActivity;
            }
        }
        throw new StudentActivityNotFoundException();
    }

    //FIXME : Comment eklendiğinde kapatılmazsa panel katlanarak gidiyor.
    public void putComment() {
        StudentActivityComment studentActivityComment = new StudentActivityComment();
        studentActivityComment.setText(currentCommentText);
        studentActivityComment.setStudentActivity(getSelectedStudentActivity());
        studentActivityComment.setUser(getLoggedInUser());
        studentActivityComment.setCreatedDate(new Date());

        getSelectedStudentActivity().getStudentActivityCommentList().add(studentActivityComment);
        studentActivityService.update(getSelectedStudentActivity());

        currentCommentText = StringUtils.EMPTY;
    }

    public void fileUploadListener(FileUploadEvent fileUploadEvent) throws IOException {
        setFile(fileUploadEvent.getFile());
        try {
            String fileName = UUID.randomUUID().toString();
            copyFile(fileName, fileUploadEvent.getFile().getInputstream());
            getSelectedStudentActivity().setLoadDocument(Boolean.TRUE);
            getSelectedStudentActivity().setDocumentName(fileName);
            studentActivityService.update(getSelectedStudentActivity());
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

    public void deleteFile() {
        getSelectedStudentActivity().setLoadDocument(Boolean.FALSE);
        getSelectedStudentActivity().setDocumentName(null);
        studentActivityService.update(getSelectedStudentActivity());
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
}
