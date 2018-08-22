package com.hyperchain.spring_boot.dao;

import com.hyperchain.spring_boot.entitiy.BookAuthor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookAuthorRepository extends JpaRepository<BookAuthor, String> {
}
