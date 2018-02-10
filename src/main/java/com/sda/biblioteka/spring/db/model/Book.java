package com.sda.biblioteka.spring.db.model;

import javax.persistence.*;

@Entity
@Table(name="books")
public class Book {
    @Id
    @SequenceGenerator(name="books_seq",
            sequenceName="books_seq",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator="books_seq")
    private int id;
    @Column
    private String title;
    @Column
    private String author;
    @Column(name = "page_count")
    private int pageCount;

    public Book() {
    }

    public Book(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
