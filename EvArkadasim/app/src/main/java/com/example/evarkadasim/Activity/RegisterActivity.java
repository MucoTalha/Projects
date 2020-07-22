package com.example.evarkadasim.Activity;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.evarkadasim.R;
import com.example.evarkadasim.Model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class RegisterActivity extends AppCompatActivity {
    private EditText regName;
    private EditText regYas;
    private EditText regSehir;
    private EditText regTel;
    private EditText regBolum;
    private EditText regMail;
    private EditText regSifre;
    private Button regKaydet;
    private EditText regAciklama;
    Context context = this;
    private ProgressDialog regProgress;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    private ImageView regfoto;
    private DatabaseReference dbRef;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        regName = (EditText) findViewById(R.id.ad);
        regYas = (EditText) findViewById(R.id.yas);
        regSehir = (EditText) findViewById(R.id.sehir);
        regTel = (EditText) findViewById(R.id.telefon);
        regBolum = (EditText) findViewById(R.id.bolum);
        regMail = (EditText) findViewById(R.id.mail);
        regSifre = (EditText) findViewById(R.id.sifre);
        regAciklama = (EditText) findViewById(R.id.aciklama);
        regProgress = new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();
        regfoto = findViewById(R.id.profilfoto);
        regKaydet = findViewById(R.id.btnkyt);


        regKaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = regName.getText().toString();
                String yas = regYas.getText().toString();
                String sehir = regSehir.getText().toString();
                String tel = regTel.getText().toString();
                String bolum = regBolum.getText().toString();
                String mail = regMail.getText().toString();
                String sifre = regSifre.getText().toString();
                String aciklama = regAciklama.getText().toString();
                if (!TextUtils.isEmpty(name) || !TextUtils.isEmpty(yas) || !TextUtils.isEmpty(sehir) || !TextUtils.isEmpty(tel) || !TextUtils.isEmpty(bolum) || !TextUtils.isEmpty(mail) || !TextUtils.isEmpty(sifre) || !TextUtils.isEmpty(aciklama))
                {
                    regProgress.setTitle("Kaydediliyor");
                    regProgress.setMessage("Hesabınız oluşturuluyor lütfen bekleyiniz.");
                    regProgress.setCanceledOnTouchOutside(false);
                    regProgress.show();

                    dbRef = FirebaseDatabase.getInstance().getReference().child("Kullanıcılar");
                    dbRef.push().setValue(
                            new User(
                                    regName.getText().toString(),
                                    regYas.getText().toString(),
                                    regSehir.getText().toString(),
                                    regTel.getText().toString(),
                                    regBolum.getText().toString(),
                                    regMail.getText().toString(),
                                    regSifre.getText().toString(),
                                    regAciklama.getText().toString()

                            )

                    );
                    regProgress.dismiss();
                    Intent intent = new Intent(context, GirisActivity.class);
                    startActivity(intent);

                }
                else
                    Toast.makeText(getApplicationContext(),"Lütfen bütün alanları doldurunuz", Toast.LENGTH_SHORT).show();
            }


        });

    }
}