package com.demo.server;

import java.util.List;
import java.util.Map;

/**   
 * @ClassName:  MenuServer   
 * @Description:TODO  菜单服务类
 * @author: xzr 
 * @date:   2019年4月19日 
 *     
 */
public interface MenuServer {

    /**   
     * @Title: findAll   
     * @Description: TODO 查询所有菜单   
     * @return: List<Menu>      
     * @throws   
     */  
    List<Map<String, Object>> findAll();
}
