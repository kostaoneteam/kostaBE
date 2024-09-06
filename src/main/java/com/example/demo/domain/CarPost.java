package com.example.demo.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
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
  private String carModel;
  private String brand;
  private String carType;
  private String carYear;
  private int mileage;
  private int price;
  private String displacement;
  private String color;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User userId;

  @OneToMany(mappedBy = "carPost", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<CarImages> carImages;

  @OneToMany(mappedBy = "postId", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Likes> likes;



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