package io.renren.modules.navigation.service.impl;

import io.renren.common.utils.R;
import io.renren.modules.navigation.dao.WebsiteDao;
import io.renren.modules.navigation.entity.WebsiteEntity;
import io.renren.modules.navigation.service.WebsiteService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class WebsiteServiceImpl implements WebsiteService {
    @Value("${uploadFolder}")
    private String filePath;

    @Autowired
    private WebsiteDao websiteDao;

    @Override
    public R upload(MultipartFile file) {

        //上传文件
        System.out.println("222");

        if (file.isEmpty()) {
            return R.error("请选择文件!");
        }
        String fileName = file.getOriginalFilename();
        int size = (int) file.getSize();
        System.out.println(fileName + "-->" + size);

        File dest = new File(filePath + "/" + fileName);
        if (!dest.getParentFile().exists()) { //判断文件父目录是否存在
            dest.getParentFile().mkdir();
        }
        try {
            file.transferTo(dest); //保存文件
//            websiteDao.saveFileInfo()
            return R.ok();
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return R.error(e.toString());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return R.error(e.toString());
        }
    }

    @Override
    public R test() {
        File dest = new File(filePath + "/" + "bookmarks_2020_3_7.html");
        try {
            Document document = Jsoup.parse(dest, "utf-8");
//            System.out.println(document);
            Elements links = document.select("dt> a");
            ArrayList<WebsiteEntity> dataList = new ArrayList<>();
            for (Element link : links) {
//                System.out.println(link.text());
                dataList.add(new WebsiteEntity().init(link.attr("href"),link.text()));
                System.out.println(link.attr("href")+"  "+ link.text());
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return R.ok();
    }
}
