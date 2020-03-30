package io.renren.modules.navigation.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.navigation.dao.WebFileDao;
import io.renren.modules.navigation.entity.WebFileEntity;
import io.renren.modules.navigation.service.WebFileService;


@Service("webFileService")
public class WebFileServiceImpl extends ServiceImpl<WebFileDao, WebFileEntity> implements WebFileService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<WebFileEntity> page = this.page(
                new Query<WebFileEntity>().getPage(params),
                new QueryWrapper<WebFileEntity>()
        );

        return new PageUtils(page);
    }

}