package net.javaguides.springboot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "news")
public class News {
	
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //news_id
	private int newsId;
	
	@Column(name = "title")
	private String title;

	@Column(name = "content")
	private String content;
	
	@Column(name = "publication_date") //which data type need to use for date?
	private String publicationDate;

    @Column(name = "author")
    private String author;


    public News(int newsId, String title, String content, String publicationDate, String author) { //Constructor
        this.newsId = newsId;
        this.title = title;
        this.content = content;
        this.publicationDate = publicationDate;
        this.author = author;
    }

    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
