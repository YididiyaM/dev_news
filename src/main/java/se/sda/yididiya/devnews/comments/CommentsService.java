package se.sda.yididiya.devnews.comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service

public class CommentsService {

    private CommentsRepo repo;

    public CommentsService(CommentsRepo repo) {
        this.repo = repo;
    }

    public List<Comments> getAll(){
        return repo.findAll();
    }

    public CommentsService() {

    }

    public Optional<Comments> getById(Long id){
        return repo.findById(id);
    }

    public Comments create(Comments comments) {
        return repo.save(comments);
    }

    public Comments update(Comments updatedComments){
        return repo.save(updatedComments);
    }

    public void delete(Long id){
        repo.deleteById(id);
    }
}
