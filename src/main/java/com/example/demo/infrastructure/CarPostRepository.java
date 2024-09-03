package com.example.demo.infrastructure;


import com.example.demo.application.dto.carPostDto.CarPostReadResponse;
import com.example.demo.domain.CarPost;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CarPostRepository extends JpaRepository<CarPost, Long> {


  @Query("SELECT new com.example.demo.application.dto.carPostDto.CarPostReadResponse(" +
          "cp.carModel, cp.brand, cp.carType, cp.mileage, cp.price, cp.displacement, cp.color, cp.userId.userId, " +
          "MIN(ci.carImagesURL)) " +
          "FROM CarPost cp " +
          "LEFT JOIN cp.carImages ci " +
          "WHERE ci.id = (SELECT MIN(c.id) FROM CarImages c WHERE c.carPost.id = cp.id) " +
          "GROUP BY cp.id, cp.carModel, cp.brand, cp.carType, cp.mileage, cp.price, cp.displacement, cp.color, cp.userId " +
          "ORDER BY cp.createdAt DESC ")
  Page<CarPostReadResponse> findPostsWithFirstImage(Pageable pageable);


}
