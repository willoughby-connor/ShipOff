package com.example.shipoff.data;

import android.content.Intent;
import android.util.Log;

import com.example.shipoff.data.model.LoggedInUser;

/**
 * Class that requests authentication and user information from the remote data source and
 * maintains an in-memory cache of login status and user credentials information.
 */
public class LoginRepository {

    private static volatile LoginRepository instance;

    private LoginDataSource dataSource;

    // If user credentials will be cached in local storage, it is recommended it be encrypted
    // @see https://developer.android.com/training/articles/keystore
    private static LoggedInUser user = null;

    // private constructor : singleton access
    private LoginRepository(LoginDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static LoginRepository getInstance(LoginDataSource dataSource) {
        if (instance == null) {
            instance = new LoginRepository(dataSource);
        }
        return instance;
    }

    public boolean isLoggedIn() {
        return user != null;
    }

    public void logout() {
        user = null;
        dataSource.logout();
    }

    private void setLoggedInUser(LoggedInUser user) {
        this.user = user;
        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
    }

    public Result<LoggedInUser> login(String username, String password) {
        // handle login
        Result<LoggedInUser> result = dataSource.login(username, password);
        if (result instanceof Result.Success) {
            setLoggedInUser(((Result.Success<LoggedInUser>) result).getData());
        }
        return result;
    }

    public void getUserInfo(){
        String username = user.getUserEmail();
        String password = user.getUserPassword();
        String info = dataSource.getUserInfo(username, password);
        Log.i("This user profile", user.getUserEmail());
        Log.i("GetUserInfo", info);
        String[] words = info.split("%");
        // Log word array info
        for (int i = 0; i <= 5; i++)
        {
            Log.i("Words array", words[i]);
        }
        user.setUserID(words[0]);
        user.setUserEmail(words[1]);
        user.setDisplayName(words[2]);
        user.setUserType(words[3]);
        user.setAddress(words[4]);
        user.setPoints(Integer.parseInt(words[5]));
        user.setSponsorName(words[6]);
    }

    public String getUserDisplayName() { return user.getDisplayName(); }

    public String getUserEmail() { return user.getUserEmail(); }

    public String getUserSponsor() { return user.getSponsorName(); }

    public String getUserAddress() { return user.getAddress(); }

    public int getUserPoints() { return user.getPoints(); }

    public void updatePreferredName(String newName){
        String username = user.getUserEmail();
        dataSource.changePreferredName(username,newName);
        user.setDisplayName(newName);
    }

    public void updatePassword(String newPassword)
    {
        String password = user.getUserPassword();
        dataSource.changePassword(password, newPassword);
        //Do we need to update the password locally? -CW
    }

    public void updateAddress(String newAddress)
    {
        String address = user.getAddress();
        dataSource.changeAddress(address, newAddress);
    }
}