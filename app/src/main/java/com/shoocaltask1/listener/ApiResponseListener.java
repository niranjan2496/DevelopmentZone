package com.shoocaltask1.listener;

public interface ApiResponseListener<T> {
void onApiResponse(T response,String error);
}
