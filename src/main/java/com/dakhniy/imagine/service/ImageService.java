package com.dakhniy.imagine.service;

import com.dakhniy.imagine.model.Image;
import com.dakhniy.imagine.model.User;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Sergiy_Dakhniy
 */
public interface ImageService {

    void save(Image image);

    void deleteImage(String url);

    Image getImage(String publicId);
}
