package com.nie.myspring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nie.myspring.entity.Book;

public interface ReadingListRepository extends JpaRepository<Book, Long> {

	List<Book> findByReader(String reader);
}
