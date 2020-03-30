package io.renren.modules.navigation.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-03-30 22:33:45
 */
@Data
@TableName("web_file")
public class WebFileEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId
    private Long id;
    /**
     * 文件名称
     */
    private String name;
    /**
     * 大小
     */
    private Long size;
    /**
     * 地址
     */
    private String path;
    /**
     * 创建时间
     */
    private Date createtime;
    /**
     * 修改时间
     */
    private Date updatetime;

    public void addDate() {
        this.createtime = new Date();
        this.updatetime = new Date();
    }

}
