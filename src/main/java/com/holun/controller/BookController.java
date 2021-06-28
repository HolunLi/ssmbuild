package com.holun.controller;

import com.holun.entity.Books;
import com.holun.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    private BookService bookService;

    @Autowired
    @Qualifier("bookServiceImpl")
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/allBooks")
    public String allBooks(Model model) {
        List<Books> books = bookService.queryAllBooks();
        model.addAttribute("books", books);

        return "allBooks";
    }

    @RequestMapping("/toAddBookPage")
    public String toAddBookPage() {
        return "addBook";
    }

    @RequestMapping("/addBook")
    public String addBook(Books book) {
        bookService.addBook(book);

        return "redirect:/book/allBooks";
    }

    @RequestMapping("/toUpdateBookPage")
    public String updateBookPage(int id, Model model) {
        Books book = bookService.queryBookById(id);
        model.addAttribute("book", book);

        return "updateBook";
    }

    @RequestMapping("/updateBook")
    public String updateBook(Books book) {
        bookService.updateBookById(book);

        return "redirect:/book/allBooks";
    }

    @GetMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") int id) {
       bookService.deleteBookById(id);

        return "redirect:/book/allBooks";
    }

    @PostMapping("/queryBooksByName")
    public String queryBooksByName(@RequestParam("bookName") String bookName, Model model) {
        List<Books> books = bookService.queryBooksByName(bookName);
        model.addAttribute("books", books);

        return "allBooks";
    }
}
