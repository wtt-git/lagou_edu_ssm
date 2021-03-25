package com.lagou.service;

import com.lagou.domain.Role;
import com.lagou.domain.RoleMenuVO;

import java.util.List;

public interface RoleService {

  public List<Role> findAllRole(Role role);

  public List<Integer> findMenuByRoleId(Integer roleId);

  public void roleMenuContext(RoleMenuVO roleMenuVO);

  public void deleteRole(Integer roleId);

}
