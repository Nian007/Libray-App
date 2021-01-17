package com.springrest.springrest.model;

import com.springrest.springrest.entites.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDao extends JpaRepository<Course, Long> {

}
