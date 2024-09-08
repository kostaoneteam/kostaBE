package com.example.demo.application.dto.carPostDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class CarPostMainPageReadResponse {
  private Long id;
  private String carModel;
  private String carYear;
  private String carType;
  private int mileage;
  private int price;
  private String displacement;
  private String color;
  private String userId;
  private String carImagesURL;
  private Long likes;

}
