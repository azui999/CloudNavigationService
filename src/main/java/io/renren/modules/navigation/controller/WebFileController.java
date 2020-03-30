package io.renren.modules.navigation.controller;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.navigation.entity.WebFileEntity;
import io.renren.modules.navigation.service.WebFileService;
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
@RequestMapping("/navigation/webfile")
public class WebFileController {
    @Autowired
    private WebFileService webFileService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("navigation:webfile:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = webFileService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("navigation:webfile:info")
    public R info(@PathVariable("id") Long id){
		WebFileEntity webFile = webFileService.getById(id);

        return R.ok().put("webFile", webFile);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("navigation:webfile:save")
    public R save(@RequestBody WebFileEntity webFile){
        webFile.addDate();
		webFileService.save(webFile);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("navigation:webfile:update")
    public R update(@RequestBody WebFileEntity webFile){
		webFileService.updateById(webFile);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("navigation:webfile:delete")
    public R delete(@RequestBody Long[] ids){
		webFileService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
