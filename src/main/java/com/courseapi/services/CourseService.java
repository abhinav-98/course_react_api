package com.courseapi.services;

import com.courseapi.entity.Course;

import java.util.List;

public interface CourseService {


    public List<Course> getCourses();

    public Course getCourse(long courseId);

    public Course addCourse(Course course);

    public void deleteCourseById(long parseLong);

    public Course updateCourse(Course course);

}
