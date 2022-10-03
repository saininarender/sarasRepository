package com.javatrainingschool;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.javatrainingschool.LibrarySpringBootApplication;
import com.javatrainingschool.entity.Book;
import com.javatrainingschool.repository.BookRepository;
import com.javatrainingschool.service.BookService;

@SpringBootTest(classes=LibrarySpringBootApplication.class)
public class BookServiceTest {
	
	@Mock 
	BookRepository bookRepo;
	
	@InjectMocks
	BookService bookService = new BookService();
	
	@Test
	public void testGetAllBooks() {
		
		List<Book> books = new ArrayList<>();
		Book b = new Book(1, "Learn Java", "Abc", 100, "borrowed");
		books.add(b);
		
		when(bookRepo.findAll()).thenReturn(books);
		List<Book> result = bookService.getAllBooks();
		
		Assertions.assertNotEquals(null, result);
		Assertions.assertTrue(result.get(0).getName().endsWith("-b"));
		Assertions.assertEquals("Learn Java-b", result.get(0).getName());
		Assertions.assertTrue(result.get(0).getAuthor().endsWith("Nishant"));
	}
}