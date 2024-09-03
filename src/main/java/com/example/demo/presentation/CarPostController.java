package com.example.demo.presentation;

import com.example.demo.application.dto.carPostDto.CarPostDetailsPageReadResponse;
import com.example.demo.application.dto.carPostDto.CarPostMainPageReadResponse;
import com.example.demo.application.service.CarPostService;
import com.example.demo.domain.CarPost;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carpost")
@RequiredArgsConstructor
public class CarPostController {

  private final CarPostService carPostService;


  @GetMapping("/main")
  public List<CarPostMainPageReadResponse> allPost(@RequestParam int limit, @RequestParam int offset){
    return carPostService.getAll(limit,offset);
  }

  @GetMapping("/details")
  public CarPostDetailsPageReadResponse details(@RequestParam Long id){
    return carPostService.getCarPostDetails(id);
  }
}
