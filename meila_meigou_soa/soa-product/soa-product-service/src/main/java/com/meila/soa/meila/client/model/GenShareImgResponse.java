package com.meila.soa.meila.client.model;

/**
 * 调用社区获取分享二维码图片的返回对象
 * 
 * @author yongqi@meila.com
 */
public class GenShareImgResponse {

    private String share_img_url;
    private Integer width;
    private Integer height;

    public String getShare_img_url() {
        return share_img_url;
    }

    public void setShare_img_url(String share_img_url) {
        this.share_img_url = share_img_url;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

}
