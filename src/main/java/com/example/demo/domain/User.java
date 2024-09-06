package com.example.demo.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
<<<<<<< HEAD
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
=======
import jakarta.persistence.*;
>>>>>>> 87890a45762d8a607859a928602af5b570703cb1

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

  @Column(nullable = false)
  private String userName;

  @Column(nullable = false, unique = true)
  private String eMail;

  @Column(nullable = false, unique = true, length = 50)
  private String phoneNumber;

  @Column(nullable = false, length = 20)
  private String userState;

  @Lob
<<<<<<< HEAD
=======
  @Column(nullable = false)
>>>>>>> 87890a45762d8a607859a928602af5b570703cb1
  private String userImagesURL;

  @OneToMany(mappedBy = "userId")
  private List<Likes> likes;

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