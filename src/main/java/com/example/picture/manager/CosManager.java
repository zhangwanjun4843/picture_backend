package com.example.picture.manager;

import cn.hutool.core.io.FileUtil;
import com.example.picture.config.CosClientConfig;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.model.*;
import com.qcloud.cos.model.ciModel.persistence.PicOperations;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Component
public class CosManager {  
  
    @Resource
    private CosClientConfig cosClientConfig;
  
    @Resource  
    private COSClient cosClient;

    /**
     * 上传对象
     *
     * @param key  唯一键
     * @param file 文件
     */
    public PutObjectResult putObject(String key, File file) {
        PutObjectRequest putObjectRequest = new PutObjectRequest(cosClientConfig.getBucket(), key,
                file);
        return cosClient.putObject(putObjectRequest);
    }
    /**
     * 下载对象
     *
     * @param key 唯一键
     */
    public COSObject getObject(String key) {
        GetObjectRequest getObjectRequest = new GetObjectRequest(cosClientConfig.getBucket(), key);
        return cosClient.getObject(getObjectRequest);
    }
    /**
     * 上传对象（附带图片信息）
     *
     * @param key  唯一键
     * @param file 文件
     */
    public PutObjectResult putPictureObject(String key, File file) {
        PutObjectRequest putObjectRequest = new PutObjectRequest(cosClientConfig.getBucket(), key,
                file);
        // 对图片进行处理（获取基本信息也被视作为一种处理）
        PicOperations picOperations = new PicOperations();
        // 1 表示返回原图信息
        picOperations.setIsPicInfo(1);

        String webKey = FileUtil.mainName(key) + ".webp";
        PicOperations.Rule rule = new PicOperations.Rule();
        rule.setRule("imageMogr2/format/webp");
        rule.setBucket(cosClientConfig.getBucket());
        rule.setFileId(webKey);
        List<PicOperations.Rule> rules = new ArrayList<>();
        rules.add(rule);
        // 构造处理参数
        putObjectRequest.setPicOperations(picOperations);
        return cosClient.putObject(putObjectRequest);
    }
    // 上传文件
    public String uploadToCOS(MultipartFile multipartFile, String bucketName, String key) throws Exception {
        // 创建 COS 客户端
        COSClient cosClient = cosClientConfig.createCOSClient();

        try (InputStream inputStream = multipartFile.getInputStream()) {
            // 元信息配置
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentLength(multipartFile.getSize());
            metadata.setContentType(multipartFile.getContentType());

            // 创建上传请求
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, inputStream, metadata);

            // 上传文件
            cosClient.putObject(putObjectRequest);

            // 生成访问链接
            return "https://" + bucketName + ".cos." + cosClient.getClientConfig().getRegion().getRegionName()
                    + ".myqcloud.com/" + key;
        } finally {
            cosClient.shutdown();
        }
    }



}
