package com.inq.kgulibrary.controller;

import com.inq.kgulibrary.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/book")
@RestController
public class BookController {

    private final BookService bookService;

    @GetMapping("/searchAll")
    public void searchAll() {
        bookService.searchAll();
    }

    @GetMapping("/searchOne/{bookName}")
    public void searchByName(@PathVariable String bookName) {
        bookService.searchByName(bookName);
    }

    @GetMapping("/searchOne/{bookAuthor}")
    public void searchByAuthor(@PathVariable String bookAuthor) {
        bookService.searchByAuthor(bookAuthor);
    }
}
