package com.example.demo.presentation;

import com.example.demo.application.carImagesDto.CarImagesCreateRequest;
import com.example.demo.application.dto.carPostDto.CarPostCreateRequest;
import com.example.demo.application.dto.carPostDto.CarPostDetailsPageReadResponse;
import com.example.demo.application.dto.carPostDto.CarPostMainPageReadResponse;
import com.example.demo.application.dto.carPostDto.CarPostMyPageReadResponse;
import com.example.demo.application.service.CarPostService;
import com.example.demo.domain.CarImages;
import com.example.demo.domain.CarPost;
import com.example.demo.infrastructure.CarImageRepository;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/carpost")
@RequiredArgsConstructor
public class CarPostController {

  private final CarPostService carPostService;
  private final CarImageRepository carImageRepository;

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

  @GetMapping("/filter")
  public List<CarPostMainPageReadResponse> getFilteredCarPosts(
      @RequestParam(required = false) List<String> brand,
      @RequestParam(required = false) List<String> carType,
      @RequestParam(required = false) List<String> displacement,
      @RequestParam(required = false) List<String> color,
      @RequestParam(required = false) List<String> carYear,
      @RequestParam int limit,
      @RequestParam int offset) {

    return carPostService.getFilteredCarPosts(
        brand, carType, displacement, color, carYear, limit, offset);
  }

  @PostMapping("/post")
  public ResponseEntity<Map<String, String>> createCarPost(@RequestBody CarPostCreateRequest request) {
      try {
          // CarPost 객체 생성 및 설정
          CarPost carPost = new CarPost();
          carPost.setCarModel(request.getCarModel());
          carPost.setBrand(request.getBrand());
          carPost.setCarType(request.getCarType());
          carPost.setCarYear(request.getCarYear());
          carPost.setPrice(request.getPrice());
          carPost.setDisplacement(request.getDisplacement());
          carPost.setColor(request.getColor());

          // CarPost 저장
          CarPost savedCarPost = carPostService.saveCarPost(carPost);

          // Base64 이미지 리스트 처리
          List<String> base64Images = request.getCarImagesURL();
          if (base64Images == null) {
              base64Images = new ArrayList<>(); // base64Images가 null인 경우 빈 리스트로 초기화
          }

          for (String base64Image : base64Images) {
              String[] parts = base64Image.split(","); // Base64 문자열에서 실제 데이터 부분만 추출
              if (parts.length > 1) {
                  String imageBase64 = parts[1]; // Base64 인코딩된 이미지 데이터

                  CarImages carImage = new CarImages();
                  carImage.setCarPost(savedCarPost); // CarPost와 연관 설정
                  carImage.setCarImagesURL(imageBase64); // Base64 인코딩된 이미지 데이터 저장
                  carImage.setCreatedAt(LocalDateTime.now()); // 생성 일시 설정

                  // CarImages 저장
                  carPostService.saveCarImages(carImage);
              }
          }

          // JSON 형식으로 응답
          Map<String, String> response = new HashMap<>();
          response.put("message", "작성 완료!");
          return ResponseEntity.ok(response);
      } catch (Exception e) {
          e.printStackTrace();
          Map<String, String> errorResponse = new HashMap<>();
          errorResponse.put("message", "데이터 처리 실패");
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
      }
  }

}

