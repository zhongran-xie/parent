package com.demo.server.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.Menu;
import com.demo.mapper.MenuMapper;
import com.demo.server.MenuServer;

@Service
public class MenuServerImpl implements MenuServer {

    @Autowired
    private MenuMapper menuMapper;

    /*  
     * <p>Title: findAll</p>   
     * <p>Description: 查询所有菜单</p>   
     * @return   
     * @see com.demo.server.MenuServer#findAll()   
     */
    @Override
    public List<Map<String, Object>> findAll() {
	List<Map<String, Object>> listMaps = new ArrayList<Map<String, Object>>();
	List<Menu> list = menuMapper.findAll();
	for (Menu menu : list) {
	    Map<String, Object> map = new HashMap<String, Object>();
	    if (menu.getUrl() == null) {
		map.put("isExpand", menu.getIsExpand());
	    } else {
		map.put("url", menu.getUrl());
	    }
	    map.put("name", menu.getName());
	    map.put("id", menu.getId());
	    map.put("sort", menu.getSort());
	    map.put("parentId", menu.getParentId());
	    listMaps.add(map);
	}
	// 对菜单排序
	Collections.sort(listMaps, new Comparator<Map<String, Object>>() {
	    public int compare(Map<String, Object> o1, Map<String, Object> o2) {
		Integer parentId1 = (Integer) o1.get("parentId");
		Integer parentId2 = (Integer) o2.get("parentId");
		// 父级相同对其它排序
		if (parentId1.equals(parentId2)) {
		    // 将文件夹排在前面
		    if (o1.get("isExpand") != null && o2.get("isExpand") == null)
			return -1;
		    if (o1.get("isExpand") == null && o2.get("isExpand") != null)
			return 1;
		    Integer sort1 = (Integer) o1.get("sort");
		    Integer sort2 = (Integer) o2.get("sort");
		    Integer id1 = (Integer) o1.get("id");
		    Integer id2 = (Integer) o2.get("id");
		    // 都有指定排序
		    if (sort1 != null && sort2 != null) {
			// 指定排序相同，对id排序
			if (sort1.equals(sort2))
			    return id1.compareTo(id2);
			// 指定不同，按指定的排序进行排序
			return sort1.compareTo(sort2);
		    }
		    // 有指定排序的排前面
		    if (sort2 == null && sort1 != null)
			return -1;
		    if (sort1 == null && sort2 != null)
			return 1;
		    // 都没有排序指定，按id排序
		    return id1.compareTo(id2);
		}
		// 对具有同级父类的菜单排序在一起
		return parentId1.compareTo(parentId2);
	    }
	});
	return listMaps;
    }

}
