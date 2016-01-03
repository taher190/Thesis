package com.thesis.service;

import com.thesis.model.Faculty;
import com.thesis.model.Topic;
import com.thesis.repository.interfaces.ITopicRepository;
import com.thesis.service.abstracts.AbstractService;
import com.thesis.service.interfaces.ITopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Mustafa Tahir ARSLAN
 */
@Service
public class TopicService extends AbstractService<Topic> implements ITopicService {

    private ITopicRepository topicRepository;

    @Autowired
    public TopicService(ITopicRepository topicRepository) {
        super(topicRepository);
        this.topicRepository = topicRepository;
    }

    @Override
    public List<Topic> retrieveByFaculty(Faculty faculty) {
        return topicRepository.retrieveByFaculty(faculty);
    }
}
