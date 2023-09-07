package com.dojoOverflow.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dojoOverflow.models.Question;
@Repository
public interface QuestionRepo extends JpaRepository<Question, Long> {

}
