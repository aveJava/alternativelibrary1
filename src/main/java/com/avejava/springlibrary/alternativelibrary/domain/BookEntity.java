package com.avejava.springlibrary.alternativelibrary.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;

@Entity
@Table(name = "book")
@EqualsAndHashCode(of = "id")
@Getter @Setter
@DynamicUpdate
@DynamicInsert
@SelectBeforeUpdate
public class BookEntity {

    public BookEntity() {
    }

    public BookEntity(Long id, byte[] image) {
        id = id;
        this.image = image;
    }

    // все поля, кроме content
    public BookEntity(Long id, String name, int pageCount, String isbn, GenreEntity genre, AuthorEntity author, PublisherEntity publisher,
                      int publishYear, byte[] image, int avgRating, long totalVoteCount, long totalRating, long viewCount, String description) {
        id = id;
        this.name = name;
        this.pageCount = pageCount;
        this.isbn = isbn;
        this.genre = genre;
        this.author = author;
        this.publisher = publisher;
        this.publishYear = publishYear;
        this.image = image;
        this.avgRating = avgRating;
        this.totalVoteCount = totalVoteCount;
        this.totalRating = totalRating;
        this.viewCount = viewCount;
        this.description = description;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Lob    // означает, что аннотированное поле должно быть представлено как BLOB (двоичные данные) в DataBase.
    private byte[] content;

    @Column(name = "page_count")
    private int pageCount;

    private String isbn;

    @JoinColumn(name = "genre_id")      // сохраняет в данное поле сущность типа GenreEntity
    @ManyToOne                          // много книг могут относиться к какому-либо жанру
    private GenreEntity genre;

    @JoinColumn(name = "author_id")
    @ManyToOne
    private AuthorEntity author;

    @JoinColumn(name = "publisher_id")
    @ManyToOne
    private PublisherEntity publisher;

    @Column(name = "publish_year")
    private int publishYear;

    @Lob
    private byte[] image;

    @Column(name = "avg_rating")
    private int avgRating;

    @Column(name = "total_vote_count")
    private long totalVoteCount;

    @Column(name = "total_rating")
    private long totalRating;

    @Column(name = "view_count")
    private long viewCount;

    @Column(name = "descr")
    private String description;

    @Override
    public String toString() {
        return name;
    }
}
