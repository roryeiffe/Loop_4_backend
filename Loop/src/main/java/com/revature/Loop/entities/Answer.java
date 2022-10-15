package com.revature.Loop.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String category;
    @Column(unique = true)
    String answer;

    public Answer(String category, String answer) {
        this.category = category;
        this.answer = answer;
    }
}
