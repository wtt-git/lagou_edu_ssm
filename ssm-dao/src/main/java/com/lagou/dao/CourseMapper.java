package com.lagou.dao;

import com.lagou.domain.Course;
import com.lagou.domain.CourseVO;
import com.lagou.domain.Teacher;


import java.util.List;

public interface CourseMapper {

  /**
   * 多条件组合查询课程信息
   * @param courseVO
   * @return
   */
  public List<Course> findCourseByCondition(CourseVO courseVO);

  /**
   * 新增课程信息
   * @param course
   */
  public void saveCourse(Course course);

  /**
   * 新增讲师信息
   * @param teacher
   */
  public void saveTeacher(Teacher teacher);

  /**
   * 课程信息回显（根据课程Id查找课程信息）
   * @param id
   * @return
   */
  public CourseVO findCourseById(Integer id);

  /**
   * 更新课程信息
   * @param course
   */
  public void updateCourse(Course course);

  /**
   * 更新讲师信息
   * @param teacher
   */
  public void updateTeacher(Teacher teacher);

  /**
   * 更新课程状态
   * @param course
   */
  public void updateCourseStatus(Course course);

}
