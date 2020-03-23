package io.renren.modules.navigation.controller;

import io.renren.common.exception.RRException;
import io.renren.common.utils.R;
import io.renren.modules.navigation.entity.WebsiteEntity;
import io.renren.modules.navigation.service.WebsiteService;
import io.renren.modules.oss.cloud.OSSFactory;
import io.renren.modules.oss.entity.SysOssEntity;
import io.renren.modules.sys.controller.AbstractController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

/**
 * 系统菜单
 *
 * @author Mark sunlightcs@gmail.com
 */
@RestController
@RequestMapping("/nav/website")
public class NavWebsiteController extends AbstractController {

    @Autowired
    private WebsiteService websiteService;

    /**
     * 上传文件
     */
    @PostMapping("/upload")
    public R upload(@RequestParam("file") MultipartFile file) throws Exception {
        if (file.isEmpty()) {
            throw new RRException("上传文件不能为空");
        }
        return websiteService.upload(file);
    }
    /**
     * 测试
     */
    @GetMapping("/test")
    public R test() throws Exception {
        return websiteService.test();
    }


}
