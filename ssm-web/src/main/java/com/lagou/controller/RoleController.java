package com.lagou.controller;

import com.lagou.domain.Menu;
import com.lagou.domain.ResponseResult;
import com.lagou.domain.Role;
import com.lagou.domain.RoleMenuVO;
import com.lagou.service.MenuService;
import com.lagou.service.RoleService;
import org.graalvm.compiler.hotspot.nodes.aot.ResolveConstantNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/pri/role")
public class RoleController {

  @Autowired
  private RoleService roleService;

  @Autowired
  private MenuService menuService;

  @RequestMapping("/findAllRole")
  public ResponseResult findAllRole(@RequestBody Role role){
    List<Role> allRole = roleService.findAllRole(role);
    return new ResponseResult(true,200,"查询角色信息（条件）成功",allRole);
  }

  @RequestMapping("/findAllMenus")
  public ResponseResult findSubMenuListByPid(){
    List<Menu> menuList = menuService.findSubMenuListByPid(-1);

    Map<String, Object> map = new HashMap<>();
    map.put("parentMenuList",menuList);

    return new ResponseResult(true,200,"查询所有菜单节点成功",map);
  }

  @RequestMapping("/findMenuByRoleId")
  public ResponseResult findMenuByRoleId(@RequestParam Integer roleId){
    List<Integer> list = roleService.findMenuByRoleId(roleId);
    return new ResponseResult(true,200,"根据roleId查询菜单",list);
  }

  @RequestMapping("/roleMenuContext")
  public ResponseResult RoleMenuContext(@RequestBody RoleMenuVO roleMenuVO){
    roleService.roleMenuContext(roleMenuVO);
    return new ResponseResult(true,200,"分配用户菜单成功",null);
  }

  @RequestMapping("deleteRole")
  public ResponseResult deleteRole(@RequestParam Integer roleId){
    roleService.deleteRole(roleId);
    return new ResponseResult(true,200,"删除角色成功",null);
  }

}
