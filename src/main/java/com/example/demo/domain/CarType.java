package com.example.demo.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "car_post")
@Getter
@Setter
@NoArgsConstructor
public class CarPost {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Long carDetailsId;

  private int price;
  private int modelYear;
  private String userId;
  private int likes;
  private String carImageURL;


  @Column(updatable = false)
  @CreationTimestamp
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
  private LocalDateTime deletedAt;

  @PrePersist
      @PreUpdate
      protected void onUpdateTimestamp() {
          if (createdAt == null) {
              createdAt = LocalDateTime.now();
          } else {
              updatedAt = LocalDateTime.now();
          }
      }


}
