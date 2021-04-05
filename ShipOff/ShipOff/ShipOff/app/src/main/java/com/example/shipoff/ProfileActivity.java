package com.example.shipoff;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.shipoff.data.LoginDataSource;
import com.example.shipoff.data.LoginRepository;
import com.example.shipoff.ui.login.LoginActivity;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Load LoggedInUser information repository
        LoginRepository loginRepository = null;
        loginRepository = loginRepository.getInstance(new LoginDataSource());
        // Update user fields from repository
        loginRepository.getUserInfo();

        // Show display name
        TextView nameTextView = (TextView) findViewById(R.id.name);
        nameTextView.setText(loginRepository.getUserDisplayName());

        // Show email
        TextView emailTextView = (TextView) findViewById(R.id.email);
        emailTextView.setText(loginRepository.getUserEmail());

        // Show sponsor
        TextView sponsorTextView = (TextView) findViewById(R.id.sponsor_name);
        sponsorTextView.setText(loginRepository.getUserSponsor());

        // Show address
        TextView addressTextView = (TextView) findViewById(R.id.address);
        addressTextView.setText(loginRepository.getUserAddress());

        // Show points
        TextView pointTextView = (TextView) findViewById(R.id.points);
        pointTextView.setText(Integer.toString(loginRepository.getUserPoints()));

        // Home Button
        Button home = (Button) findViewById(R.id.button_home);
        home.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), HomeActivity.class);
                startActivityForResult(myIntent, 0);
                finish();
            }

        });

        // Logout button
        Button next = (Button) findViewById(R.id.button_logout);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), LoginActivity.class);
                myIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivityForResult(myIntent, 0);
                finish();
            }

        });

        //Settings button
        Button settings = (Button) findViewById(R.id.button_settings);
        settings.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), SettingsActivity.class);
                startActivityForResult(myIntent, 0);
                finish();
            }

        });
    }
}