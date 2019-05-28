package com.demo;

/**   
 * @ClassName:  Detail   
 * @Description:TODO  
 * @author: xzr 
 * @date:   2019年4月16日 
 *     
 */ 
public class Detail {

	public void setCheck01(String type) {
		System.out.println("check01\t"+type);
	}
	
	public void setCheck01(Integer type) {
		System.out.println("check01_int\t"+type);
	}
	
	public void setCheck02(Integer type) {
		System.out.println("check02\t"+type);
	}
	
	public void setCheck03(String type) {
		System.out.println("check03\t"+type);
	}
	
	public void setCheck04(String type) {
		System.out.println("check04\t"+type);
	}
	
	public void setCheck05(String type) {
		System.out.println("check04\t"+type);
	}
	 
	public Integer setCheck06(String type,Integer integer) {
		System.out.println("check04\t"+type+"\t"+integer);
		return integer;
	}

}
