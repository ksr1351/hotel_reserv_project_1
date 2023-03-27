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
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import webCrawlig.dto.RoomDTO;
import webCrawlig.dto.Room_SubInfoDTO;
import webCrawlig.service.CrawligService;

// http://localhost:8090/test/test/RoomOutLine

@Controller
public class RoomOutLineController {


	private final CrawligService service;

	@Autowired
	public RoomOutLineController(CrawligService service) {
		this.service = service;
	}
	
	
	@GetMapping("/test/test/RoomOutLine")
	public void execute() throws IOException {
		
		
		
		String url = "https://www.goodchoice.kr/product/detail?ano=55178&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20";
	      
	      Document doc = Jsoup.connect(url).get();
	      
	      Elements e1 = doc.getElementsByAttributeValue("class", "layer pop_full pop_useinfo");
	      
	      
	      	
	      	
	      	//객실 기본정보
			//e1.select("section").eachText().stream().filter(n->n.contains("기본정보")).forEach(n->System.out.println(n.substring(5)));
			
			List<String> subList = e1.select("section")
					.eachText().stream().filter(n->n.contains("기본정보")).collect(Collectors.toList());
	      
	      
	   
	      //객실가격
	      //e1.select("b").eachText().forEach(n->System.out.println(n));
	      
	      Elements e3 = doc.getElementsByAttributeValue("class", "room");
	      
	      List<String> priceList = e3.select("b").eachText().stream().collect(Collectors.toList());
	      
	      //객실이름
	      //e1.select("strong").eachText().stream()
			//.filter(n-> !(n.equals("가격"))).forEach(n->System.out.println(n));
	      
	      List<String> nameList =e3.select("strong").eachText().stream()
	    		  					.filter(n-> !(n.equals("가격"))).collect(Collectors.toList());
	      
	      
	      //객실사진
	      //e1.select("img").eachAttr("data-original").forEach(n->System.out.println(n));
	      
//			Elements e2 = doc.getElementsByAttributeValue("class", "address");
//			
//			e2.select("p").eachText().forEach(n->System.out.println(n));
	      
	      
	      
			
	      for(int i=0; i<e1.size(); i++) {
	    		 
	    	  	int room_code = 1;
	    	  
	    	  	//객실 이름
	    	  	String roomName = nameList.get(i);
	    	  	
	    	  	//객실 기본 정보
	    	  	String SubInfo = subList.get(i);
	    		
	    	  	//객실가격
	    	  	String price = priceList.get(i);
	    		
	    		Room_SubInfoDTO room_SubInfoDTO = 
	    				new Room_SubInfoDTO(room_code, roomName,SubInfo,price);
	    	  	
	    	  	
	    		//service.roomSubInfoProcess(room_SubInfoDTO);
	    	  
	    		System.out.println(i+"작업 완료");
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
