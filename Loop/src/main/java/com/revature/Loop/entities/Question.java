package com.revature.Loop.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String category;
    private String question;
    @ManyToMany
    private List<Room> rooms;

    public Question(String cat, String question) {
        this.category = cat;
        this.question = question;
        this.rooms = new ArrayList<>();
    }
}
