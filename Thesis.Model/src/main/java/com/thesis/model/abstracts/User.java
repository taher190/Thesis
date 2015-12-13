package com.thesis.model.abstracts;

import javax.persistence.*;

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
public class User<T> extends AbstractEntity<User> {

    private String name;

    private String surname;

    @Column(unique = true)
    private String entryVal;

    private String password;

    private Boolean active;

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
}
