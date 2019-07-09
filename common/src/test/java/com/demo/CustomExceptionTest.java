package com.demo;

import java.util.Scanner;

import org.junit.Test;

import com.demo.exception.CustomException;

/* 
* 自定义的异常测试类 
*/
public class CustomExceptionTest {

	@Test
	public void test1() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("输入数字，输入-1结束：");
			int score = sc.nextInt();
			if (score == -1) {
				System.out.println("结束循环");
				break;
			}
			try {
				check(score);
			} catch (CustomException e) {// 用自己的异常类来捕获异常
				System.out.println(e.getMessage());
//				e.printStackTrace();
			}
		}
	}

	// 检查分数合法性的方法check() 如果定义的是运行时异常就不用抛异常了
	public void check(int score) throws CustomException {// 抛出自己的异常类
		if (score > 120 || score < 0) {
			// 分数不合法时抛出异常
			throw new CustomException("分数不合法，分数应该是0--120之间");// new一个自己的异常类
		} else {
			System.out.println("分数合法，你的分数是" + score);
		}
	}
}
