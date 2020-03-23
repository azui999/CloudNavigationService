package io.renren.modules.navigation.service;

import io.renren.common.utils.R;
import org.springframework.web.multipart.MultipartFile;

public interface WebsiteService {

    R upload(MultipartFile file);

    R test();

}
