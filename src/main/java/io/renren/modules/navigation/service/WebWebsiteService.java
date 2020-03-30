package io.renren.modules.navigation.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.navigation.entity.WebWebsiteEntity;

import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-03-30 21:00:36
 */
public interface WebWebsiteService extends IService<WebWebsiteEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

