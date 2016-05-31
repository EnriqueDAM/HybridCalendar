package com.example.enrique.financescalendar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


public  class CalendarActivity extends AppCompatActivity {

    private static final String SPLIT_TOKEN = "/";
    public ImageView calImageView;
    public TextView dateTextView;
    public Button btnChangeDate;
    public EditText moneyEditText, descEditText;
    public int year, month, day;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        calImageView = (ImageView) findViewById(R.id.cal_image_view);
        dateTextView = (TextView) findViewById(R.id.text_view_date);
        btnChangeDate = (Button) findViewById(R.id.btn_change_date);
        moneyEditText = (EditText) findViewById(R.id.edit_text_add_money);
        descEditText = (EditText) findViewById(R.id.edit_text_description);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    public void sendDataToDB() {
        String chain = (String) dateTextView.getText();
        String [] splitter = chain.split(SPLIT_TOKEN);

        month = Integer.parseInt(splitter [0]);
        day = Integer.parseInt(splitter[1]);
        year = Integer.parseInt(splitter[2]);

        


    }

    public void onBackPressed() {
        Intent intent = new Intent(CalendarActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new CalendarFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }
}
