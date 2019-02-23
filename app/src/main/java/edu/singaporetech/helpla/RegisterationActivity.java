package edu.singaporetech.helpla;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import edu.singaporetech.helpla.firebaseHelper.FirebaseDatabaseHelper;
import edu.singaporetech.helpla.models.User;
import edu.singaporetech.helpla.utils.Utils;

//import com.google.firebase.auth.ActionCodeSettings;

public class RegisterationActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText email;
    private EditText password;
    private EditText cpw;
    private EditText name;
    private FirebaseDatabaseHelper database;
    private Utils utils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration);

    }

    public void registerWithEmail(View view) {

        Intent intent = new Intent(getApplicationContext(), IndexActivity.class);
        startActivity(intent);
    }
}