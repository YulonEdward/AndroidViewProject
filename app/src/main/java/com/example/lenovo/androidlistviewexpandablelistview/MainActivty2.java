package com.example.lenovo.androidlistviewexpandablelistview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivty2 extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_recyclerview);

        List<String> listStr = new ArrayList<>();
        for(int i =0; i < 50; i++){
            listStr.add(new String("第" + String.valueOf(i+1) + "項"));
        }

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerView);

        //設定 RecyclerView 使用的 LayoutManager，
        // LayoutManager 決定項目的排列方式。
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
//        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));

        ItemAdapter itemAdapter = new ItemAdapter(listStr);
        recyclerView.setAdapter(itemAdapter);
    }
}
