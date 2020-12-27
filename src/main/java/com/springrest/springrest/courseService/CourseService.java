package com.springrest.springrest.courseService;

import com.springrest.springrest.entites.Course;

import java.util.List;
public interface CourseService {
    List<Course> getCourses();

    Course getCourse(Long id);

    String addCourse(Course course);
}
