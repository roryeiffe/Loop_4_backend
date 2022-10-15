package com.revature.Loop.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Entity
@Data
@AllArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String password;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id", referencedColumnName = "id")
    List<Player> players;
    String category;
    // questions that will be asked
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "room_questions",
            joinColumns = @JoinColumn(name = "room_id"),
            inverseJoinColumns = @JoinColumn(name = "question_id"))
    List<Question> questions;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "room_answers",
            joinColumns = @JoinColumn(name = "room_id"),
            inverseJoinColumns = @JoinColumn(name = "answer_id"))
    List<Answer> answers;
    // secret answer:
    String answer;

    public Room() {
        this.players = new ArrayList<>();
        this.questions = new ArrayList<>();
        this.answers = new ArrayList<>();
        this.answer = "";
        this.category = "food";
        // randomly generate password:
        Random generator = new Random();
        String password = "";
        for (int i = 0;i < 5; i ++) {
            int c = 65 + generator.nextInt(26);
            char ch = (char) c;
            password += ch;
        }
        this.setPassword(password);

    }
}
