package com.lagou.controller;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.PromotionAd;
import com.lagou.domain.PromotionAdVO;
import com.lagou.domain.ResponseResult;
import com.lagou.service.PromotionAdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pub/PromotionAd")
public class PromotionAdController {

  @Autowired
  private PromotionAdService promotionAdService;

  @RequestMapping("/findPromotionAdByPage")
  public ResponseResult findPromotionAdByPage(PromotionAdVO promotionAdVO){
    PageInfo<PromotionAd> pageInfo = promotionAdService.findPromotionAdByPage(promotionAdVO);
    return new ResponseResult(true,200,"分页查询广告成功",pageInfo);
  }

  @RequestMapping("/updatePromotionAdStatus")
  public ResponseResult updatePromotionAdStatus(@RequestParam Integer id, @RequestParam Integer status){
    promotionAdService.updatePromotionAdStatus(id, status);
    return new ResponseResult(true,200,"更新广告上下线状态成功",null);
  }
}
