package com.example.demo.application.dto.userDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class UserDetailsReadResponse {
  private String userName;
  private String phoneNumber;
  private String userImagesURL;

}
