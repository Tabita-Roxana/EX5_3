package com.example.demo.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class User implements Serializable
{
  private @Id @GeneratedValue int id;
  private String email;
  private String password;

  public User( String email, String password)
  {
    this.email = email;
    this.password = password;
  }

  public User() {

  }

  public int getId()
  {
    return id;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public String getEmail()
  {
    return email;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public String getPassword()
  {
    return password;
  }

  public void setPassword(String password)
  {
    this.password = password;
  }

  @Override public String toString()
  {
    return "User{" + "id=" + id + ", email='" + email + '\'' + ", password='"
        + password + '\'' + '}';
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.email, this.password);
  }
}
