package com.nishant.meetingschedular.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "user_email")
public class UserEmail extends BaseEntity {

  @Column
  private String email;

  @Column
  private String password;
}
