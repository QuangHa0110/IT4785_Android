package com.hadvq.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Context context = this;
    private String giatriinput = "0";
    private TextView tvDonvi1, tvDonvi2, tvTyGia1, tvTyGia2, tvTyGiaQuyDoi;
    private Spinner spinnerTien1, spinnerTien2;
    double tygiaquydoi = 1.0;
    Tien dv1, dv2;
    private Button btn1, btn2, btn3, btn4, btn5,btn6, btn7, btn8, btn9, btn0, btnDot, btnDel, btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Tien[] tiens = Tien.getTien();

        spinnerTien1 = (Spinner) findViewById(R.id.dropdownMenu1);
        spinnerTien2 = (Spinner) findViewById(R.id.dropdownMenu2);
        tvDonvi1 = (TextView) findViewById(R.id.tvDonViInput);
        tvDonvi2 = (TextView) findViewById(R.id.tvDonViOutput);
        tvTyGia1 = (TextView) findViewById(R.id.tvInput);
        tvTyGia2 = (TextView) findViewById(R.id.tvOutput);
        tvTyGiaQuyDoi = (TextView) findViewById(R.id.tvTyGiaQuyDoi);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btn0 = (Button) findViewById(R.id.btn0);
        btnDot = (Button) findViewById(R.id.btnDot);
        btnDel = (Button) findViewById(R.id.btnDel);
        btnClear = (Button) findViewById(R.id.btnReset);

        ArrayAdapter<Tien> adapter = new ArrayAdapter<Tien>(context, androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item, tiens);
        adapter.setDropDownViewResource( androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item);
        spinnerTien1.setAdapter(adapter);
        spinnerTien2.setAdapter(adapter);

        spinnerTien1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                dv1 = tiens[i];
                tvDonvi1.setText(dv1.getViettat());
                tvTyGia1.setText("1");
                giatriinput = "1";
                try {
                    tygiaquydoi = dv1.getTygiavnd() / dv2.getTygiavnd();
                    if(giatriinput.equals("0")){

                        tvTyGia2.setText(String.valueOf(tygiaquydoi));
                    } else{

                        tvTyGia2.setText(String.valueOf(Double.parseDouble(giatriinput)*tygiaquydoi));
                    }
                    tvTyGiaQuyDoi.setText("1 " + dv1.getDonvi() + " = " + String.valueOf(tygiaquydoi) + " " + dv2.getDonvi());
                } catch (Exception e){
                    Log.e("ERROR",e.getMessage());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                dv1 = tiens[0];
                tvDonvi1.setText(dv1.getViettat());
                tvTyGia1.setText("1");
            }
        });
        spinnerTien2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                dv2 = tiens[i];
                tvDonvi2.setText(dv1.getViettat());
                tygiaquydoi = dv1.getTygiavnd() / dv2.getTygiavnd();
                if(giatriinput.equals("0")){

                    tvTyGia2.setText(String.valueOf(tygiaquydoi));
                } else{

                    tvTyGia2.setText(String.valueOf(Double.parseDouble(giatriinput)*tygiaquydoi));
                }
                tvTyGiaQuyDoi.setText("1 " + dv1.getDonvi() + " = " + String.valueOf(tygiaquydoi) + " " + dv2.getDonvi());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                dv2 = tiens[0];
                tvDonvi2.setText(dv1.getViettat());
                tygiaquydoi = dv1.getTygiavnd() / dv2.getTygiavnd();
                tvTyGia2.setText(String.valueOf(tygiaquydoi));
                tvTyGiaQuyDoi.setText("1 " + dv1.getDonvi() + " = " + String.valueOf(tygiaquydoi) + " " + dv2.getDonvi());
            }

        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvTyGia1.setText("1");
                tvTyGia2.setText(String.valueOf(1 * tygiaquydoi));
            }
        });

        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(giatriinput.equals("0")){
                    giatriinput = "1";
                }else if(!giatriinput.contains(".")){
                    giatriinput += ".";
                }
                if(giatriinput.endsWith(".")){
                    tvTyGia1.setText(giatriinput);
                    tvTyGia2.setText(String.valueOf(Double.parseDouble(giatriinput.substring(0, giatriinput.length()-1)) * tygiaquydoi));
                } else{
                    tvTyGia1.setText(giatriinput);
                    tvTyGia2.setText(String.valueOf(Double.parseDouble(giatriinput) * tygiaquydoi));
                }
            }
        });
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(giatriinput.equals("0")){
                    giatriinput = "0";
                }else if(giatriinput.length() > 1){
                    giatriinput = giatriinput.substring(0, giatriinput.length()-1);
                } else{
                    giatriinput = "0";
                }
                if(giatriinput.endsWith(".")){
                    tvTyGia1.setText(giatriinput);
                    tvTyGia2.setText(String.valueOf(Double.parseDouble(giatriinput.substring(0, giatriinput.length()-1)) * tygiaquydoi));
                } else{
                    tvTyGia1.setText(giatriinput);
                    tvTyGia2.setText(String.valueOf(Double.parseDouble(giatriinput) * tygiaquydoi));
                }
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(giatriinput.equals("0")){
                    giatriinput = "1";
                }else{
                    giatriinput += "1";
                }
                tvTyGia1.setText(giatriinput);
                tvTyGia2.setText(String.valueOf(Double.parseDouble(giatriinput) * tygiaquydoi));
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(giatriinput.equals("0")){
                    giatriinput = "2";
                }else{
                    giatriinput += "2";
                }
                tvTyGia1.setText(giatriinput);
                tvTyGia2.setText(String.valueOf(Double.parseDouble(giatriinput) * tygiaquydoi));
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(giatriinput.equals("0")){
                    giatriinput = "3";
                }else{
                    giatriinput += "3";
                }
                tvTyGia1.setText(giatriinput);
                tvTyGia2.setText(String.valueOf(Double.parseDouble(giatriinput) * tygiaquydoi));
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(giatriinput.equals("0")){
                    giatriinput = "4";
                }else{
                    giatriinput += "4";
                }
                tvTyGia1.setText(giatriinput);
                tvTyGia2.setText(String.valueOf(Double.parseDouble(giatriinput) * tygiaquydoi));
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(giatriinput.equals("0")){
                    giatriinput = "5";
                }else{
                    giatriinput += "5";
                }
                tvTyGia1.setText(giatriinput);
                tvTyGia2.setText(String.valueOf(Double.parseDouble(giatriinput) * tygiaquydoi));
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(giatriinput.equals("0")){
                    giatriinput = "6";
                }else{
                    giatriinput += "6";
                }
                tvTyGia1.setText(giatriinput);
                tvTyGia2.setText(String.valueOf(Double.parseDouble(giatriinput) * tygiaquydoi));
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(giatriinput.equals("0")){
                    giatriinput = "7";
                }else{
                    giatriinput += "7";
                }
                tvTyGia1.setText(giatriinput);
                tvTyGia2.setText(String.valueOf(Double.parseDouble(giatriinput) * tygiaquydoi));
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(giatriinput.equals("0")){
                    giatriinput = "8";
                }else{
                    giatriinput += "8";
                }
                tvTyGia1.setText(giatriinput);
                tvTyGia2.setText(String.valueOf(Double.parseDouble(giatriinput) * tygiaquydoi));
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(giatriinput.equals("0")){
                    giatriinput = "9";
                }else{
                    giatriinput += "9";
                }
                tvTyGia1.setText(giatriinput);
                tvTyGia2.setText(String.valueOf(Double.parseDouble(giatriinput) * tygiaquydoi));
            }
        });
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(giatriinput.equals("0")){
                    giatriinput = "1";
                }else{
                    giatriinput += "0";
                }
                tvTyGia1.setText(giatriinput);
                tvTyGia2.setText(String.valueOf(Double.parseDouble(giatriinput) * tygiaquydoi));
            }
        });


    }

    public void btnClickReset(){

    }
    public void btnClickDot(){


    }

    public void btnClickDel(){

    }

    public void btnClick1(){

    }
    public void btnClick0(){

    }

    public void btnClick2(){

    }
    public void btnClick3(){

    }
    public void btnClick4(){

    }
    public void btnClick5(){

    }
    public void btnClick6(){

    }
    public void btnClick7(){

    }
    public void btnClick8(){

    }

    public void btnClick9(){

    }

}