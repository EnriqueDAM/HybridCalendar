package com.example.enrique.financescalendar;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.widget.DatePicker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarFragment extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {


    public Calendar c;
    public SimpleDateFormat sdf;
    public static int year, month, day;
    private static final String DATE_FORMAT = month + " / " + day + " / " + year;


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
        month = selectedMonth + 1;
        day = selectedDay;

        setDate();

    }

    private void setDate() {


        try {
            CalendarActivity calendarActivity = (CalendarActivity) getActivity();

            sdf = new SimpleDateFormat("MM / dd / yyyy");
            String dateStr = DATE_FORMAT;
            Date dateObj = sdf.parse(dateStr);
            String newDate = sdf.format(dateObj);

            calendarActivity.dateTextView.setText(newDate);

        } catch (ParseException e) {
            e.printStackTrace();
        }


    }

}
