package com.mahtzak.giveAwayThingsApp.domain.model;


import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

 // @NotNull
  @Size(min=3)
  private String username;
  @Pattern(regexp = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,}$",
  message = "Podano nieprawidłowy adres email!!!")
  @NotNull
  @Size(min=5)
    private String email;
  @Size(min=3, message="Nazwa użytkownika musi mieć co najmniej 3 znaki")
  @NotNull
  private String password;
  /*@OneToOne
  @JoinColumn(name = "details_id"
          , unique=true)
  private UserDetails userDetails;*/


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }



  /*public UserDetails getUserDetails() {
    return userDetails;
  }

  public void setUserDetails(UserDetails userDetails) {
    this.userDetails = userDetails;
  }

*/
}
