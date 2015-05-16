package com.daniel.grboard.dao;

/**
 * Created by daniel on 15. 4. 12.
 */
public interface Query {
    String getArticleList = "SELECT * FROM ARTICLE";
    String getArticleByNo = "SELECT * FROM ARTICLE WHERE ARTICLE_NO=?";
    String registerArticle = "INSERT INTO ARTICLE(TITLE,CONTENTS,WRITER,RECOMMAND_COUNT,VIEW_COUNT,REGISTERED_TIME)" +
            " VALUES(?,?,?,0,0,NOW())";
    String updateArticle = "UPDATE ARTICLE SET TITLE=?, CONTENTS=? WHERE ARTICLE_NO=?";
    String deleteArticle = "DELETE from ARTICLE WHERE ARTICLE_NO=?";
}
