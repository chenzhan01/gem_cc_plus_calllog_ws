package com.futurelinkgrp.lingyi.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

/**
 * Created by lchen on 8/20/2017.
 */

public interface GemMapper {
    @Insert("INSERT INTO DAILY_EXCL_PHONE_NUMBER(EXCL_ID,PHONE_NUMBER,EFFECTIVE_DATE) VALUES(DAILY_EXCL_ID_SEQ.NEXTVAL," +
            "#{phoneNumber},SYSDATE)")
    public int insertPhoneNumber(@Param("phoneNumber") String phoneNumber);
}
