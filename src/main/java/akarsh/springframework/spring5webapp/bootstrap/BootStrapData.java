package akarsh.springframework.spring5webapp.bootstrap;

import akarsh.springframework.spring5webapp.domain.Author;
import akarsh.springframework.spring5webapp.domain.Book;
import akarsh.springframework.spring5webapp.repositories.AuthorRepository;
import akarsh.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;

public class BootStrapData implements CommandLineRunner{
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author chris = new Author("Chris","Evans");
        Book ca = new Book("Captian America","2011");

        chris.getBooks().add(ca);
        ca.getAuthors().add(chris);

        authorRepository.save(chris);
        bookRepository.save(ca);

        Author robert = new Author("Robert","Downey Jr");
        Book im = new Book("Iron Man","2008");
        robert.getBooks().add(im);
        im.getAuthors().add(robert);

        authorRepository.save(robert);
        bookRepository.save(im);

        System.out.println("Starting from BootStrap");
        System.out.println("Number of Book"+bookRepository.count());

    }
}
