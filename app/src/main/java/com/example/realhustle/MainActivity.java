package com.example.realhustle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.realhustle.R.id;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    EditText ed1,ed2,ed3,ed4;
    String Firstname,Lastname,Age,Username;
    Button btn1;
    FirebaseDatabase db;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1=findViewById(R.id.one);
        ed2=findViewById(R.id.two);
        ed3=findViewById(R.id.three);
        ed4=findViewById(R.id.four);
        btn1=findViewById(R.id.button);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Firstname = ed1.getText().toString();
                Lastname= ed2.getText().toString();
                Age= ed3.getText().toString();
                Username = ed4.getText().toString();

                if (!Firstname.isEmpty() && !Lastname.isEmpty() && !Username.isEmpty() &&  !Age.isEmpty()){

                    user users=new user(Firstname,Lastname,Age,Username);
                    db=FirebaseDatabase.getInstance();
                    ref=db.getReference("users");
                    ref.child(Username).setValue(users).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                           ed1.setText("");
                           ed2.setText("");
                           ed3.setText("");
                           ed4.setText("");
                            Toast.makeText(MainActivity.this, "Successfully update", Toast.LENGTH_SHORT).show();
                        }
                    });

                }

            }
        });
    }


}