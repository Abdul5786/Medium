package com.Abdul.Medium.entities;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name="User")
@NoArgsConstructor
public class User implements Serializable
  {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private int id;


      @Column(name="user_name" ,nullable = false,length = 100)
      private String name;
      @Column(name = "user_email",nullable = false,length = 100)
      private String email;
      @Column(name="user_password",nullable = false,length = 100)
      private String password;
      @Column(name="user_about",nullable = false,length = 100)
      private String about;

      @ManyToMany(mappedBy = "likedBy")
      private Set<Post> likedPosts = new HashSet<>();

      @OneToMany(mappedBy = "user", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
       List<Post> postList= new ArrayList<>();

      @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL)
       List<Comments> comments=new ArrayList<>();

      public int getId() {
          return id;
      }

      public String getName() {
          return name;
      }

      public String getEmail() {
          return email;
      }

      public String getPassword() {
          return password;
      }

      public void setId(int id) {
          this.id = id;
      }

      public void setName(String name) {
          this.name = name;
      }

      public void setEmail(String email) {
          this.email = email;
      }

      public void setPassword(String password) {
          this.password = password;
      }

      public void setAbout(String about) {
          this.about = about;
      }

      public String getAbout() {
          return about;
      }

      public List<Post> getPostList() {
      return postList;
  }

      public void setPostList(List<Post> postList) {
          this.postList = postList;
      }

      public List<Comments> getComments() {
          return comments;
      }

      public void setComments(List<Comments> comments) {
          this.comments = comments;
      }
  }
