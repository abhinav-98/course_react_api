package com.courseapi.dao;

import com.courseapi.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDao extends JpaRepository<Course, Long>{ //(entity, primary-key type)

}
