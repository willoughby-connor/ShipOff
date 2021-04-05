package com.example.shipoff.data;

import android.util.Log;
import android.view.View;

import com.example.shipoff.data.model.LoggedInUser;
import com.example.shipoff.data.model.FetchData;
import com.example.shipoff.data.model.PutData;

import java.io.IOException;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    public Result<LoggedInUser> login(String username, String password) {

        try {
            //loggedInUser authentication
            FetchData fetchData = new FetchData("http://174.129.244.109/hello.php");
            if (fetchData.startFetch()) {
                if (fetchData.onComplete()) {
                    String result = fetchData.getResult();
                    Log.i("FetchData", result);
                }
            }

            //field[] is used to specify what parameter you will be passing. data[] is for the email and password entered by the user.
            String[] field = new String[2];
            field[0] = "email";
            field[1] = "pass";
            //Creating array for data
            String[] data = new String[2];
            data[0] = username;
            data[1] = password;

            //this is how data passed to the web server
            String result = "";
            PutData putData = new PutData("http://174.129.244.109/login.php", "POST", field, data);
            if (putData.startPut()) {
                //putData.onComplete() will return the string Login Successful...! or Login Failed...! depending on if the credentials are correct
                if (putData.onComplete()) {
                    result = putData.getResult();
                    Log.i("PutData", result);
                }
            }

            if (result.equals("login successfull...!")) {
                Log.i("LoginResult", result);
                Log.i("Login","login success return");
            }
            else {
                Log.i("LoginResult", result);
                Log.i("Login","login fail return");
                return new Result.Error(new IOException("Invalid Username or Password"));
            }


            LoggedInUser user = new LoggedInUser(username, password, username);
            return new Result.Success<>(user);
            /*
            LoggedInUser fakeUser =
                    new LoggedInUser(
                            java.util.UUID.randomUUID().toString(),
                            "Jane Doe");
            return new Result.Success<>(fakeUser);

             */
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public String getUserInfo(String username, String password) {
        String[] field = new String[2];
        field[0] = "email";
        field[1] = "pass";
        //Creating array for data
        String[] data = new String[2];
        data[0] = username;
        data[1] = password;

        String result = "";
        PutData putData = new PutData("http://174.129.244.109/fetchDriverData.php", "POST", field, data);
        if (putData.startPut()) {
            //putData.onComplete() will return the string Login Successful...! or Login Failed...! depending on if the credentials are correct
            if (putData.onComplete()) {
                result = putData.getResult();
                Log.i("PutData", result);
            }
        }
        return result;
    }

    public void changePreferredName(String username, String preferredName){
        String[] field = new String[2];
        field[0] = "email";
        field[1] = "pName"; //preferred name
        //Creating array for data
        String[] data = new String[2];
        data[0] = username;
        data[1] = preferredName;

        Log.i("NameChange", "attempt");
        PutData putData = new PutData("http://174.129.244.109/updateDisplayName.php", "POST", field, data);
        if (putData.startPut()) {
            //putData.onComplete() will return the string Login Successful...! or Login Failed...! depending on if the credentials are correct
            if (putData.onComplete()) {
                String result = putData.getResult();
                Log.i("PutData", "Updated display name");
            }
        }
    }

    public void changePassword(String password, String newPassword){
        String[] field = new String[2];
        field[0] = "email";
        field[1] = "pass"; //password
        //Creating array for data
        String[] data = new String[2];
        data[0] = password;
        data[1] = newPassword;

        Log.i("PasswordChange", "attempt");
        PutData putData = new PutData("http://174.129.244.109/updatePassword.php", "POST", field, data);
        if (putData.startPut()) {
            //putData.onComplete() will return the string Login Successful...! or Login Failed...! depending on if the credentials are correct
            if (putData.onComplete()) {
                String result = putData.getResult();
                Log.i("PutData", "Updated password");
            }
        }
    }

    public void changeAddress(String address, String newAddress){
        String[] field = new String[2];
        field[0] = "email";
        field[1] = "Address"; //password
        //Creating array for data
        String[] data = new String[2];
        data[0] = address;
        data[1] = newAddress;

        Log.i("AddressChange", "attempt");
        PutData putData = new PutData("http://174.129.244.109/updateAddress.php", "POST", field, data);
        if (putData.startPut()) {
            //putData.onComplete() will return the string Login Successful...! or Login Failed...! depending on if the credentials are correct
            if (putData.onComplete()) {
                String result = putData.getResult();
                Log.i("PutData", "Updated address");
            }
        }
    }
    public void logout() {
        // TODO: revoke authentication
    }
}