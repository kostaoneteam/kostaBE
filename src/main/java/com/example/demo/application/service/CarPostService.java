package com.example.demo.application.service;

import com.example.demo.application.dto.carPostDto.CarPostMainReadResponse;
import com.example.demo.infrastructure.CarPostRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarPostService {

  private final CarPostRepository carPostRepository;

  public List<CarPostMainReadResponse> getAll(int page, int size) {
    Pageable pageable = PageRequest.of(page, size);
    return carPostRepository.findAll(pageable).stream()
        .map(CarPostMainReadResponse::new)
        .collect(Collectors.toList());
  }
}
