package com.example.cms.controller;

import com.example.cms.dto.*;
import com.example.cms.payload.ApiResponse;
import com.example.cms.service.CourseService;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService service;

    public CourseController(CourseService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<CourseResponseDTO>> createCourse(
            @Valid @RequestBody CourseRequestDTO dto){

        CourseResponseDTO created = service.createCourse(dto);

        ApiResponse<CourseResponseDTO> response =
                new ApiResponse<>(true,"Course created successfully",created);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CourseResponseDTO>> getCourse(@PathVariable Long id){

        CourseResponseDTO course = service.getCourseById(id);

        return ResponseEntity.ok(
                new ApiResponse<>(true,"Course fetched successfully",course));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<Page<CourseResponseDTO>>> getAllCourses(

            @RequestParam(defaultValue="0") int page,
            @RequestParam(defaultValue="10") int size,
            @RequestParam(defaultValue="id") String sortBy){

        Page<CourseResponseDTO> courses =
                service.getAllCourses(page,size,sortBy);

        return ResponseEntity.ok(
                new ApiResponse<>(true,"Courses fetched successfully",courses));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<CourseResponseDTO>> updateCourse(
            @PathVariable Long id,
            @Valid @RequestBody CourseRequestDTO dto){

        CourseResponseDTO updated = service.updateCourse(id,dto);

        return ResponseEntity.ok(
                new ApiResponse<>(true,"Course updated successfully",updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> deleteCourse(@PathVariable Long id){

        service.deleteCourse(id);

        return ResponseEntity.ok(
                new ApiResponse<>(true,"Course deleted successfully",null));
    }
}