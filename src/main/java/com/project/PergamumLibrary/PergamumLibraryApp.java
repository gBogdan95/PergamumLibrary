// Here we are creating a Spring Boot app with five HTTP endpoints, one for each functionality

package com.project.PergamumLibrary;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@RequestMapping("/library")
public class PergamumLibraryApp {
	private Library library;

	public PergamumLibraryApp() {
		this.library = new Library();
	}

	// The @PostMapping annotation maps the "addBook" method to the "/library/books" endpoint
	@PostMapping("/books")
	public ResponseEntity<String> addBook(@RequestBody Book book) {
		this.library.addBook(book);
		return ResponseEntity.ok("Book added successfully.");
	}

	// The @GetMapping annotation maps the "addBook" method to the "/library/books" endpoint
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getAllBooksSorted() {
		List<Book> sortedBooks = this.library.getAllBooksSorted();
		return ResponseEntity.ok(sortedBooks);
	}

	// The @DeleteMapping annotation maps the "addBook" method to the "/library/books" endpoint
	@DeleteMapping("/books")
	public ResponseEntity<String> deleteBook(@RequestBody Book book) {
		library.deleteBook(book);
		return ResponseEntity.ok("Book deleted successfully");
	}

	// The @GetMapping annotation maps the "addBook" method to the "/library/books/title" endpoint
	@GetMapping("/books/title")
	public ResponseEntity<Book> getBookByTitle(@RequestParam String title) {
		Book book = library.getBookByTitle(title);
		if (book != null) {
			return ResponseEntity.ok(book);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// The @PutMapping annotation maps the "addBook" method to the "/library/books/author" endpoint
	@PutMapping("/books/author")
	public ResponseEntity<Void> updateAuthor(@RequestParam String title, @RequestParam String author) {
		boolean updated = library.updateAuthor(title, author);
		if (updated) {
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// Here we define the main method
	public static void main(String[] args) {
		SpringApplication.run(PergamumLibraryApp.class, args);
	}
}