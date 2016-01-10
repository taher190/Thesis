package com.thesis.service;

import com.thesis.model.Title;
import com.thesis.repository.interfaces.ITitleRepository;
import com.thesis.service.abstracts.AbstractService;
import com.thesis.service.interfaces.ITitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * Created by Mustafa Tahir ARSLAN
 */
@Service
public class TitleService extends AbstractService<Title> implements ITitleService {

    @Autowired
    public TitleService(ITitleRepository titleRepository) {
        super(titleRepository);
    }
}
