package com.courseapi.services;

import com.courseapi.dao.CourseDao;
import com.courseapi.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CourseServiceImpl implements CourseService {

    //List<Course> list;

    @Autowired
    private CourseDao courseDao;

    public CourseServiceImpl() {


//		list = new ArrayList<>();
//		list.add(new Course(1, "Java", "Basics of Java"));
//		list.add(new Course(2, "Spring", "Spring application"));
    }

    @Override
    public List<Course> getCourses() {
        // TODO Auto-generated method stub

        return courseDao.findAll();

    }

    @SuppressWarnings("deprecation")
    @Override
    public Course getCourse(long courseId) {
        // TODO Auto-generated method stub

//		Course course = null;
//		for(Course c : list) {
//
//			if(c.getId() == courseId) {
//
//				course = c;
//				break;
//
//			}
//
//		}


        return courseDao.findById(courseId).get();
    }

    @Override
    public Course addCourse(Course course) {
        // TODO Auto-generated method stub
//		list.add(course);
        courseDao.save(course);
        return course;
    }

    @Override
    public void deleteCourseById(long parseLong) {
        // TODO Auto-generated method stub

//		list = this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
        @SuppressWarnings("deprecation")
        Course entity = courseDao.getOne(parseLong);
        courseDao.delete(entity);

    }

    @Override
    public Course updateCourse(Course course) {
        // TODO Auto-generated method stub
//		list.forEach(e->{
//			if(e.getId() == course.getId()) {
//				e.setTitle(course.getTitle());
//				e.setDescription(course.getDescription());
//			}
//		});

        courseDao.save(course);

        return course;
    }

}