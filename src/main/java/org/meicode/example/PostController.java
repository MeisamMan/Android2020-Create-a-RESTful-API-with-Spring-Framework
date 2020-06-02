package org.meicode.example;

import org.meicode.example.api.PostsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {
    private PostsRepository repository;

    public PostController(PostsRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    public ResponseEntity getSinglePost(@PathVariable("id") int id) {
        Optional<Post> resultSet = repository.findById(id);
        if (resultSet.isPresent()) {
            Post post = resultSet.get();
            return new ResponseEntity(post, HttpStatus.OK);
        }
        return new ResponseEntity(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/newPost", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Post addNewPost (@RequestBody Post post) {
        return repository.save(post);
    }
}
