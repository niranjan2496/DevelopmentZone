package com.shoocaltask1.home;

import com.shoocaltask1.listener.ApiResponseListener;
import com.shoocaltask1.model.IssueDataModel;
import com.shoocaltask1.network.ApiHandler;

import java.util.List;

public class MainActivityPresenter implements ApiResponseListener<List<IssueDataModel>>, MainActivityContract.OnUserAction {
    MainActivityContract.View view;

    public MainActivityPresenter(MainActivityContract.View view) {
        this.view = view;
    }

    @Override
    public void onApiResponse(List<IssueDataModel> response, String error) {
        view.onApiResponse(response, error);
    }

    @Override
    public void getIssuesData() {
        ApiHandler handler = new ApiHandler();
        handler.setApiResponseListener(this);
        handler.getIssueSData();
    }
}
