package edu.singaporetech.helpla;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;
import edu.singaporetech.helpla.utils.Utils;

public class MainActivity extends AppCompatActivity {


    FirebaseDatabase database;
    DatabaseReference myRef;
    private EditText username;
    private EditText password;
    private FirebaseAuth mAuth;

    private Utils utils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.email);
        password = findViewById(R.id.password);
        ButterKnife.bind(this);
        mAuth = FirebaseAuth.getInstance();


    }


    public void login(View view){
        Intent intent = new Intent(getApplicationContext(), IndexActivity.class);
        startActivity(intent);
    }


    public void registration(View v){
        Intent intent = new Intent(getApplicationContext(), RegisterationActivity.class);
        startActivity(intent);
    }


}
