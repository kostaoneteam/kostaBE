package com.example.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "car_images")
@Getter
@Setter
@NoArgsConstructor
public class CarImages {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) // 엔티티의 PK 자동 생성
  private Long id;
  private String carImagesURL;

  @CreationTimestamp
  private LocalDateTime createdAt;

  @OneToMany(mappedBy = "carImages")
  private List<CarPost> CarPost;
}
