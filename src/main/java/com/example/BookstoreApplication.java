package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.domain.Book;
import com.example.domain.BookRepository;
import com.example.BookstoreApplication;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);		
	}
	
	@Bean
	public CommandLineRunner bookstoreDemo(BookRepository repository) {
		return (args) -> {
			log.info("enter sample books");
			repository.save(new Book("Gone Girl", "Gillian Flynn", 2012, "9780307588364", 10.00));
			repository.save(new Book("The Girl on the Train", "Paula Hawkins", 2015, "9781594633669", 12.00));
			
			log.info("show all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
		
	}
			
}
