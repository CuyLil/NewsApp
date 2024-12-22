package be.ehb.newsapp;

import be.ehb.newsapp.domain.Article;
import be.ehb.newsapp.repository.ArticleRepository;
import be.ehb.newsapp.repository.CommentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class NewsAppApplicationTests {
    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Test
    public void contextLoads() {
        assertThat(articleRepository).isNotNull();
        assertThat(commentRepository).isNotNull();
    }

    @Test
    public void testSaveAndRetrieveArticle() {
        Article article = new Article();
        article.setTitle("Test Article");
        article.setContent("This is a test article.");
        articleRepository.save(article);

        Iterable<Article> articles = articleRepository.findAll();
        assertThat(articles).isNotEmpty();
    }
}