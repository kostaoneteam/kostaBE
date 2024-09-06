package com.example.demo.domain;

<<<<<<< HEAD
import jakarta.persistence.*;

=======
import jakarta.persistence.CascadeType;
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
>>>>>>> 6c3320ed438cdcbe8d3fad9189be3dcec6653b05
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

  public CarPost(String carModel, String brand, String carType, String carYear, int mileage,
      int price, String displacement, String color) {
    this.carModel = carModel;
    this.brand = brand;
    this.carType = carType;
    this.carYear = carYear;
    this.mileage = mileage;
    this.price = price;
    this.displacement = displacement;
    this.color = color;
  }
}