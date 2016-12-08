package com.randioo.demo_optimisticframe_server.utils;

import java.util.Random;

public class Utils {
	public static Random random = new Random();
	public static int getNowTime() {
		return (int) (System.currentTimeMillis() / 1000);
	}
	
	public static final int getRandomNum(int startIndex, int base) {
		if (base <= 0) {
			return 0;
		}
		return startIndex + random.nextInt(base - startIndex + 1);
	}
}
