package com.lagou.dao;

import com.lagou.domain.PromotionAd;

import java.util.List;

public interface PromotionAdMapper {

  public List<PromotionAd> findPromotionAdByPage();

  public void updatePromotionAdStatus(PromotionAd promotionAd);
}
