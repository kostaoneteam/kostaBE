package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
<<<<<<< HEAD
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
=======
import jakarta.persistence.*;

>>>>>>> 87890a45762d8a607859a928602af5b570703cb1
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "car_images")
@Getter
@Setter
@NoArgsConstructor
public class CarImages {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) // 엔티티의 PK 자동 생성
  private Long id;

<<<<<<< HEAD
=======
  @Lob
>>>>>>> 87890a45762d8a607859a928602af5b570703cb1
  private String carImagesURL;

  @CreationTimestamp
  private LocalDateTime createdAt;

  @ManyToOne
  @JoinColumn(name = "carpost_id")
  private CarPost carPost;
}