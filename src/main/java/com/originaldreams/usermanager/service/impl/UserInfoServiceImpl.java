package com.originaldreams.usermanager.service.impl;

import com.originaldreams.common.response.MyServiceResponse;
import com.originaldreams.usermanager.mapper.UserInfoMapper;
import com.originaldreams.usermanager.service.UserInfoService;
import com.originaldreams.usermanagercenter.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public MyServiceResponse getById(Integer id) {
        if(id == null){
            return new MyServiceResponse(MyServiceResponse.SUCCESS_CODE_FAILED,"用户ID为空");
        }
        return new MyServiceResponse(userInfoMapper.getById(id));
    }


    @Override
    public List<UserInfo> getAll(){
        return userInfoMapper.getAll();
    }

    public Integer deleteById(Integer id){
        return userInfoMapper.deleteById(id);
    }

    @Override
    public Integer update(UserInfo userInfo) {
        return userInfoMapper.update(userInfo);
    }


}
