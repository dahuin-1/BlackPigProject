package com.huineey.blackpigproject.repository;

import com.huineey.blackpigproject.model.Board;
import com.huineey.blackpigproject.model.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findAll();
    Page<Board> findByTitleContainingOrContentContaining(String searchText, String searchText1, Pageable pageable);
    //List<Board> findByStoreId(Long id);
    Board findByStoreId(Long id);
    List<Board> findByTitleOrContent(String title, String content);
}
