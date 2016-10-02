package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.domain.Book;
import com.example.domain.BookRepository;
import com.example.domain.Category;
import com.example.domain.CategoryRepository;

import com.example.BookstoreApplication;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);		
	}
	
	@Bean
	public CommandLineRunner bookstoreDemo(BookRepository repository, CategoryRepository crepository) {
		return (args) -> {
			log.info("enter sample books");
			crepository.save(new Category("Fiction"));
			crepository.save(new Category("Non-fiction"));
			
			repository.save(new Book("Gone Girl", "Gillian Flynn", 2012, "9780307588364", 10.00, crepository.findByName("Fiction").get(0)));
			repository.save(new Book("The Girl on the Train", "Paula Hawkins", 2015, "9781594633669", 12.00, crepository.findByName("Fiction").get(0)));
			
			log.info("show all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
			
			log.info("show all categories");
			for (Category cat : crepository.findAll()) {
				log.info(cat.toString());
			}

		};
		
	}
			
}
