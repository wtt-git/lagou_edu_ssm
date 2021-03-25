package com.lagou.service.impl;

import com.lagou.dao.PromotionSpaceMapper;
import com.lagou.domain.PromotionSpace;
import com.lagou.service.PromotionSpaceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class PromotionSpaceServiceImpl implements PromotionSpaceService {

  @Autowired
  private PromotionSpaceMapper promotionSpaceMapper;

  @Override
  public List<PromotionSpace> findAllPromotionSpace() {
    List<PromotionSpace> list = promotionSpaceMapper.findAllPromotionSpace();
    return list;
  }

  @Override
  public void savePromotionSpace(PromotionSpace promotionSpace) {
    promotionSpace.setSpaceKey(UUID.randomUUID().toString());
    Date date = new Date();
    promotionSpace.setCreateTime(date);
    promotionSpace.setUpdateTime(date);
    promotionSpace.setIsDel(0);

    promotionSpaceMapper.savePromotionSpace(promotionSpace);
  }

  @Override
  public void updatePromotionSpace(PromotionSpace promotionSpace) {
    promotionSpace.setUpdateTime(new Date());

    promotionSpaceMapper.updatePromotionSpace(promotionSpace);
  }

  @Override
  public List<PromotionSpace> findPromotionSpaceById(int id) {
    List<PromotionSpace> list = promotionSpaceMapper.findPromotionSpaceById(id);
    return list;
  }
}
