package com.dakhniy.imagine.util;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;
import com.cloudinary.utils.ObjectUtils;
import org.apache.log4j.Logger;

public class CloudManager {

    private Logger logger;
    private Cloudinary cloudinary;
    
    
    public Map uploadImage(File image, int width, int height){
        Map uploadResult = null;
        try{
            uploadResult = cloudinary.uploader().upload(image,
                    ObjectUtils.asMap("transformation",new Transformation().crop("pad").width(width).height(height).background("black")));
        }catch(IOException e){
            logger.error(e.getMessage());
        }
        return uploadResult;
    }
    
    //default sized upload
    public Map uploadImage(File image){
        return uploadImage(image, 500, 500);
    }
    
    public void deleteImage(String publicId) throws IOException{
        cloudinary.uploader().destroy(publicId, ObjectUtils.asMap("invalidate", true));
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public CloudManager(Map cloudParams) {
        cloudinary = new Cloudinary(cloudParams);
    }
}
