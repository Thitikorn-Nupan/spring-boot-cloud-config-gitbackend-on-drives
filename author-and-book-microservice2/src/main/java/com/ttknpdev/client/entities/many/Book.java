package com.ttknpdev.client.entities.many;

import com.ttknpdev.client.entities.one.Author;
import jakarta.persistence.*;

@Entity
@Table(name = "books")
// must have constructor() {} null arg
public class Book {
    @Id // Mark is a Pk
    private String bid;
    private String title;
    private String releaseDate; // mean @Column("release_date")
    private Float price;
    /*
    -- the @JoinColumn annotation to specify the foreign key column (eid).
    -- If you don’t provide the JoinColumn name, the name will be set automatically.
    -- @JsonIgnore is used to ignore the logical property used in serialization and deserialization.
    */
    @JoinColumn(name = "aid")
    @ManyToOne(fetch = FetchType.EAGER) // By default, the @ManyToOne association uses FetchType.EAGER for fetch type but it is bad for performance *** if you use FetchType.LAZY you have to use with @JsonIgnore
    /*
    if you use FetchType.EAGER
    {
        "bid": "B000",
        "title": "Let her go",
        "releaseDate": "2013-03-31",
        "price": 13.79,
        "author": {
            "aid": "A000",
            "fullname": "Alex Slider",
            "age": 29,
            "alive": true
        }
    },
    {
        "bid": "B001",
        "title": "We did it",
        "releaseDate": "2007-01-01",
        "price": 9.79,
        "author": {
            "aid": "A000",
            "fullname": "Alex Slider",
            "age": 29,
            "alive": true
        }
    }
    */
    // @JsonIgnore // @JsonIgnore is used to ignore the logical property used in serialization and deserialization.
    private Author author;

    public Book(String bid, String title, String releaseDate, Float price, Author author) {
        this.bid = bid;
        this.title = title;
        this.releaseDate = releaseDate;
        this.price = price;
        this.author = author;
    }

    public Book() {
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bid='" + bid + '\'' +
                ", title='" + title + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", price=" + price +
                ", author=" + author +
                '}';
    }
}
