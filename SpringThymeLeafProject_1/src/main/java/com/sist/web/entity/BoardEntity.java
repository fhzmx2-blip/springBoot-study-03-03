package com.sist.web.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Table(name="jpaboard") 
@DynamicUpdate
@Data
@DynamicInsert
@SequenceGenerator(
  name="jpb_no_seq",
  sequenceName = "jpb_no_seq",
  allocationSize = 1
)

public class BoardEntity {
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "jpb_no_seq")
   private int no;
   private String name,subject,content;
   @Column(insertable = true,updatable = false)
   private String pwd;
   
   @ColumnDefault("0")
   private int hit;
   
   @Column(insertable = true,updatable = false)
   @ColumnDefault("SYSDATE")
   private String regdate;
   
   @PrePersist
   public void regdate() {
	   this.regdate=LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
   }
}