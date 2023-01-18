package com.spring.socialmediarestapp.repo.impls;

import com.spring.socialmediarestapp.entity.Post;
import com.spring.socialmediarestapp.repo.PostPaginationCustom;
import com.spring.socialmediarestapp.utils.PageUtils;
import com.spring.socialmediarestapp.utils.request.PageDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostPaginationCustomImpl implements PostPaginationCustom {

    private final EntityManager entityManager;

    @Override
    public PageDTO findAllWithCustomProperties(int size, int page, String direction, String properties, String content, String title) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<Long> count = cb.createQuery(Long.class);

        count.select(cb.count(count.from(Post.class)));

        // get totalElements to calculate Page
        Long totalElements = entityManager.createQuery(count).getSingleResult();

        // write query to get data
        CriteriaQuery<Post> getPostQuery = cb.createQuery(Post.class);

        Root<Post> from = getPostQuery.from(Post.class);

        CriteriaQuery<Post> select = getPostQuery.select(from);

        List<Predicate> predicateList = new ArrayList<>();

        if (!ObjectUtils.isEmpty(content)) {
            predicateList.add(cb.like(from.get("content"), "%" + content + "%"));
        }

        if (!ObjectUtils.isEmpty(title)) {
            predicateList.add(cb.like(from.get("title"), "%" + title + "%"));
        }

        select.select(from).where(predicateList.toArray(new Predicate[]{}));

        // calculate sorting order
        if (direction.equalsIgnoreCase("desc") && !ObjectUtils.isEmpty(properties)) {
            getPostQuery.orderBy(cb.desc(from.get(properties)));
        } else if (direction.equalsIgnoreCase("asc") && !ObjectUtils.isEmpty(properties)) {
            getPostQuery.orderBy(cb.asc(from.get(properties)));
        }

        // calculate page and size
        TypedQuery<Post> typedQuery = entityManager.createQuery(select);

        int offset = (page - 1) * size;
        typedQuery.setFirstResult(offset);
        typedQuery.setMaxResults(size);

        // set data and return
        PageDTO<Post> pageDTO = PageUtils.calculatePage(size, page, totalElements.intValue());
        pageDTO.setData(typedQuery.getResultList());

        return pageDTO;
    }
}
