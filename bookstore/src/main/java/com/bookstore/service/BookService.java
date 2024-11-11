package com.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bookstore.entity.Books;
import com.bookstore.repository.BookRepository;

@Service
public class BookService {
    @Autowired
    private BookRepository bRepo;

    public void save(Books b) {
        bRepo.save(b);
    }
    public List<Books> getAllBook()
    {
    	return bRepo.findAll();
    }
    public Books c(int id)
    {
    	return bRepo.findById(id).get();
    }
    /*yeh me banayi*/
	public Books getBookById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	public void deleteById(int id)
	{
		bRepo.deleteById(id);
	}
    
}
