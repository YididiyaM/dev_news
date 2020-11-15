package se.sda.yididiya.devnews.articles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepo repo;

    public List <Articles> getAll(){
        return repo.findAll();
    }

    public ArticleService() {

    }

    public Optional <Articles> getById(Long id){
        return repo.findById(id);
    }

    public Articles create(Articles articles) {
        return repo.save(articles);
    }

    public Articles update(Articles updatedArticles){
        return repo.save(updatedArticles);
    }

    public void delete(Long id){
         repo.deleteById(id);
    }
}
