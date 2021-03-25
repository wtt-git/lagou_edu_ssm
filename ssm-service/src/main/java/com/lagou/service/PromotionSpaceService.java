package com.lagou.service;

import com.lagou.domain.PromotionSpace;

import java.util.List;

public interface PromotionSpaceService {

  public List<PromotionSpace> findAllPromotionSpace();

  public void savePromotionSpace(PromotionSpace promotionSpace);

  public void updatePromotionSpace(PromotionSpace promotionSpace);

  public List<PromotionSpace> findPromotionSpaceById(int id);
}
