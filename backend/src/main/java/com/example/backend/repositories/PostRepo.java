package com.example.backend.repositories;

import com.example.backend.dtos.PostsResponseDTO;
import com.example.backend.entities.Post;
import com.example.backend.entities.PostType;
import com.example.backend.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostRepo {
    @PersistenceContext
    private EntityManager entityManager;

    public List<PostsResponseDTO> getPostsOfUsers(List<User> users) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<PostsResponseDTO> query = criteriaBuilder.createQuery(PostsResponseDTO.class);

        Root<Post> postRoot = query.from(Post.class);
        Join<Post, User> userJoin = postRoot.join("user");

        query.select(criteriaBuilder.construct(
                        PostsResponseDTO.class,
                        userJoin.get("id"),
                        userJoin.get("username"),
                        userJoin.get("pictureURL"),

                        postRoot.get("id"),
                        postRoot.get("content"),
                        postRoot.get("image"),
                        postRoot.get("likesCount"),
                        postRoot.get("commentsCount"),
                        postRoot.get("repostsCount"),
                        postRoot.get("createdAt")
                ))
                .distinct(true)
                .where(postRoot.get("user").in(users))
                .orderBy(criteriaBuilder.desc(postRoot.get("createdAt")));

        return entityManager.createQuery(query).getResultList();
    }

    public List<PostsResponseDTO> getPostAndCreatorByTopics(List<String> topics) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<PostsResponseDTO> query = criteriaBuilder.createQuery(PostsResponseDTO.class);

        Root<Post> postRoot = query.from(Post.class);
        Join<Post, User> userJoin = postRoot.join("user");
        Join<Post, PostType> postTypeJoin = postRoot.join("postTypes");

        query.select(criteriaBuilder.construct(
                        PostsResponseDTO.class,
                        userJoin.get("id"),
                        userJoin.get("username"),
                        userJoin.get("pictureURL"),

                        postRoot.get("id"),
                        postRoot.get("content"),
                        postRoot.get("image"),
                        postRoot.get("likesCount"),
                        postRoot.get("commentsCount"),
                        postRoot.get("repostsCount"),
                        postRoot.get("createdAt")
                ))
                .distinct(true)
                .where(postTypeJoin.get("name").in(topics))
                .orderBy(criteriaBuilder.desc(postRoot.get("createdAt")));

        return entityManager.createQuery(query).getResultList();
    }

    public List<Post> getPostsByUser(long userId) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Post> criteriaQuery = criteriaBuilder.createQuery(Post.class);
        Root<Post> postRoot = criteriaQuery.from(Post.class);
        criteriaQuery.select(postRoot)
                .where(criteriaBuilder.equal(postRoot.get("user").get("id"), userId))
                .orderBy(criteriaBuilder.desc(postRoot.get("createdAt")));

        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
