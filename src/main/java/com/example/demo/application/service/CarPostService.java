package com.example.demo.application.service;

import com.example.demo.application.dto.carPostDto.CarPostReadResponse;
import com.example.demo.domain.CarPost;
import com.example.demo.infrastructure.CarPostRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarPostService {

  private final CarPostRepository carPostRepository;

  public List<CarPostReadResponse> getAll(int limit,int offset) {

         Pageable pageable = PageRequest.of(offset / limit, limit); // 페이지 번호와 페이지 크기 설정
         Page<CarPostReadResponse> page = carPostRepository.findPostsWithFirstImage(pageable);
         return page.getContent(); // 페이지에서 내용만 추출
  }
}
