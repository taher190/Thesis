package com.thesis.service;

import com.thesis.model.*;
import com.thesis.repository.interfaces.IThesisRepository;
import com.thesis.service.abstracts.AbstractService;
import com.thesis.service.interfaces.IThesisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Mustafa Tahir ARSLAN
 */
@Service
public class ThesisService extends AbstractService<Thesis> implements IThesisService {

    private IThesisRepository thesisRepository;

    @Autowired
    public ThesisService(IThesisRepository thesisRepository) {
        super(thesisRepository);
        this.thesisRepository = thesisRepository;
    }

    @Override
    public void createThesisWithActivity(ThesisAppeal thesisAppeal) {
        int numberOfWeek = thesisAppeal.getThesisTemplate().getSeason().getNumberOfWeek();
        Date startDate = thesisAppeal.getThesisTemplate().getSeason().getStartDate();
        List<StudentActivity> studentActivityList = new ArrayList<StudentActivity>();

        Thesis thesis = new Thesis();
        thesis.setStudent(thesisAppeal.getStudent());
        thesis.setThesisTemplate(thesisAppeal.getThesisTemplate());

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);

        for(int counterOfWeek = 0; counterOfWeek < numberOfWeek ;counterOfWeek++) {
            StudentActivity studentActivity = new StudentActivity();
            studentActivity.setStartDate(calendar.getTime());
            studentActivity.setThesis(thesis);

            calendar.add(Calendar.WEEK_OF_YEAR, 1);
            studentActivity.setEndDate(calendar.getTime());
            studentActivityList.add(studentActivity);
        }
        thesis.setStudentActivityList(studentActivityList);
        super.save(thesis);
    }

    @Override
    public List<Thesis> retrieveCurrentThesis(Student student) {
        return thesisRepository.retrieveCurrentThesis(student);
    }

    @Override
    public List<Thesis> retrieveCurrentThesis(ThesisManager thesisManager) {
        return thesisRepository.retrieveCurrentThesis(thesisManager);
    }
}
