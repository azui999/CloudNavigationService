package io.renren.modules.navigation.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.navigation.dao.WebWebsiteDao;
import io.renren.modules.navigation.entity.WebWebsiteEntity;
import io.renren.modules.navigation.service.WebWebsiteService;


@Service("webWebsiteService")
public class WebWebsiteServiceImpl extends ServiceImpl<WebWebsiteDao, WebWebsiteEntity> implements WebWebsiteService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<WebWebsiteEntity> page = this.page(
                new Query<WebWebsiteEntity>().getPage(params),
                new QueryWrapper<WebWebsiteEntity>()
        );

        return new PageUtils(page);
    }

}