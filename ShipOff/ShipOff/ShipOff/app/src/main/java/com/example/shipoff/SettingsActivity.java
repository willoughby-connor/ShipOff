package com.example.shipoff;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.shipoff.data.LoginRepository;
import com.example.shipoff.data.LoginDataSource;
import com.example.shipoff.data.model.PutData;
import com.example.shipoff.ui.login.LoginActivity;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // Home Button
        Button next2 = (Button) findViewById(R.id.button_home);
        next2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), HomeActivity.class);
                startActivityForResult(myIntent, 0);
                finish();
            }

        });

        //Change Username Button
        Button changeName = (Button) findViewById(R.id.button_change_name);
        changeName.setOnClickListener(new View.OnClickListener() {
            //@SuppressWarnings("deprecation")
            public void onClick(final View view) {

                // Creating alert Dialog with one Button
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(SettingsActivity.this);

                // Setting Dialog Title
                alertDialog.setTitle("Change Display Name");

                // Setting Dialog Message
                alertDialog.setMessage("Enter New Name");
                final EditText input = new EditText(SettingsActivity.this);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                input.setLayoutParams(lp);
                alertDialog.setView(input);


                // Setting Icon to Dialog
                //alertDialog.setIcon(R.drawable.key);

                // Setting Positive "Yes" Button
                alertDialog.setPositiveButton("Submit",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int which) {

                                String newName = input.getText().toString();

                                LoginRepository loginRepository = null;
                                loginRepository = loginRepository.getInstance(new LoginDataSource());
                                loginRepository.updatePreferredName(input.getText().toString());

                                dialog.cancel();
                            }
                        });
                // Setting Negative "NO" Button
                alertDialog.setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // Write your code here to execute after dialog
                                dialog.cancel();
                            }
                        });

                // closed

                // Showing Alert Message
                alertDialog.show();
            }

        });

        //Change Password Button
        Button changePassword = (Button) findViewById(R.id.button_change_password);
        changePassword.setOnClickListener(new View.OnClickListener() {
            //@SuppressWarnings("deprecation")
            public void onClick(final View view) {

                // Creating alert Dialog with one Button
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(SettingsActivity.this);

                // Setting Dialog Title
                alertDialog.setTitle("Change Password");

                // Setting Dialog Message
                alertDialog.setMessage("Enter New Password");
                final EditText input = new EditText(SettingsActivity.this);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                input.setLayoutParams(lp);
                alertDialog.setView(input);


                // Setting Icon to Dialog
                //alertDialog.setIcon(R.drawable.key);

                // Setting Positive "Yes" Button
                alertDialog.setPositiveButton("Submit",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int which) {

                                String newName = input.getText().toString();

                                LoginRepository loginRepository = null;
                                loginRepository = loginRepository.getInstance(new LoginDataSource());
                                loginRepository.updatePassword(input.getText().toString());

                                dialog.cancel();
                            }
                        });
                // Setting Negative "NO" Button
                alertDialog.setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // Write your code here to execute after dialog
                                dialog.cancel();
                            }
                        });

                // closed

                // Showing Alert Message
                alertDialog.show();
            }

        });

        //Change Address Button
        Button changeAddress = (Button) findViewById(R.id.button_address);
        changeAddress.setOnClickListener(new View.OnClickListener() {
            //@SuppressWarnings("deprecation")
            public void onClick(final View view) {

                // Creating alert Dialog with one Button
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(SettingsActivity.this);

                // Setting Dialog Title
                alertDialog.setTitle("Change Address");

                // Setting Dialog Message
                alertDialog.setMessage("Enter New Address");
                final EditText input = new EditText(SettingsActivity.this);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                input.setLayoutParams(lp);
                alertDialog.setView(input);


                // Setting Icon to Dialog
                //alertDialog.setIcon(R.drawable.key);

                // Setting Positive "Yes" Button
                alertDialog.setPositiveButton("Submit",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int which) {

                                String newName = input.getText().toString();

                                LoginRepository loginRepository = null;
                                loginRepository = loginRepository.getInstance(new LoginDataSource());
                                loginRepository.updateAddress(input.getText().toString());

                                dialog.cancel();
                            }
                        });
                // Setting Negative "NO" Button
                alertDialog.setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // Write your code here to execute after dialog
                                dialog.cancel();
                            }
                        });

                // closed

                // Showing Alert Message
                alertDialog.show();
            }

        });

        //Profile button
        Button profile = (Button) findViewById(R.id.button_profile);
        profile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), ProfileActivity.class);
                startActivityForResult(myIntent, 0);
                finish();
            }

        });
    }
}