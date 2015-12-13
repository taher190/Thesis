package com.thesis.model;

import com.thesis.model.abstracts.User;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by Mustafa Tahir ARSLAN
 */
@Entity
@DiscriminatorValue("1")
public class Student extends User<Student> {
}
