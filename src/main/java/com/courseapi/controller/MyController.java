package com.courseapi.controller;

import com.courseapi.entity.Course;
import com.courseapi.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//presentation layer
@RestController
@CrossOrigin
public class MyController {

    @Autowired
    private CourseService courseService; //autowired will create object of courseservice class and will inject it into "courseService".

    //get all courses
    @GetMapping("/courses")
    public List<Course> getCourses(){ //course is entity class which will store data

        return this.courseService.getCourses();

    }

    //get course by ID
    @GetMapping("/courses/{courseId}")
    public Course getCourse(@PathVariable String courseId) {
        return this.courseService.getCourse(Long.parseLong(courseId));
    }

    //add new course
    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course) {

        return this.courseService.addCourse(course);
    }


    //update course
    @PutMapping("/courses")
    public Course updateCourse(@RequestBody Course course) {
        return this.courseService.updateCourse(course);
    }

    //delete course by ID
    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity<HttpStatus> deleteCourseById(@PathVariable String courseId){

        try {
            this.courseService.deleteCourseById(Long.parseLong(courseId));
            return new ResponseEntity<HttpStatus>(HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}