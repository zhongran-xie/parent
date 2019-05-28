/**
 * 
 */
package com.demo.entity;

import lombok.Getter;
import lombok.Setter;

/**   
 * @ClassName:  Menu  菜单实体类  
 * @Description:TODO  
 * @author: xzr 
 * @date:   2019年4月18日 
 *     
 */
@Getter
@Setter
public class Menu {
    //是否展开菜单
    private Boolean isExpand=false;
    //菜单名称
    private String name;
    //菜单id
    private Integer id;
    //菜单排序
    private Integer sort;
    //父级id
    private Integer parentId;
    //菜单url
    private String url;
}
