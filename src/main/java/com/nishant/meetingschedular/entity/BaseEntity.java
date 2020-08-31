package com.nishant.meetingschedular.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import lombok.Data;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Data
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected Long id;

  @Version
  protected Integer version;

  @Column(length = 19, columnDefinition = "datetime DEFAULT CURRENT_TIMESTAMP")
  @CreatedDate
  protected LocalDateTime created = LocalDateTime.now();

  @Column(length = 19, columnDefinition = "datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
  @Generated(GenerationTime.ALWAYS)
  @LastModifiedDate
  protected LocalDateTime lastupdated = LocalDateTime.now();

  @Column(columnDefinition = "tinyint(1) default 1")
  protected Boolean activeflag = true;
}
