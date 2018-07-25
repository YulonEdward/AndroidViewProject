package com.example.lenovo.androidlistviewexpandablelistview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

public class MainActivity_AutoCompleteTextView extends AppCompatActivity{

    private Button mBtnAddAutoCompleteText, mBtnClearAutoCompleteText;

    private AutoCompleteTextView mAutoCompleteTextView;

    private ArrayAdapter<String> mAdapAutoCompText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_autocompletetext);

        mBtnAddAutoCompleteText = (Button)findViewById(R.id.btnAutoCompleteText);
        mBtnClearAutoCompleteText = (Button)findViewById(R.id.btnClearAutoCompleteText);

        mAutoCompleteTextView = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);

        mAdapAutoCompText = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line);

        mAutoCompleteTextView.setAdapter(mAdapAutoCompText);

        mBtnAddAutoCompleteText.setOnClickListener(btnAddAutoCompleteTextOnClick);
        mBtnClearAutoCompleteText.setOnClickListener(btnClearAutoCompleteTextOnClick);
    }

    private View.OnClickListener btnAddAutoCompleteTextOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String s = mAutoCompleteTextView.getText().toString();
            mAdapAutoCompText.add(s);
            mAutoCompleteTextView.setText("");
        }
    };

    private View.OnClickListener btnClearAutoCompleteTextOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mAdapAutoCompText.clear();
        }
    };
}
