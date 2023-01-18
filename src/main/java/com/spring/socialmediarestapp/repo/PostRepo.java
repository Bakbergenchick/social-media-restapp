package com.spring.socialmediarestapp.repo;

import com.spring.socialmediarestapp.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepo extends JpaRepository<Post, Long>, PostPaginationCustom {

}
