//package com.pavelchak.service.impl;
//
//import com.pavelchak.domain.NewsEntity;
//import com.pavelchak.exception.NoFoundException;
//import com.pavelchak.service.NewsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//import java.util.List;
//
//@Service
//public class NewsServiceImpl implements NewsService {
//    @Autowired
//    News newsRepository;
//
//    public List<NewsEntity> findAll() {
//        return newsRepository.findAll();
//    }
//
//    public List<NewsEntity> FindByFilmId(Integer film_id) {
//        return newsRepository.findByFilmId(film_id);
//    }
//
//    @Transactional
//    public NewsEntity findById(Integer id) {
//        return newsRepository.findById(id)
//                .orElseThrow(() -> new NoFoundException(id, "News"));
//    }
//
//    @Transactional
//    public NewsEntity create(NewsEntity news) {
//        newsRepository.save(news);
//        return news;
//    }
//
//    @Transactional
//    public void update(Integer id, NewsEntity updateNews) {
//        NewsEntity news = newsRepository.findById(id)
//                .orElseThrow(() -> new NoFoundException(id, "News"));
//        //update
//        news.setNews(updateNews.getNews());
//        newsRepository.save(news);
//    }
//
//    @Transactional
//    public void delete(Integer id) {
//        NewsEntity news = newsRepository.findById(id)
//                .orElseThrow(() -> new NoFoundException(id, "News"));
//        newsRepository.delete(news);
//    }
//}
