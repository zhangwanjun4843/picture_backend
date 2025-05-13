package com.example.picture.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.picture.model.dto.picture.PictureQueryRequest;
import com.example.picture.model.dto.picture.PictureReviewRequest;
import com.example.picture.model.dto.picture.PictureUploadByBatchRequest;
import com.example.picture.model.dto.picture.PictureUploadRequest;
import com.example.picture.model.entity.Picture;
import com.example.picture.model.entity.PictureVO;
import com.example.picture.model.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;

public interface PictureService extends IService<Picture> {


    // 上传图片
    PictureVO uploadPicture(Object inputSource, PictureUploadRequest pictureUploadRequest, User loginUser);

    QueryWrapper<Picture> getQueryWrapper(PictureQueryRequest pictureQueryRequest);

    PictureVO getPictureVO(Picture picture, HttpServletRequest request);

    Page<PictureVO> getPictureVOPage(Page<Picture> picturePage, HttpServletRequest request);

    void validPicture(Picture picture);

    /**
     * 图片审核
     *
     * @param pictureReviewRequest
     * @param loginUser
     */
    void doPictureReview(PictureReviewRequest pictureReviewRequest, User loginUser);

    void fillReviewParams(Picture picture, User loginUser);

    /**
     * 批量抓取和创建图片
     *
     * @param pictureUploadByBatchRequest
     * @param loginUser
     * @return 成功创建的图片数
     */
    Integer uploadPictureByBatch(
            PictureUploadByBatchRequest pictureUploadByBatchRequest,
            User loginUser
    );

}
