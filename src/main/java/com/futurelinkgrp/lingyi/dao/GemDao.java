package com.futurelinkgrp.lingyi.dao;

import com.futurelinkgrp.lingyi.mapper.GemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lchen on 8/20/2017.
 */
@Service
public class GemDao {
    @Autowired
    private GemMapper gemMapper;

    public int insertPhoneNumber(String phoneNumber){
        return gemMapper.insertPhoneNumber(phoneNumber);
    }

}
