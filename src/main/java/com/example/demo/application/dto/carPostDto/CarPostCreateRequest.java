package com.example.demo.application.dto.carPostDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class CarPostCreateRequest {
  private String carModel;
  private String brand;
  private String carType;
  private String carYear;
  private int mileage;
  private int price;
  private String displacement;
  private String color;
}
