package xyz.vaith.springbootpagingandsortingrepository.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import xyz.vaith.springbootpagingandsortingrepository.bean.Article;

public interface ArticleRepository extends PagingAndSortingRepository<Article, Integer> {

}
