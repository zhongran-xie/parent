package com.demo.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**   
 * @ClassName:  Product  商品信息表 
 * @Description:TODO  
 * @author: xzr 
 * @date:   2019年4月19日 
 *     
 */
@Getter
@Setter
public class Product implements Serializable {

    private static final long serialVersionUID = 8862976401933892292L;
    // 主键id
    private Integer id;
    // 商家ID
    private Integer shopId;
    // 商品名称
    private String productName;
    // 商品类型(1:虚拟商品;2:实体商品)
    private Integer productType;
    // 商品价格
    private Double productPrice;
    // 商品库存
    private Integer productStock;
    // 创建时间
    private Date createTime;
    // 修改时间
    private Date modifyTime;
    // 是否有效（0：无效 1：有效）
    private Integer isValid;
    // 是否支持支付宝（0：不支持 1：支持）
    private Integer isAlipay;
    // 是否支持微信（0：不支持 1：支持）
    private Integer isWechat;
    // 是否支持余额（0：不支持 1：支持）
    private Integer isRemainingSum;
    // 是否上架(0:下架,1:上架)
    private Integer productPutaway;
    // 商品编码
    private String productCode;
    // 审核状态(1:待审核;2:审核通过;3:审核不通过;)
    private Integer productAuth;
}
