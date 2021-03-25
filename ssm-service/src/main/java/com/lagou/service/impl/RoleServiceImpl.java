package com.lagou.service.impl;

import com.lagou.dao.RoleMapper;
import com.lagou.domain.Role;
import com.lagou.domain.RoleMenuVO;
import com.lagou.domain.Role_menu_relation;
import com.lagou.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {

  @Autowired
  private RoleMapper roleMapper;

  @Override
  public List<Role> findAllRole(Role role) {
    List<Role> allRole = roleMapper.findAllRole(role);
    return allRole;
  }

  @Override
  public List<Integer> findMenuByRoleId(Integer roleId) {
    List<Integer> list = roleMapper.findMenuByRoleId(roleId);
    return list;
  }

  @Override
  public void deleteRole(Integer roleId) {
    roleMapper.deleteRoleContextMenu(roleId);
    roleMapper.deleteRole(roleId);
  }

  @Override
  public void roleMenuContext(RoleMenuVO roleMenuVO) {
    roleMapper.deleteRoleContextMenu(roleMenuVO.getRoleId());

    for (Integer mid : roleMenuVO.getRoleMenuList()) {
      Role_menu_relation role_menu_relation = new Role_menu_relation();
      role_menu_relation.setMenuId(mid);
      role_menu_relation.setRoleId(roleMenuVO.getRoleId());
      Date date = new Date();
      role_menu_relation.setCreatedTime(date);
      role_menu_relation.setUpdatedTime(date);
      role_menu_relation.setCreatedBy("system");
      role_menu_relation.setUpdatedby("system");

      roleMapper.addRoleContextMenu(role_menu_relation);
    }
  }
}
