package com.example.demo.infrastructure;


import com.example.demo.domain.CarPost;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CarPostRepository extends JpaRepository<CarPost, Long> {

  @Query("SELECT p FROM CarPost p LEFT JOIN p.carImages i WHERE i.createdAt = (SELECT MIN(i2.createdAt) FROM CarImages i2 WHERE i2.post = p)")
  List<CarPost> findPostsWithFirstImage();


}
