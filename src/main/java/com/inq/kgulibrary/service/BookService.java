package com.inq.kgulibrary.service;

import com.inq.kgulibrary.domain.Book;
import com.inq.kgulibrary.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> searchAll() {
        return bookRepository.findAll();
    }

    public Optional<Book> searchByName(String bookName) {
        return bookRepository.findByBookName(bookName);
    }

    public Optional<Book> searchByAuthor(String bookAuthor) {
        return bookRepository.findByBookAuthor(bookAuthor);
    }

    public Optional<Book> searchOneDetail(String bookId) {
        return bookRepository.findByBookId(bookId);
    }
}
