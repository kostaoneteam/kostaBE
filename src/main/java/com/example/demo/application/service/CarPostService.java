package com.example.demo.application.service;

import com.example.demo.application.dto.carPostDto.CarPostCreateRequest;
import com.example.demo.application.dto.carPostDto.CarPostDetailsPageReadResponse;
import com.example.demo.application.dto.carPostDto.CarPostMainPageReadResponse;
import com.example.demo.application.dto.carPostDto.CarPostMyPageReadResponse;
import com.example.demo.application.dto.userDto.UserDetailsReadResponse;
import com.example.demo.domain.CarImages;
import com.example.demo.domain.CarPost;
import com.example.demo.infrastructure.CarImageRepository;
import com.example.demo.infrastructure.CarPostRepository;
import com.example.demo.infrastructure.LikesRepository;
import com.example.demo.infrastructure.UserRepository;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Service
@RequiredArgsConstructor
public class CarPostService {

  private static final String DEFAULT_IMAGE_URL = "https://i.pinimg.com/originals/ff/c2/37/ffc2379c099c0b25bb7e6afaba5748fb.jpg";
  private final CarPostRepository carPostRepository;
  private final UserRepository userRepository;
  private final LikesRepository likesRepository;
  private final CarImageRepository carImageRepository;

  public List<CarPostMainPageReadResponse> getAll(int limit, int offset) {
    Pageable pageable = PageRequest.of(offset / limit, limit);
    Page<CarPostMainPageReadResponse> page = carPostRepository.findPostsWithFirstImage(pageable);
    return page.getContent();
  }


  public CarPostDetailsPageReadResponse getCarPostDetails(Long carPostId) {

    CarPostDetailsPageReadResponse response = carPostRepository.findCarPostDetailsById(carPostId);
    List<UserDetailsReadResponse> userDetailsList = userRepository.findUserByCarPostId(carPostId);

    for (UserDetailsReadResponse details : userDetailsList) {
      if (details.getUserImagesURL() == null || details.getUserImagesURL().isEmpty()) {
        details.setUserImagesURL(DEFAULT_IMAGE_URL);
      }
    }
    // 리스폰의 데이터가 있으면 여러 이미지를 받아오는 쿼리를 리스트화 하여 Dto에 넣어준다.
    if (response != null) {
      List<String> imageURLs = carPostRepository.findCarImageURLsByCarPostId(carPostId);
      response.setCarImagesURL(imageURLs);
      response.setUser(userDetailsList);
    }
    return response;
  }

/*  public List<CarPostMyPageReadResponse> getMyPageCarPost (String userId,int limit,int offset) {
           Pageable pageable = PageRequest.of(offset / limit, limit); // 페이지 번호와 페이지 크기 설정
           Page<CarPostMyPageReadResponse> page = carPostRepository.findCarPostsByUserId(userId,pageable);
           return page.getContent(); // 페이지에서 내용만 추출
  }*/

  public List<CarPostMyPageReadResponse> getMyPageCarPost(String userId) {
    return carPostRepository.findCarPostsByUserId(userId);
  }

  public List<CarPost> getA() {
    return carPostRepository.findAll();
  }

  public List<CarPostMainPageReadResponse> getFilteredCarPosts(
      List<String> brand, List<String> carType, List<String> displacement,
      List<String> color, List<String> carYear, int limit, int offset) {
    Pageable pageable = PageRequest.of(offset / limit, limit);
    Page<CarPostMainPageReadResponse> page = carPostRepository.findByFiltersWithPagination(brand,
        carType, displacement, color, carYear, pageable);

    return page.getContent();
  }

  @PostMapping("/upload")
  public Map<String, Object> handleFileUpload(@RequestParam("imageUploads") MultipartFile[] files) {
    Map<String, Object> response = new HashMap<>();

    try {
      for (MultipartFile file : files) {
        String fileName = file.getOriginalFilename();
        String filePath = "uploads/" + fileName;
        File destinationFile = new File(filePath);
        file.transferTo(destinationFile);
      }

      response.put("success", true);
    } catch (Exception e) {
      response.put("success", false);
      response.put("error", e.getMessage());
    }

    return response;
  }

  public CarImages multiImages( MultipartFile file){
    // 파일 저장 로직
    String fileName = file.getOriginalFilename();
    assert fileName != null;
    String fileUri = ServletUriComponentsBuilder.fromCurrentContextPath()
        .path("/api/files/")
        .path(fileName)
        .toUriString();

    CarImages carImages = new CarImages();
    carImages.setCarImagesURL(fileUri);

    return carImageRepository.save(carImages);
  }

  public CarPost saveCarPost(CarPost carPost) {
      return carPostRepository.save(carPost);
  }
  public void saveCarImages(CarImages carImages) {
         carImageRepository.save(carImages);
     }
}
