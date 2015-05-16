package com.daniel.grboard.service;

import com.daniel.grboard.dao.ArticleDAO;
import com.daniel.grboard.vo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Created by daniel on 15. 4. 26.
 */
@Repository
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleDAO dao;

    @Override
    public ArrayList<Article> getAllList() {
        return dao.getAllList();
    }

    @Override
    public Article registerArticle(Article vo) {
        return dao.registerArticle(vo);
    }

    @Override
    public Article getArticleByNo(int articleNo) {
        return dao.getArticleByNo(articleNo);
    }

    @Override
    public int updateArticle(Article vo) {
        return dao.updateArticle(vo);
    }

    @Override
    public int deleteArticle(int articleNo) {
        return dao.deleteArticle(articleNo);
    }
}
