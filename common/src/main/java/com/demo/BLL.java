package com.demo;

import java.lang.reflect.Method;
import java.util.Map;

/**   
 * @ClassName:  BLL   
 * @Description:TODO 使用反射代替switch类
 * @author: xzr 
 * @date:   2019年4月16日 
 *     
 */
public class BLL {
    private Map<Object, Method> maps;

    /**
     * @Title:  BLL   
     * @Description: TODO  有参构造方法 
     * @param maps  
     * @throws
     */
    public BLL(Map<Object, Method> maps) {
	this.maps = maps;
    }

    /**   
     * @Title: demoValidate   
     * @Description: TODO 使用反射代替switch类
     * @param condition 条件(key)
     * @param method 调用方法所属类
     * @param parameters  方法参数列表
     * @return: Object   有返回结果返回几个,无返回返回null   
     * @throws   
     */
    @SuppressWarnings("finally")
    public Object demoValidate(Object condition, Object method, Object... parameters) {
	Object invoke = null;
	try {
	    // 判断Map集合中是否存在
	    if (maps.containsKey(condition)) {
		// 获取方法对象
		Method methodName = maps.get(condition);
		// 调用方法
		invoke = methodName.invoke(method, parameters);
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    return invoke;
	}
    }
}
