package com.lagou.service.impl;

import com.lagou.dao.MenuMapper;
import com.lagou.domain.Menu;
import com.lagou.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MenuServiceImpl implements MenuService {

  @Autowired
  private MenuMapper menuMapper;

  @Override
  public List<Menu> findAllMenu() {
    List<Menu> allMenuList = menuMapper.findAllMenu();
    return allMenuList;
  }

  @Override
  public List<Menu> findSubMenuListByPid(Integer pid) {
    List<Menu> menuList = menuMapper.findSubMenuListByPid(pid);
    return menuList;
  }

  @Override
  public List<Menu> findMenuById(Integer id) {
    return menuMapper.findMenuById(id);
  }
}
