package io.renren.modules.navigation.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import lombok.Data;
import org.jsoup.nodes.Element;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-03-30 22:33:45
 */
@Data
@TableName("web_website")
public class WebWebsiteEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private Long id;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * url地址
	 */
	private String url;
	/**
	 * 协议
	 */
	private String protocol;
	/**
	 * 主地址
	 */
	private String host;
	/**
	 * 路径
	 */
	private String path;
	/**
	 * 端口
	 */
	private String port;
	/**
	 * 创建时间
	 */
	private Date createtime;
	/**
	 * 修改时间
	 */
	private Date updatetime;

	public void addUrl(Element link) throws MalformedURLException {
		this.name = link.text();
		this.url = link.attr("href");
		URL url = new URL(this.url );
		this.protocol = url.getProtocol();
		this.host = url.getHost();
		this.path = url.getPath();
		this.port = String.valueOf(url.getPort() == -1 ? url.getDefaultPort() : url.getPort());
		this.addDate();
	}
	public void addDate() {
		this.createtime = new Date();
		this.updatetime = new Date();
	}

}
