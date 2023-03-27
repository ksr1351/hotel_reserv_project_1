package webCrawlig;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.apache.commons.collections.map.HashedMap;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import javassist.compiler.ast.StringL;



public class RoomStock {
		
	public static void main(String[] args) throws IOException {
		
		String url = "https://www.goodchoice.kr/product/detail?ano=55178&adcno=2&sel_date=2023-04-19&sel_date2=2023-04-20";
		
		Document doc = Jsoup.connect(url).get();
		
		Elements e1 = doc.getElementsByAttributeValue("class","room");
		
		//e1.select("img").forEach(n->System.out.println(n));
		
		//e1.select("img").eachAttr("data-src").forEach(n->System.out.println(n));
		
		e1 = doc.getElementsByAttributeValue("class", "detail_info");
		
		
		//e1.select("section").attr("class","theme_wrap").forEach(n->System.out.println(n));
		
		
		//System.out.println(e1.select("img").eachAttr("data-src").size());
		
		//e1.attr("class", "lazy").select("img").eachAttr("data-original").forEach(n->System.out.println());
		
		//e1.attr("class", "info").forEach(n->System.out.println(n));
		//e1.forEach(n->System.out.println(n));
		
		//e1.attr("class", "lazy").eachAttr("data-original").forEach(n->System.out.println(n));
		
		
		//호텔 메인 사진
		//e1.select("img").eachAttr("data-original").forEach(n->System.out.println(n));
		
		//호텔 서브 사진
		e1 = doc.getElementsByAttributeValue("class", "swiper-wrapper");
		
		
		
		//e1.forEach(n->System.out.println(n));
		
//		e1.first().children()
//				.select("img").eachAttr("data-src")
//				.forEach(n-> System.out.println(n));
//		System.out.println(e1.first().children().select("img").eachAttr("data-src").size()); // 14
		
		
		//객실 메인 사진
		
		
		
		
		//객실 서브 사진
		e1 = doc.getElementsByAttributeValue("class","item on");
		//전체 
		
		//e1.forEach(n->System.out.println(n));
		
		//System.out.println(e1.size());
		
		
		//e1.select("img").eachAttr("alt").forEach(n->System.out.println(n));
		
		//전체 객실 사진수 87
		//System.out.println(e1.select("img").eachAttr("alt").stream().count());
		
		//e1.select("img").eachAttr("data-src").forEach(n->System.out.println(n));
		
		
		
		//e1.select("img").eachAttr("alt").forEach(n->System.out.println(n));
		
		//객실 주소  87
		List<String> img_Room = e1.select("img").eachAttr("data-src");
//		//객실 이름  87
		List<String> img_Name = e1.select("img").eachAttr("alt");    
//		//객실 넘버  87
//		
		List<String> roomImages = new ArrayList<>();
		
		
		List<Integer> Room_num = new ArrayList<>();
		
		//int numPlus =0;
		
		int num = 1;
		
//		if(numPlus > 1) {
//			num = numPlus;
//		}
		
		for(int i=1; i<e1.select("img").eachAttr("alt").size(); i++) {
			
			roomImages.add(img_Name.get(i-1)+num);
			
			Room_num.add(num);
			
			if(!(img_Name.get(i-1).equals(img_Name.get(i)))){
					num++;
			}
			
//			if(i==e1.select("img").eachAttr("alt").size()-1) { 
//				
//				numPlus +=Room_num.get(e1.select("img").eachAttr("alt").size()-1);
//			}
			
		}
		
			Room_num.add(num);
			
			Room_num.forEach(n->System.out.println(n));
		  	
			
			
			
		
				
				
				
			
			
//		
//		System.out.println(Room_num.size());
//		roomImages.add(img_Name.get(e1.select("img").eachAttr("alt").size()-1)+num);
//		
//		roomImages.forEach(n->System.out.println(n));
//		
//		//객실 코드
//		//Room_num.forEach(n->System.out.println(n));
//		
//		System.out.println(Room_num.stream().count());
		
		//객실  이름
		//List<String> roomImgList = e1.select("img").eachAttr("alt");
		
		
		
		//roomImgList.forEach(n->System.out.println(n));
		
//		roomImgList.forEach(n->{
//			
//			int num = n.indexOf("|");
//			System.out.println(n.substring(num+2, n.length()));
//			
//		});
//		
//		
//		
//		List<String> roomImgList2 = new ArrayList<>();
//		
//		List<Integer> roomNumList = new ArrayList<>();
//		
//		int num = 1;
//		
//		for(int i=1; i<roomImgList.size(); i++) {
//				
//			roomImgList2.add(roomImgList.get(i-1)+num);
//			
//			roomNumList.add(num);
//			
//				if(!(roomImgList.get(i-1)
//						.equals(roomImgList.get(i)))) {
//					num++;
//				}
//			
//				//마지막 값 추가 
//				if(i==roomImgList.size()-1) {
//					roomImgList2.add(roomImgList.get(roomImgList.size()-1)+num);
//					
//					roomNumList.add(num);
//				}
//				
//		}
		
		
		//roomImgList2.forEach(n->System.out.println(n));
		
		//System.out.println(roomImgList2.stream().count());
		
		//System.out.println("------------------------------------");
		//roomNumList.forEach(n->System.out.println(n));
		
		//System.out.println(roomNumList.stream().count());
		
	
	
		
		//System.out.println(e1.size());
		
		//e1.forEach(n->System.out.println(n));
		
		//e1.forEach(n->System.out.println(n));
		
		//e1.select("strong").eachText().forEach(n->System.out.println(n));
		
		e1 = doc.getElementsByAttributeValue("class", "room");
		
		//객실 이름
		//e1.select("strong").eachText().stream()
		//.filter(n-> !(n.equals("가격"))).forEach(n->System.out.println(n));
		//e1.select("strong").eachText().stream()
		//	.filter(n-> !(n.equals("가격"))).collect(Collectors.toList()).forEach(n->System.out.println(n));
		//객실 이름
	//	List<String> nameList =e1.select("strong").eachText().stream()
	//				.filter(n-> !(n.equals("가격"))).collect(Collectors.toList());
		
		//nameList.forEach(n->System.out.println(n));
		
		
		
		
		
		//객실 가격
		//e1.select("b").eachText().forEach(n->System.out.println(n));
		
		/////////////////////////////////////////////////////////////////////////////////////////
		
		e1 = doc.getElementsByAttributeValue("class", "layer pop_full pop_useinfo");
		
		//e1.attr("class", "dot_txt").forEach(n->System.out.println(n));
		
//		e1.attr("class", "dot_txt").select("ul")
//		.first().children().eachText().forEach(n->System.out.println(n));
		
//		List<String> room_subInfo =e1.attr("class", "dot_txt").select("ul")
//		.first().children().eachText(); // 
		
		//e1.attr("class", "dot_txt")
		//		.select("ul").first().childNodes().forEach(n->System.out.println(n));
		//childNodes 이건 속성도 같이 
		//System.out.println(e1.attr("class", "dot_txt").get(9));
		
//		System.out.println(e1.attr("class", "dot_txt").get(9)
//					.select("ul").first().children().eachText()
//		);
		
//		List<String> room_member = new ArrayList<>();
//		
//		List<String> room_bed = new ArrayList<>();
//		
//		List<String> room_width = new ArrayList<>();
//		
//		for(int e=0; e<e1.size(); e++) {
//			
//			for(int k=0; k<e1.attr("class", "dot_txt").get(e)
//					.select("ul").first().children().size(); k++) {
//				
//				if(e1.attr("class", "dot_txt").get(e)
//						.select("ul").first().children().size()==4) {
//					
//					if(k==0) {
//						room_member.add(e1.attr("class", "dot_txt").get(e)
//								.select("ul").first().children().eachText().get(k)
//								+e1.attr("class", "dot_txt").get(e)
//								.select("ul").first().children().eachText().get(k+1)
//								);
//						
//					}
//					if(k==2) {
//						room_bed.add(e1.attr("class", "dot_txt").get(e)
//								.select("ul").first().children().eachText().get(k));
//					}
//					if(k==3) {
//						room_width.add(e1.attr("class", "dot_txt").get(e)
//								.select("ul").first().children().eachText().get(k));
//					}
//					
//				}else if(e1.attr("class", "dot_txt").get(e)
//						.select("ul").first().children().size()==2){
//					
//					if(k==0) {
//						room_member.add(e1.attr("class", "dot_txt").get(e)
//								.select("ul").first().children().eachText().get(k));
//					}
//					
//					if(k==1) {
//						
//						room_bed.add("@@@@@@@@@@@@@@@@@");
//						
//						
//						room_width.add(e1.attr("class", "dot_txt").get(e)
//								.select("ul").first().children().eachText().get(k));
//					}
//					
//					
//				}else {
//					
//					if(k==0) {
//						room_member.add(e1.attr("class", "dot_txt").get(e)
//								.select("ul").first().children().eachText().get(k));
//					}
//					
//					if(k==1) {
//						room_bed.add(e1.attr("class", "dot_txt").get(e)
//								.select("ul").first().children().eachText().get(k));
//					}
//					
//					if(k==2) {
//						room_width.add(e1.attr("class", "dot_txt").get(e)
//								.select("ul").first().children().eachText().get(k));
//					}
//					
//				}
//				
//				
//				
//			}
//			
//		}
//		
//		System.out.println(room_member.size());
//		System.out.println(room_bed.size());
//		System.out.println(room_width.size());
//		
//		room_width.forEach(n->System.out.println(n));
		
		//room_member.forEach(n->System.out.println(n));
		//room_bed.forEach(n->System.out.println(n));
		//room_width.forEach(n->System.out.println(n));
		
		 Elements e5 = doc.getElementsByAttributeValue("class", "default_info");
		
		 
		 Elements e6 = doc.getElementsByAttributeValue("class", "layer pop_full pop_useinfo");
		
		 //System.out.println(e5.size());
		 
		 //System.out.println(e6.size());
		 
		//e1.select("ul").forEach(n->System.out.println(n));
		
		
		//System.out.println(e1.select("b").eachText().size());
		
		//e1.get(0).forEach(n->System.out.println(n));
		
//		e1.select("section").attr("class","dot_txt").eachText().stream()
//		.filter(n->!(n.equals("선택 날짜"))).forEach(n->System.out.println(n));	
		
		
		
//		e1.select("section").eachText().stream()
//		.filter(n->n.contains("선택 날짜")).forEach(n->System.out.println(n));
		
//		e1.select("section").eachText().stream()
//		.filter(n->!(n.contains("선택 날짜"))).forEach(n->System.out.println(n));
		
		//e1.attr("class","dot_txt").select("li").eachText().forEach(n->System.out.println(n));
		
		
////////////////////////////////////		
		
		//e1.select("section").forEach(n->System.out.println(n));
		
		//객실 기본정보
		//e1.select("section").eachText().stream().filter(n->n.contains("기본정보")).forEach(n->System.out.println(n.substring(5)));
		//System.out.println("기본정보"+e1.select("section").eachText().stream().filter(n->n.contains("기본정보")).count());
		//객실 기본정보
		//List<String> room_info =e1.select("section").eachText().stream().filter(n->n.contains("기본정보"))
		//.peek(n->n.substring(5)).collect(Collectors.toList());
		
		//room_info.forEach(n->System.out.println(n));
		
		//객실 편의시설
		//e1.select("section").eachText().stream()
		//.filter(n->n.contains("편의시설")).forEach(n->System.out.println(n.substring(5)));
		
		//System.out.println("편의 시설" + e1.select("section").eachText().stream()
		//.filter(n->n.contains("편의시설")).count());
		
		//객실 추가정보
		//e1.select("section").eachText().stream()
		//.filter(n->n.contains("추가 정보")).forEach(n->System.out.println(n.substring(6)));
		
		//System.out.println("기본정보" + e1.select("section").eachText().stream()
		//.filter(n->n.contains("추가 정보")).count());
	
		//e1.select("section").eachText().forEach(n->System.out.println(n));	
		
		//System.out.println(e1.select("section").eachText().size());
		
		
		Elements e3 = doc.getElementsByAttributeValue("class", "theme_wrap");
		
		
		//객실 편의 시설 및 서비스
		//e3.eachText().forEach(n->System.out.println(n));
		
		
		
		
		//객실 디테일 주소
		//객실/ 호텔 주소
				Elements e2 = doc.getElementsByAttributeValue("class", "address");
				
				//e2.select("p").eachText().forEach(n->System.out.println(n));
			
		

		
		//객실 숙소 정보
		
		
		e1 = doc.getElementsByAttributeValue("class", "default_info");
		
		//e1.forEach(n->System.out.println(n));
		
		//e1.select("li").eachText().forEach(n->System.out.println(n));
		
		//e1.select("h3").forEach(n->System.out.println(n));
	
		//System.out.println(e1.select("ul").get(0));
		
		//호텔 상세정보
		
//		List<String> detail_MainInfo =  e1.select("li").eachText();
//		
//		List<String> detail_info = new ArrayList<>();
//		
//		for(int i=0; i<e1.select("ul").size(); i++) {
//			
//			
//			for(int j=0; j<e1.select("ul").get(i).select("li").size(); j++) {
//				
//				
//					detail_info.add(e1.select("h3").get(i+1).text());
//				
//			}
//			
//		}
//		
//		detail_info.forEach(n->System.out.println(n));
//		detail_MainInfo.forEach(n->System.out.println(n));
//		System.out.println(detail_info.size());
//		System.out.println(detail_MainInfo.size());
		
		
		
		//호텔 크레센도 숙소정보
		
		//e1.forEach(n->System.out.println(n));
		
		//e1.select("h3").eachText().forEach(n->System.out.println(n));
		
		//e1.select("li").eachText().forEach(n->System.out.println(n));
		
		
	
		//System.out.println(e1.select("ul").size());
		//System.out.println(e1.select("ul").get(0).select("li").size());
		//System.out.println(e1.select("ul").get(1).select("li").size());
		//Map<String, String> data = new HashMap<>();
		
//		List<String> list1 =e1.select("h3").eachText();
//		
//		
//		
//		List<String> list2 =e1.select("li").eachText();
//		
//		
//		
//		//System.out.println(e1.select("ul").get(0).select("li").eachText().get(0));
//		
//		
//		List<String> list3 = new ArrayList<>();
//		
//		for(int i=1; i<e1.select("ul").size()+1; i++) {
//			
//			for(int j=0; j<e1.select("ul").get(i-1).select("li").size(); j++) {
//				
//				list3.add(list1.get(i)+"@"+e1.select("ul").get(i-1).select("li").get(j).text());
//			}
//			
//			//list3.add(list1.get(i)+e1.select("ul").get(i-1).select("li").size());
//			
//			for(int j=0; j<e1.select("ul").get(i).select("li").size(); j++) {
//				
//				//data.put(list1.get(i)+j, list2.get(j));
//				list3.add(list1.get(i)+list2.get(j));
//				
//			}
//			
//		}
//			list3.forEach(n->System.out.println(n));
			
			
			
			//list3.add(list1.get(i)+list2.get(i));
			
//		} 
		
		//System.out.println(e1.select("ul").size());
		
		
		//System.out.println(e1.select("ul").select("li").size());
		
		//System.out.println(e1.select("ul").size());
		//list3.stream().forEach(n->System.out.println(n));
		
//		List<String> StringList = new ArrayList<>();
//		
//		String[] arr = null;
//		
//		for(int i=0; i<list3.size(); i++) {
//			
//			
//			for(int j=0; j<2; j++) {
//				
//				StringList.add(list3.get(i).split("@")[j]);
//				
//			}
//			
//			
//			
//		}
		
		//arr = list3.get(0).split("@");
		//System.out.println(list3.get(3).split("@").length);
		
//		List<String> infoList = new ArrayList<>();
//		
//		List<String> detailInfoList = new ArrayList<>();
//		
//		for(int i=0; i<StringList.size(); i++) {
//			
//			if(i%2==0) {
//				infoList.add(StringList.get(i));
//			}
//			
//			if(i%2!=0) {
//				detailInfoList.add(StringList.get(i));
//			}
//			
//		}
		
		
//		for(String a : infoList) {
//			System.out.println(a);
//		}
//		
//		System.out.println("----------------------------------------");
//		
//		for(String a : detailInfoList) {
//			System.out.println(a);
//		}
//		
//		
//		for(String a : StringList) {
//			//System.out.println(a);
//		}
		
		
		//StringList.forEach(n->System.out.println(n));
	
		
		//data.keySet().stream().forEach(n->System.out.println(n));
		
		//data.keySet().stream().forEach(n->System.out.println(data.get(n)));
		
		
		
		
		
		//e1.select("ul").first().children().forEach(n->System.out.println(n));
		
//		String test = "안녕@누구@하이@";
//		
//		String[] arr;
//		
//		arr=test.split("@");
//		
//		System.out.println(arr.length);
//		
//		for(String aa: arr) {
//			System.out.println(aa);
//		}
		
		//StringBuffer sb = new StringBuffer();
		
//		String[][] data = new String[e1.select("ul").size()][e1.select("ul").select("li").size()];
//		
//		//String[] data2 = new String[e1.select("ul").size()];
//		
//		List<String> RoomList = new ArrayList<>();
//		
//		String data3 = "";
//		
//		for(int i=0; i<e1.select("ul").size(); i++) {
//			
//			for(int j=0; j<e1.select("ul").get(i).select("li").size(); j++) {
//				
//				//System.out.println(e1.select("ul").get(i).select("li").get(j).text());
//				
//				data[i][j] = e1.select("ul").get(i).select("li").get(j).text();
//				
//				if(data[i][j]!=null) {
//					//data2[j]=data[i][j]+"@";
//					data3 += data[i][j]+"@";
//				}
//				
//				//System.out.println(data3);
//				
//				
//			}
//			
//			System.out.println("----------------------------------------------");
//			
//			RoomList.add(data3);
//			
//			data3="";
//			
//			
//		}
//		
//		
//		RoomList.forEach(n->System.out.println(n));
//		
//		
//		for(int i=0; i<data.length; i++) {
//			
//			for(int j=0; j<data[i].length; j++) {
//				
//				if(data[i][j]!=null) {
//					//System.out.println(data[i][j]);
//				}
//				
//			}
//			
//			//System.out.println("------------------------------");
//		}
		
		
		
		//e1.select("ul").get(1).select("li").eachText().forEach(n->System.out.println(n));
		
		//e1.select("ul").select("li").eachText().forEach(n->System.out.println(n));
		
		
		//e1.select("ul").select("li").eachText().forEach(n->System.out.println(n));
		
		
		
	}
	
}
