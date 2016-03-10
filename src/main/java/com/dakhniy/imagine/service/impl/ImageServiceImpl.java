package com.dakhniy.imagine.service.impl;

import com.dakhniy.imagine.model.Image;
import com.dakhniy.imagine.repisitory.ImageRepository;
import com.dakhniy.imagine.repisitory.UserRepository;
import com.dakhniy.imagine.service.ImageService;

/**
 * Created by Sergiy_Dakhniy
 */
public class ImageServiceImpl implements ImageService{

    private ImageRepository imageRepository;

    public void setImageRepository(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public void save(Image image) {
        imageRepository.save(image);
    }

    public void deleteImage(String url) {
        imageRepository.deleteByUrl(url);
    }

    public Image getImage(String publicId) {
        return imageRepository.findByPublicId(publicId);
    }
}
