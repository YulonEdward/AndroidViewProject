package com.example.lenovo.androidlistviewexpandablelistview;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivty_DateTime extends AppCompatActivity{

    private TextView mTxtResult;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_datetime);

        Button btnTimePickerDlg = (Button)findViewById(R.id.btnTimePickerDlg);
        Button btnDatePickerDlg = (Button)findViewById(R.id.btnDatePickerDlg);
        mTxtResult = (TextView)findViewById(R.id.txtResult);

        btnDatePickerDlg.setOnClickListener(btnDatePickerDlgOnClick);
        btnTimePickerDlg.setOnClickListener(btnTimePickerDlgOnClick);
    }

    private View.OnClickListener btnDatePickerDlgOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mTxtResult.setText("");

            Calendar now = Calendar.getInstance();

            DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivty_DateTime.this,
                    datePickerDlgOnDateSet,
                    now.get(Calendar.YEAR),
                    now.get(Calendar.MONTH),
                    now.get(Calendar.DAY_OF_MONTH));

            datePickerDialog.setTitle("選擇日期");
            datePickerDialog.setMessage("請選擇適合您的日期");
            datePickerDialog.setIcon(android.R.drawable.ic_dialog_info);
            datePickerDialog.setCancelable(false);

            datePickerDialog.show();
        }
    };

    private DatePickerDialog.OnDateSetListener datePickerDlgOnDateSet = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            mTxtResult.setText("您選擇的日期是" + Integer.toString(year) + "年" + Integer.toString(month + 1) +"月"+ Integer.toString(dayOfMonth) + "日");
        }
    };

    private View.OnClickListener btnTimePickerDlgOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mTxtResult.setText("");

            Calendar now = Calendar.getInstance();

            TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivty_DateTime.this,
                    timePickerDlgOnTimeSet,
                    now.get(Calendar.HOUR),
                    now.get(Calendar.MINUTE),
                    true);

            timePickerDialog.setTitle("選擇時間");
            timePickerDialog.setMessage("請選擇適合您的時間");
            timePickerDialog.setIcon(android.R.drawable.ic_dialog_info);
            timePickerDialog.setCancelable(false);

            timePickerDialog.show();
        }
    };

    private TimePickerDialog.OnTimeSetListener timePickerDlgOnTimeSet = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            mTxtResult.setText("您選擇的時間是" + Integer.toString(hourOfDay) + "時" + Integer.toString(minute) + "分");
        }
    };
}
