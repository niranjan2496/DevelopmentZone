package com.shoocaltask1.network;

import com.shoocaltask1.listener.ApiResponseListener;
import com.shoocaltask1.model.IssueDataModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiHandler {
String Base_url="https://api.github.com/repositories/19438/";
    private ApiService service;
    ApiResponseListener apiResponseListener;
    public ApiService getService(){
        if(service == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Base_url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            service = retrofit.create(ApiService.class);
        }
        return service;
    }
    private <T>void doNetworkCall(Call<T> call){
      call.enqueue(new Callback<T>() {
          @Override
          public void onResponse(Call<T> call, Response<T> response) {
              if (response.isSuccessful()) {
                  if (apiResponseListener != null) {
                      apiResponseListener.onApiResponse(response.body(),null);
                  }
              } else {
                  apiResponseListener.onApiResponse(response,call.toString());
              }
          }

          @Override
          public void onFailure(Call<T> call, Throwable t) {
              apiResponseListener.onApiResponse(null,t.getMessage());
          }
      });
    }

    public void setApiResponseListener(ApiResponseListener apiResponseListener) {
        this.apiResponseListener = apiResponseListener;
    }

    public void getIssueSData(){
        Call<List<IssueDataModel>> call=getService().getIssuesData();
        doNetworkCall(call);
    }
}
