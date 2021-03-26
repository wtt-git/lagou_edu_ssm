package com.lagou.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lagou.dao.UserMapper;
import com.lagou.domain.*;
import com.lagou.service.UserService;
import com.lagou.utils.Md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserMapper userMapper;

  @Override
  public PageInfo findAllUserByPage(UserVO userVO) {
    PageHelper.startPage(userVO.getCurrentPage(),userVO.getPageSize());
    List<User> list = userMapper.findAllUserByPage(userVO);
    PageInfo<User> userPageInfo = new PageInfo<>(list);

    return userPageInfo;
  }

  @Override
  public User login(User user) throws Exception {
    User userLogin = userMapper.login(user);
    if(userLogin != null && Md5.verify(user.getPassword(),"lagou",userLogin.getPassword())){
      return userLogin;
    }else {
      return null;
    }
  }

  @Override
  public List<Role> findUserRelationRoleById(Integer id) {
    List<Role> list = userMapper.findUserRelationRoleById(id);
    return list;
  }

  @Override
  public void userContextRole(UserVO userVO) {
    userMapper.deleteUserContextRole(userVO.getUserId());

    for (Integer roleId : userVO.getRoleIdList()) {
      User_Role_relation user_role_relation = new User_Role_relation();
      user_role_relation.setUserId(userVO.getUserId());
      user_role_relation.setRoleId(roleId);
      Date date = new Date();
      user_role_relation.setCreatedTime(date);
      user_role_relation.setUpdatedTime(date);
      user_role_relation.setCreatedBy("system");
      user_role_relation.setUpdatedBy("system");
      userMapper.userContextRole(user_role_relation);
    }
  }

  @Override
  public ResponseResult getUserPermissions(Integer userId) {
    List<Role> roleList = userMapper.findUserRelationRoleById(userId);
    List<Integer> roleIds = new ArrayList<>();
    for (Role role : roleList) {
      roleIds.add(role.getId());
    }
    List<Menu> parentMenu = userMapper.findParentMenuByRoleId(roleIds);
    for (Menu menu : parentMenu) {
      List<Menu> subMenu = userMapper.findSubMenuByPid(menu.getId());
      menu.setSubMenuList(subMenu);
    }
    List<Resource> resourceList = userMapper.findResourceByRoleId(roleIds);
    Map<String, Object> map = new HashMap<>();
    map.put("menuList",parentMenu);
    map.put("resourceList",resourceList);
    return new ResponseResult(true,200,"获取用户权限成功",map);
  }

  @Override
  public void register(User user) throws Exception {
    user.setPassword(Md5.md5(user.getPassword(),"lagou"));
    Date date = new Date();
    user.setCreate_time(date);
    user.setUpdate_time(date);
    userMapper.register(user);
  }
}
