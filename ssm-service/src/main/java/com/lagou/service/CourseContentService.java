package com.lagou.service;

import com.lagou.domain.Course;
import com.lagou.domain.CourseSection;
import com.lagou.domain.PromotionSpace;

import java.util.List;

public interface CourseContentService {

  public List<CourseSection> findCourseSectionAndLessonById(Integer courseId);

  public List<Course> findCourseByCourseId(Integer courseId);

  public void savaCourseSection(CourseSection courseSection);

  public void updateCourseSection(CourseSection courseSection);

  public void updateSectionStatus(int id, int status);


}
