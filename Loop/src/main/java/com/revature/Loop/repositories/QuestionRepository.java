package com.revature.Loop.repositories;

import com.revature.Loop.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    @Query(value = "SELECT * FROM question where category = ?1 ORDER BY random() LIMIT ?2", nativeQuery = true)
    List<Question> getRandomQuestions(String category, int numQuestions);
}
