package com.lagou.dao;

import com.lagou.domain.Resource;
import com.lagou.domain.ResourceVO;

import java.util.List;

public interface ResourceMapper {

  public List<Resource> findAllResourceByPage(ResourceVO resourceVO);

}
