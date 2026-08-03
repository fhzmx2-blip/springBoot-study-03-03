package com.sist.web.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Table(name="board") 
@DynamicUpdate
@Data
public class BoardEntity {
   @Id
   private int no;
   private String name,subject,content;
   @Column(insertable = true,updatable = false)
   private String pwd;
   private int hit;
   @Column(insertable = true,updatable = false)
   private String regdate;
   
   @PrePersist
   public void regdate() {
	   this.regdate=LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
   }
}