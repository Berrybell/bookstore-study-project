package com.example.web;

import java.util.List;

import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.domain.Book;
import com.example.domain.BookRepository;
import com.example.domain.CategoryRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Controller
public class BookController {
	@Autowired
	private BookRepository repository;
	@Autowired
	private CategoryRepository crepository;
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
    public String index(Model model) {
        return "index";        
    }
	
	@RequestMapping(value = "/addbook")
    public String addBook(Model model){
    	model.addAttribute("book", new Book());
    	model.addAttribute("categories", crepository.findAll());
        return "addbook";
    }
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book){
        repository.save(book);
        return "redirect:booklist";
    }    

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
    	repository.delete(bookId);
        return "redirect:/booklist";
    }   
	
	@RequestMapping(value="/booklist", method=RequestMethod.GET)
    public String booklist(Model model) {
        // Add books to model and return to view
        model.addAttribute("books", repository.findAll());
        return "booklist";        
    }
	
	// RESTful service to get all books
	@ManyToOne
	@JsonIgnore
    @RequestMapping(value="/books", method = RequestMethod.GET)
    public @ResponseBody List<Book> bookListRest() {	
        return (List<Book>) repository.findAll();
    }    

	// RESTful service to get book by id
    @RequestMapping(value="/book/{id}", method = RequestMethod.GET)
    public @ResponseBody Book findBookRest(@PathVariable("id") Long bookId) {	
    	return repository.findOne(bookId);
    } 

}
