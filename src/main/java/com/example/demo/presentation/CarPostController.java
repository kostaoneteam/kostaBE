package com.example.demo.presentation;

import com.example.demo.application.dto.carPostDto.CarPostDetailsPageReadResponse;
import com.example.demo.application.dto.carPostDto.CarPostMainPageReadResponse;
import com.example.demo.application.service.CarPostService;
import com.example.demo.domain.CarPost;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carpost")
@RequiredArgsConstructor
public class CarPostController {

  private final CarPostService carPostService;

  //메인페이지
  @GetMapping("/main")
  public List<CarPostMainPageReadResponse> allPost(@RequestParam int limit, @RequestParam int offset){
    return carPostService.getAll(limit,offset);
  }
  //상세페이지
  @GetMapping("/details/{id}")
  public CarPostDetailsPageReadResponse details(@PathVariable Long id){
    return carPostService.getCarPostDetails(id);
  }
  //내가 쓴 글 조회
  @GetMapping("/mypage")
  public List<CarPostMainPageReadResponse> myPage(@RequestParam String userId,int limit,int offset){
    return carPostService.getMyPageCarPost(userId, limit, offset);
  }

  @GetMapping("/qwe")
  public List<CarPost> qwe(){
    return carPostService.getA();
  }
<<<<<<< HEAD
}
=======
}
>>>>>>> f7201aa3ba97944595125338727f3e4685fc5986
