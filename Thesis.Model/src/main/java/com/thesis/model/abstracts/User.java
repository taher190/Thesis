package com.thesis.model.abstracts;

import com.thesis.model.Role;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Mustafa Tahir ARSLAN.
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(
        name = "discriminator",
        discriminatorType = DiscriminatorType.INTEGER
)
@DiscriminatorValue("0")
@Table(name = "users")
public class User<T> extends AbstractEntity<User> {

    private String name;

    private String surname;

    @Column(unique = true)
    private String entryVal;

    private String password;

    private Boolean active;

    @OneToMany
    @JoinTable(name = "user_role",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "role_id") })
    private List<Role> roleList;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getEntryVal() {
        return entryVal;
    }

    public void setEntryVal(String entryVal) {
        this.entryVal = entryVal;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }
}
