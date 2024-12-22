package be.ehb.newsapp.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.List;
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message ="{title_error}")
    @Size(min = 5, max = 100, message ="{title_length_error}")
    private String title;

    private String content;
    private LocalDateTime createArticle;

    //list of comments over the article
   @OneToMany(mappedBy = "article", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Comment> comments;

    public Article() {
    }
    public Article(String title,  String content) {
        this.title = title;
        this.content = content;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
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
     public List<Comment> getComments() {
        return comments;
    }
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public LocalDateTime getCreateArticle() {
        return createArticle;
    }

    public void setCreateArticle(LocalDateTime createArticle) {
        this.createArticle = createArticle;
    }
}
