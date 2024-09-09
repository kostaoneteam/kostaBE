package com.example.demo.infrastructure;

import com.example.demo.domain.CarImages;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarImageRepository extends JpaRepository<CarImages, Long> {

}
