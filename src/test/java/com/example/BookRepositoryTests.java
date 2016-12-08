package com.example;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.Category;
import com.example.domain.Book;
import com.example.domain.BookRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTests {

    @Autowired
    private BookRepository repository;

    @Test
    public void findByTitleShouldReturnAuthor() {
        List<Book> books = repository.findByTitle("Gone Girl");
        
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getTitle()).isEqualTo("Gillian Flynn");
    }
    
    @Test
    public void createNewBook() {
    	Book book = new Book("The Shining", "Stephen King", 1980, "9780450040184", 10.00, new Category("Fiction"));
    	repository.save(book);
    	assertThat(book.getId()).isNotNull();
    }
    
    @Test
    public void deleteBook() {
    	List<Book> books = repository.findByTitle("Gone Girl");
    	repository.delete(books.get(0).getId());
    	assertThat(repository.findOne(books.get(0).getId()) == null);
    }
    

}