package com.interview.entity;

import java.io.Serializable;

/**
 * 管理员实体类.
 *
 * @author rxliuli
 */
public class Admin implements Serializable {

  private Long id;
  private String adminName;
  private String password;

  public Admin() {
  }

  public Admin(Long id, String adminName, String password) {

    this.id = id;
    this.adminName = adminName;
    this.password = password;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }


  public String getAdminName() {
    return adminName;
  }

  public void setAdminName(String adminName) {
    this.adminName = adminName;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

}
