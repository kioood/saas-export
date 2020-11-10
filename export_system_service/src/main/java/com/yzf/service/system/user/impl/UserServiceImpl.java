package com.yzf.service.system.user.impl;

import com.yzf.dao.system.user.IUserDao;
import com.yzf.domain.system.user.User;
import com.yzf.service.system.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    IUserDao iUserDao;

    public User findUserByEmail(String email) {
        return iUserDao.finByEmail(email);
    }


}
