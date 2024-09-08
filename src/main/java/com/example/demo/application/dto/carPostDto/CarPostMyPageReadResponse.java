package com.example.demo.application.dto.carPostDto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class CarPostMyPageReadResponse {

    private String carModel;
    private LocalDateTime createdAt;

}
