package com.lagou.service;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.PromotionAd;
import com.lagou.domain.PromotionAdVO;

import java.util.List;

public interface PromotionAdService {

  public PageInfo<PromotionAd> findPromotionAdByPage(PromotionAdVO promotionAdVO);

  public void updatePromotionAdStatus(Integer id, Integer status);

}
