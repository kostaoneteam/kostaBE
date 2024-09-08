package com.example.demo.application.dto.carPostDto;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yy-MM-dd")
    private LocalDateTime createdAt;

}
