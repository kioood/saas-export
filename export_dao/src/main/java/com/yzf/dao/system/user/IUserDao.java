package com.yzf.dao.system.user;

import com.yzf.domain.system.user.User;

public interface IUserDao {
    User finByEmail(String email);
}
