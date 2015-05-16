package com.daniel.grboard.dao;

import com.daniel.grboard.exception.DataNotFoundException;
import com.daniel.grboard.vo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.*;

import static java.time.LocalTime.now;

/**
 * Created by daniel on 15. 4. 4.
 */

@Repository
public class ArticleDAOImpl implements ArticleDAO {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String getTest() {
        String title = jdbcTemplate.queryForObject("select TITLE from ARTICLE where ARTICLE_NO= ?", new Object[]{"4"}, String.class);
        return title;
    }

    public ArrayList<Article> getAllList() {
        ArrayList<Article> list = (ArrayList<Article>) jdbcTemplate.query("select * from ARTICLE", new ArticleRowMapper());
        return list;
    }

    public Article registerArticle(Article vo) {
        jdbcTemplate.update(
                "insert into ARTICLE (TITLE,CONTENTS,WRITER,RECOMMAND_COUNT,VIEW_COUNT,REGISTERED_TIME) " +
                        "values (?,?,?,0,0,now())", new Object[]{vo.getTitle(), vo.getContents(), vo.getWriter()});
        return vo;
    }

    public Article getArticleByNo(int articleNo) {
        Article vo = null;
        try {
            vo = jdbcTemplate.queryForObject(
                    "SELECT * FROM ARTICLE WHERE ARTICLE_NO=?",
                    new Object[]{articleNo}, new ArticleRowMapper());
        } catch (EmptyResultDataAccessException e) {
            throw new DataNotFoundException(articleNo + "번에 해당하는 글이 없습니다.");
        }
        return vo;
    }

    public int updateArticle(Article vo) {
        int i = jdbcTemplate.update("UPDATE ARTICLE SET TITLE=?, CONTENTS=? WHERE ARTICLE_NO=?", vo.getTitle(), vo.getContents(), vo.getArticleNo());
        return i;
    }

    public int deleteArticle(int articleNo) {
        int i = jdbcTemplate.update("DELETE from ARTICLE WHERE ARTICLE_NO=?", articleNo);
        if (i == 0) throw new DataNotFoundException(articleNo + "번에 해당하는 글이 없습니다.");
        return i;
    }

    private static final class ArticleRowMapper implements RowMapper<Article> {
        @Override
        public Article mapRow(ResultSet rs, int rowNum) throws SQLException {
            Article vo = new Article();
            vo.setArticleNo(rs.getInt("ARTICLE_NO"));
            vo.setTitle(rs.getString("TITLE"));
            vo.setContents(rs.getString("CONTENTS"));
            vo.setWriter(rs.getString("WRITER"));
            vo.setRecommendCount(rs.getInt("RECOMMAND_COUNT"));
            vo.setViewCount(rs.getInt("VIEW_COUNT"));
            vo.setRegisteredTime(rs.getString("REGISTERED_TIME"));
            return vo;
        }
    }
}
