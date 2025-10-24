package javaStreams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class terminalOperations {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book("Fiction", 15.99, 2018, "The Silent Garden"),
                new Book("Science", 22.50, 2020, "Cosmic Wonders"),
                new Book("Fiction", 12.75, 2005, "Echoes in the Rain"),
                new Book("Biography", 18.00, 2022, "A Life in Code"),
                new Book("Technology", 35.90, 2023, "Java Stream Mastery"),
                new Book("Fiction", 14.50, 2018, "The Midnight Library"),
                new Book("Science", 25.99, 2015, "Quantum Realm"),
                new Book("Technology", 40.00, 2023, "Advanced Spring Boot"),
                new Book("Biography", 16.99, 2019, "The Innovator's Journey"),
                new Book("Fiction", 9.99, 1998, "Old Man and the Sea")
        );

        // Total cost of all books in the bookstore
        System.out.println(books.stream().mapToDouble(book -> book.price).reduce(0,Double::sum));

        // Collecting books into a list of titles
        //List<String> booksCollection = books.stream().map(book -> book.title).collect(Collectors.toList());
        List<String> booksCollection = books.stream().map(book -> book.title).toList();
        System.out.println(booksCollection);
        //booksCollection.forEach(System.out::println);

        // Grouping books by Title
//        Map<String, List<Book>> titleToName = books.stream().collect(Collectors.groupingBy(bookStringFunction));
//        System.out.println(titleToName);

        Map<String, List<Book>> titleToName = books.stream().collect(Collectors.groupingBy(Book::getCategory));
//        titleToName.forEach((category, bookList) -> bookList.forEach(System.out::println));
        System.out.println(titleToName);

    }

    static Function<Book, String> bookStringFunction = new Function<Book, String>() {
        @Override
        public String apply(Book book) {
            return book.getCategory();
        }
    };
}
