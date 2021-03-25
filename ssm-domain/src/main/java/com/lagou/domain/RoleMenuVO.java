package com.lagou.domain;

import java.util.List;

public class RoleMenuVO {

  private Integer roleId;

  private List<Integer> roleMenuList;

  public Integer getRoleId() {
    return roleId;
  }

  public void setRoleId(Integer roleId) {
    this.roleId = roleId;
  }

  public List<Integer> getRoleMenuList() {
    return roleMenuList;
  }

  public void setRoleMenuList(List<Integer> roleMenuList) {
    this.roleMenuList = roleMenuList;
  }
}
