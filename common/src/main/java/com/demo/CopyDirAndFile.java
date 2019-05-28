/**
 * 
 */
package com.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**   
 * @ClassName:  CopyDirAndFile   
 * @Description:TODO  复制文件夹或者文件。排除文件夹、文件
 * @author: xzr 
 * @date:   2019年4月30日 
 *     
 */
public class CopyDirAndFile {

    /**   
     * @Title: copyDir   
     * @Description: TODO 复制文件夹
     * @param: @param sourcePath
     * @param: @param newPath
     * @param: @param ignorePath      
     * @return: void      
     * @throws   
     */
    public static void copyDir(String sourcePath, String newPath) throws IOException {
	copyDir(sourcePath, newPath, null);
    }

    /**   
     * @Title: copyDir   
     * @Description: TODO 复制文件夹，，带过滤文件夹或文件
     * @param: @param sourcePath
     * @param: @param newPath
     * @param: @throws IOException      
     * @return: void      
     * @throws   
     */
    public static void copyDir(String sourcePath, String newPath, String[] ignorePath) throws IOException {
	File file = new File(sourcePath);
	// 获取目录下的文件夹及文件数组
	String[] filePath = file.list();
	// 判断目标文件夹是否存在，不存在就创建
	if (!(new File(newPath)).exists()) {
	    (new File(newPath)).mkdir();
	}

	for (int i = 0; i < filePath.length; i++) {
	    // 过滤的文件夹及文件
	    if (useArraysBinarySearch(ignorePath, filePath[i])) {
		System.out.println("跳过：" + filePath[i]);
		continue;
	    }
	    if ((new File(sourcePath + File.separator + filePath[i])).isDirectory()) {
		copyDir(sourcePath + File.separator + filePath[i], newPath + File.separator + filePath[i], ignorePath);
	    }
	    // 判断是否是文件
	    if (new File(sourcePath + File.separator + filePath[i]).isFile()) {
		copyFile(sourcePath + File.separator + filePath[i], newPath + File.separator + filePath[i]);
	    }

	}
    }

    /**   
     * @Title: copyFile   
     * @Description: TODO 复制文件
     * @param: @param oldPath
     * @param: @param newPath
     * @param: @throws IOException      
     * @return: void      
     * @throws   
     */
    public static void copyFile(String oldPath, String newPath) throws IOException {
	File oldFile = new File(oldPath);
	File file = new File(newPath);
	FileInputStream in = new FileInputStream(oldFile);
	FileOutputStream out = new FileOutputStream(file);
	;

	byte[] buffer = new byte[2097152];
	int readByte = 0;
	while ((readByte = in.read(buffer)) != -1) {
	    out.write(buffer, 0, readByte);
	}

	in.close();
	out.close();
    }

    /**   
     * @Title: useArraysBinarySearch   
     * @Description: TODO 判断是否存在某个值
     * @param: @param arr
     * @param: @param targetValue
     * @param: @return      
     * @return: boolean      
     * @throws   
     */
    public static boolean useArraysBinarySearch(String[] arr, String targetValue) {
	if (arr == null || arr.length < 1)
	    return false;
	for (String string : arr) {
	    if (string.equalsIgnoreCase(targetValue))
		return true;
	}
	return false;
    }
}
