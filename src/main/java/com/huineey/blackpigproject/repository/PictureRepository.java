package com.huineey.blackpigproject.repository;

import com.huineey.blackpigproject.model.Picture;
import com.huineey.blackpigproject.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PictureRepository extends JpaRepository<Picture, Long> {

    Picture findPictureByStoreId(Long id);

}
