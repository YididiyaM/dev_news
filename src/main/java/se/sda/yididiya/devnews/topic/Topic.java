package se.sda.yididiya.devnews.topic;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import se.sda.yididiya.devnews.articles.Articles;

import javax.persistence.*;
import java.util.List;

@Entity
public class Topic {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "topics")
    private List<Articles> articles;

    public Topic(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Topic() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addArticle (Articles article) {
        articles.add(article);
    }

}


