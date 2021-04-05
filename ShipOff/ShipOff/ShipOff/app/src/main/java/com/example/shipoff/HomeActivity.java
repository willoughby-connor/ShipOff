package com.example.shipoff;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.shipoff.ui.login.LoginActivity;
import com.example.shipoff.data.LoginDataSource;
import com.example.shipoff.data.LoginRepository;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Load LoggedInUser information repository
        LoginRepository loginRepository = null;
        loginRepository = loginRepository.getInstance(new LoginDataSource());
        // Update user fields from repository
        loginRepository.getUserInfo();

        // Show name
        TextView nameTextView = (TextView) findViewById(R.id.name);
        nameTextView.setText(loginRepository.getUserDisplayName());

        // Show points
        TextView pointAvailableTextView = (TextView) findViewById(R.id.points_available);
        pointAvailableTextView.setText("Points Available: " + Integer.toString(loginRepository.getUserPoints()));

        //Profile button
        Button profile = (Button) findViewById(R.id.button_profile);
        profile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), ProfileActivity.class);
                startActivityForResult(myIntent, 0);
                finish();
            }

        });

        // Logout button
        Button logout = (Button) findViewById(R.id.button_logout);
        logout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), LoginActivity.class);
                myIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivityForResult(myIntent, 0);
                finish();
            }

        });
    }
}