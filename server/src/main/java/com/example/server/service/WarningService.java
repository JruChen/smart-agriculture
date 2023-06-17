package com.example.server.service;

import com.example.server.dao.WarningDao;
import com.example.server.dao.bo.Warning;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarningService {
    private WarningDao warningDao;

    @Autowired
    public WarningService(WarningDao warningDao){
        this.warningDao = warningDao;
    }

    public List<Warning> retrieveAllWarnings(){
        return this.warningDao.retrieveAll();
    }


}
