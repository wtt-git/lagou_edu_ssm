package com.lagou.service.impl;

import com.lagou.dao.CourseContentMapper;
import com.lagou.domain.Course;
import com.lagou.domain.CourseSection;
import com.lagou.domain.PromotionSpace;
import com.lagou.service.CourseContentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CourseContentServiceImpl implements CourseContentService {

  @Autowired
  private CourseContentMapper courseContentMapper;

  @Override
  public List<CourseSection> findCourseSectionAndLessonById(Integer courseId) {
    List<CourseSection> list = courseContentMapper.findCourseSectionAndLessonById(courseId);
    return list;
  }

  @Override
  public List<Course> findCourseByCourseId(Integer courseId) {
    List<Course> courseList = courseContentMapper.findCourseByCourseId(courseId);
    return courseList;
  }

  @Override
  public void savaCourseSection(CourseSection courseSection) {

    Date date = new Date();
    courseSection.setCreateTime(date);
    courseSection.setUpdateTime(date);

    courseContentMapper.savaCourseSection(courseSection);
  }

  @Override
  public void updateCourseSection(CourseSection courseSection) {
    courseSection.setUpdateTime(new Date());
    courseContentMapper.updateCourseSection(courseSection);
  }

  @Override
  public void updateSectionStatus(int id, int status) {
    CourseSection courseSection = new CourseSection();
    courseSection.setId(id);
    courseSection.setStatus(status);
    courseSection.setUpdateTime(new Date());

    courseContentMapper.updateSectionStatus(courseSection);
  }

}
