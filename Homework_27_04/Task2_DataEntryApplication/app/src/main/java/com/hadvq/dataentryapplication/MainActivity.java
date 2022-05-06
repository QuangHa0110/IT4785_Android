package com.hadvq.dataentryapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText editMssv, editName, editID, editPhone, editEmail, editBirthday;
    EditText editFrom, editNow;
    RadioGroup groupClass;
    CheckBox checkBoxPython, checkBoxJava, checkBoxCC, checkBoxJs, checkBoxYes;
    Button btnClick;
    Context context;
    CalendarView calendarView;
    TextView require1, require2, require3, require4, require5;
    int radioChecked;
    RadioButton radiobtnMajor1, radiobtnMajor2;
    DatePickerDialog picker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        // require
        editMssv = (EditText) findViewById(R.id.editMSSV);
        editName = (EditText) findViewById(R.id.editName);
        editEmail = (EditText) findViewById(R.id.editEmail);
        editID = (EditText) findViewById(R.id.editCCCD);
        editPhone = (EditText) findViewById(R.id.editPhone);
        editBirthday = (EditText) findViewById(R.id.editBirthday);
        editBirthday.setInputType(InputType.TYPE_NULL);
        editBirthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                editBirthday.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });
        // end require
        radiobtnMajor1 = (RadioButton) findViewById(R.id.radiobtnMajor1);
        radiobtnMajor2 = (RadioButton) findViewById(R.id.radiobtnMajor2);
        editFrom = (EditText) findViewById(R.id.editFrom);
        editNow = (EditText) findViewById(R.id.editNow);
        groupClass = (RadioGroup) findViewById(R.id.groupMajor);
        checkBoxPython = (CheckBox) findViewById(R.id.python);
        checkBoxJava = (CheckBox) findViewById(R.id.java);
        checkBoxCC = (CheckBox) findViewById(R.id.cc);
        checkBoxJs = (CheckBox) findViewById(R.id.js);
        checkBoxYes = (CheckBox) findViewById(R.id.yes);
        btnClick = (Button) findViewById(R.id.btnClick);
        require1 = (TextView) findViewById(R.id.require1);
        require2 = (TextView) findViewById(R.id.require2);
        require3 = (TextView) findViewById(R.id.require3);
        require4 = (TextView) findViewById(R.id.require4);
        require5 = (TextView) findViewById(R.id.require5);

        // init vars
        if (savedInstanceState != null) {
            editMssv.setText(savedInstanceState.getString("editMssv"));
            editName.setText(savedInstanceState.getString("editName"));
            editEmail.setText(savedInstanceState.getString("editEmail"));
            editID.setText(savedInstanceState.getString("editID"));
            editPhone.setText(savedInstanceState.getString("editPhone"));
            // end require
            editFrom.setText(savedInstanceState.getString("editFrom"));
            editNow.setText(savedInstanceState.getString("editNow"));
//            groupClass.se(savedInstanceState.getString("editMssv"));
            if (savedInstanceState.getInt("radioGroup") == 1) {
                radiobtnMajor1.setChecked(true);
                radiobtnMajor2.setChecked(false);
            } else {
                radiobtnMajor2.setChecked(true);
                radiobtnMajor1.setChecked(false);
            }
            checkBoxPython.setChecked(savedInstanceState.getBoolean("checkedPython"));
            checkBoxJava.setChecked(savedInstanceState.getBoolean("checkedJava"));
            checkBoxCC.setChecked(savedInstanceState.getBoolean("checkedCc"));
            checkBoxJs.setChecked(savedInstanceState.getBoolean("checkedJs"));
            checkBoxYes.setChecked(savedInstanceState.getBoolean("checkedYes"));
            calendarView.setDate(savedInstanceState.getLong("birthday"));
            require1.setVisibility(savedInstanceState.getInt("require1"));

            require2.setVisibility(savedInstanceState.getInt("require2"));

            require3.setVisibility(savedInstanceState.getInt("require3"));

            require4.setVisibility(savedInstanceState.getInt("require4"));

            require5.setVisibility(savedInstanceState.getInt("require5"));

        }
        // end init

        // handle button
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String error = "";
                if (editMssv.getText().toString().isEmpty()) {
                    error += "Thiếu trường mã số sinh viên\n";
                    require1.setVisibility(View.VISIBLE);
                } else {
                    require1.setVisibility(View.INVISIBLE);
                }
                if (editPhone.getText().toString().isEmpty()) {
                    error += "Thiếu trường số điện thoại\n";
                    require4.setVisibility(View.VISIBLE);

                } else {
                    require4.setVisibility(View.INVISIBLE);
                }
                if (editID.getText().toString().isEmpty()) {
                    error += "Thiếu trường căn cước công dân\n";
                    require3.setVisibility(View.VISIBLE);

                } else {
                    require3.setVisibility(View.INVISIBLE);
                }
                if (editEmail.getText().toString().isEmpty()) {
                    error += "Thiếu trường email\n";
                    require5.setVisibility(View.VISIBLE);

                } else {
                    require5.setVisibility(View.INVISIBLE);
                }
                if (editName.getText().toString().isEmpty()) {
                    error += "Thiếu trường tên sinh viên\n";
                    require2.setVisibility(View.VISIBLE);

                } else {
                    require2.setVisibility(View.INVISIBLE);
                }

                String finalError = error;
                if (!finalError.isEmpty()) {
                    Toast.makeText(context, finalError, Toast.LENGTH_SHORT).show();
                } else {
                    if (!checkBoxYes.isChecked()) {
                        Toast.makeText(context, "Bạn cần phải đồng ý với các điều khoản chúng tôi đưa ra", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(context, "Nhập dữ liệu thành công", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("require1", require1.getVisibility());
        outState.putInt("require2", require2.getVisibility());
        outState.putInt("require3", require3.getVisibility());
        outState.putInt("require4", require4.getVisibility());
        outState.putInt("require5", require5.getVisibility());
        outState.putString("editMssv", editMssv.getText().toString());
        outState.putString("editEmail", editEmail.getText().toString());
        outState.putString("editName", editName.getText().toString());
        outState.putString("editID", editID.getText().toString());
        outState.putString("editPhone", editPhone.getText().toString());
        outState.putString("editNow", editNow.getText().toString());
        outState.putString("editFrom", editFrom.getText().toString());
        outState.putString("editFrom", editFrom.getText().toString());
        outState.putString("editFrom", editFrom.getText().toString());
        outState.putInt("radioGroup", groupClass.getCheckedRadioButtonId());
        outState.putBoolean("checkedPython", checkBoxPython.isChecked());
        outState.putBoolean("checkedCc", checkBoxCC.isChecked());
        outState.putBoolean("checkedJs", checkBoxJs.isChecked());
        outState.putBoolean("checkedJava", checkBoxJava.isChecked());
        outState.putBoolean("checkedYes", checkBoxYes.isChecked());
        outState.putLong("birthday", calendarView.getDate());

    }
}