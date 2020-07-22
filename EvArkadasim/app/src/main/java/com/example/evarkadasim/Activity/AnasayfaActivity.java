package com.example.evarkadasim.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewManager;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toolbar;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.evarkadasim.Adapter.GridAdapter;
import com.example.evarkadasim.R;
import com.example.evarkadasim.Model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AnasayfaActivity extends AppCompatActivity {
    private FirebaseDatabase Database;
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    private Button buton;
    private Button buton2;
    ArrayList<User> users;
    GridAdapter gridAdapter;
    GridView gridView;
    Context context =this;


    @Override
    public void setContentView(View view) {
        super.setContentView(view);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anasayfa);


        Database=FirebaseDatabase.getInstance();
        mDatabase=Database.getReference();
        mAuth= FirebaseAuth.getInstance();
        users=new ArrayList<>();
        buton=(Button)findViewById(R.id.button);
        buton2=(Button)findViewById(R.id.button2);
        gridAdapter=new GridAdapter(this,users);
        gridView = (GridView)findViewById(R.id.gridView);

        buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gridView.setAdapter(gridAdapter);
            }
        });
        buton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,HesabimActivity.class);
                startActivity(intent);
            }
        });



        mDatabase.child("Kullanıcılar").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()){
                    User user = postSnapshot.getValue(User.class);
                    users.add(
                      new User(
                              user.getAd(),
                              user.getYas(),
                              user.getSehir(),
                              user.getTel(),
                              user.getBolum(),
                              user.getEmail(),
                              user.getSifre(),
                              user.getAciklama()

                      )
                    );

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

}
