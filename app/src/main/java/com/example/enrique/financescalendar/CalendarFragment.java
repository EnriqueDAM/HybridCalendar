package com.example.enrique.financescalendar;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class CalendarFragment extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {

    public Calendar c;
    public int year, month, day;
    public TextView dateTextView;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current time as the default values for the picker
        c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of TimePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);

    }

    public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {
        // Do something with the time chosen by the user
        year = selectedYear;
        month = selectedMonth;
        day = selectedDay;

        setDate();

    }

    private void setDate() {
        LayoutInflater li = LayoutInflater.from(getActivity());
        View showView = li.inflate(R.layout.activity_calendar, null);
        dateTextView = (TextView) showView.findViewById(R.id.text_view_date);

        dateTextView.setText(month + " / " + day + " / " + year);
    }

}
