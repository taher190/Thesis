package com.thesis.controller.util;

import com.thesis.controller.abstracts.AbstractBean;
import com.thesis.model.*;
import com.thesis.service.interfaces.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mustafa Tahir ARSLAN
 */
@ManagedBean(eager = true)
@ApplicationScoped
public class ApplicationBean extends AbstractBean {

    private final Logger logger = LoggerFactory.getLogger(ApplicationBean.class.getName());

    @ManagedProperty("#{facultyService}")
    private IFacultyService facultyService;

    @ManagedProperty("#{departmentService}")
    private IDepartmentService departmentService;

    @ManagedProperty("#{titleService}")
    private ITitleService titleService;

    @ManagedProperty("#{userService}")
    private IUserService userService;

    @ManagedProperty("#{roleService}")
    private IRoleService roleService;

    private List<Faculty> facultyList;

    private List<Department> departmentList;
    private List<Title> titleList;
    @PostConstruct
    public void init() {
        try {
            if(!checkLoadStartupData()) {
                logger.info("Startup data is loading...");
                initStartupData();
            }

            setFacultyList(facultyService.retrieveAll());
            setDepartmentList(departmentService.retrieveAll());
            setTitleList(titleService.retrieveAll());
        } catch (Exception ex) {
            logger.error("ApplicationBean class failed, result: {}", ex.getMessage());
            ex.printStackTrace();
        }
    }

    private boolean checkLoadStartupData() {
        return !CollectionUtils.isEmpty(facultyService.retrieveAll());
    }

    private void initStartupData() {
        Faculty m = new Faculty();
        m.setCode("MUH");
        m.setName("Mühendislik Fakültesi");

        List<Department> departmentList = new ArrayList<Department>();

        Department bm = new Department();
        bm.setName("Bilgisayar Mühendisliği");
        bm.setCode("BM");
        bm.setFaculty(m);

        Department em = new Department();
        em.setName("Elektronik Mühendisliği");
        em.setCode("EM");
        em.setFaculty(m);

        departmentList.add(bm);
        departmentList.add(em);

        m.setDepartmentList(departmentList);

        facultyService.save(m);

        Role adminRole = new Role();
        adminRole.setCode("ROLE_ADMIN");

        Role thesisManagerRole = new Role();
        thesisManagerRole.setCode("ROLE_THESIS_MANAGER");

        Role studentRole = new Role();
        studentRole.setCode("ROLE_STUDENT");

        Role userRole = new Role();
        userRole.setCode("ROLE_USER");

        roleService.save(adminRole);
        roleService.save(thesisManagerRole);
        roleService.save(studentRole);
        roleService.save(userRole);

        Student john = new Student();
        john.setActive(true);
        john.setName("John");
        john.setSurname("Wick");
        john.setPassword("12345");
        john.setEntryVal("john");
        john.setFaculty(m);
        john.setDepartment(bm);

        List<UserRole> userRoleList = new ArrayList<UserRole>();

        UserRole userRoleStudent = new UserRole();
        userRoleStudent.setRole(studentRole);
        userRoleStudent.setUser(john);

        UserRole userRoleStudent1 = new UserRole();
        userRoleStudent1.setRole(userRole);
        userRoleStudent1.setUser(john);

        userRoleList.add(userRoleStudent);
        userRoleList.add(userRoleStudent1);
        john.setUserRoleList(userRoleList);

        //---

        userService.save(john);

        Title prof = new Title();
        prof.setName("Prof.");

        Title doc = new Title();
        doc.setName("Doc.");

        titleService.save(prof);
        titleService.save(doc);

        //---

        ThesisManager thesisManager = new ThesisManager();
        thesisManager.setFaculty(m);
        thesisManager.setDepartment(bm);
        thesisManager.setName("Recep");
        thesisManager.setSurname("İvedik");
        thesisManager.setActive(true);
        thesisManager.setEntryVal("recep");
        thesisManager.setPassword("12345");
        thesisManager.setTitle(prof);

        List<UserRole> userRoleList2 = new ArrayList<UserRole>();

        UserRole userRoleThesisManager = new UserRole();
        userRoleThesisManager.setRole(thesisManagerRole);
        userRoleThesisManager.setUser(thesisManager);

        UserRole userRoleStudent2 = new UserRole();
        userRoleStudent2.setRole(userRole);
        userRoleStudent2.setUser(thesisManager);

        userRoleList2.add(userRoleThesisManager);
        userRoleList2.add(userRoleStudent2);
        thesisManager.setUserRoleList(userRoleList2);

        userService.save(thesisManager);
    }

    public List<Faculty> getFacultyList() {
        return facultyList;
    }

    public void setFacultyList(List<Faculty> facultyList) {
        this.facultyList = facultyList;
    }

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    public IFacultyService getFacultyService() {
        return facultyService;
    }

    public void setFacultyService(IFacultyService facultyService) {
        this.facultyService = facultyService;
    }

    public IDepartmentService getDepartmentService() {
        return departmentService;
    }

    public void setDepartmentService(IDepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    public ITitleService getTitleService() {
        return titleService;
    }

    public void setTitleService(ITitleService titleService) {
        this.titleService = titleService;
    }

    public IUserService getUserService() {
        return userService;
    }

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    public List<Title> getTitleList() {
        return titleList;
    }

    public void setTitleList(List<Title> titleList) {
        this.titleList = titleList;
    }

    public IRoleService getRoleService() {
        return roleService;
    }

    public void setRoleService(IRoleService roleService) {
        this.roleService = roleService;
    }
}
