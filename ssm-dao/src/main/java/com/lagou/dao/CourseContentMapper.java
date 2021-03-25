package com.lagou.dao;

import com.lagou.domain.Course;
import com.lagou.domain.CourseSection;

import java.util.List;

public interface CourseContentMapper {

  public List<CourseSection> findCourseSectionAndLessonById(int courseId);

  public List<Course> findCourseByCourseId(int courseId);

  public void savaCourseSection(CourseSection courseSection);

  public void updateCourseSection(CourseSection courseSection);

  public void updateSectionStatus(CourseSection courseSection);

}
