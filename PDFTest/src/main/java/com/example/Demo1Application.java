package com.example;

import java.io.IOException;

import org.dom4j.DocumentException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demo1Application {

	public static void main(String[] args) throws DocumentException, IOException, com.lowagie.text.DocumentException {
		
		System.out.println("hi");
		PDFService pf=new PDFService();
		
		try {
			pf.extension();
		
		} catch (IOException e) {
			System.out.println("i am comming");
			e.printStackTrace();
		} catch (com.lowagie.text.DocumentException e) {
			System.out.println("i am comming");
			e.printStackTrace();
		}
		
		
		
		SpringApplication.run(Demo1Application.class, args);
		
	}
}
