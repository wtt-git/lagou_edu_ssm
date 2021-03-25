package com.lagou.service.impl;

import com.lagou.dao.CourseMapper;
import com.lagou.domain.Course;
import com.lagou.domain.CourseVO;
import com.lagou.domain.Teacher;
import com.lagou.service.CourseService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

  @Autowired
  private CourseMapper courseMapper;

  @Override
  public List<Course> findCourseByCondition(CourseVO courseVO) {
    List<Course> courseList = courseMapper.findCourseByCondition(courseVO);
    return courseList;
  }

  @Override
  public void savaCourseOrTeacher(CourseVO courseVO) {
    Course course = new Course();
    try {
      BeanUtils.copyProperties(course, courseVO);
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }

    Date date = new Date();
    course.setCreateTime(date);
    course.setUpdateTime(date);

    courseMapper.saveCourse(course);

    int id = course.getId();
    Teacher teacher = new Teacher();
    try {
      BeanUtils.copyProperties(teacher, courseVO);
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }

    teacher.setCourseId(id);
    teacher.setCreateTime(date);
    teacher.setUpdateTime(date);
    teacher.setIsDel(0);
    courseMapper.saveTeacher(teacher);
  }

  @Override
  public CourseVO findCourseById(Integer id) {
    return courseMapper.findCourseById(id);
  }

  @Override
  public void updateCourseOrTeacher(CourseVO courseVO) {
    Course course = new Course();
    try {
      BeanUtils.copyProperties(course,courseVO);
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }

    Date date = new Date();
    course.setUpdateTime(date);
    courseMapper.updateCourse(course);

    Teacher teacher = new Teacher();
    try {
      BeanUtils.copyProperties(teacher,courseVO);
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }

    teacher.setCourseId(course.getId());
    teacher.setUpdateTime(date);
    courseMapper.updateTeacher(teacher);

  }


  @Override
  public void updateCourseStatus(int course_id, int status) {
    Course course = new Course();
    course.setId(course_id);
    course.setStatus(status);
    course.setUpdateTime(new Date());

    courseMapper.updateCourseStatus(course);
  }
}
