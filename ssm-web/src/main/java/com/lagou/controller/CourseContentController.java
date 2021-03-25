package com.lagou.controller;

import com.lagou.domain.Course;
import com.lagou.domain.CourseSection;
import com.lagou.domain.ResponseResult;
import com.lagou.service.CourseContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/pub/courseContent")
public class CourseContentController {

  @Autowired
  private CourseContentService courseContentService;

  @GetMapping("/findCourseSectionAndLessonById")
  public ResponseResult findCourseSectionAndLessonById(@RequestParam Integer courseId){
    List<CourseSection> sectionList = courseContentService.findCourseSectionAndLessonById(courseId);
    ResponseResult responseResult = new ResponseResult(true,200,"响应成功",sectionList);
    return responseResult;
  }

  @GetMapping("/findCourseByCourseId")
  public ResponseResult findCourseByCourseId(@RequestParam Integer courseId){
    List<Course> courseList = courseContentService.findCourseByCourseId(courseId);
    ResponseResult responseResult = new ResponseResult(true,200,"响应成功",courseList);
    return responseResult;
  }

  @PostMapping("/saveOrUpdateCourseSection")
  public ResponseResult savaCourseSection(@RequestBody CourseSection courseSection){
    if(courseSection.getId() == null){
      courseContentService.savaCourseSection(courseSection);
      ResponseResult responseResult = new ResponseResult(true,200,"新建章节信息成功",null);
      return responseResult;
    }else {
      courseContentService.updateCourseSection(courseSection);
      ResponseResult responseResult = new ResponseResult(true,200,"更新章节信息成功",null);
      return responseResult;
    }
  }

  @GetMapping("/updateSectionStatus")
  public ResponseResult updateSectionStatus(@RequestParam Integer id, @RequestParam Integer status){
    courseContentService.updateSectionStatus(id, status);
    Map<Object, Object> map = new HashMap<>();
    map.put("status",status);
    return new ResponseResult(true,200,"更新章节状态成功",map);
  }
}
