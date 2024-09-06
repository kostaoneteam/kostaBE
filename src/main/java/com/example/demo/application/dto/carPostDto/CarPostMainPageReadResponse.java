/*
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

  private String carModel;
  private String brand;
  private String carType;
  private int mileage;
  private int price;
  private String displacement;
  private String color;
  private String userId;
  private String carImagesURL;


  public CarPostMainPageReadResponse(CarPostMainPageReadResponse carPostMainPageReadResponse) {
    this.carModel = carPostMainPageReadResponse.getCarModel();
    this.brand = carPostMainPageReadResponse.getBrand();
    this.carType = carPostMainPageReadResponse.getCarType();
    this.mileage = carPostMainPageReadResponse.getMileage();
    this.price = carPostMainPageReadResponse.getPrice();
    this.displacement = carPostMainPageReadResponse.getDisplacement();
    this.color = carPostMainPageReadResponse.getColor();
    this.userId= String.valueOf(carPostMainPageReadResponse.getUserId());
    this.carImagesURL=String.valueOf(carPostMainPageReadResponse.getCarImagesURL());
  }

}
*/

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
  private String brand;
  private String carType;
  private int mileage;
  private int price;
  private String displacement;
  private String color;
  private String userId;
  private String carImagesURL;
  private Long likes;

}