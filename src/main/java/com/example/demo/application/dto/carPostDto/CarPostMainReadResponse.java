package com.example.demo.application.dto.carPostDto;

import com.example.demo.domain.CarImages;
import com.example.demo.domain.CarPost;
import com.example.demo.domain.User;
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
  private CarImages carImages;


  public CarPostReadResponse(CarPost carPost) {
    this.carModel = carPost.getCarModel();
    this.brand = carPost.getBrand();
    this.carType = carPost.getCarType();
    this.mileage = carPost.getMileage();
    this.price = carPost.getPrice();
    this.displacement = carPost.getDisplacement();
    this.color = carPost.getColor();
    this.userId = String.valueOf(carPost.getUserId());
    this.carImages = carPost.getCarImages();
  }
}
