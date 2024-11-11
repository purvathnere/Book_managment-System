package com.bookstore.bookstore;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.bookstore.entity.Books;
import com.bookstore.entity.MyBookList;
import com.bookstore.service.BookService;
import com.bookstore.service.MyBookListService;

@Controller
public class BookStoreController {
   //@Autowired
    private BookService service;

    //@Autowired
    private MyBookListService myBookService;
    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/book_register")
    public String bookRegister() {
        return "bookRegister";
    }

    
    @GetMapping("/available_books")
    public ModelAndView getAllBook() {
        List<Books> list = service.getAllBook();  
        ModelAndView m = new ModelAndView("bookList");  
        m.addObject("book", list);  
        return m;  
    }

    @PostMapping("/save")
    public String addBook(@ModelAttribute Books b) {
        service.save(b);
        return "redirect:/available_books";
    }
    @GetMapping("my_books")
    public String getMyBooks()
    {
    	List<MyBookList>list=myBookService.getAllMyBooks();
    	//ise thik karna hai
    	//model.addAttribute("book",list);
    	return "myBooks";
    	
    }
    @RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable("id")int id) {
    	Books b=service.getBookById(id);
    	MyBookList mb=new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
    	myBookService.saveMyBooks(mb);
    	return "redirect:/my_books";
    }
   
    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id")int id,Model model)
    {
    	Books b=service.getBookById(id);
    	model.addAttribute("book",b);
    	return "BookEdit";
    }
    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") int id)
    {
    	//service.deleteById(id);
    	return "redirect:/available_books";
    }
}
