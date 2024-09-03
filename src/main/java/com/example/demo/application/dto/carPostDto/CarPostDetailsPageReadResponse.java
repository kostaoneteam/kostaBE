package com.example.demo.application.dto.carPostDto;

import com.example.demo.domain.CarImages;
import java.util.Collections;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class CarPostDetailsPageReadResponse {

  private String carModel;
  private String brand;
  private String carType;
  private int mileage;
  private int price;
  private String displacement;
  private String color;
  private String userId;
  private List<String> carImagesURL;


  public CarPostDetailsPageReadResponse(String carModel, String brand, String carType, int mileage,
      int price, String displacement, String color, String userId) {
    this.carModel = carModel;
    this.brand = brand;
    this.carType = carType;
    this.mileage = mileage;
    this.price = price;
    this.displacement = displacement;
    this.color = color;
    this.userId = userId;
  }
}
