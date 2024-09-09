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
import org.springframework.security.core.parameters.P;

public interface CarPostRepository extends JpaRepository<CarPost, Long> {


/*    @Query("SELECT new com.example.demo.application.dto.carPostDto.CarPostMainPageReadResponse(" +
            "cp.id, cp.carModel, cp.brand, cp.carType, cp.mileage, cp.price, cp.displacement, cp.color, cp.userId.userId, " +
            "MIN(ci.carImagesURL), COUNT(l.id)) " +
            "FROM CarPost cp " +
            "LEFT JOIN cp.carImages ci " +
            "LEFT JOIN cp.likes l " +
            "WHERE ci.id = (SELECT MIN(c.id) FROM CarImages c WHERE c.carPost.id = cp.id) " +
            "GROUP BY cp.id, cp.carModel, cp.brand, cp.carType, cp.mileage, cp.price, cp.displacement, cp.color, cp.userId " +
            "ORDER BY cp.createdAt DESC ")*/

    @Query("SELECT new com.example.demo.application.dto.carPostDto.CarPostMainPageReadResponse(" +
            "cp.id, cp.carModel, cp.carYear, cp.carType, cp.mileage, cp.price, cp.displacement, cp.color, " +
            "CAST(cp.userId.userId AS string), " +
            "MIN(ci.carImagesURL), COUNT(l)) " +
            "FROM CarPost cp " +
            "LEFT JOIN cp.carImages ci " +
            "LEFT JOIN cp.likes l " +
            "GROUP BY cp.id, cp.carModel, cp.brand, cp.carType, cp.mileage, cp.price, cp.displacement, cp.color, cp.userId " +
            "ORDER BY cp.createdAt DESC")
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

  @Query("SELECT new com.example.demo.application.dto.carPostDto.CarPostMyPageReadResponse"
    + "(cp.carModel, cp.createdAt) FROM CarPost cp where cp.userId.userId = :userId ORDER BY cp.createdAt DESC")
  List<CarPostMyPageReadResponse> findCarPostsByUserId(@Param("userId") String userId);



  @Query("SELECT new com.example.demo.application.dto.carPostDto.CarPostMainPageReadResponse(" +
          "cp.id, cp.carModel, cp.carYear, cp.carType, cp.mileage, cp.price, cp.displacement, cp.color, " +
          "CAST(cp.userId.userId AS string), " +
          "MIN(ci.carImagesURL), COUNT(l)) " +
          "FROM CarPost cp " +
          "LEFT JOIN cp.carImages ci " +
          "LEFT JOIN cp.likes l " +
          "WHERE (:brand IS NULL OR cp.brand IN :brand) " +
          "AND (:carType IS NULL OR cp.carType IN :carType) " +
          "AND (:displacement IS NULL OR cp.displacement IN :displacement) " +
          "AND (:color IS NULL OR cp.color IN :color) " +
          "AND (:carYear IS NULL OR cp.carYear IN :carYear) " +
          "GROUP BY cp.id, cp.carModel, cp.brand, cp.carType, cp.mileage, cp.price, cp.displacement, cp.color, cp.userId " +
          "ORDER BY cp.createdAt DESC")
  Page<CarPostMainPageReadResponse> findByFiltersWithPagination(
      @Param("brand") List<String> brand,
      @Param("carType") List<String> carType,
      @Param("displacement") List<String> displacement,
      @Param("color") List<String> color,
      @Param("carYear") List<String> carYear,
      Pageable pageable);
}
