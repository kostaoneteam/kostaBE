package com.example.demo.application.service;

import com.example.demo.application.dto.carPostDto.CarPostDetailsPageReadResponse;
import com.example.demo.application.dto.carPostDto.CarPostMainPageReadResponse;
import com.example.demo.domain.CarPost;
import com.example.demo.infrastructure.CarPostRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarPostService {

  private final CarPostRepository carPostRepository;

  public List<CarPostMainPageReadResponse> getAll(int limit,int offset) {

         Pageable pageable = PageRequest.of(offset / limit, limit); // 페이지 번호와 페이지 크기 설정
         Page<CarPostMainPageReadResponse> page = carPostRepository.findPostsWithFirstImage(pageable);
         return page.getContent(); // 페이지에서 내용만 추출
  }


  public CarPostDetailsPageReadResponse getCarPostDetails(Long carPostId) {

      CarPostDetailsPageReadResponse response = carPostRepository.findCarPostDetailsById(carPostId);

      // 리스폰의 데이터가 있으면 여러 이미지를 받아오는 쿼리를 리스트화 하여 Dto에 넣어준다.
      if (response != null) {
          List<String> imageURLs = carPostRepository.findCarImageURLsByCarPostId(carPostId);
          response.setCarImagesURL(imageURLs);
      }
      return response;
  }

  public List<CarPostMainPageReadResponse> getMyPageCarPost (String userId,int limit,int offset) {
    Pageable pageable = PageRequest.of(offset / limit, limit); // 페이지 번호와 페이지 크기 설정
           Page<CarPostMainPageReadResponse> page = carPostRepository.findCarPostsByUserId(userId,pageable);
           return page.getContent(); // 페이지에서 내용만 추출
  }

  public List<CarPost> getA (){
    return carPostRepository.findAll();
  }

}
