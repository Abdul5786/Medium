package com.Abdul.Medium.entities;



import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name ="category_table")
@NoArgsConstructor
public class Category
{
    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", postList=" + postList +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="category_title" ,nullable = false,length = 100)
    private String title;
    @Column(name = "category_description",nullable = false ,length = 100)
    private String description;

    @OneToMany(mappedBy = "category" ,cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
    private List<Post> postList= new ArrayList<>();


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
