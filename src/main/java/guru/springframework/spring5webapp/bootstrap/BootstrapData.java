package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository,
                         PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author Eric = new Author("Eric","Evan");
        Book book1 = new Book("Domain Driven Design", "12345");
        Eric.getBooks().add(book1);
        book1.getAuthors().add(Eric);
        authorRepository.save(Eric);
        bookRepository.save(book1);

        Author Shalini = new Author("Shalini", "Kurup");
        Book book2 = new Book("Self Realization", "252525");
        Shalini.getBooks().add(book2);
        book2.getAuthors().add(Shalini);
        authorRepository.save(Shalini);
        bookRepository.save(book2);


        Author Dilip = new Author("Dilip", "Kurup");
        Book book3 = new Book("New Techstack 2020", "8789556");
        Dilip.getBooks().add(book3);
        book3.getAuthors().add(Dilip);
        authorRepository.save(Dilip);
        bookRepository.save(book3);

        System.out.println("Started in BootStrap");
        System.out.println("Number of Books : " + bookRepository.count());

        Publisher pub = new Publisher("Technology Books", "Andheri","Mumbai", "Maharashtra","400072");
        publisherRepository.save(pub);
        System.out.println("Publisher Count : " + publisherRepository.count());
    }
}
