package com.daniel.grboard.web;

import com.daniel.grboard.dao.ArticleDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by daniel on 15. 4. 11.
 */
@Controller
public class HelloController {
    @Autowired
    private ArticleDAOImpl articleDAOImpl;

    @RequestMapping(value = "/hello")
    @ResponseBody
    public Object hello() {
        Map<String, Object> model = new HashMap<>();
        model.put("time", new Date());
        model.put("message","welcome");
        String title = articleDAOImpl.getTest();
        model.put("title",title);
        return model;
    }

    @RequestMapping(value = "/index")
    public String index(Map<String, Object> model) {
        model.put("time", new Date());
        model.put("message","welcome");
        String title = articleDAOImpl.getTest();
        model.put("title",title);
        return "index";
    }

    @RequestMapping(value = "/index2")
    public ModelAndView index2() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("time", new Date());
        mav.addObject("message","welcom~~~");
        mav.addObject("title", "title");
        mav.setViewName("index");
        return mav;
    }

}
