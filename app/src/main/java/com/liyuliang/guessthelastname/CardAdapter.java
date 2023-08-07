package com.liyuliang.guessthelastname;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {

    private final Context mContext;
    private final List<List<String>> dataList;

    public CardAdapter(Context mContext, List<List<String>> dataList) {
        this.mContext = mContext;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        List<String> data = dataList.get(position);
        holder.bindData(position, data);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final AppCompatTextView textView;
        private final RecyclerView recyclerView;
        private final LinearLayout llRoot;

        public ViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.textView);
            recyclerView = view.findViewById(R.id.recyclerView);
            llRoot = view.findViewById(R.id.llRoot);
            GridLayoutManager layoutManager = new GridLayoutManager(mContext, 6);
            recyclerView.setLayoutManager(layoutManager);
        }

        public void bindData(int index, List<String> dataList) {
            textView.setText("第" + (index + 1) + "页");
            DataAdapter dataAdapter = new DataAdapter(dataList);
            recyclerView.setAdapter(dataAdapter);
            llRoot.setBackgroundColor(Color.parseColor(Constant.COLOR_LIST[index]));
        }
    }
}
