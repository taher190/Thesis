package com.thesis.repository.interfaces;

import com.thesis.model.Faculty;
import com.thesis.model.Topic;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Mustafa Tahir ARSLAN
 */
public interface ITopicRepository extends IAbstractRepository<Topic> {

    List<Topic> retrieveByFaculty(Faculty faculty);
}
