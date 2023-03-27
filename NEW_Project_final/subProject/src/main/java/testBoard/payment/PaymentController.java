package testBoard.payment;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import testBoard.board.dto.BookingDTO;
import testBoard.board.service.HotelService;
import testBoard.payment.dto.KakaoApproveResponse;
import testBoard.payment.dto.KakaoBookingDTO;
import testBoard.payment.dto.KakaoPayCancelDTO;
import testBoard.payment.dto.KakaoReadyResponse;

@Controller
public class PaymentController {

	
	private KakaoReadyResponse kakaoReadyResponse;
	
	private final HotelService service;
	
	
	
	@Autowired
	public PaymentController(HotelService service) {
		this.service = service;
	}

	@GetMapping("/pay/payment")
	public String execute() {
		
		return "payment/payMent";
		
	}
	
	@ResponseBody
	@GetMapping("/pay/kakaopay")
	public KakaoReadyResponse execute2(KakaoBookingDTO kakaoBookingDTO) {
			
			
			String booking_info = kakaoBookingDTO.getCheckin() + "@"+
								  kakaoBookingDTO.getCheckout() + "@"+
								  kakaoBookingDTO.getGuests()+ 	"@"+
								  kakaoBookingDTO.getMem_code() + "@"+
								  kakaoBookingDTO.getRoom_code() + "@"+
								  kakaoBookingDTO.getHotel_code(); 
			
			
			
			long num = Integer.parseInt(kakaoBookingDTO.getTotalPrice().substring(0,kakaoBookingDTO.getTotalPrice().length()-1).replace(",", ""));
			
			
			
			
			String name = "hotel";
			try {
				
				name = URLEncoder.encode(kakaoBookingDTO.getRoom_name(), "UTF-8");
				booking_info = URLEncoder.encode(booking_info,"UTF-8");
				
			} catch (UnsupportedEncodingException e1) {
				
				e1.printStackTrace();
			}
			
			ObjectMapper parse = new ObjectMapper();
			
			
		try {
			URL address = new URL("https://kapi.kakao.com/v1/payment/ready");
			try {
				HttpURLConnection con = (HttpURLConnection)address.openConnection();
				con.setRequestMethod("POST");
				con.setRequestProperty("Authorization", "KakaoAK dae56277e5f51d81b6f0c18eca0ff47e");
				con.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
				con.setDoOutput(true);
				
				String param = "cid=TC0ONETIME&partner_order_id=partner_order_id"
						+ "&partner_user_id=partner_user_id&item_name="+name
						+ "&item_code="+booking_info
						+ "&quantity=1&total_amount="+ num +"&vat_amount=200&tax_free_amount=0"
						+ "&approval_url=http://localhost:8090/kakaoPay/success"
						+ "&cancel_url=http://localhost:8090/"
						+ "&fail_url=http://localhost:8090/";
				
				OutputStream os = con.getOutputStream();
				
				DataOutputStream dos = new DataOutputStream(os);
				
				dos.writeBytes(param);
				
				//dos.flush();
				dos.close();
				
				int result = con.getResponseCode();
				
				System.out.println(result);
				
				InputStream is;
				if(result ==200) {
					
					is = con.getInputStream();
					
				}else {
					is = con.getErrorStream();
				}
				
				InputStreamReader reader = new InputStreamReader(is);
				BufferedReader brd = new BufferedReader(reader);
				
				kakaoReadyResponse
				 = parse.readValue(brd.readLine(), KakaoReadyResponse.class);
				
				
				
				return kakaoReadyResponse; 
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		kakaoReadyResponse = new KakaoReadyResponse();
		
		return kakaoReadyResponse;
	}
	
	
	
	@GetMapping("/kakaoPay/success")
	public String paySuccess(@RequestParam("pg_token") String pgToken) {
		
		
		
		MultiValueMap<String, String> param = new LinkedMultiValueMap<>();
		
		param.add("cid", "TC0ONETIME");
		param.add("tid", kakaoReadyResponse.getTid());
		param.add("partner_order_id", "partner_order_id");
		param.add("partner_user_id", "partner_user_id");
		param.add("pg_token", pgToken);
		
		   HttpHeaders httpHeaders = new HttpHeaders();

	        String auth = "KakaoAK " + "dae56277e5f51d81b6f0c18eca0ff47e";

	        httpHeaders.set("Authorization", auth);
	        httpHeaders.set("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
	        
	        RestTemplate restTemplate =new RestTemplate();
	        
	        HttpEntity<MultiValueMap<String, String>> requestEntity = 
	        		new HttpEntity<>(param,httpHeaders);
	        
	        KakaoApproveResponse approveResoponse 
	        = restTemplate.postForObject(
	        		"https://kapi.kakao.com/v1/payment/approve"
	        		, requestEntity
	        		, KakaoApproveResponse.class);
	        
	        //new ResponseEntity<>(approveResoponse, HttpStatus.OK)
	    
	       
	       String[] data =approveResoponse.getItem_code().split("@");
	       
	       SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			
			
			Date dateCheckin = new Date();
			Date dateCheckout= new Date();
			try {
				
				dateCheckin = formatter.parse(data[0]);
				dateCheckout = formatter.parse(data[1]);
				
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
	       
			//&quantity=1&total_amount="+ num +"&vat_amount=200&tax_free_amount=0
			
			
			System.out.println(approveResoponse);
	       
	      
	     
	      
	       
	       KakaoPayCancelDTO KakaoPayCancelDTO = new KakaoPayCancelDTO();
	       KakaoPayCancelDTO.setCancel_amount(String.valueOf(approveResoponse.getAmount().getTotal()));
	       KakaoPayCancelDTO.setCancel_tax_free_amount(String.valueOf(approveResoponse.getAmount().getTax_free()));
	       KakaoPayCancelDTO.setCancel_vat_amount(String.valueOf(approveResoponse.getAmount().getTax()));
	       KakaoPayCancelDTO.setCid(approveResoponse.getCid());
	       KakaoPayCancelDTO.setTid(approveResoponse.getTid());
	       
	       BookingDTO bookingDTO = new BookingDTO();
	       
	       bookingDTO.setCheckin(dateCheckin);
	       bookingDTO.setCheckout(dateCheckout);
	       bookingDTO.setGuests(Integer.parseInt(data[2]));
	       bookingDTO.setMem_code(Integer.parseInt(data[3]));
	       bookingDTO.setRoom_code(Integer.parseInt(data[4]));
	       bookingDTO.setHotel_code(Integer.parseInt(data[5]));
	       bookingDTO.setStatus('2');
	       
	       
	       
	       
	       service.KakaoPayCancelProcess(KakaoPayCancelDTO, bookingDTO);
		
		return "redirect:/check";
		
	}
	
	
	@PostMapping("/refund")
	public String refund(@RequestParam("booking_code") int booking_code) {
		
		System.out.println(booking_code);
		KakaoPayCancelDTO kakaoCancelDTO =service.selectKakaoPayProcess(booking_code);
		
		System.out.println("/refund 컨트롤러 호출" );
		
		MultiValueMap<String, String> param = new LinkedMultiValueMap<>();
		
		param.add("cid", kakaoCancelDTO.getCid());
		param.add("tid", kakaoCancelDTO.getTid());
		param.add("cancel_amount", kakaoCancelDTO.getCancel_amount());
		param.add("cancel_tax_free_amount", kakaoCancelDTO.getCancel_tax_free_amount());
		param.add("cancel_vat_amount", kakaoCancelDTO.getCancel_vat_amount());
		
		
		 HttpHeaders httpHeaders = new HttpHeaders();

	        String auth = "KakaoAK " + "dae56277e5f51d81b6f0c18eca0ff47e";

	        httpHeaders.set("Authorization", auth);
	        httpHeaders.set("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
	        
	        RestTemplate restTemplate =new RestTemplate();
	        
	        HttpEntity<MultiValueMap<String, String>> requestEntity = 
	        		new HttpEntity<>(param,httpHeaders);
	        
	        KakaoApproveResponse approveResoponse 
	        = restTemplate.postForObject(
	        		 "https://kapi.kakao.com/v1/payment/cancel"
	        		, requestEntity
	        		, KakaoApproveResponse.class);
		
	        
		service.bookingCancelProcess(booking_code);
		
		return "redirect:/check";
		
	}
	
	
	
	
	
	
}
