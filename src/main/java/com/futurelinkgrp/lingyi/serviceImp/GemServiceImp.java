package com.futurelinkgrp.lingyi.serviceImp;

import com.futurelinkgrp.lingyi.dao.GemDao;
import com.futurelinkgrp.lingyi.service.GemService;
import com.futurelinkgrp.lingyi.util.GemConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lchen on 8/20/2017.
 */
@Service
public class GemServiceImp implements GemService{

    @Autowired
    private GemDao gemDao;
    private static final Logger logger = LoggerFactory.getLogger(GemServiceImp.class);
    public Boolean insertPhoneNumber(String phoneNumber){
        logger.info("insertPhoneNumber start");
        Boolean result = GemConstants.RESULT_TRUE;
        int cnt = gemDao.insertPhoneNumber(phoneNumber);
        if (cnt == 0) {
            result = GemConstants.RESULT_FALSE;
        }
        return result;
    }
}
