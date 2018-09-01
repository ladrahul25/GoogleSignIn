package com.identity.rahul.customgooglesignin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginSuccessActivity extends AppCompatActivity {
    Button logout;
    TextView name;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);

        name = findViewById(R.id.name);
        logout = findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signOut();
            }
        });
        mAuth = FirebaseAuth.getInstance();
    }

    private void signOut() {
        FirebaseAuth.getInstance().signOut();
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();
        if (null != user){
            name.setText(user.getDisplayName());
        }
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
    }
}
