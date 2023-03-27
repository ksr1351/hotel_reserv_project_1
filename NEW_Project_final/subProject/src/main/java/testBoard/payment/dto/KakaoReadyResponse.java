package testBoard.payment.dto;

public class KakaoReadyResponse {
		
	private String tid; // 결제 고유 번호
    private String next_redirect_mobile_url; // 모바일 웹일 경우 받는 결제페이지 url
    private String next_redirect_pc_url; // pc 웹일 경우 받는 결제 페이지
    private String next_redirect_app_url;
    private String created_at;
	private String android_app_scheme;
	private String ios_app_scheme;
	private boolean tms_result;
	
	
	public KakaoReadyResponse() {
	}


	public KakaoReadyResponse(String tid, String next_redirect_mobile_url, String next_redirect_pc_url,
			String next_redirect_app_url, String created_at, String android_app_scheme, String ios_app_scheme,
			boolean tms_result) {
		this.tid = tid;
		this.next_redirect_mobile_url = next_redirect_mobile_url;
		this.next_redirect_pc_url = next_redirect_pc_url;
		this.next_redirect_app_url = next_redirect_app_url;
		this.created_at = created_at;
		this.android_app_scheme = android_app_scheme;
		this.ios_app_scheme = ios_app_scheme;
		this.tms_result = tms_result;
	}


	public String getTid() {
		return tid;
	}


	public void setTid(String tid) {
		this.tid = tid;
	}


	public String getNext_redirect_mobile_url() {
		return next_redirect_mobile_url;
	}


	public void setNext_redirect_mobile_url(String next_redirect_mobile_url) {
		this.next_redirect_mobile_url = next_redirect_mobile_url;
	}


	public String getNext_redirect_pc_url() {
		return next_redirect_pc_url;
	}


	public void setNext_redirect_pc_url(String next_redirect_pc_url) {
		this.next_redirect_pc_url = next_redirect_pc_url;
	}


	public String getNext_redirect_app_url() {
		return next_redirect_app_url;
	}


	public void setNext_redirect_app_url(String next_redirect_app_url) {
		this.next_redirect_app_url = next_redirect_app_url;
	}


	public String getCreated_at() {
		return created_at;
	}


	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}


	public String getAndroid_app_scheme() {
		return android_app_scheme;
	}


	public void setAndroid_app_scheme(String android_app_scheme) {
		this.android_app_scheme = android_app_scheme;
	}


	public String getIos_app_scheme() {
		return ios_app_scheme;
	}


	public void setIos_app_scheme(String ios_app_scheme) {
		this.ios_app_scheme = ios_app_scheme;
	}


	public boolean isTms_result() {
		return tms_result;
	}


	public void setTms_result(boolean tms_result) {
		this.tms_result = tms_result;
	}


	@Override
	public String toString() {
		return "KakaoReadyResponse [tid=" + tid + ", next_redirect_mobile_url=" + next_redirect_mobile_url
				+ ", next_redirect_pc_url=" + next_redirect_pc_url + ", next_redirect_app_url=" + next_redirect_app_url
				+ ", created_at=" + created_at + ", android_app_scheme=" + android_app_scheme + ", ios_app_scheme="
				+ ios_app_scheme + ", tms_result=" + tms_result + "]";
	}
    
    
    
    
    
}
