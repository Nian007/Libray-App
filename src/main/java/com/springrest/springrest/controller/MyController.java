package com.springrest.springrest.controller;

import com.springrest.springrest.courseService.CourseService;
import com.springrest.springrest.entites.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class MyController {
        @Autowired
        private CourseService courseService;

        @GetMapping("/courses")
        public ResponseEntity<List<Course> > getCourses() {
            return ResponseEntity.ok(this.courseService.getCourses());
        }

        @GetMapping("/course/{id}")
        public ResponseEntity<Course> getCourse(@PathVariable Long id) {
            return ResponseEntity.ok(this.courseService.getCourse(id));
        }

        @PostMapping("/course/add")
        public ResponseEntity<String> addCourse(@RequestBody Course course) {
            String response = this.courseService.addCourse(course);
            if(response==null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            } else {
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }
}
