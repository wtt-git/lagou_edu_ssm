package com.lagou.dao;

import com.lagou.domain.Menu;

import java.util.List;

public interface MenuMapper {

  public List<Menu> findSubMenuListByPid(Integer pid);

  public List<Menu> findAllMenu();

  public List<Menu> findMenuById(Integer id);
}
