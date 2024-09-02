package com.example.demo.infrastructure;


import com.example.demo.domain.CarPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarPostRepository extends JpaRepository<CarPost, Long> {


}
