package webCrawlig;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Stock {
	 public static void main(String[] args) throws IOException {
	      
	      String url = "https://www.goodchoice.kr/product/search/2/2012?sel_date=2023-04-19&sel_date2=2023-04-20";
	      
	      Document doc = Jsoup.connect(url).get();
	      
	      Elements e1 = doc.getElementsByAttributeValue("class", "list_2 adcno2");
	      
	      
	      
	     //e1.forEach(n->System.out.println(n));
	      
	     // e1.select("p").forEach(n->System.out.println(n));
	      
	      System.out.println(e1.size());  //53
	      
	      //호텔 위치 / 전부다 강남구 
	      //e1.select("p").eachText().stream().filter(n-> n.contains("강남구")).forEach(j->System.out.println(j));
	      
	     // System.out.println(e1.select("p").eachText().stream().filter(n-> n.contains("강남구")).count());
	      
	      //사진/
	      //e1.attr("class","pic").select("img").eachAttr("data-original").forEach(n->System.out.println(n));
	      
	      
	      
	      // 사진이름
	      //e1.attr("class","pic").select("img").eachAttr("alt").forEach(n->System.out.println(n));
	      //System.out.println(e1.attr("class","pic").select("img").eachAttr("alt").get(0));
	      //System.out.println(e1.attr("class","pic").select("img").eachAttr("data-original").stream().count());
	      
	      
	      //호텔 이름
	      e1.select("strong").eachText().forEach(n->System.out.println(n));
	      System.out.println(e1.select("strong").eachText().size());
//	      List<String> hotelName = e1.select("strong").eachText();

//	     System.out.println(e1.select("strong").eachText().stream().count());
	      
//	      //  System.out.println(hotelName.get(0));      
	      //Elements e2 = doc.getElementsByAttributeValue("class", "list_2 adcno2");
	      
	      
	      
	      
	      
	     // e1 = doc.getElementsByAttributeValue("class", "layer pop_full pop_useinfo");
	      
	     
	      
	      
	      
	      
	      //호텔 가격
//	      List<String> TrueList = new ArrayList<>();
//	      List<String> StringList= e1.select("b").eachText().stream().filter(n->n.contains("원"))
//	      .collect(Collectors.toList());
//	      for(int i=0; i<StringList.size(); i++) {
//	    	  
//	    	  if(i %2 ==0) {
//	    		 TrueList.add(StringList.get(i));
//	    	  }
//	    	 
//	    	 
//	      }
	      
	      //System.out.println(TrueList.size());
	      
	      //StringList.forEach(n->System.out.println(n));
	      
	      //호텔등급
	      
  	      
//	      List<String> listRating = 
//	      	e1.attr("class", "badge").select("span").eachText().stream()
//	      		.filter(n -> (n.contains("성급")|| n.contains("비지니스") || n.contains("특급")|| n.contains("레지던스")||
//	      				n.contains("관광") || n.contains("부티크") || n.contains("급"))).collect(Collectors.toList());
//	      	
//	      
//	      listRating.forEach(n->System.out.println(n));
//	      
	     // System.out.println(listRating.size());
	      
	      for(int i=0; i<e1.size(); i++) {
	    	  
	    	  
	    	  
	    	  
	    	  
	    	  
	      }
	      
	      
	      
	      
	      
	      //////////////////////////////////////////////////////////////////////////////////////////
	      
	      
//	      
//	  	  호텔가격@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  
	    
	      
	      // StringList.forEach(n->System.out.println(n));
	      
//	     // System.out.println(StringList.get(0));
	      
	     
	      
	     // StringList.forEach(n->System.out.println(n));
	      
	      
//	      List<String> TrueList = new ArrayList<>();
//	      List<String> StringList= e1.select("b").eachText().stream().filter(n->n.contains("원"))
//	      .collect(Collectors.toList());
//	      for(int i=0; i<StringList.size(); i++) {
//	    	  
//	    	  if(i %2 ==0) {
//	    		 TrueList.add(StringList.get(i));
//	    	  }
//	    	 
//	    	 
//	      }
	      
	      
//	      TrueList.forEach(n->System.out.println(n));
//	      
//	      System.out.println(TrueList.size());
	      
	     // int num =TrueList.size();
	     // System.out.println(num);
	      
	      
	      //TrueList.forEach(n->System.out.println(n));
	   
	      
	      
	      //System.out.println(e1.select("b").eachText().stream().filter(n->n.contains("원")).count());
	      
	      
	      //e1.forEach(n->System.out.println(n));
	      
	     // e1.select("b")//.eachText().stream()
	      //.filter(n->n.contains("원"))
	      //.forEach(n->System.out.println(n));
	      
	      //System.out.println( e1.select("b").eachText().stream().count());
	      
	      
	      
	      
	      //호텔 위치 / 전부다 강남구 
	      //e1.select("p").eachText().stream().filter(n-> n.contains("강남구")).forEach(j->System.out.println(j));
	      //System.out.println(e1.select("p").eachText().stream().filter(n-> n.contains("강남구")).count());
	      //e1.select("p").eachText().forEach(n->System.out.println(n));
	      
	      //Elements e1 = doc.getElementsByAttributeValue("class", "name");
	      
	      //호텔 이름
	      //e1.select("strong").eachText().forEach(n->System.out.println(n));
	      
	      //System.out.println(e1.select("strong").eachText().stream().count()); //49
	      
	      //Elements e1 = doc.getElementsByAttributeValue("class", "badge");
	      System.out.println("--------------------------------------------------------------");
	      
	      //System.out.println(e1.select("span").eachText());
	      
	      
	      
	      //호텔등급
	      
	      	      
//	      List<String> listRating = 
//	      	e1.attr("class", "badge").select("span").eachText().stream()
//	      		.filter(n -> (n.contains("성급")|| n.contains("비지니스") || n.contains("특급")|| n.contains("레지던스")||
//	      				n.contains("관광") || n.contains("부티크") || n.contains("급"))).collect(Collectors.toList());
//	      	
//	      
//	      listRating.forEach(n->System.out.println(n));
//	      
//	      System.out.println(listRating.size());
	      	
	      	
	      
			//e1.select("span").eachText().forEach(n->System.out.println(n));
	      
	      //System.out.println(e1.select("span").eachText().stream().count()); //49
	      
	      //////////////////////////////////////////////////////////////////////////////////
	      
	      
	      //e1.select("span").text();
	      
	      //System.out.println(e1.select("img"));
	      System.out.println();
	      
	      
//	      사진 // 사진 이름
	      //Elements e2 = doc.getElementsByAttributeValue("class", "pic");
	      System.out.println("--------------------------------------------------------------");
	      	
	      //System.out.println(e2.select("img"));
	      //System.out.println(e1.select("img"));
	      System.out.println();
	      
	      // jpg
	      //List<String> list = e1.select("img").eachAttr("data-original");
	      
	      //e1.attr("class","pic").select("img").eachAttr("data-original").forEach(n->System.out.println(n));
	      
	      //list.stream().forEach(n->System.out.println(n));
	      //System.out.println(list.stream().count())
	      
	      
	      
//	      List<String> list = e1.select("img").eachAttr("src");
	        //png      
//	      list.stream().forEach(n->System.out.println(n));
//	      System.out.println(list.stream().count());  //49
	      
	      //사진이름
//	      List<String> list = e1.select("img").eachAttr("alt");
//	      
//	      list.stream().forEach(n->System.out.println(n));
//	      
//	      System.out.println(list.stream().count());  49
	      
	      
	///////////////////////////////////////////////////////////////////////////////////////////      
	      
	      
	      
//	       String dataa = null;
//	       
//	       for(int i = 0; i<e1.size(); i++) {
//	          
//	          for(int j=0; j<e1.get(i).select("img").size(); j++) {
//	             
//	                         
//	             System.out.println(e1.get(i).select("img").get(j).text());
//	          }
//	          
//	       }
//	      
	      
	      
//	      Elements e1 = doc.getElementsByAttributeValue("class", "pic");
//	      System.out.println("--------------------------------------------------------------");
//	      
//	      System.out.println(e1);
	      
	      
	      
	      //
	      
	      // e1.stream().forEach(n->System.out.println(e1.get(0).select("span").get(0).text()));
	       
//	       String dataa = null;
//	       
//	       for(int i = 0; i<e1.size(); i++) {
//	          
//	          for(int j=0; j<e1.get(i).select("span").size(); j++) {
//	             
//	            
//	             
//	             System.out.println(e1.get(i).select("span").get(j).text());
//	          }
//	          
//	       }
//	       
	      
//	      <li class="list_2 adcno2"><a href="https://www.goodchoice.kr/product/detail?ano=11764&amp;adcno=2&amp;sel_date=2023-03-06&amp;sel_date2=2023-03-07" data-ano="11764" data-adcno="2" data-alat="37.5028467014" data-alng="127.0394064429" data-distance="8.901" data-affiliate="1"> <p class="pic"><img class="lazy align" data-original="//image.goodchoice.kr/resize_1000X500x0/affiliate/2016/12/14/585094efa144b.jpg" src="//image.goodchoice.kr/images/web_v3/bg_trans.png" alt="역삼 트리아호텔"></p>
//	        <div class="stage gra_black_vertical">
//	         <div class="name">
//	          <div class="badge">
//	           <span class="build_badge" style="color: rgba(255,255,255,1); background-color: rgba(106,120,141,1);">2성급</span>
//	          </div> <strong>역삼 트리아호텔</strong>
//	          <p class="score"><em>8.4</em>&nbsp;<span>만족해요</span>&nbsp;(143)</p>
//	          <p>강남구 | 역삼역 도보5분</p>
//	         </div>
//	         <div class="price">
//	          <div class="map_html">
//	           <p><em class="mark"><span><b>남은 객실 1개</b><i>&nbsp;</i></span></em><b>80,000원</b></p>
//	          </div>
//	          <p><em class="mark"><span><b>남은 객실 1개</b><i>&nbsp;</i></span></em><b>80,000원</b></p>
//	         </div>
//	        </div> </a></li>
	       
//	       
//	       System.out.println("--------------------------------------------------------------");
//	      
//	      Element e2 = e1.get(0);
//	      
//	      System.out.println(e2);
//	      
//	      System.out.println("--------------------------------------------------------------");
//	      
//	      Elements e3 = e2.select("span");
//	      
//	      
//	      
//	      System.out.println(e3);
	//   
//	      System.out.println("--------------------------------------------------------------");
//	      Element e4 = e3.get(0);
//	      
//	      System.out.println(e4);
//	      System.out.println(e4.text());
//	      
//	      String data = e2.select("span").get(0).text();
//	      System.out.println("--------------------------------------------------------------");
//	      System.out.println(data); 
//	      
//	      
	      
	//   }

	   } // main
	}//class

