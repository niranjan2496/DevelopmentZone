package com.shoocaltask1.network;

import com.shoocaltask1.model.IssueDataModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

interface ApiService {
    @GET("issues")
    Call<List<IssueDataModel>> getIssuesData();
}
