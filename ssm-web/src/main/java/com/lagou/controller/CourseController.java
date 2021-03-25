package com.lagou.controller;

import com.lagou.domain.Course;
import com.lagou.domain.CourseVO;
import com.lagou.domain.ResponseResult;
import com.lagou.service.CourseService;
import com.lagou.service.impl.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/pub/course")
public class CourseController {

  @Autowired
  private CourseService courseService;

  /**
   * 多条件查询课程
   * @param courseVO
   * @return
   */
  @PostMapping("/findCourseByCondition")
  public ResponseResult findCourseByCondition(@RequestBody CourseVO courseVO){
    List<Course> courseList = courseService.findCourseByCondition(courseVO);
    ResponseResult responseResult = new ResponseResult(true, 200, "响应成功", courseList);
    return responseResult;
  }

  /**
   * 图片上传
   * @param file
   * @param request
   * @return
   */
  @PostMapping("/courseUpload")
  public ResponseResult fileUpload(@RequestParam("file")MultipartFile file, HttpServletRequest request){
//    System.out.println(file);
    //1.判断文件是否为空
    if(file.isEmpty()){
      System.out.println("123");
      throw new RuntimeException();
    }

    //2.获取项目部署路径
    String realPath = request.getServletContext().getRealPath("/");
    System.out.println(realPath);
    String webappsPath = realPath.substring(0, realPath.indexOf("ssm_web"));

    //3.获取原文件名
    String fileName = file.getOriginalFilename();

    //4.新文件名
    String newFileName = System.currentTimeMillis()+fileName.substring(fileName.lastIndexOf("."));

    //5.上传文件
    String uploadPath = webappsPath+"upload";
    System.out.println("uploadPath"+uploadPath);
    File filePath = new File(uploadPath,newFileName);

    //如果目录不存在就创建目录
    if(!filePath.getParentFile().exists()){
      filePath.getParentFile().mkdirs();
      System.out.println("创建目录："+ filePath);
    }
    try {
      file.transferTo(filePath);
    } catch (IOException e) {
      e.printStackTrace();
    }

    //6.将文件名和文件路径返回
    Map<String, String> map = new HashMap<>();
    map.put("fileName", newFileName);
    map.put("filePath", "http://localhost:8080/upload/" + newFileName);
    ResponseResult responseResult = new ResponseResult(true,200,"响应成功",map);
    return responseResult;
  }

  /**
   * 新增课程和讲师信息
    * @param courseVO
   * @return
   */
  @PostMapping("/saveOrUpdateCourse")
  public ResponseResult saveOrUpdateCourse(@RequestBody CourseVO courseVO){
    if(courseVO.getId() == null){
      courseService.savaCourseOrTeacher(courseVO);
      ResponseResult responseResult = new ResponseResult(true,200,"新增成功",null);
      return responseResult;
    }else {
      courseService.updateCourseOrTeacher(courseVO);
      ResponseResult responseResult = new ResponseResult(true,200,"更新成功",null);
      return responseResult;
    }

  }

  @GetMapping("/findCourseById")
  public ResponseResult findCourseById(Integer id){
    CourseVO courseVo = courseService.findCourseById(id);
    ResponseResult responseResult = new ResponseResult(true,200,"响应成功",courseVo);
    return responseResult;
  }

  @GetMapping("/updateCourseStatus")
  public ResponseResult updateCourseStatus(@RequestParam Integer courseId, @RequestParam Integer status){
    courseService.updateCourseStatus(courseId,status);
    Map<String,Object> map = new HashMap<>();
    map.put("status",status);
    ResponseResult responseResult = new ResponseResult(true,200,"修改状态成功",map);
    return responseResult;
  }
}
