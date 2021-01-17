package com.springrest.springrest.courseService;

import com.springrest.springrest.entites.Course;
import com.springrest.springrest.model.CourseDao;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@Log
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseDao courseDao;

    @Override
    public List<Course> getCourses() {
        return courseDao.findAll();
    }

    @Override
    public Course getCourse(Long id) {
        return courseDao.getOne(id);
    }

    @Override
    public String addCourse(Course course) {
        List<Course> list = getCourses();
        boolean present = list.stream().anyMatch(course1 -> course.getId().equals(course1.getId()));
        if(present) {
            return null;
        } else {
            courseDao.save(course);
        }
        return "Course has been added";
    }
}
