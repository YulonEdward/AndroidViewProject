package com.example.lenovo.androidlistviewexpandablelistview;

import android.app.ExpandableListActivity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.ArrayMap;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity_expandlist extends ExpandableListActivity {

    private static final String ITEM_NAME = "ITEM NAME";
    private static final String ITEM_SUBNAME = "ITEM SUBNAME";

    private TextView mTxtResult;
    private ExpandableListView mExpandLst;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listexpand_item);

        mTxtResult = (TextView)findViewById(R.id.txtResult);

        List<Map<String, String>> groupList = new ArrayList<Map<String, String>>();
        List<List<Map<String, String>>> child2D = new ArrayList<List<Map<String, String>>>();

        for(int i = 0; i<5; i++){
            Map<String, String> group = new HashMap<String, String>();
            group.put(ITEM_NAME, "選項群組" + i);
            group.put(ITEM_SUBNAME, "說明" + i);
            groupList.add(group);

            List<Map<String, String>> childList = new ArrayList<Map<String, String>>();
            for(int j = 0; j < 2; j++){
                Map<String, String> child = new HashMap<String, String>();
                child.put(ITEM_NAME, "選項"+i+j);
                child.put(ITEM_SUBNAME, "說明"+i+j);
                childList.add(child);
            }

            child2D.add(childList);
        }

        ExpandableListAdapter expandableListAdapter = new SimpleExpandableListAdapter(
                this, groupList, android.R.layout.simple_expandable_list_item_2,
                new String[] {ITEM_NAME, ITEM_SUBNAME},
                new int[] {android.R.id.text1, android.R.id.text2},
                child2D,
                android.R.layout.simple_expandable_list_item_2,
                new String[] {ITEM_NAME, ITEM_SUBNAME},
                new int[]{android.R.id.text1, android.R.id.text2}
        );

        setListAdapter(expandableListAdapter);
    }

    @Override
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
        String s = "選擇：群組" + groupPosition + ", 選項" + childPosition + ", ID" + id;
        mTxtResult.setText(s);
        return super.onChildClick(parent, v, groupPosition, childPosition, id);
    }
}
