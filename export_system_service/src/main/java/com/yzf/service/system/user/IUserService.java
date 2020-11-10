package com.yzf.service.system.user;

import com.yzf.domain.system.user.User;

public interface IUserService {
    User findUserByEmail(String email);
}
