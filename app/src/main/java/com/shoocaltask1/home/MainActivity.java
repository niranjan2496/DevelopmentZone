package com.shoocaltask1.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.shoocaltask1.R;
import com.shoocaltask1.model.IssueDataModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View {

    MainActivityPresenter presenter;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    IssueSDataAdaper adaper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adaper=new IssueSDataAdaper();
        recyclerView.setAdapter(adaper);
        presenter=new MainActivityPresenter(this);
        presenter.getIssuesData();
    }

    @Override
    public void onApiResponse(List<IssueDataModel> dataModels, String error) {
        if (error==null){
            adaper.setList(dataModels);
        }else {
            Log.d("Error==",error);
        }
    }
}