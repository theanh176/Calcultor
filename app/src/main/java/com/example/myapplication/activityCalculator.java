package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class activityCalculator extends AppCompatActivity {

    Button btnKq, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnCong, btnTru, btnNhan, btnChia, btnAC, btnCham, btnPhai, btnTrai, btnPhamTram;
    TextView txtKetqua;
    Double var1, var2, ans;
    //Boolean cong = false, tru = false, nhan = false, chia = false;
    int flag, temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        txtKetqua = findViewById(R.id.txtKetqua);
        btnKq = findViewById(R.id.btnKq);
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnPhai = findViewById(R.id.btnPhai);
        btnCong = findViewById(R.id.btnCong);
        btnTru = findViewById(R.id.btnTru);
        btnNhan = findViewById(R.id.btnNhan);
        btnChia = findViewById(R.id.btnChia);
        btnAC = findViewById(R.id.btnAC);
        btnCham = findViewById(R.id.btnCham);
        btnTrai = findViewById(R.id.btnTrai);
        btnPhamTram = findViewById(R.id.btnPhanTram);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtKetqua.setText(txtKetqua.getText()+"0");
            }
        });
        btn1.setOnClickListener(view -> {
            txtKetqua.setText(txtKetqua.getText()+"1");
        });
        btn2.setOnClickListener(view -> {
            txtKetqua.setText(txtKetqua.getText()+"2");
        });
        btn3.setOnClickListener(view -> {
            txtKetqua.setText(txtKetqua.getText()+"3");
        });
        btn4.setOnClickListener(view -> {
            txtKetqua.setText(txtKetqua.getText()+"4");
        });
        btn5.setOnClickListener(view -> {
            txtKetqua.setText(txtKetqua.getText()+"5");
        });
        btn6.setOnClickListener(view -> {
            txtKetqua.setText(txtKetqua.getText()+"6");
        });
        btn7.setOnClickListener(view -> {
            txtKetqua.setText(txtKetqua.getText()+"7");
        });
        btn8.setOnClickListener(view -> {
            txtKetqua.setText(txtKetqua.getText()+"8");
        });
        btn9.setOnClickListener(view -> {
            txtKetqua.setText(txtKetqua.getText()+"9");
        });

        btnTrai.setOnClickListener(view -> {
            txtKetqua.setText(txtKetqua.getText()+"(");
        });
        btnPhai.setOnClickListener(view -> {
            txtKetqua.setText(txtKetqua.getText()+")");
        });
        btnPhamTram.setOnClickListener(view -> {
            txtKetqua.setText(txtKetqua.getText()+"%");
        });
        btnCong.setOnClickListener(view -> {
            setVar1();
            txtKetqua.setText(txtKetqua.getText()+"+");
            temp = txtKetqua.length();
            flag=1;

        });
        btnTru.setOnClickListener(view -> {
            setVar1();
            txtKetqua.setText(txtKetqua.getText()+"-");
            temp = txtKetqua.length();
            flag=2;

        });
        btnNhan.setOnClickListener(view -> {
            setVar1();
            txtKetqua.setText(txtKetqua.getText()+"x");
            temp = txtKetqua.length();
            flag=3;

        });
        btnChia.setOnClickListener(view -> {
            setVar1();
            txtKetqua.setText(txtKetqua.getText()+"/");
            temp = txtKetqua.length();
            flag=4;

        });

        btnKq.setOnClickListener(view -> {
            var2 = Double.parseDouble(txtKetqua.getText().toString().substring(temp));
            if(flag==1){
                ans=var1+var2;
            } else if(flag==2){
                ans = var1-var2;
            } else if(flag==3){
                ans = var1*var2;
            } else if(flag==4){
                ans = var1/var2;
            } else {
                ans = ans + 0;
            }
            txtKetqua.setText(ans.toString());

        });
        btnAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                txtKetqua.setText("");

            }
        });

    }

    public void setVar1(){
        var1 = Double.parseDouble(txtKetqua.getText().toString());
    }

    /*public void buttonFalse(){
        btnCong.setEnabled(false);
        btnTru.setEnabled(false);
        btnNhan.setEnabled(false);
        btnChia.setEnabled(false);
        txtKetqua.setText("");
    }*/


}
// Tai lieu https://dayhoc.pltpro.net/2020/08/huong-dan-lam-ung-dung-android-may-tinh-bo-tui-voi-anroid-studio-phan-2/