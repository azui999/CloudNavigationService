package io.renren.modules.navigation.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.navigation.entity.WebWebsiteEntity;
import io.renren.modules.navigation.service.WebWebsiteService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-03-30 21:00:36
 */
@RestController
@RequestMapping("/navigation/webwebsite")
public class WebWebsiteController {
    @Autowired
    private WebWebsiteService webWebsiteService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("navigation:webwebsite:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = webWebsiteService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("navigation:webwebsite:info")
    public R info(@PathVariable("id") Long id){
		WebWebsiteEntity webWebsite = webWebsiteService.getById(id);

        return R.ok().put("webWebsite", webWebsite);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("navigation:webwebsite:save")
    public R save(@RequestBody WebWebsiteEntity webWebsite){
		webWebsiteService.save(webWebsite);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("navigation:webwebsite:update")
    public R update(@RequestBody WebWebsiteEntity webWebsite){
		webWebsiteService.updateById(webWebsite);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("navigation:webwebsite:delete")
    public R delete(@RequestBody Long[] ids){
		webWebsiteService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
