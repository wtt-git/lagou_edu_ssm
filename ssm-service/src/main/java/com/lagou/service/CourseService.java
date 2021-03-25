package com.lagou.service;

import com.lagou.domain.Course;
import com.lagou.domain.CourseVO;

import java.util.List;

public interface CourseService {

  /**
   * 多条件组合查询课程
   *
   * @param courseVO
   * @return
   */
  public List<Course> findCourseByCondition(CourseVO courseVO);

  /**
   * 新增课程信息
   *
   * @param courseVO
   */
  public void savaCourseOrTeacher(CourseVO courseVO);

  /**
   * 课程信息回显
   * @param id
   * @return
   */
  public CourseVO findCourseById(Integer id);

  /**
   * 更新课程信息
   * @param courseVO
   */
  public void updateCourseOrTeacher(CourseVO courseVO);

  /**
   * 更新课程状态
   * @param course_id
   * @param status
   */
  public void updateCourseStatus(int course_id, int status);

}
