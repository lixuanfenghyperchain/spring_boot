package com.hyperchain.spring_boot.dao;

import com.hyperchain.spring_boot.entitiy.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDao extends JpaRepository<Book,Long> {
}
