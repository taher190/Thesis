package com.thesis.model;

import com.thesis.model.abstracts.User;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by Mustafa Tahir ARSLAN
 */
@Entity
@DiscriminatorValue("3")
public class Admin extends User<Admin> {
}
