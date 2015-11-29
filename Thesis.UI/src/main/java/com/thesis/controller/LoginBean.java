package com.thesis.controller;

import com.thesis.model.Faculty;
import com.thesis.model.Role;
import com.thesis.model.Student;
import com.thesis.repository.interfaces.IFacultyRepository;
import com.thesis.service.interfaces.IFacultyService;
import com.thesis.service.interfaces.IRoleService;
import com.thesis.service.interfaces.IStudentService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Mustafa Tahir ARSLAN.
 */
@ManagedBean
@RequestScoped
public class LoginBean {

    @ManagedProperty("#{studentService}")
    private IStudentService studentService;

    @ManagedProperty("#{facultyService}")
    private IFacultyService facultyService;

    @ManagedProperty("#{roleService}")
    private IRoleService roleService;

    @PostConstruct
    public void init() {
        Faculty faculty = new Faculty();
        faculty.setName("Mühendislik Fakültesi");
        faculty.setCode("01");
        facultyService.save(faculty);

        Role role = new Role();
        role.setCode("ROLE_USER");
        roleService.save(role);

        Set<Role> roleSet = new HashSet<Role>();
        roleSet.add(role);

        Student student = new Student();
        student.setStudentNumber("2009010207044");
        student.setFaculty(faculty);
        student.setRoleSet(roleSet);
        studentService.save(student);
    }

    public String getName() {
        return "Hi!";
    }

    public IFacultyService getFacultyService() {
        return facultyService;
    }

    public void setFacultyService(IFacultyService facultyService) {
        this.facultyService = facultyService;
    }

    public IStudentService getStudentService() {
        return studentService;
    }

    public void setStudentService(IStudentService studentService) {
        this.studentService = studentService;
    }

    public IRoleService getRoleService() {
        return roleService;
    }

    public void setRoleService(IRoleService roleService) {
        this.roleService = roleService;
    }
}
