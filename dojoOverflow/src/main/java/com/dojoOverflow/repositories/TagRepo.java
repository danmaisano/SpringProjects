package com.dojoOverflow.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dojoOverflow.models.Tag;

	public interface TagRepo extends JpaRepository<Tag, Long> {
	    Optional<Tag> findBySubject(String subject);

}
