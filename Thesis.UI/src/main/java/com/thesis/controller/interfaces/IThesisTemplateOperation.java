package com.thesis.controller.interfaces;

import com.thesis.model.Topic;

import java.util.List;

/**
 * Created by Mustafa Tahir ARSLAN
 */
public interface IThesisTemplateOperation {

    void save();

    void update();

    void delete();

    List<Topic> getTopicList();

    List<Topic> getSelectedTopicList();
}
