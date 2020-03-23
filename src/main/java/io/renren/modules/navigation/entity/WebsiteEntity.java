package io.renren.modules.navigation.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 系统验证码
 *
 * @author Mark sunlightcs@gmail.com
 */
@Data
@TableName("sys_captcha")
public class WebsiteEntity {

    private Long id;

    private String href;

    private String name;

    public WebsiteEntity init(String href,String name){
        this.setHref(href);
        this.setName(name);
        return this;
    }

}
