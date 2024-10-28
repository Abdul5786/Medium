package com.Abdul.Medium.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="comments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comments
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cid;

    private String comment;
    @ManyToOne
    private Post post;
    @ManyToOne
    private User user;








}
