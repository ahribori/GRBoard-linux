package com.daniel.grboard.service;

import com.daniel.grboard.vo.Article;

import java.util.ArrayList;

/**
 * Created by daniel on 15. 4. 26.
 */

public interface ArticleService {
    public ArrayList<Article> getAllList();
    public Article registerArticle(Article vo);
    public Article getArticleByNo(int articleNo);
    public int updateArticle(Article vo);
    public int deleteArticle(int articleNo);
}
