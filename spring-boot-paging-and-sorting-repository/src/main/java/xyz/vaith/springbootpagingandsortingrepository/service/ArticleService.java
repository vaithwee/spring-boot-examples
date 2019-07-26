package xyz.vaith.springbootpagingandsortingrepository.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import xyz.vaith.springbootpagingandsortingrepository.bean.Article;
import xyz.vaith.springbootpagingandsortingrepository.repository.ArticleRepository;

import javax.annotation.Resource;

@Service
public class ArticleService {
    @Resource
    private ArticleRepository articleRepository;

    public Iterable<Article> findAllSort(Sort sort) {
        return articleRepository.findAll(sort);
    }

    public Page<Article> findAll(Pageable pageable) {
        return articleRepository.findAll(pageable);
    }
}
