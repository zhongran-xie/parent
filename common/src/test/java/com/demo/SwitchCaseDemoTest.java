package com.demo;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * @ClassName: SwitchCaseDemoTest
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: xzr
 * @date: 2019年4月16日
 * 
 */
public class SwitchCaseDemoTest {

    /**
     * 
     * @Title: SwitchTest 
     * @Description: TODO 
     * @param: 
     * @return: void 
     * @throws
     */
    @Test
    public void SwitchTest() {

	// 添加条件
	Map<Object, Method> maps = new HashMap<>();
	try {
	    // maps.put("参数", "方法名,方法参数类型...")
	    maps.put("check01", new Detail().getClass().getMethod("setCheck01", String.class));
	    maps.put("check01_1", new Detail().getClass().getMethod("setCheck01", Integer.class));
	    maps.put("check02", new Detail().getClass().getMethod("setCheck02", Integer.class));
	    maps.put("check03", new Detail().getClass().getMethod("setCheck03", String.class));
	    maps.put("check04", new Detail().getClass().getMethod("setCheck04", String.class));
	    maps.put("check05", new Detail().getClass().getMethod("setCheck05", String.class));
	    maps.put("check06", new Detail().getClass().getMethod("setCheck06", String.class, Integer.class));

	} catch (Exception e) {
	    e.printStackTrace();
	}

	BLL detailBLL = new BLL(maps);

	long start2 = System.nanoTime(); // 获取当前时间
	// 调用方法
	Object demoValidate1 = detailBLL.demoValidate("check01", new Detail(), "很开心啊");
	Object demoValidate1_1 = detailBLL.demoValidate("check01_1", new Detail(), 12);
	Object demoValidate2 = detailBLL.demoValidate("check02", new Detail(), 14);
	Object demoValidate3 = detailBLL.demoValidate("check03", new Detail(), "很开心啊");
	Object demoValidate4 = detailBLL.demoValidate("check04", new Detail(), "很开心啊");
	Object demoValidate5 = detailBLL.demoValidate("check05", new Detail(), "很开心啊");
	Object demoValidate6 = detailBLL.demoValidate("check06", new Detail(), "很开心啊", 15);

	System.out.println("1\t" + demoValidate1);
	System.out.println("1-1\t" + demoValidate1_1);
	System.out.println("2\t" + demoValidate2);
	System.out.println("3\t" + demoValidate3);
	System.out.println("4\t" + demoValidate4);
	System.out.println("5\t" + demoValidate5);
	System.out.println("6\t" + demoValidate6);
	long end2 = System.nanoTime();
	System.out.println("程序运行时间： " + (end2 - start2) + "ns");
    }
}
