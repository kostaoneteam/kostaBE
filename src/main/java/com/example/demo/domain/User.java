package com.example.demo.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true)
  private String userId;

  @Column(nullable = false)
  private String password;

  @Column(nullable = false, unique = true)
  private String eMail;

  @Column(nullable = false, unique = true, length = 50)
  private String phoneNumber;
<<<<<<< HEAD

  @Column(nullable = false, unique = true, length = 20)
=======
  @Column(nullable = false, length = 20)
>>>>>>> f7201aa3ba97944595125338727f3e4685fc5986
  private String userState;

  @JsonIgnore
  @OneToMany(mappedBy = "userId")
  private List<Likes> likes;

  @JsonIgnore
  @OneToMany(mappedBy = "userId")
  private List<CarPost> carPost;


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