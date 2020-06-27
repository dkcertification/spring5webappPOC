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

        Publisher pub1 = new Publisher();
        pub1.setName("SFG Publishing");
        pub1.setCity("St Petersburg");
        pub1.setState("FL");
        publisherRepository.save(pub1);
        System.out.println("Publisher Count: " + publisherRepository.count());

        Author Eric = new Author("Eric","Evan");
        Book book1 = new Book("Domain Driven Design", "12345");
        Eric.getBooks().add(book1);
        book1.getAuthors().add(Eric);
        book1.setPublisher(pub1);
        pub1.getBooks().add(book1);

        authorRepository.save(Eric);
        bookRepository.save(book1);

        Author Shalini = new Author("Shalini", "Kurup");
        Book book2 = new Book("Self Realization", "252525");
        Shalini.getBooks().add(book2);
        book2.getAuthors().add(Shalini);
        book2.setPublisher(pub1);
        pub1.getBooks().add(book2);

        authorRepository.save(Shalini);
        bookRepository.save(book2);


        Author Dilip = new Author("Dilip", "Kurup");
        Book book3 = new Book("New Techstack 2020", "8789556");
        Dilip.getBooks().add(book3);
        book3.getAuthors().add(Dilip);
        book3.setPublisher(pub1);
        pub1.getBooks().add(book3);

        authorRepository.save(Dilip);
        bookRepository.save(book3);

        publisherRepository.save(pub1);

        System.out.println("Started in BootStrap");
        System.out.println("Number of Books : " + bookRepository.count());
        System.out.println("Publisher Number of books : " + pub1.getBooks().size());
    }
}
