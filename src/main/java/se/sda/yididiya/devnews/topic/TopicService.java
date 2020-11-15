package se.sda.yididiya.devnews.topic;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import se.sda.yididiya.devnews.articles.ArticleService;


import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    private TopicRepo topicRepository;
    private ArticleService articleService;

    public TopicService(TopicRepo topicRepository, ArticleService articleService) {
        this.topicRepository = topicRepository;
        this.articleService = articleService;
    }

    public List<Topic> getAll() {
        return topicRepository.findAll();
    }

    public Optional<Topic> getById(Long id) {
        return topicRepository.findById(id);
    }

    public Topic create(Topic topic) {
        topicRepository.save(topic);
        return topic;
    }

    public Topic update(Topic updatedTopic) {
        return topicRepository.save(updatedTopic);
    }

    public void delete(Long id) {
        Topic topic = topicRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        topicRepository.deleteById(id);
    }

    public List<Topic> getAllByArticleId(Long articleId) {
        return topicRepository.findAllByArticles_id(articleId);
    }
}
