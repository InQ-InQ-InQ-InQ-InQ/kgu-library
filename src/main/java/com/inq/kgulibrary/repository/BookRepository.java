package com.inq.kgulibrary.repository;

import com.inq.kgulibrary.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findByBookId(String bookId);

    Optional<Book> findByBookName(String bookName);

    Optional<Book> findByBookAuthor(String bookAuthor);
}
