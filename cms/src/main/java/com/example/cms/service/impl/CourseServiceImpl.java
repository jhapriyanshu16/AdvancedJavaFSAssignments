package com.example.cms.service.impl;

import com.example.cms.dto.*;
import com.example.cms.entity.Course;
import com.example.cms.exception.ResourceNotFoundException;
import com.example.cms.repository.CourseRepository;
import com.example.cms.service.CourseService;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository repository;
    private final ModelMapper mapper;

    public CourseServiceImpl(CourseRepository repository,
                             ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public CourseResponseDTO createCourse(CourseRequestDTO dto) {

        Course course = mapper.map(dto, Course.class);

        Course saved = repository.save(course);

        return mapper.map(saved, CourseResponseDTO.class);
    }

    @Override
    public CourseResponseDTO getCourseById(Long id) {

        Course course = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Course","id",id));


        return mapper.map(course, CourseResponseDTO.class);
    }

    @Override
    public Page<CourseResponseDTO> getAllCourses(int page,int size,String sortBy){

        Pageable pageable = PageRequest.of(page,size, Sort.by(sortBy));

        Page<Course> courses = repository.findAll(pageable);

        return courses.map(c -> mapper.map(c,CourseResponseDTO.class));
    }

    @Override
    public CourseResponseDTO updateCourse(Long id, CourseRequestDTO dto) {

        Course course = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Course","id",id));

        mapper.map(dto,course);

        Course updated = repository.save(course);

        return mapper.map(updated,CourseResponseDTO.class);
    }

    @Override
    public void deleteCourse(Long id){

        Course course = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Course","id",id));

        repository.delete(course);
    }

}