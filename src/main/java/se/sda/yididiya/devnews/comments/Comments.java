package se.sda.yididiya.devnews.comments;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.sda.yididiya.devnews.articles.Articles;

import javax.persistence.*;

@Entity
@Table(name= "comment")
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="body")
    private String body;

    @Column(name="authorName")
    private String authorName;

    @ManyToOne
    private Articles article;


    public Comments(Long id, String body, String authorName, Articles article) {
        this.id = id;
        this.body = body;
        this.authorName = authorName;
        this.article= article;
    }

    public Comments() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Articles getArticle() {
        return article;
    }

    public void setArticle(Articles article) {
        this.article = article;
    }
}
