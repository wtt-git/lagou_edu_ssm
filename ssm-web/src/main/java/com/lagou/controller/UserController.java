package com.lagou.controller;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.ResponseResult;
import com.lagou.domain.Role;
import com.lagou.domain.User;
import com.lagou.domain.UserVO;
import com.lagou.service.UserService;
import com.lagou.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/pub/User")
public class UserController {

  @Autowired
  private UserService userService;

  @RequestMapping("/findAllUserByPage")
  public ResponseResult findAllUserByPage(@RequestBody UserVO userVO){
    PageInfo allUserByPage = userService.findAllUserByPage(userVO);
    return new ResponseResult(true,200,"分页多条件查询用户信息",allUserByPage);

  }

  @RequestMapping("/login")
  public ResponseResult login(@RequestBody User user, HttpServletRequest request) throws Exception {
    User loginUser = userService.login(user);
    if(loginUser != null){
      HttpSession session = request.getSession();
      String access_token = UUID.randomUUID().toString();
      session.setAttribute("access_token", access_token);
      session.setAttribute("user_id",loginUser.getId());

      Map<String, Object> map = new HashMap<>();
      map.put("access_token", access_token);
      map.put("user_id", loginUser.getId());
      map.put("user",loginUser);

      return new ResponseResult(true,1,"登录成功",map);
    }else {
      return new ResponseResult(true,400,"用户名或密码错误",null);
    }
  }


  @RequestMapping("/findUserRoleById")
  public ResponseResult findUserRelationRoleById(@RequestParam Integer id){
    List<Role> list = userService.findUserRelationRoleById(id);
    return new ResponseResult(true,200,"用户角色信息回显成功",list);

  }


  @RequestMapping("/userContextRole")
  public ResponseResult userContextRole(@RequestBody UserVO userVO){
    userService.userContextRole(userVO);
    return new ResponseResult(true,200,"添加用户角色成功",null);

  }
}
