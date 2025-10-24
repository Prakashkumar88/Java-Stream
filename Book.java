package javaStreams;

public class Book {
    String title;
    int publicationYear;
    double price;
    String category;

    public Book(String title,  double price, int publicationYear, String category) {
        this.title = title;
        this.publicationYear = publicationYear;
        this.price = price;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", publicationYear=" + publicationYear +
                ", price=" + price +
                ", category='" + category + '\'' +
                '}';
    }
}
