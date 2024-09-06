package com.example.demo.presentation;

import com.example.demo.application.dto.carPostDto.CarPostCreateRequest;
import com.example.demo.application.dto.carPostDto.CarPostDetailsPageReadResponse;
import com.example.demo.application.dto.carPostDto.CarPostMainPageReadResponse;
import com.example.demo.application.dto.carPostDto.CarPostMyPageReadResponse;
import com.example.demo.application.service.CarPostService;
import com.example.demo.domain.CarPost;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
  public List<CarPostMainPageReadResponse> allPost(@RequestParam int limit,
      @RequestParam int offset) {
    return carPostService.getAll(limit, offset);
  }

  //상세페이지
  @GetMapping("/details/{id}")
  public CarPostDetailsPageReadResponse details(@PathVariable Long id) {
    return carPostService.getCarPostDetails(id);
  }

  //내가 쓴 글 조회
  @GetMapping("/mypage")
  public List<CarPostMyPageReadResponse> myPage(@RequestParam String userId) {
    return carPostService.getMyPageCarPost(userId);
  }


  @PostMapping("/post")
  public ResponseEntity<?> createCarPost(@RequestBody CarPostCreateRequest carPost) {
    try {
      CarPost createdCarPost = carPostService.createPost(carPost);
      return ResponseEntity.ok(createdCarPost); // 성공 시 200 OK
    } catch (IllegalArgumentException e) {
      // 유효성 검사 실패 시 400 Bad Request
      return ResponseEntity.badRequest().body(e.getMessage());
    } catch (Exception e) {
      // 기타 예외 처리
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
    }
  }
}
