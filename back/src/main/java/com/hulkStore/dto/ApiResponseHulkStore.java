package com.hulkStore.dto;

import lombok.Getter;

@Getter
public class ApiResponseHulkStore<T>  {
	
	private T data;
	
	private Notification notification;
	
	public ApiResponseHulkStore(T data, Notification notification) {
		this.data = data;
		this.notification = notification;
	}

}
