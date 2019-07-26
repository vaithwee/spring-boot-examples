package xyz.vaith.springbootpagingandsortingrepository.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.vaith.springbootpagingandsortingrepository.bean.Article;
import xyz.vaith.springbootpagingandsortingrepository.service.ArticleService;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/article")
@Log4j2
public class ArticleController {
    @Resource
    private ArticleService articleService;

    @RequestMapping("/sort")
    public Iterable<Article> sortArticle() {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Iterable<Article> articles = articleService.findAllSort(sort);
        return articles;
    }

    @RequestMapping("/pager")
    public List<Article> sortPagerArticle(Integer page) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(page, 2, sort);
        Page<Article> articles = articleService.findAll(pageable);
        log.info("total page : " + articles.getTotalPages());
        log.info("total count : " + articles.getTotalElements());
        log.info("current page : " + articles.getNumber());
        log.info("current page total : " + articles.getNumberOfElements());
        List<Article> articleList = articles.getContent();
        return articleList;
    }
}
