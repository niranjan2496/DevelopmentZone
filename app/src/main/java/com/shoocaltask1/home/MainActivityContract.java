package com.shoocaltask1.home;

import com.shoocaltask1.model.IssueDataModel;

import java.util.List;

public class MainActivityContract {
    interface View{
        void onApiResponse(List<IssueDataModel> dataModels,String error);
    }
    interface OnUserAction{
        void getIssuesData();
    }
}
