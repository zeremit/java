package com.kharevich.pricetools;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kharevich.pricetools.logic.service.ProductService;

public class Main {
	static void updateProgress(double progressPercentage) {
		final int width = 50; // progress bar width in chars

		System.out.print("\r[");
		int i = 0;
		for (; i <= (int) (progressPercentage * width); i++) {
			System.out.print(".");
		}
		for (; i < width; i++) {
			System.out.print(" ");
		}
		System.out.print("]");
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		ProductService productService = (ProductService) context
				.getBean("productService");
		System.out.println(productService.getByCode("133").getModel());
		try {
			for (double progressPercentage = 0.0; progressPercentage < 1.0; progressPercentage += 0.01) {
				updateProgress(progressPercentage);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
		}
	}
}