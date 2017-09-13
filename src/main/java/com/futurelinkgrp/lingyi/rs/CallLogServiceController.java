package com.futurelinkgrp.lingyi.rs;

import com.futurelinkgrp.lingyi.serviceImp.GemServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by lchen on 8/20/2017.
 */
@RestController
@RequestMapping(value="/rest")
public class CallLogServiceController {

    /*
    * To Play List:
    * 1. (DONE)make a annotation myself, following http://blog.csdn.net/blueheart20/article/details/45174399
    * 2. (DONE, it will fail either 404 or 500)try remove phoneNumber for path
    * 3. (Done)GemDao's function's return value be other than int? - No, it must be int. Cant be String at least.
    * 4. (Done)Why GemService dosent have @Repository? or on the other hand, why GemMapper has @Service? - They dont need that
    * annotation at all.
    * 5. the main class, can we remove exclude = {DataSourceAutoConfiguration.class,DataSourceTransactionManagerAutoConfiguration.class}
    * 6. Can we merge all classes in config folder into GemCcPlusCalllogWsApplication, sicne SpringBootApplication annotation
    * include @configuration
    * 7. Can we not include WebAppConfig
    * 8. Can we remove fastJsonHttpMessageConverters
    * 9. I already removed new self designed annotation on ApplicationConfig
    * 10. @ResponseBody Boolean insertPhoneNumber can throw an exception ? how is it captured in RESTED
    * 11. how the test works?
    * 12. Logback doesnt work??
    * */
    @Autowired
    private GemServiceImp gemService;

    @RequestMapping(value = "/insertPhoneNumber/{phoneNumber}", method = RequestMethod.GET, produces = "text/plain; " +
            "charset=UTF-8")
    @ResponseStatus(value= HttpStatus.OK)
    public @ResponseBody Boolean insertPhoneNumber(@PathVariable("phoneNumber") String phoneNumber) throws Exception{
        Boolean result = false;
        if(phoneNumber.length() == 10) {
            result = gemService.insertPhoneNumber(phoneNumber);
        } else {
            throw new Exception("msg");
        }

        return result;
    }
}
