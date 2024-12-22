package be.ehb.newsapp.repository;

import be.ehb.newsapp.domain.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Long> {
    List<Comment> findByArticleId(Long articleId);
}
