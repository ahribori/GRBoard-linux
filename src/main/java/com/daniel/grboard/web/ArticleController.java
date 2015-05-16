package com.daniel.grboard.web;

import com.daniel.grboard.service.ArticleService;
import com.daniel.grboard.vo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by daniel on 15. 4. 26.
 */
@Controller
public class ArticleController {

    @Autowired
    private ArticleService service;

    @RequestMapping(value = "/article")
    public String getArticle(Model model) {
        model.addAttribute("articleList", service.getAllList());
        model.addAttribute("title", "TITLE 입니다.");
        model.addAttribute("content", "CONTENT 입니다.");
        return "article";
    }

    @RequestMapping(value = "/register")
    public String registerArticle(@RequestParam String title, @RequestParam String content, Model model) {
        String url="redirect:/article";
        if(title=="" || content=="") {
            model.addAttribute("message1", "제목을 입력하세요.");
            model.addAttribute("message2", "내용을 입력하세요.");
            url="article";
        } else {
            service.registerArticle(new Article(title, content));
        }
        model.addAttribute("articleList",service.getAllList());
        return url;
    }
}
