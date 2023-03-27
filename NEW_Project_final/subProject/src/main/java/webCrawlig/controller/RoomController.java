package webCrawlig.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import webCrawlig.dto.Hotel_banner_InfoDTO;
import webCrawlig.dto.RoomDTO;
import webCrawlig.service.CrawligService;

// http://localhost:8090/test/test/Room

@Controller
public class RoomController {

	private final CrawligService service;

	@Autowired
	public RoomController(CrawligService service) {
		this.service = service;
	}
	
	
	@GetMapping("/test/test/Room")
	public void execute() throws IOException {
		
		
		
		String url = "https://www.goodchoice.kr/product/detail?ano=49442&adcno=2&sel_date=2023-03-14&sel_date2=2023-03-15";
	      
	      Document doc = Jsoup.connect(url).get();
	      
	      Elements e1 = doc.getElementsByAttributeValue("class", "default_info");
	      
	      
	     
	      //객실 주소
	      Elements ee = doc.getElementsByAttributeValue("class", "address");
	      
	      List<String> list1 =e1.select("h3").eachText();
	      
	      List<String> list3 = new ArrayList<>();
			
			for(int i=1; i<e1.select("ul").size()+1; i++) {
				
				for(int j=0; j<e1.select("ul").get(i-1).select("li").size(); j++) {
					
					list3.add(list1.get(i)+"@"+e1.select("ul").get(i-1).select("li").get(j).text());
				}
				
				
			} 
	      
			List<String> StringList = new ArrayList<>();
			
			for(int i=0; i<list3.size(); i++) {
				
				
				for(int j=0; j<2; j++) {
					
					StringList.add(list3.get(i).split("@")[j]);
					
				}
				
				
				
			}
			
			List<String> infoList = new ArrayList<>();
			
			List<String> detailInfoList = new ArrayList<>();
			
			for(int i=0; i<StringList.size(); i++) {
				
				if(i%2==0) {
					infoList.add(StringList.get(i));
				}
				
				if(i%2!=0) {
					detailInfoList.add(StringList.get(i));
				}
				
			}

			
		
			
			
	      for(int i=0; i<e1.select("ul").select("li").size(); i++) {
	    		  
	    	  
	    	  
	    	  //객실 정보
	    	  
	    	  int room_code = 2;
	    	  
	    	  String info = infoList.get(i);
	    	  
	    	  //객실 세부정보
	    	  String detail_info = detailInfoList.get(i);
	    	  
	    	  //객실 주소
	    	  //String detail_address = null;
	    	  
//	    	  if(i==0) {
//	    		  detail_address = ee.select("p").text();
//		    	  
//	    	  }
	    	  
	    	  
	    	  RoomDTO roomDTO = new RoomDTO(room_code,info,detail_info);
	    	  
	    	  	System.out.println(i + "번 작업 완료");
	    	  	
	    	  	service.roomDetailInfoProcess(roomDTO);
	    	  
	    	  
	      }
	      
	      
	      
		
	}
	
	static void saveFile(String no, String imgSrc) throws IOException {
		
		URL url = new URL("https:"+imgSrc);
		
		
		BufferedInputStream bis = new BufferedInputStream(url.openStream());
		
		File file = new File("C:\\hotel_images",no);
		
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
