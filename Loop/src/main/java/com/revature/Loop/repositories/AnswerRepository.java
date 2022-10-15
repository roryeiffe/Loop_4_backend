package com.revature.Loop.repositories;

import com.revature.Loop.entities.Answer;
import com.revature.Loop.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {

    @Query(value = "SELECT * FROM answer where category = ?1 ORDER BY RANDOM() LIMIT ?2", nativeQuery = true)
    List<Answer> getRandomAnswers(String category, int numAnswers);
}
