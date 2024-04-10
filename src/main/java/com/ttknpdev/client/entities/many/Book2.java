package com.ttknpdev.client.entities.many;

import com.ttknpdev.client.entities.one.Author;
// For response @ManyToOne
public class Book2 {
    private String bid;
    private String title;
    private String releaseDate; // mean @Column("release_date")
    private Float price;
    private Author author;

    public Book2(String bid, String title, String releaseDate, Float price, Author author) {
        this.bid = bid;
        this.title = title;
        this.releaseDate = releaseDate;
        this.price = price;
        this.author = author;
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
        return "Book2{" +
                "bid='" + bid + '\'' +
                ", title='" + title + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", price=" + price +
                ", author=" + author +
                '}';
    }
}
