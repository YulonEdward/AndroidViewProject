package com.example.lenovo.androidlistviewexpandablelistview;

import android.app.ListActivity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private TextView mTxtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTxtResult = (TextView)findViewById(R.id.txtResult);

//        ArrayAdapter<CharSequence> arrAdapterWeekday =
//                ArrayAdapter.createFromResource(this, R.array.weekday, android.R.layout.simple_list_item_1);
//
//        setListAdapter(arrAdapterWeekday);

        List<Map<String, Object>> mList = new ArrayList<Map<String, Object>>();
        String[] listFromResource = getResources().getStringArray(R.array.weekday);

        for(int i = 0; i < listFromResource.length; i++){
            Map<String, Object> listItem = new HashMap<String, Object>();
            listItem.put("imgView", android.R.drawable.ic_menu_my_calendar);
            listItem.put("txtView", listFromResource[i]);
            mList.add(listItem);
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(this, mList,
                R.layout.list_item,
                new String[]{"imgView", "txtView"},
                new int[]{R.id.imageView, R.id.textView});

        ListView listView = (ListView)findViewById(R.id.lstView);
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(listViewOnItemClick);

       }

    private AdapterView.OnItemClickListener listViewOnItemClick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//            mTxtResult.setText(((TextView) view).getText());
            String s = ((TextView)view.findViewById(R.id.textView)).getText().toString();
            mTxtResult.setText(s);
        }
    };
}
