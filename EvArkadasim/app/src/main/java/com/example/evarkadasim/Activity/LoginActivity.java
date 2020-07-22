package com.example.evarkadasim.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.evarkadasim.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    RelativeLayout girisbtn;
    RelativeLayout kayitbtn;
    Context context =this;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        init();
        girisbtn.setOnClickListener(this);
        kayitbtn.setOnClickListener(this);

        
    }

    private void init() {

        girisbtn =findViewById(R.id.rlt);
        kayitbtn =findViewById(R.id.rlt2);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rlt:
                Intent intent = new Intent(context,GirisActivity.class);
                        startActivity(intent);
                break;
        }

        switch (v.getId()) {
            case R.id.rlt2:
                Intent intent = new Intent(context,RegisterActivity.class);
                startActivity(intent);
                break;
        }
    }
}
