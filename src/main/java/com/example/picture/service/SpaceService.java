package com.example.picture.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.picture.model.dto.space.SpaceAddRequest;
import com.example.picture.model.dto.space.SpaceQueryRequest;
import com.example.picture.model.entity.Space;
import com.example.picture.model.entity.SpaceVO;
import com.example.picture.model.entity.User;
import jakarta.servlet.http.HttpServletRequest;

/**
* @author junjun
* @description 针对表【space(空间)】的数据库操作Service
* @createDate 2025-05-16 00:36:52
*/
public interface SpaceService extends IService<Space> {

    void fillSpaceBySpaceLevel(Space space);

    void validSpace(Space space, boolean add);

    long addSpace(SpaceAddRequest spaceAddRequest, User loginUser);

    SpaceVO getSpaceVO(Space space, HttpServletRequest request);

    Page<SpaceVO> getSpaceVOPage(Page<Space> spacePage, HttpServletRequest request);

    QueryWrapper<Space> getQueryWrapper(SpaceQueryRequest spaceQueryRequest);
}
