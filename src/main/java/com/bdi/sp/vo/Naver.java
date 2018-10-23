package com.bdi.sp.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Naver {
	private Message Message;
	
	public Message getMessage() {
		return Message;
	}
	public void setMessage(Message message) {
		Message = message;
	}
	
	@JsonIgnoreProperties(ignoreUnknown=true)
	public class Message{
		private Result Result;

		public Result getResult() {
			return Result;
		}

		public void setResult(Result result) {
			Result = result;
		}
		
		@JsonIgnoreProperties(ignoreUnknown=true)
		public class Result{
			private String translatedText;

			public String getTranslatedText() {
				return translatedText;
			}

			public void setTranslatedText(String translatedText) {
				this.translatedText = translatedText;
			}
		}
	}
}