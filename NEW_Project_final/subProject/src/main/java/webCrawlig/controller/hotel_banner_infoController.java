package webCrawlig.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import webCrawlig.dto.Hotel_banner_InfoDTO;
import webCrawlig.dto.RoomDTO;
import webCrawlig.service.CrawligService;

// http://localhost:8090/test/test/hotel_banner_info

@Controller
public class hotel_banner_infoController {

	private final CrawligService service;

	@Autowired
	public hotel_banner_infoController(CrawligService service) {
		this.service = service;
	}
	
	
	@GetMapping("/test/test/hotel_banner_info")
	public void execute() throws IOException {
		
		
		
		/////////////////////////////////////
		
				String url = "https://www.goodchoice.kr/product/search/2/2012?sort=HIT&sel_date=2023-04-19&sel_date2=2023-04-20&persons=";
				
			
				////////////////////////////////
				 Document doc = Jsoup.connect(url).get();
				 
				 Elements e1 = doc.getElementsByAttributeValue("class", "list_2 adcno2");
				
				//호텔 위치 / 전부다 강남구 
			     //e1.select("p").eachText().stream().filter(n-> n.contains("강남구")).forEach(j->System.out.println(j));
			       
				 List<String> hotel_address = e1.select("p").eachText().stream().filter(n-> n.contains("강남구")).collect(Collectors.toList());
					
			      //호텔 이름
//			      e1.select("strong").eachText().forEach(n->System.out.println(n));
//			      List<String> hotelName = e1.select("strong").eachText();
				 
				  List<String> hotel_name = e1.select("strong").eachText();
				 
//			     System.out.println(e1.select("strong").eachText().stream().count());
				
				
			      //호텔 최저 가격
			      List<String> price_TrueList = new ArrayList<>();
			      List<String> StringList= e1.select("b").eachText().stream().filter(n->n.contains("원"))
			      .collect(Collectors.toList());
			      for(int e=0; e<StringList.size(); e++) {
			    	  
			    	  if(e %2 ==0) {
			    		  price_TrueList.add(StringList.get(e));
			    	  }
			    	 
			    	 
			      }
			
			      //호텔등급
			      List<String> listRating = 
			      	e1.attr("class", "badge").select("span").eachText().stream()
			      		.filter(n -> (n.contains("성급")|| n.contains("비지니스") || n.contains("특급")|| n.contains("레지던스")||
			      				n.contains("관광") || n.contains("부티크") || n.contains("급"))).collect(Collectors.toList());
		      
				
	    	  	//int num = (i+1);
				
		      for(int j=0; j<e1.size(); j++) {
		    		
		    	  
		    	//호텔 이름
		    	String name = hotel_name.get(j);
		    	//호텔 등급
		    	String type = listRating.get(j);
		    	//호텔 주소
		    	String address = hotel_address.get(j);
		    	//호텔 객실 최저 가격
		    	String price = price_TrueList.get(j);
		    	
		    	Hotel_banner_InfoDTO bannerDTO 
		    			= new Hotel_banner_InfoDTO(name, type, address, price); 
		    	  	
		    	service.hotelProcess(bannerDTO);
		    	
		    		System.out.println(j + "번 작업 완료");
		    	  	
		    	  
		      }
		      
		    
			}
	      
	      
	      
		
	
	
}
