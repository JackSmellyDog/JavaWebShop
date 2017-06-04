package com.spring.project.dao;

import com.spring.project.model.Meme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemeDao extends JpaRepository<Meme, Long> {
}
