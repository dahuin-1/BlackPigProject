package com.huineey.blackpigproject.service;

import com.huineey.blackpigproject.model.Picture;
import com.huineey.blackpigproject.model.Store;
import com.huineey.blackpigproject.repository.PictureRepository;
import com.huineey.blackpigproject.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PictureService {

    @Autowired
    PictureRepository pictureRepository;
    @Autowired
    StoreRepository storeRepository;

    public Picture getPicture(Long storeId) {
        Store store = storeRepository.findById(storeId).orElse(null);
        storeId = store.getId();
        return pictureRepository.findPictureByStoreId(storeId);
    }
}
