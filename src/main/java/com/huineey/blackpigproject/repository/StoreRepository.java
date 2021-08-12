package com.huineey.blackpigproject.repository;

import com.huineey.blackpigproject.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface StoreRepository extends JpaRepository<Store, Long> {
    List<Store> findAll();
}

