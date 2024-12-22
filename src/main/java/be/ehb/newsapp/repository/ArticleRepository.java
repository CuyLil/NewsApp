package be.ehb.newsapp.repository;

import be.ehb.newsapp.domain.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> {

}
