/**
 * 
 */
package com.demo.mapper;

import java.util.List;

import com.demo.entity.Menu;

/**   
 * @ClassName:  MenuMapper   菜单操作
 * @Description:TODO  
 * @author: xzr 
 * @date:   2019年4月19日 
 *     
 */
public interface MenuMapper {

    public List<Menu> findAll();
}
