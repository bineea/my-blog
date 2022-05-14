package my.blog.content.services;

import my.blog.comm.base.pub.MyManagerException;
import my.blog.content.model.CreateArticleModel;
import my.blog.content.resources.entity.Article;

import java.util.List;

public interface ArticleService {

    List<Article> findByUserId(String userId) throws MyManagerException;

    String createArticle(CreateArticleModel articleModel) throws MyManagerException;
}
