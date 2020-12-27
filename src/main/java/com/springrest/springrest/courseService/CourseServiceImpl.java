package com.springrest.springrest.courseService;

import com.springrest.springrest.entites.Course;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@Log
public class CourseServiceImpl implements CourseService{
    List<Course>list;

    public CourseServiceImpl() {
        list = new ArrayList<>();
        list.add(new Course(1L, "Java", "Basics of Java"));
        list.add(new Course(2L, "Springboot", "Creating rest-API"));
    }
    @Override
    public List<Course> getCourses() {
        return list;
    }

    @Override
    public Course getCourse(Long id) {
        return list.stream().filter(course -> id.equals(course.getId())).findAny().orElse(null);
    }

    @Override
    public String addCourse(Course course) {
        boolean present = list.stream().anyMatch(course1 -> course.getId().equals(course1.getId()));
        if(present) {
            return null;
        } else {
            list.add(course);
        }
        return "Course has been added";
    }
}
