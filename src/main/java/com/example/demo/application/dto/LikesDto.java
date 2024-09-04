package com.example.demo.application.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LikesDto {
    // private Long id;
    private Long userId;
    private Long postId;
    // private LocalDateTime createdAt;
}
