package webCrawlig.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import webCrawlig.dto.Hotel_ImagesDTO;
import webCrawlig.service.CrawligService;


// http://localhost:8090/test/test/images_Sub

@Controller
public class hotel_sub_ImagesController {

	
	
	
	private final CrawligService service;

	@Autowired
	public hotel_sub_ImagesController(CrawligService service) {
		this.service = service;
	}
	
	
	@GetMapping("/test/test/images_Sub")
	public void execute() throws IOException {
		
		// 지역 : 강남/역삼/삼성/신사/청담 
				// 기간 : 4.19 ~ 4.20 
				// 호텔 갯수 : 47

				String [] urlList = {
						// 1. 호텔 크레센도 서울
						"https://www.goodchoice.kr/product/detail?ano=55178&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 2. 호텔 리베라    
						"https://www.goodchoice.kr/product/detail?ano=6264&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 3. 호텔 인 나인 강남
						"https://www.goodchoice.kr/product/detail?ano=57843&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 4. 노보텔 앰배서더 서울 강남
						"https://www.goodchoice.kr/product/detail?ano=6473&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 5. 이비스 스타일 앰배서더 강남
						"https://www.goodchoice.kr/product/detail?ano=6826&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 6. 호텔 안테룸 서울
						"https://www.goodchoice.kr/product/detail?ano=65455&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 7. 더 디자이너스 리즈 강남 프리미어
						"https://www.goodchoice.kr/product/detail?ano=6903&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 8. 호텔 카푸치노
						"https://www.goodchoice.kr/product/detail?ano=6915&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 9. 호텔 선샤인 서울
						"https://www.goodchoice.kr/product/detail?ano=6533&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 10. 에이든 바이베스트웨스턴 청담
						"https://www.goodchoice.kr/product/detail?ano=55185&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 11. L7 강남 바이 롯데
						"https://www.goodchoice.kr/product/detail?ano=48567&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 12. AC 호텔 바이 메리어트 서울 강남
						"https://www.goodchoice.kr/product/detail?ano=70224&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 13. 글래드 강남 코엑스센터
						"https://www.goodchoice.kr/product/detail?ano=49442&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 14. 신라스테이 역삼
						"https://www.goodchoice.kr/product/detail?ano=7936&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 15. 보코서울강남, IHG 호텔
						"https://www.goodchoice.kr/product/detail?ano=70540&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 16. 엘리에나 호텔
						"https://www.goodchoice.kr/product/detail?ano=72776&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 17. H 에비뉴 호텔 역삼점
						"https://www.goodchoice.kr/product/detail?ano=71261&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 18. 조선 팰리스 서울 강남 럭셔리 컬렉션
						"https://www.goodchoice.kr/product/detail?ano=69906&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 19. 사월 호텔
						"https://www.goodchoice.kr/product/detail?ano=69487&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 20. 역삼 아르누보씨티 호텔앤레지던스
						"https://www.goodchoice.kr/product/detail?ano=70045&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 21. 신라스테이 삼성
						"https://www.goodchoice.kr/product/detail?ano=64392&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 22. 안다즈 서울 강남
						"https://www.goodchoice.kr/product/detail?ano=61931&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 23. 파크 하얏트 서울
						"https://www.goodchoice.kr/product/detail?ano=57910&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 24. 오크우드 프리미어 코엑스센터
						"https://www.goodchoice.kr/product/detail?ano=65311&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 25. 라비타호텔
						"https://www.goodchoice.kr/product/detail?ano=52120&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 26. 호텔 세느
						"https://www.goodchoice.kr/product/detail?ano=51954&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 27. 호텔 페이토 삼성
						"https://www.goodchoice.kr/product/detail?ano=45184&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 28. 파티오세븐 호텔
						"https://www.goodchoice.kr/product/detail?ano=52834&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 29. 호텔 아노블리
						"https://www.goodchoice.kr/product/detail?ano=61661&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 30. 호텔 컬리넌 개포
						"https://www.goodchoice.kr/product/detail?ano=48277&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 31. 도미인 서울강남
						"https://www.goodchoice.kr/product/detail?ano=13067&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 32. 오월 호텔
						"https://www.goodchoice.kr/product/detail?ano=51593&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 33. 인터컨티넨탈 서울 코엑스
						"https://www.goodchoice.kr/product/detail?ano=6980&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 34. 마리호텔
						"https://www.goodchoice.kr/product/detail?ano=51237&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 35. 삼정호텔
						"https://www.goodchoice.kr/product/detail?ano=45099&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 36. 그랜드 인터컨티넨탈 서울 파르나스
						"https://www.goodchoice.kr/product/detail?ano=6490&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 37. 호텔 엔트라 강남
						"https://www.goodchoice.kr/product/detail?ano=10845&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 38. 호텔스타 강남
						"https://www.goodchoice.kr/product/detail?ano=9850&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 39. 강남 스테이호텔
						"https://www.goodchoice.kr/product/detail?ano=8200&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 40. 호텔 그라모스
						"https://www.goodchoice.kr/product/detail?ano=6446&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 41. 호텔 카파스
						"https://www.goodchoice.kr/product/detail?ano=7103&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 42. 인더시티 비즈니스
						"https://www.goodchoice.kr/product/detail?ano=6564&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 43. 라까사호텔 서울
						"https://www.goodchoice.kr/product/detail?ano=6639&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 44. 알로프트 서울 강남
						"https://www.goodchoice.kr/product/detail?ano=6322&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 45. 호텔 데님
						"https://www.goodchoice.kr/product/detail?ano=6338&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 46. 베니키아 강남 노블레스
						"https://www.goodchoice.kr/product/detail?ano=6350&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20",
						// 47. 베스트웨스턴 프리미어 강남 호텔
						"https://www.goodchoice.kr/product/detail?ano=6259&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20"
				
			};
		
		/////////////////////////////////////
		
			for(int i=0; i<urlList.length; i++) {
				
				String url = urlList[i];
			      
				////////////////////////////////
		      Document doc = Jsoup.connect(url).get();
		      
		      //호텔 서브 사진
		      Elements e1 = doc.getElementsByAttributeValue("class", "swiper-wrapper");
				
				List<String> hotel_SubList = e1.first().children()
							.select("img").eachAttr("data-src");
		      	
				List<String> hotel_SubName = e1.first().children()
						.select("img").eachAttr("alt");
				
				 
				//폴더 이름
	    	  	String hotel_num = "hotel_Num"+(i+1);
				
	    	  	int num = (i+1);
				
		      for(int j=0; j<hotel_SubList.size(); j++) {
		    		 
		    	  	///////////////////////////////////
		    	  	//hotel_code
		    	  	
		    	  	/////////////////////////////////////////
		    	  	
		    	  	
		    	  	
		    	  	//호텔 이름
		    	  	String filename = hotel_SubName.get(j);
		    	  			
		    	  	
		    	 	//호텔 사진 경로 
		    	  	String filepath = hotel_SubList.get(j);
		    	  	
		    	  	//호텔 우리가 저장할 경로
					/*
					 * String filepathTrue = "hotel_Num"+(i+1)+"/"+ hotel_SubList.get(j)
					 * .substring(filepath.length()-17,filepath.length());
					 */
		    	 
		    	  	Hotel_ImagesDTO hotelImagesDTO = new Hotel_ImagesDTO(num,filename,filepath);
		    	  	
		    	  	service.hotelSubImagesProcess(hotelImagesDTO);
		    	  	
		    	  	
		    	  	
		    	  	//saveFile(hotel_num, filepath);
		    	  	
		    	  	
		    	  	
		    	  
		    		System.out.println(j+"작업 완료");
		      }
		      
		      
				
			}
	      
	      
	      
		
	}
	
	static void saveFile(String no, String imgSrc) throws IOException {
		
		URL url = new URL("https:"+imgSrc);
		
		
		BufferedInputStream bis = new BufferedInputStream(url.openStream());
		
		File file = new File("D:\\hotel_images_sub",no);
		
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