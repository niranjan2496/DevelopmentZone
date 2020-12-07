package com.shoocaltask1.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.recyclerview.widget.RecyclerView;

import com.shoocaltask1.R;
import com.shoocaltask1.model.IssueDataModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

class IssueSDataAdaper extends RecyclerView.Adapter<IssueSDataAdaper.ItemViewHolder> {
    List<IssueDataModel> list;

    public IssueSDataAdaper() {
        list=new ArrayList<>();
    }

    @NonNull
    @Override
    public IssueSDataAdaper.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.issue_data_item,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IssueSDataAdaper.ItemViewHolder holder, int position) {
        IssueDataModel data=list.get(position);
        holder.tvRepository.setText(data.getRepository_url());
        holder.tvLogin.setText(data.getUser().getLogin());
        holder.tvId.setText(data.getUser().getId());
        holder.chckViewState.setChecked(data.getState().equals("open"));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_login)
        TextView tvLogin;
        @BindView(R.id.tv_id)
        TextView tvId;
        @BindView(R.id.tv_repository)
        TextView tvRepository;
        @BindView(R.id.chck_view_state)
        AppCompatCheckBox chckViewState;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

        }
    }
    public void setList(List<IssueDataModel> list){
        this.list=list;
        notifyDataSetChanged();
    }
}
