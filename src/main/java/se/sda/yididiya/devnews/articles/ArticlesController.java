package se.sda.yididiya.devnews.articles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se.sda.yididiya.devnews.topic.Topic;

import java.util.Optional;
import java.util.List;



@RestController
@RequestMapping("/")
public class ArticlesController {

    @Autowired
    private  ArticleService articleService;



    @GetMapping("/articles")
    public List<Articles> getAll (){
            return articleService.getAll();
    }

    @GetMapping("/articles/{id}")
    public  Articles getById(@PathVariable Long id){
        return articleService.getById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }

    @PostMapping("/articles")
    public Articles create(@RequestBody Articles newArticle)
    {
        return articleService.create(newArticle);
    }


    @DeleteMapping("/articles//{id}")
    public void delete(@PathVariable Long id) {
        articleService.delete(id);
    }


    @PutMapping("/articles")
    public Articles update(@RequestBody Articles updatedArticle) {
        return articleService.update(updatedArticle);
    }

}
