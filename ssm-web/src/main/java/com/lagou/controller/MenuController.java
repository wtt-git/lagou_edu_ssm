package com.lagou.controller;

import com.lagou.domain.Menu;
import com.lagou.domain.ResponseResult;
import com.lagou.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/pub/menu")
public class MenuController {

  @Autowired
  private MenuService menuService;

  @RequestMapping("/findAllMenu")
  public ResponseResult findAllMenu(){
    List<Menu> allMenuList = menuService.findAllMenu();
    return new ResponseResult(true,200,"查询所有菜单信息成功",allMenuList);
  }

  @RequestMapping("/findMenuInfoById")
  public ResponseResult findMenuInfoById(@RequestParam Integer id){
    if(id == -1){
      List<Menu> subMenuListByPid = menuService.findSubMenuListByPid(-1);
      Map<String, Object> map = new HashMap<>();
      map.put("menuInfo",null);
      map.put("parentMenuList",subMenuListByPid);

      return new ResponseResult(true,200,"添加菜单回显成功",map);
    }else {
      List<Menu> menu = menuService.findMenuById(id);
      List<Menu> subMenuListByPid = menuService.findSubMenuListByPid(id);
      Map<String, Object> map = new HashMap<>();
      map.put("menuInfo",menu);
      map.put("parentMenuList",subMenuListByPid);

      return new ResponseResult(true,200,"修改菜单回显成功",map);
    }
  }
}
