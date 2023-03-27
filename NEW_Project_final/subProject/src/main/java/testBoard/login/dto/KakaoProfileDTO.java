package testBoard.login.dto;

public class KakaoProfileDTO {

		
		public long id;
		public String connected_at;
		public Properties properties;
		public KakaoAccount kakao_account;
		
		public KakaoProfileDTO() {
		}
		
		
		public KakaoProfileDTO(long id, String connected_at, Properties properties, KakaoAccount kakao_account) {
			this.id = id;
			this.connected_at = connected_at;
			this.properties = properties;
			this.kakao_account = kakao_account;
		}


		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getConnected_at() {
			return connected_at;
		}

		public void setConnected_at(String connected_at) {
			this.connected_at = connected_at;
		}

		public Properties getProperties() {
			return properties;
		}

		public void setProperties(Properties properties) {
			this.properties = properties;
		}

		public KakaoAccount getKakao_account() {
			return kakao_account;
		}

		public void setKakao_account(KakaoAccount kakao_account) {
			this.kakao_account = kakao_account;
		}

		
		
		@Override
		public String toString() {
			return "KakaoProfileDTO [id=" + id + ", connected_at=" + connected_at + ", properties=" + properties
					+ ", kakao_account=" + kakao_account + "]";
		}

///////////////////////////////////////////////////

		public static class Properties{
			
			public String nickname;

			public Properties() {
			}
			
			
			
			public Properties(String nickname) {
				this.nickname = nickname;
			}



			public String getNickname() {
				return nickname;
			}

			public void setNickname(String nickname) {
				this.nickname = nickname;
			}
			
			
			
		}

		
/////////////////////////////////////////////////////////////////
		
		
		public static class KakaoAccount{
			
			public boolean profile_nickname_needs_agreement;
			public profile profile;
			public boolean has_email;
			public boolean email_needs_agreement;
			public boolean is_email_valid;
			public boolean is_email_verified;
			public String email;
			
			
			public KakaoAccount() {
			}
			
			
			
			public KakaoAccount(boolean profile_nickname_needs_agreement,
					testBoard.login.dto.KakaoProfileDTO.KakaoAccount.profile profile, boolean has_email,
					boolean email_needs_agreement, boolean is_email_valid, boolean is_email_verified, String email) {
				this.profile_nickname_needs_agreement = profile_nickname_needs_agreement;
				this.profile = profile;
				this.has_email = has_email;
				this.email_needs_agreement = email_needs_agreement;
				this.is_email_valid = is_email_valid;
				this.is_email_verified = is_email_verified;
				this.email = email;
			}



			public boolean isProfile_nickname_needs_agreement() {
				return profile_nickname_needs_agreement;
			}



			public void setProfile_nickname_needs_agreement(boolean profile_nickname_needs_agreement) {
				this.profile_nickname_needs_agreement = profile_nickname_needs_agreement;
			}



			public profile getProfile() {
				return profile;
			}



			public void setProfile(profile profile) {
				this.profile = profile;
			}



			public boolean isHas_email() {
				return has_email;
			}



			public void setHas_email(boolean has_email) {
				this.has_email = has_email;
			}



			public boolean isEmail_needs_agreement() {
				return email_needs_agreement;
			}



			public void setEmail_needs_agreement(boolean email_needs_agreement) {
				this.email_needs_agreement = email_needs_agreement;
			}



			public boolean isIs_email_valid() {
				return is_email_valid;
			}



			public void setIs_email_valid(boolean is_email_valid) {
				this.is_email_valid = is_email_valid;
			}



			public boolean isIs_email_verified() {
				return is_email_verified;
			}



			public void setIs_email_verified(boolean is_email_verified) {
				this.is_email_verified = is_email_verified;
			}



			public String getEmail() {
				return email;
			}



			public void setEmail(String email) {
				this.email = email;
			}

			

			@Override
			public String toString() {
				return "KakaoAccount [profile_nickname_needs_agreement=" + profile_nickname_needs_agreement
						+ ", profile=" + profile + ", has_email=" + has_email + ", email_needs_agreement="
						+ email_needs_agreement + ", is_email_valid=" + is_email_valid + ", is_email_verified="
						+ is_email_verified + ", email=" + email + "]";
			}


///////////////////////////////////////////////////////////////
			public static class profile{
				
				public String nickname;
				
				public profile() {
				}
				
				
				

				public profile(String nickname) {
					this.nickname = nickname;
				}




				public String getNickname() {
					return nickname;
				}

				public void setNickname(String nickname) {
					this.nickname = nickname;
				}




				@Override
				public String toString() {
					return "profile [nickname=" + nickname + "]";
				}
				
				
				
			}
			
		}
		
	
}
