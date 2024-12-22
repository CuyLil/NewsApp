package be.ehb.newsapp.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "username_error")
    @Size(min = 4, max = 20, message = "username_length_error")
    private String username;

    @NotEmpty(message = "{content_error}")
    private String content;

    private LocalDateTime createdArticle;

    @ManyToOne
    @JoinColumn(name = "article_id", nullable = false)
    private Article article;

    public Comment() {
    }
    //constructor
    public Comment(Long id, String username, String content, LocalDateTime createdArticle) {
        this.id = id;
        this.username = username;
        this.content = content;
        this.createdArticle = createdArticle;
    }
    //getters & setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotEmpty(message = "username_error") @Size(min = 4, max = 20, message = "username_length_error") String getUsername() {
        return username;
    }

    public void setUsername(@NotEmpty(message = "username_error") @Size(min = 4, max = 20, message = "username_length_error") String username) {
        this.username = username;
    }

    public @NotEmpty(message = "{content_error}") String getContent() {
        return content;
    }

    public void setContent(@NotEmpty(message = "{content_error}") String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedArticle() {
        return createdArticle;
    }

    public void setCreatedArticle(LocalDateTime createdArticle) {
        this.createdArticle = createdArticle;
    }

    public Article getArticle(){
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}