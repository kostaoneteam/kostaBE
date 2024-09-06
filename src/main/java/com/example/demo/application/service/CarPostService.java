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

<<<<<<< HEAD
<<<<<<< HEAD
    private static final String DEFAULT_IMAGE_URL = "https://i.pinimg.com/originals/ff/c2/37/ffc2379c099c0b25bb7e6afaba5748fb.jpg";
    private final CarPostRepository carPostRepository;
    private final UserRepository userRepository;
    private final LikesRepository likesRepository;
=======
  private static final String DEFAULT_IMAGE_URL = "https://i.pinimg.com/originals/ff/c2/37/ffc2379c099c0b25bb7e6afaba5748fb.jpg";
  private final CarPostRepository carPostRepository;
  private final UserRepository userRepository;
  private final LikesRepository likesRepository;
>>>>>>> 6c3320ed438cdcbe8d3fad9189be3dcec6653b05
=======
  private final CarPostRepository carPostRepository;
>>>>>>> parent of 17b77ef (test)

  public List<CarPostMainPageReadResponse> getAll(int limit,int offset) {

         Pageable pageable = PageRequest.of(offset / limit, limit); // 페이지 번호와 페이지 크기 설정
         Page<CarPostMainPageReadResponse> page = carPostRepository.findPostsWithFirstImage(pageable);
         return page.getContent(); // 페이지에서 내용만 추출
  }


  public CarPostDetailsPageReadResponse getCarPostDetails(Long carPostId) {

<<<<<<< HEAD
<<<<<<< HEAD
        CarPostDetailsPageReadResponse response = carPostRepository.findCarPostDetailsById(carPostId);
        List<UserDetailsReadResponse> userDetailsList = userRepository.findUserByCarPostId(carPostId);
=======
      CarPostDetailsPageReadResponse response = carPostRepository.findCarPostDetailsById(carPostId);
>>>>>>> parent of 17b77ef (test)

      // 리스폰의 데이터가 있으면 여러 이미지를 받아오는 쿼리를 리스트화 하여 Dto에 넣어준다.
      if (response != null) {
          List<String> imageURLs = carPostRepository.findCarImageURLsByCarPostId(carPostId);
          response.setCarImagesURL(imageURLs);
      }
      return response;
  }

<<<<<<< HEAD
        for (UserDetailsReadResponse details : userDetailsList) {
            if (details.getUserImagesURL() == null || details.getUserImagesURL().isEmpty()) {
                details.setUserImagesURL(DEFAULT_IMAGE_URL);
            }
        }
        // 리스폰의 데이터가 있으면 여러 이미지를 받아오는 쿼리를 리스트화 하여 Dto에 넣어준다.
        if (response != null) {
            List<String> imageURLs = carPostRepository.findCarImageURLsByCarPostId(carPostId);
            response.setCarImagesURL(imageURLs);
            */
/*response.setUser(userDetailsList);*//*

        }
        return response;
    }

*/
=======
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

>>>>>>> 6c3320ed438cdcbe8d3fad9189be3dcec6653b05
/*  public List<CarPostMyPageReadResponse> getMyPageCarPost (String userId,int limit,int offset) {
           Pageable pageable = PageRequest.of(offset / limit, limit); // 페이지 번호와 페이지 크기 설정
           Page<CarPostMyPageReadResponse> page = carPostRepository.findCarPostsByUserId(userId,pageable);
           return page.getContent(); // 페이지에서 내용만 추출
<<<<<<< HEAD
  }*//*
=======
  }*/

  public List<CarPostMyPageReadResponse> getMyPageCarPost (String userId) {
    return carPostRepository.findCarPostsByUserId(userId);
  }
>>>>>>> 6c3320ed438cdcbe8d3fad9189be3dcec6653b05
=======
  public List<CarPostMainPageReadResponse> getMyPageCarPost (String userId,int limit,int offset) {
    Pageable pageable = PageRequest.of(offset / limit, limit); // 페이지 번호와 페이지 크기 설정
           Page<CarPostMainPageReadResponse> page = carPostRepository.findCarPostsByUserId(userId,pageable);
           return page.getContent(); // 페이지에서 내용만 추출
  }
>>>>>>> parent of 17b77ef (test)

  public List<CarPost> getA (){
    return carPostRepository.findAll();
  }
}