package be.ehb.newsapp.Controller;

import be.ehb.newsapp.Service.ArticleService;
import be.ehb.newsapp.Service.CommentService;
import be.ehb.newsapp.domain.Article;
import be.ehb.newsapp.domain.Comment;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private CommentService commentService;

    @GetMapping
    public String getAllArticles(Model model) {
        model.addAttribute("articles", articleService.getAllArticles());
        return "list";
    }

    @GetMapping("/{id}")
    public String getArticleById(@PathVariable Long id, Model model) {
        model.addAttribute("article", articleService.getArticleById(id).orElse(null));
        model.addAttribute("comments", commentService.getCommentsByArticleID(id));
        model.addAttribute("comment", new Comment());
        return "articles/detail";
    }

    @PostMapping("{id}/comments")
    public String addComment(@PathVariable Long id,
                             @Valid @ModelAttribute("comment") Comment comment,
                             BindingResult result,
                             Model model) {
        //input validation
        if (result.hasErrors()) {
            model.addAttribute("article", articleService.getArticleById(id).orElse(null));
           model.addAttribute("comments", commentService.getCommentsByArticleID(id));
            return "articles-detail"; //refers to the detail page of the article
        }
        comment.setArticle(articleService.getArticleById(id).orElse(null));
        return "redirect:/articles/" + id;
    }

    @PostMapping
    public ResponseEntity<Article> createArticle(@RequestBody Article article) {
        Article savedArticle = articleService.saveArticle(article);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedArticle);
    }
}
