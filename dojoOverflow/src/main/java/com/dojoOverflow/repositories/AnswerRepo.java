package com.dojoOverflow.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dojoOverflow.models.Answer;

@Repository
public interface AnswerRepo extends JpaRepository<Answer, Long> {

}
