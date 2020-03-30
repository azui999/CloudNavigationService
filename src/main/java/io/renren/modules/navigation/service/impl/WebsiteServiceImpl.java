package io.renren.modules.navigation.service.impl;

import io.renren.common.utils.R;
import io.renren.modules.navigation.dao.WebsiteDao;
import io.renren.modules.navigation.entity.WebFileEntity;
import io.renren.modules.navigation.entity.WebWebsiteEntity;
import io.renren.modules.navigation.entity.WebsiteEntity;
import io.renren.modules.navigation.service.WebFileService;
import io.renren.modules.navigation.service.WebWebsiteService;
import io.renren.modules.navigation.service.WebsiteService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

@Service
public class WebsiteServiceImpl implements WebsiteService {
    @Value("${uploadFolder}")
    private String filePath;

    @Autowired
    private WebFileService webFileService;
    @Autowired
    private WebWebsiteService webWebsiteService;

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

        Date date = new Date(); // this object contains the current date value
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");


        String path = formatter.format(date);

        File dest = new File(filePath + "/" + path + "/" + fileName);
        if (!dest.getParentFile().exists()) { //判断文件父目录是否存在
            dest.getParentFile().mkdir();
        }
        try {
            file.transferTo(dest); //保存文件
            WebFileEntity webFileEntity = new WebFileEntity();
            webFileEntity.setName(fileName);
            webFileEntity.setSize(Long.valueOf(String.valueOf(size)));
            webFileEntity.setPath(path);
            webFileEntity.addDate();
            webFileService.save(webFileEntity);
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
        File dest = new File(filePath + "/" + "bookmarks_2020_3_19.html");
        try {
            Document document = Jsoup.parse(dest, "utf-8");
//            System.out.println(document);
            Elements links = document.select("dt> a");
            ArrayList<WebsiteEntity> dataList = new ArrayList<>();
            for (Element link : links) {
//                System.out.println(link.text());
                dataList.add(new WebsiteEntity().init(link.attr("href"), link.text()));
                System.out.println(link.attr("href") + "  " + link.text());
                WebWebsiteEntity webWebsiteEntity = new WebWebsiteEntity();
                webWebsiteEntity.addUrl(link);
                webWebsiteService.save(webWebsiteEntity);
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return R.ok();
    }
}
