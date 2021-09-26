package com.huineey.blackpigproject.repository;

import com.huineey.blackpigproject.model.Review;

import java.util.List;

public interface ReviewRepository {
    List<Review> findAll();
}
