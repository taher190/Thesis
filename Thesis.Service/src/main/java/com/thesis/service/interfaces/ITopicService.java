package com.thesis.service.interfaces;

import com.thesis.model.Faculty;
import com.thesis.model.Topic;

import java.util.List;

/**
 * Created by Mustafa Tahir ARSLAN
 */
public interface ITopicService extends IAbstractService<Topic> {

    List<Topic> retrieveByFaculty(Faculty faculty);
}
