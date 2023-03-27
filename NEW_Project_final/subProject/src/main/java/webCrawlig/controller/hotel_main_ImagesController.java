package webCrawlig.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import webCrawlig.dto.Hotel_ImagesDTO;
import webCrawlig.dto.Room_SubInfoDTO;
import webCrawlig.service.CrawligService;

// http://localhost:8090/test/test/images

@Controller
public class hotel_main_ImagesController {

	private final CrawligService service;

	@Autowired
	public hotel_main_ImagesController(CrawligService service) {
		this.service = service;
	}
	
	
	@GetMapping("/test/test/images")
	public void execute() throws IOException {
		
		
		
		String url = "https://www.goodchoice.kr/product/search/2/2012?sel_date=2023-04-19&sel_date2=2023-04-20";
	      
	      Document doc = Jsoup.connect(url).get();
	      
	      Elements e1 = doc.getElementsByAttributeValue("class", "list_2 adcno2");
	      
	      //사진/
	      //e1.attr("class","pic").select("img").eachAttr("data-original").forEach(n->System.out.println(n));
	      // 사진이름
	      //e1.attr("class","pic").select("img").eachAttr("alt").forEach(n->System.out.println(n));
	      
	      	
	      	
	      
	      
	      
	      
			
	      for(int i=0; i<e1.size(); i++) {
	    		 
	    	  	Element e2 = e1.get(i);
	    	  	
	    	  	//폴더 이름
	    	  	String hotel_num = "hotel_Num"+(i+1);
	    	  	
	    	  	//호텔 이름
	    	  	String filename = e2.attr("class","pic").select("img").attr("alt");
	    	  	
	    	  	
	    	  	
	    	 	//호텔 사진 경로 
	    	  	String filepath = e2.attr("class", "pic").select("img").attr("data-original");
	    	  	
	    	  	//호텔 우리가 저장할 경로
//	    	  	String filepathTrue = "hotel_Num"+(i+1)+"/"+e2.attr("class", "pic").select("img")
//	    	  			.attr("data-original")
//	    	  			.substring(filepath.length()-17,filepath.length());
	    	 
	    	  	Hotel_ImagesDTO hotelImagerDTO = new Hotel_ImagesDTO(filename,filepath);
	    	  	
	    	  	service.hotelImagesProcess(hotelImagerDTO);
	    	  	
	    	  	
	    	  	
	    	  	
	    	  	//saveFile(hotel_num, filepath);
	    	  	
	    	  	
	    	  	
	    	  	
	    	  	
	    	  
	    		System.out.println(i+"작업 완료");
	      }
	      
	      
	      
		
	}
	
	static void saveFile(String no, String imgSrc) throws IOException {
		
		URL url = new URL("https:"+imgSrc);
		
		
		BufferedInputStream bis = new BufferedInputStream(url.openStream());
		
		File file = new File("D:\\hotel_images",no);
		
		if(!file.exists()) {
			file.mkdirs();
		}
		
		 file = new File(file, imgSrc.substring(imgSrc.length()-17, imgSrc.length()));
	        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
		
		
		int b = 0;
		while((b = bis.read()) != -1){
			
			bos.write(b);
			
		}
		
		bos.close();
		
	}
	
}
