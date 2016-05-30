package com.example.enrique.financescalendar;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public  class CalendarActivity extends AppCompatActivity {

    //a
    public TextView dateTextView;
    public EditText moneyEditText, descEditText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        showOptionsDialog();
    }

    private void showOptionsDialog() {
        AlertDialog.Builder addIssue = new AlertDialog.Builder(CalendarActivity.this);
        //addIssue.setView(R.layout.activity_calendar);

        dateTextView = (TextView) findViewById(R.id.text_view_date);
        moneyEditText = (EditText) findViewById(R.id.edit_text_add_money);
        descEditText = (EditText) findViewById(R.id.edit_text_description);

        //Go

        addIssue.setCancelable(false).
                setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //money = Float.parseFloat(String.valueOf(setMoney.getText()));
                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        AlertDialog alert = addIssue.create();
        alert.show();

    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new CalendarFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }



}
