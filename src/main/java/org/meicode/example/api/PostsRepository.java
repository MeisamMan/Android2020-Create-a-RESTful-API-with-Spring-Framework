package org.meicode.example.api;

import org.meicode.example.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostsRepository extends CrudRepository<Post, Integer> {
}
