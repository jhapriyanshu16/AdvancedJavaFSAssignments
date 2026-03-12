package com.example.cms.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseResponseDTO {

    private Long id;

    private String title;

    private String description;

    private String instructor;

    private int duration;

    private Double price;

    private LocalDateTime createdAt;
}