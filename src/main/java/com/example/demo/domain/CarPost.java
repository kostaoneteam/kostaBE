package com.example.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "car_details")
@Getter
@Setter
@NoArgsConstructor
public class CarPost {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private int price;
  @ManyToOne
  @JoinColumn(name = "CarType")
  private CarType carTypeId;

  @ManyToOne
  @JoinColumn(name = "userId")
  private User userId;

/*  @ManyToOne
  @JoinColumn(name = "CarImages")
  private CarImages carImagesId;*/

  @OneToMany(mappedBy = "CarType")
  private List<Like> like;

  //private String carImageURL;

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
