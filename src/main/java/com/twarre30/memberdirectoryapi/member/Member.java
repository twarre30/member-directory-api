package com.twarre30.memberdirectoryapi.member;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;

import lombok.Data;

@Entity
@Data
@Table(name = "member")
public class Member {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(name = "parentName")
  private String parentName;
  @Column(name = "daughterName")
  private String daughterName;
  @Column(name = "address")
  private String address;
  @Column(name = "email")
  private String email;
  @Column(name = "phoneNumber")
  private String phoneNumber;
}