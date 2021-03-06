package com.originaldreams.usermanager.controller;

import com.originaldreams.common.response.MyResponse;
import com.originaldreams.usermanager.service.UserInfoService;
import com.originaldreams.usermanagercenter.entity.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 杨凯乐
 * @date 2018-07-30 09:16:35
 */
@RestController
@RequestMapping("/api/v1/userInfo")
public class UserInfoController {

    private static final Logger logger = LoggerFactory.getLogger(UserInfoController.class);

    @Resource
    private UserInfoService userInfoService;

    /**
     * 查询用户信息
     * @param userId
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity get(Integer userId){
        if(userId == null){
            return MyResponse.badRequest();
        }
        return MyResponse.ok(userInfoService.getById(userId));
    }

    @RequestMapping(method = RequestMethod.PUT)
    ResponseEntity put(UserInfo userInfo){
        Integer result = userInfoService.update(userInfo);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(result);
    }

}
