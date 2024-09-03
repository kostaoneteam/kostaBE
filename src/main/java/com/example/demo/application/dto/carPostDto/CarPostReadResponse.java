package com.example.demo.application.dto.carPostDto;

import com.example.demo.domain.CarPost;
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
public class CarPostReadResponse {

  private String carModel;
  private String brand;
  private String carType;
  private int mileage;
  private int price;
  private String displacement;
  private String color;
  private String userId;
  private String carImagesURL;


  public CarPostReadResponse(CarPostReadResponse carPostReadResponse) {
    this.carModel = carPostReadResponse.getCarModel();
    this.brand = carPostReadResponse.getBrand();
    this.carType = carPostReadResponse.getCarType();
    this.mileage = carPostReadResponse.getMileage();
    this.price = carPostReadResponse.getPrice();
    this.displacement = carPostReadResponse.getDisplacement();
    this.color = carPostReadResponse.getColor();
    this.userId= String.valueOf(carPostReadResponse.getUserId());
    this.carImagesURL=String.valueOf(carPostReadResponse.getCarImagesURL());

  }

}
