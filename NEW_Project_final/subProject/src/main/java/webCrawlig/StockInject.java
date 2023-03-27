package webCrawlig;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oracle.ucp.jdbc.oracle.DataBasedConnectionAffinityCallback;
import webCrawlig.dao.CrawligDAO;
import webCrawlig.dto.Hotel_ImagesDTO;
import webCrawlig.dto.Hotel_banner_InfoDTO;
import webCrawlig.service.CrawligService;



public class StockInject {
	
	
		

	

	public static void main(String[] args) throws IOException {
		
		String url = "https://www.goodchoice.kr/product/search/2";
	      
	      Document doc = Jsoup.connect(url).get();
	      
	      Elements e1 = doc.getElementsByAttributeValue("class", "list_2 adcno2");
	      
	     
	      
	      //호텔 위치 / 전부다 강남구 
	      //e1.select("p").eachText().stream().filter(n-> n.contains("강남구")).forEach(j->System.out.println(j));
	      
	      List<String> location =  e1.select("p").eachText().stream().filter(n-> n.contains("강남구")).collect(Collectors.toList());
	      
	      //사진
	      //e1.attr("class","pic").select("img").eachAttr("data-original").forEach(n->System.out.println(n));
	      // 사진이름
	      //e1.attr("class","pic").select("img").eachAttr("alt").forEach(n->System.out.println(n));
	      
	      //호텔 이름
	      //e1.select("strong").eachText().forEach(n->System.out.println(n));
	      
	      //호텔 가격
	      
	      List<String> TrueList = new ArrayList<>();
	      List<String> StringList= e1.select("b").eachText().stream().filter(n->n.contains("원"))
	      .collect(Collectors.toList());
	      for(int i=0; i<StringList.size(); i++) {
	    	  
	    	  if(i %2 ==0) {
	    		 TrueList.add(StringList.get(i));
	    	  }
	    	 
	    	 
	      }
	      
	      
	      //호텔등급
	      
	      
//	      List<String> listRating = 
//	      	e1.attr("class", "badge").select("span").eachText().stream()
//	      		.filter(n -> (n.contains("성급")|| n.contains("비지니스") || n.contains("특급")|| n.contains("레지던스")||
//	      				n.contains("관광") || n.contains("부티크") || n.contains("급"))).collect(Collectors.toList());
//	      	
//	      
//	      listRating.forEach(n->System.out.println(n));
	      	
	      
	      List<String> listRating = 
	      	e1.attr("class", "badge").select("span").eachText().stream()
	      		.filter(n -> (n.contains("비지니스") || n.contains("특급")|| n.contains("레지던스")||
	      				n.contains("관광") || n.contains("부티크") || n.contains("급"))).collect(Collectors.toList());
	      	
	      
//	      listRating.forEach(n->System.out.println(n));
	      

	      for(int i=0; i<e1.size(); i++) {
	    	  
	    	  
	    	  Element e2 = e1.get(i);
	    	  
	    	  	//호텔 정보 
	    	  	
	    	  	
	    	  
	    	  	//호텔 이름
	    	  	String name = e2.select("strong").text();
	    	  	//호텔 등급
	    	  	String type = listRating.get(i);
	    	  	//호텔 주소
	    	  	String address = location.get(i);
	    	  	//호텔 가격
	    	  	String price = TrueList.get(i);
	    	  	
	    	  	Hotel_banner_InfoDTO hotelDTO = 
	    	  			new Hotel_banner_InfoDTO(name, type, address,price);
	    	  	
	    	  
	    	  
	    	  	///////////////////////////////////////////////////////////////
	    	  	
	    	  
	    	  	
	    	  
	    	  	
	    	  	//호텔 사진
	    	  	String filename = "http://"+ e2.attr("class", "pic").select("img").attr("data-original");
	    	  	
	    	  	//호텔 이름
	    	  	String filepath = e2.select("strong").text();
	    	  	
	    	  //호텔 이미지 정도
	    	  	Hotel_ImagesDTO hotelImagerDTO = new Hotel_ImagesDTO(filename,filepath);
	    	  	
	    	  
	    	  	
	    	  	
	    	  	
	    	  	saveFile(name, filename);
	    	  	
	    	  	System.out.println(i + "번 작업 완료");
	    	  
	      }
	      
	      
	      
		
	}
	
	static void saveFile(String no, String imgSrc) throws IOException {
		
		URL url = new URL(imgSrc);
		
		
		BufferedInputStream bis = new BufferedInputStream(url.openStream());
		
		File file = new File("C:\\hotel_images",no);
		
		if(!file.exists()) {
			file.mkdirs();
		}
		
		 file = new File(file, imgSrc);
	        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
		
		
		int b = 0;
		while((b = bis.read()) != -1){
			
			bos.write(b);
			
		}
		
		bos.close();
		
	}
	
	
	static void saveDB(Hotel_banner_InfoDTO hotelDTO,Hotel_ImagesDTO hotelImagerDTO) {
		
		
		
	}
	
	
	
}//class






