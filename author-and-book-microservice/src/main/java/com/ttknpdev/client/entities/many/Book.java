package com.ttknpdev.client.entities.many;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
// must have constructor() {} null arg
public class Book {
    @Id // Mark is a Pk
    private String bid;
    private String title;
    private String releaseDate; // mean @Column("release_date")
    private Float price;

    public Book(String bid, String title, String releaseDate, Float price) {
        this.bid = bid;
        this.title = title;
        this.releaseDate = releaseDate;
        this.price = price;
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

    @Override
    public String toString() {
        return "Book{" +
                "bid='" + bid + '\'' +
                ", title='" + title + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", price=" + price +
                '}';
    }
}
