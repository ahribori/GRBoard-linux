package com.daniel.grboard.dao;

import com.daniel.grboard.config.ApplicationConfig;
import com.daniel.grboard.exception.DataNotFoundException;
import com.daniel.grboard.vo.Article;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;


/**
 * Created by daniel on 15. 4. 11.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class}, loader = SpringApplicationContextLoader.class)
public class ArticleDaoTest {

    @Autowired
    private ArticleDAOImpl articleDaoImpl;

    @Test
    public void test() {
    }

    @Test
    public void getArticle() {
        // 1. article dao 만들기
        // 2. article dao에서 테스트 메소드 호출하기
        // 3. 테스트 메소드는 db연결이 되어있어야함.

        String title = articleDaoImpl.getTest();
        assertThat("title입니다", is(title));
    }

    /*
        글 목록
        글 읽기
        글 쓰기
        글 수정
        글 삭제
     */

    @Test
    public void testGetAllList() {
        ArrayList<Article> list = articleDaoImpl.getAllList();
        assertThat(list.size(), greaterThan(0));
    }

    @Test
    public void testGetArticleByNo() {
        int articleNo = 4;
        Article vo = articleDaoImpl.getArticleByNo(articleNo);
        assertThat(articleNo, is(vo.getArticleNo()));
        assertNotNull(vo);
    }

    @Test (expected = DataNotFoundException.class)
    public void testGetEmptyArticleByNo() {
        int articleNo = 10000;
        Article vo = articleDaoImpl.getArticleByNo(articleNo);
        assertThat(articleNo, is(vo.getArticleNo()));
    }

    @Test
    public void testRegisterArticle() {
        Article article = new Article("title2232", "2314", "admin");
        Article registeredArticle = articleDaoImpl.registerArticle(article);
        assertThat(article.getTitle(), is(registeredArticle.getTitle()));
    }

    @Test
    public void testUpdateArticle() {
        ArrayList<Article> list = articleDaoImpl.getAllList();
        int listSize = list.size();
        assertThat(listSize, greaterThan(0));
        Article article = list.get(listSize-1);
        article.setTitle("Changed Title");
        article.setContents("Changed Contents");
        int i = articleDaoImpl.updateArticle(article);
        assertThat(i,is(1));
    }

    /**
     *  Article을 삭제하는 메소드에 대한 테스트 코드.
     *  전체 리스트를 가져와서 가장 마지막 라인을 삭제하도록 작성되었다.
     *  @Transactional 어노테이션은 쿼리문을 실행하기 전 rollback 해주기 떄문에
     *  실제로 자료가 삭제되지는 않는다.
     */
    @Test
    @Transactional
    public void testDeleteArticle() {
        ArrayList<Article> list = articleDaoImpl.getAllList();
        int listSize = list.size();
        assertThat(listSize, greaterThan(0));
        Article article = list.get(listSize-1);
        int i = articleDaoImpl.deleteArticle(article.getArticleNo());
        assertThat(i,is(1));
    }

    /**
        DeleteArticle 메소드를 호출하는 경우 존재하지 않는 articleNo를
        매개변수로 넘겨주었을때 발생하는 문제에 대한 테스트 코드.
        (expected = DataNotFoundException.class)는 해당 예외가 발생해야만
        테스트 코드가 통과된다는 것을 의미한다.
     */
    @Test(expected = DataNotFoundException.class)
    public void testDeleteEmptyData() {
        ArrayList<Article> list = articleDaoImpl.getAllList();
        int listSize = list.size();
        Article article = list.get(listSize - 1);
        int i = articleDaoImpl.deleteArticle(article.getArticleNo()+1);
        assertThat(i, is(0));
    }
}
