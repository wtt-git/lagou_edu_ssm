package com.lagou.service;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.Role;
import com.lagou.domain.User;
import com.lagou.domain.UserVO;

import java.util.List;

public interface UserService {

  public PageInfo findAllUserByPage(UserVO userVO);

  public User login(User user) throws Exception;

  public List<Role> findUserRelationRoleById(Integer id);

  public void userContextRole(UserVO userVO);
}
