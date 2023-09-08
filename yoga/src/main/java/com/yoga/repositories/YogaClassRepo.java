package com.yoga.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yoga.models.YogaClass;
@Repository
public interface YogaClassRepo extends JpaRepository<YogaClass, Long> {


	 
}
