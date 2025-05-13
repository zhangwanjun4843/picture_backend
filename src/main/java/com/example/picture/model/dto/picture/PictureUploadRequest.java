package com.example.picture.model.dto.picture;

import lombok.Data;

import java.io.Serializable;

@Data
public class PictureUploadRequest implements Serializable {
  
    /**  
     * 图片 id（用于修改）  
     */  
    private Long id;
    /**
     * 图片名称
     */
    private String picName;
    /**  
     * 文件地址  
     */  
    private String fileUrl;  
  
    private static final long serialVersionUID = 1L;  
}
