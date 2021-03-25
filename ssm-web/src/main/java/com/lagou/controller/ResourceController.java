package com.lagou.controller;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.Resource;
import com.lagou.domain.ResourceCategory;
import com.lagou.domain.ResourceVO;
import com.lagou.domain.ResponseResult;
import com.lagou.service.ResourceCategoryService;
import com.lagou.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pub/resource")
public class ResourceController {

  @Autowired
  private ResourceService resourceService;

  @Autowired
  private ResourceCategoryService resourceCategoryService;

  @RequestMapping("/findAllResourceByPage")
  public ResponseResult findAllResourceByPage(@RequestBody ResourceVO resourceVO){
    PageInfo<Resource> pageInfo = resourceService.findAllResourceByPage(resourceVO);
    return new ResponseResult(true,200,"分页多条件查询资源成功",pageInfo);
  }

  @RequestMapping("/findAllResourceCategory")
  public ResponseResult findAllResourceCategory(){
    List<ResourceCategory> allResourceCategory = resourceCategoryService.findAllResourceCategory();
    return new ResponseResult(true,200,"查询所有资源分类成功",allResourceCategory);
  }
}
