package se.sda.yididiya.devnews.articles;
import se.sda.yididiya.devnews.comments.Comments;
import se.sda.yididiya.devnews.topic.Topic;
import javax.persistence.*;
import java.util.List;


@Entity
@Table (name="articles")
public class Articles {

    @Column(name= "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

    @Column(name= "title")
     private String title;

    @Column(name= "body")
     private String body;

    @Column (name="authorName")
     private String authorName;

     @OneToMany
     private List<Comments> comments;

     @ManyToMany
     private List<Topic> topics;

    public Articles() {
    }

    public Articles(Long id, String title, String body, String authorName) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.authorName = authorName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Column(columnDefinition = "TEXT")
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

    public List<Topic> getTopic() {
        return topics;
    }

    public void setTopic(List<Topic> topics) {
        this.topics = topics;
    }

    public Articles addTopic(Topic topic) {
        this.topics.add(topic);
        return this;
    }

    public void deleteTopic(Topic topic) {
        System.out.println("Deleting " + topic.getId());
        System.out.println(this.topics.remove(topic));
    }
}

