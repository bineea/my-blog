package my.blog.content.controllers.article;

import my.blog.comm.base.pub.MyManagerException;
import my.blog.content.model.CreateArticleModel;
import my.blog.content.resources.entity.Article;
import my.blog.content.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/findByUserId/{userId}", method = RequestMethod.GET)
    public List<Article> findByUserId(@PathVariable("userId") String userId) throws MyManagerException {
        List<Article> resList = articleService.findByUserId(userId);
        return resList;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createArticle(@ModelAttribute("articleModel")CreateArticleModel articleModel) throws MyManagerException {
        String articleId = articleService.createArticle(articleModel);
        return articleId;
    }
}
