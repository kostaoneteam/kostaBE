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
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;
  @Column(nullable = false, unique = true,length = 20)
  String userId;
  @Column(nullable = false,length = 255)
  String password;
  @Column(nullable = false, unique = true,length = 100)
  String eMail;
  @Column(nullable = false, unique = true,length = 20)
  String phoneNumber;

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
