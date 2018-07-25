package com.example.lenovo.androidlistviewexpandablelistview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivty_BarView extends AppCompatActivity{

    private RatingBar mRatingBar;
    private SeekBar mSeekBar;
    private TextView mTxtSeekBarProgress, mTxtRatingBarValue, mTxtRatingBarProgress;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_barview);

        mRatingBar = (RatingBar)findViewById(R.id.ratingBar);
        mSeekBar = (SeekBar)findViewById(R.id.seekBar);

        mTxtSeekBarProgress = (TextView)findViewById(R.id.txtSeekBarProgress);
        mTxtRatingBarValue = (TextView)findViewById(R.id.txtRatingBarVlaue);
        mTxtRatingBarProgress = (TextView)findViewById(R.id.txtRatingBarProgress);

        mSeekBar.setOnSeekBarChangeListener(btnOnSeekBarChange);
        mRatingBar.setOnRatingBarChangeListener(btnOnRatingBarChange);
    }

    private SeekBar.OnSeekBarChangeListener btnOnSeekBarChange = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            String s = getString(R.string.seek_bar_progress);
            mTxtSeekBarProgress.setText(s + String.valueOf(progress));
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    private RatingBar.OnRatingBarChangeListener btnOnRatingBarChange = new RatingBar.OnRatingBarChangeListener() {
        @Override
        public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
            String s = getString(R.string.rating_bar_value);
            mTxtRatingBarValue.setText(s + String.valueOf(rating));
            s = getString(R.string.rating_bar_progress);
            mTxtRatingBarProgress.setText(s + String.valueOf(ratingBar.getProgress()));
        }
    };
}
