package com.example.evarkadasim.Activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.evarkadasim.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class GirisActivity extends AppCompatActivity implements View.OnClickListener {
    RelativeLayout girisbtn;
    Context context =this;
    private EditText girismail;
    private EditText girissifre;
    private ProgressDialog girisProgress;
    private FirebaseAuth mAuth;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.giris);
        init();
        girisbtn.setOnClickListener(this);
        girismail = (EditText) findViewById(R.id.mail);
        girissifre = (EditText) findViewById(R.id.sifre);
        girisProgress =new ProgressDialog(this);
        mAuth= FirebaseAuth.getInstance();


    }

    private void init() {
        girisbtn =findViewById(R.id.rlt);
    }

    @Override
    public void onClick(View v) {

                String mail =girismail.getText().toString();
                String sifre = girissifre.getText().toString();
         if (!TextUtils.isEmpty(mail) || !TextUtils.isEmpty(sifre)) {


             girisProgress.setTitle("Oturum açılıyor");
             girisProgress.setMessage("Hesabınıza giriş yapılıyor lütfen bekleyiniz.");
             girisProgress.setCanceledOnTouchOutside(false);
             girisProgress.show();
             girisUser(mail, sifre);
         }
    }

    private void girisUser(String mail, String sifre) {
        mAuth.signInWithEmailAndPassword(mail,sifre).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    girisProgress.dismiss();
                    Intent intent = new Intent(context, AnasayfaActivity.class);
                    startActivity(intent);
                }
                else {
                    girisProgress.dismiss();
                    Toast.makeText(getApplicationContext(), "E-mail veya şifre hatalı" , Toast.LENGTH_SHORT).show();
                    ;
                }
            }
        });
    }
}
