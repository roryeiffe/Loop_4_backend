package com.revature.Loop.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int total_score;
    private int current_score;
    private int vote_count;
    private boolean inLoop;

    public Player() {
        this.name = name;
        this.total_score = this.current_score = this.vote_count = 0;
        this.inLoop = true;
        return;
    }


}
