package com.lagou.dao;

import com.lagou.domain.Role;
import com.lagou.domain.User;
import com.lagou.domain.UserVO;
import com.lagou.domain.User_Role_relation;

import java.util.List;

public interface UserMapper {

  public List<User> findAllUserByPage(UserVO userVO);

  public User login(User user);

  public List<Role> findUserRelationRoleById(Integer id);

  public void deleteUserContextRole(Integer userId);

  public void userContextRole(User_Role_relation user_role_relation);

}
