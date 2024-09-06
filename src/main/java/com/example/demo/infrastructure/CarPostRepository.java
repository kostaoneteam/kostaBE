/*
package com.example.demo.infrastructure;


import com.example.demo.application.dto.carPostDto.CarPostDetailsPageReadResponse;
import com.example.demo.application.dto.carPostDto.CarPostMainPageReadResponse;
import com.example.demo.application.dto.carPostDto.CarPostMyPageReadResponse;
import com.example.demo.domain.CarPost;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CarPostRepository extends JpaRepository<CarPost, Long> {


    @Query("SELECT new com.example.demo.application.dto.carPostDto.CarPostMainPageReadResponse(" +
            "cp.id, cp.carModel, cp.brand, cp.carType, cp.mileage, cp.price, cp.displacement, cp.color, cp.userId.userId, " +
            "MIN(ci.carImagesURL), COUNT(l.id)) " +
            "FROM CarPost cp " +
            "LEFT JOIN cp.carImages ci " +
            "LEFT JOIN cp.likes l " +
            "WHERE ci.id = (SELECT MIN(c.id) FROM CarImages c WHERE c.carPost.id = cp.id) " +
            "GROUP BY cp.id, cp.carModel, cp.brand, cp.carType, cp.mileage, cp.price, cp.displacement, cp.color, cp.userId " +
            "ORDER BY cp.createdAt DESC ")
    Page<CarPostMainPageReadResponse> findPostsWithFirstImage(Pageable pageable);

    //userId를 가져옴 / 이미지컬럼은 제외함 -> 여러 이미지를 리스트화해야하는데 쿼리를 작성하면 List 를 못시킴
    @Query("SELECT new com.example.demo.application.dto.carPostDto.CarPostDetailsPageReadResponse(" +
            "cp.carModel, cp.brand, cp.carType, cp.mileage, cp.price, cp.displacement, cp.color) " +
            "FROM CarPost cp " +
            "JOIN cp.userId u " +
            "WHERE cp.id = :carPostId")
    CarPostDetailsPageReadResponse findCarPostDetailsById(@Param("carPostId") Long carPostId);

    // carPostid에 맞는 carImage들을 가져옴
    @Query("SELECT ci.carImagesURL FROM CarImages ci WHERE ci.carPost.id = :carPostId")
    List<String> findCarImageURLsByCarPostId(@Param("carPostId") Long carPostId);

  */
/*@Query("SELECT new com.example.demo.application.dto.carPostDto.CarPostMainPageReadResponse(" +
         "cp.id,cp.carModel, cp.brand, cp.carType, cp.mileage, cp.price, cp.displacement, cp.color, cp.userId.userId, " +
         "MIN(ci.carImagesURL)) " +
         "FROM CarPost cp " +
         "LEFT JOIN cp.carImages ci " +
         "WHERE ci.id = (SELECT MIN(c.id) FROM CarImages c WHERE c.carPost.id = cp.id) " +
         "AND cp.userId.userId = :userId " +
         "GROUP BY cp.id, cp.carModel, cp.brand, cp.carType, cp.mileage, cp.price, cp.displacement, cp.color, cp.userId " +
         "ORDER BY cp.createdAt DESC ")
  Page<CarPostMainPageReadResponse> findCarPostsByUserId(@Param("userId") String userId,Pageable);*//*


    @Query("SELECT new com.example.demo.application.dto.carPostDto.CarPostMyPageReadResponse"
            + "(cp.carModel, cp.createdAt) FROM CarPost cp where cp.userId.userId = :userId ORDER BY cp.createdAt DESC")
    List<CarPostMyPageReadResponse> findCarPostsByUserId(@Param("userId") String userId);





}*/
