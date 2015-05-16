package com.daniel.grboard.dao;

import com.daniel.grboard.vo.Article;

import java.util.ArrayList;

/**
 * Created by daniel on 15. 4. 12.
 */
public interface ArticleDAO {
    public ArrayList<Article> getAllList();
    public Article registerArticle(Article vo);
    public Article getArticleByNo(int articleNo);
    public int updateArticle(Article vo);
    public int deleteArticle(int articleNo);
}
