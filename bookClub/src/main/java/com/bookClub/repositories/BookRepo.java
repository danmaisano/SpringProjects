package com.bookClub.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookClub.models.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {
 
 List<Book> findAll();
 
}
