package com.example.demo.presentation;

import com.example.demo.application.dto.carPostDto.CarPostReadResponse;
import com.example.demo.application.service.CarPostService;
import java.util.List;
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
  public List<CarPostReadResponse> allPost(@RequestParam int limit, @RequestParam int offset){
    return carPostService.getAll(limit,offset);
  }
}
