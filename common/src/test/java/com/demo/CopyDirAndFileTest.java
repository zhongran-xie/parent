/**
 * 
 */
package com.demo;

import org.junit.Test;

/**   
 * @ClassName:  CopyDirAndFileTest   
 * @Description:TODO  
 * @author: xzr 
 * @date:   2019年4月30日 
 *     
 */
public class CopyDirAndFileTest {

    @Test
    public void test() {
	/*	Scanner sc = new Scanner(System.in);
		System.out.println("请输入源目录：");
		String sourcePath = sc.nextLine();
		System.out.println("请输入新目录：");
		String path = sc.nextLine();*/

	 String sourcePath = "C:\\Users\\Administrator\\Desktop\\文档\\test\\旧";
	 String path = "C:\\Users\\Administrator\\Desktop\\文档\\test\\新";
	try {
	    CopyDirAndFile.copyDir(sourcePath, path);
	} catch (Exception e) {
	    System.err.println("复制出错了");
	}

    }
    
    
    @Test
    public void test1() {
	 String sourcePath = "C:\\Users\\Administrator\\Desktop\\文档\\test\\旧";
	 String newPath = "C:\\Users\\Administrator\\Desktop\\文档\\test\\新";
	 String[] ignorePath= {"新建文本文档.txt","新建文件夹 (3)","新建文件夹"};
	try {
	    CopyDirAndFile.copyDir(sourcePath, newPath, ignorePath);
	} catch (Exception e) {
	    System.err.println("复制出错了");
	}
    }
}
