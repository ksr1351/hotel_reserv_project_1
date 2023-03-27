package testBoard.payment.dto;

public class KakaoPayCancelDTO {
	
		private String booking_code;
        private String cid;
        private String tid;
        private String cancel_amount;
        private String cancel_tax_free_amount;
        private String cancel_vat_amount;
		
        public KakaoPayCancelDTO() {
		}

		public KakaoPayCancelDTO(String booking_code, String cid, String tid, String cancel_amount,
				String cancel_tax_free_amount, String cancel_vat_amount) {
			this.booking_code = booking_code;
			this.cid = cid;
			this.tid = tid;
			this.cancel_amount = cancel_amount;
			this.cancel_tax_free_amount = cancel_tax_free_amount;
			this.cancel_vat_amount = cancel_vat_amount;
		}

		public String getBooking_code() {
			return booking_code;
		}

		public void setBooking_code(String booking_code) {
			this.booking_code = booking_code;
		}

		public String getCid() {
			return cid;
		}

		public void setCid(String cid) {
			this.cid = cid;
		}

		public String getTid() {
			return tid;
		}

		public void setTid(String tid) {
			this.tid = tid;
		}

		public String getCancel_amount() {
			return cancel_amount;
		}

		public void setCancel_amount(String cancel_amount) {
			this.cancel_amount = cancel_amount;
		}

		public String getCancel_tax_free_amount() {
			return cancel_tax_free_amount;
		}

		public void setCancel_tax_free_amount(String cancel_tax_free_amount) {
			this.cancel_tax_free_amount = cancel_tax_free_amount;
		}

		public String getCancel_vat_amount() {
			return cancel_vat_amount;
		}

		public void setCancel_vat_amount(String cancel_vat_amount) {
			this.cancel_vat_amount = cancel_vat_amount;
		}

		@Override
		public String toString() {
			return "KakaoPayCancelDTO [booking_code=" + booking_code + ", cid=" + cid + ", tid=" + tid
					+ ", cancel_amount=" + cancel_amount + ", cancel_tax_free_amount=" + cancel_tax_free_amount
					+ ", cancel_vat_amount=" + cancel_vat_amount + "]";
		}
        
        
        
        
        
}
