package com.example;

import java.io.File;
//import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
//import java.nio.file.Path;

/*import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;*/
//import java.util.Locale;

//import org.dom4j.DocumentException;


//import org.springframework.beans.factory.annotation.Autowired;
//import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;
//import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.FileTemplateResolver;

//import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
//import org.thymeleaf.templateresolver.TemplateResolver;

import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;
import com.lowagie.text.pdf.BaseFont;
//import com.lowagie.text.pdf.BaseFont;
import com.sun.xml.messaging.saaj.util.ByteOutputStream;
//import com.sun.xml.messaging.saaj.util.ByteOutputStream;
//import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

public class PDFService  {

	/* @Autowired
	    private SpringTemplateEngine templateEngine;*/
	
	
	
/*
	public void pdffile() throws DocumentException, IOException, com.lowagie.text.DocumentException {
		 
		 ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
		     
		    templateResolver.setPrefix("src/resources/templates/");
		    templateResolver.setSuffix(".html");
		    templateResolver.setTemplateMode("XHTML");
		    templateResolver.setCharacterEncoding("UTF-8");
		    
		TemplateResolver templateResolver=new ClassLoaderTemplateResolver();
		    templateResolver.setPrefix("resources/templates/");
		    templateResolver.setSuffix(".html"); 
		    
		    templateResolver.setCharacterEncoding("UTF-8");
		    templateResolver.setTemplateMode("HTML5");
		    
		    

		    TemplateEngine templateEngine = new TemplateEngine();
		    templateEngine.setTemplateResolver(templateResolver);
		   
		    
		    
		   // System.out.println("30==="+templateResolver.getName());
		    
		    final Context ctx = new Context();
		    
		    ctx.setVariable("message", "Generating PDF files from html template");
		    System.out.println("its comming");
		    String htmlContent = templateEngine.process("F:\\EagreeDC\\demo1\\src\\main\\resources\\templates\\messageTpl.html", ctx);
		    
		    
		    System.out.println("its not comming");
		    //ctx.setVariable("", htmlContent);
		    
		    ByteOutputStream os = new ByteOutputStream();
		    
		    ITextRenderer renderer = new ITextRenderer();
		    //ITextFontResolver fontResolver = renderer.getFontResolver();

		    ClassPathResource regular = new ClassPathResource("");
		    fontResolver.addFont(regular.getURL().toString(), "", true);

		    renderer.setDocument(htmlContent);
		    renderer.layout();
		    renderer.createPDF(os);

		    byte[] pdfAsBytes = os.getBytes();
		    os.close();

		    FileOutputStream fos = new FileOutputStream(new File("/tmp/message.pdf"));
		    fos.write(pdfAsBytes);
		    fos.close();
		  }*/
		
	 public void extension() throws com.lowagie.text.DocumentException, IOException {
	        FileTemplateResolver resolver = new FileTemplateResolver();
	        resolver.setPrefix("Templates/");
	        resolver.setSuffix(".html");
	        resolver.setTemplateMode("HTML5");
	        //resolver.setOrder(templateEngine.getTemplateResolvers().size());
	        resolver.setCacheable(false);
	        
	        SpringTemplateEngine templateEngine=new SpringTemplateEngine();
 	        
	        templateEngine.setTemplateResolver(resolver);
	        
            final Context ctx = new Context();
		    
		    ctx.setVariable("message", "Generating PDF files from html template");
		    System.out.println("its comming");
		    String htmlContent = templateEngine.process("messageTpl", ctx);
		    
		    
		    ByteOutputStream os = new ByteOutputStream();
		    
		    File f=new File("abc.txt");
		    System.out.println("its 123"+f.getAbsolutePath());
		    
		    
		    ITextRenderer renderer = new ITextRenderer();
		   
		   ITextFontResolver fontResolver = renderer.getFontResolver();
	       
		  
		    
		    fontResolver.addFont(f.getAbsolutePath().toString(), BaseFont.IDENTITY_H, true);
	        renderer.setDocument(htmlContent);
		    renderer.layout();
		    renderer.createPDF(os);

		    byte[] pdfAsBytes = os.getBytes();
		    os.close();

		    FileOutputStream fos = new FileOutputStream(new File("/tmp/message.pdf"));
		    fos.write(pdfAsBytes);
		    fos.close();
	    }





}
	

