package se.sda.yididiya.devnews.comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;

@RequestMapping("/comments")
@RestController
public class CommentsController {

    private CommentsService commentsService;



    @GetMapping("/comments")
    public List<Comments> getAll (){
        return commentsService.getAll();
    }

    @GetMapping("/comments/{id}")
    public  Comments getById(@PathVariable Long id){
        return commentsService.getById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }

    @PostMapping("/comments")
    public Comments create(@RequestBody Comments comments)
    {
        return commentsService.create(comments);
    }


    @DeleteMapping("/comments/{id}")
    public void delete(@PathVariable Long id) {
        commentsService.delete(id);
    }


    @PutMapping("/comments")
    public Comments update(@RequestBody Comments updatedComment) {
        return commentsService.update(updatedComment);
    }
}
