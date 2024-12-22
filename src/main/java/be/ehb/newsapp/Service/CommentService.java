package be.ehb.newsapp.Service;

import be.ehb.newsapp.domain.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import be.ehb.newsapp.repository.CommentRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    //save a new comment of an article
    public Comment saveComment(Comment comment) {
        comment.setCreatedArticle(LocalDateTime.now());
        return commentRepository.save(comment);
    }
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
    public List<Comment> getCommentsByArticleID(Long articleId) {
        return commentRepository.findByArticleId(articleId);
    }
}
