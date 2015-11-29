package com.thesis.repository;

import com.thesis.model.Faculty;
import com.thesis.repository.interfaces.IFacultyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Mustafa Tahir ARSLAN.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath*:applicationContext.xml")
public class FacultyRepositoryTest {

    @Autowired
    private IFacultyRepository facultyRepository;

    @Test
    public void testSave() {
        Faculty faculty = new Faculty();
        faculty.setCode("02");
        faculty.setName("Mühendislik Fakültesi");
        facultyRepository.save(faculty);
    }
}
