package com.hyperchain.spring_boot.dao;

import com.hyperchain.spring_boot.entitiy.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, String> {
}
