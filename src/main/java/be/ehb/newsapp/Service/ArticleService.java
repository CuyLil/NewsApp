package be.ehb.newsapp.Service;

import be.ehb.newsapp.domain.Article;
import be.ehb.newsapp.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;
    public List<Article> getAllArticles() {
        return (List<Article>) articleRepository.findAll();
    }
    public Optional<Article> getArticleById(Long id) {
        return articleRepository.findById(id);
    }
    public Article saveArticle(Article article) {
        return articleRepository.save(article);
    }
}
