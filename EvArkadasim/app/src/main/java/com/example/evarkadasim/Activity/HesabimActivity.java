package com.example.evarkadasim.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.evarkadasim.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HesabimActivity extends AppCompatActivity {
    private EditText ayarName;
    private EditText ayarYas;
    private EditText ayarSehir;
    private EditText ayarTel;
    private EditText ayarBolum;
    private Button   ayarKaydet;
    private EditText ayarAciklama;
    private FirebaseAuth mAtuth;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hesabim);

        ayarName= (EditText) findViewById(R.id.ayarad);
        ayarYas= (EditText) findViewById(R.id.ayaryas);
        ayarSehir = (EditText) findViewById(R.id.ayarsehir);
        ayarTel= (EditText) findViewById(R.id.ayartelefon);
        ayarBolum = (EditText) findViewById(R.id.ayarbolum);
        ayarAciklama = (EditText) findViewById(R.id.ayaraciklama);
        ayarKaydet = (Button) findViewById(R.id.ayarkyt);
        mAtuth =FirebaseAuth.getInstance();
        String user_id =mAtuth.getCurrentUser().getUid();
        mDatabase= FirebaseDatabase.getInstance().getReference().child("Kullanıcılar").child(user_id);
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String username = dataSnapshot.child("ad").getValue().toString();
                String useryas = dataSnapshot.child("yas").getValue().toString();
                String usersehir = dataSnapshot.child("sehir").getValue().toString();
                String usertel = dataSnapshot.child("tel").getValue().toString();
                String userbolum = dataSnapshot.child("bolum").getValue().toString();
                String useraciklama = dataSnapshot.child("aciklama").getValue().toString();

                ayarName.setText(username);
                ayarYas.setText(useryas);
                ayarSehir.setText(usersehir);
                ayarTel.setText(usertel);
                ayarBolum.setText(userbolum);
                ayarAciklama.setText(useraciklama);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });





    }
}
