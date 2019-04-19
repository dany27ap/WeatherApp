package ro.pentalog.wheaterapp;

import android.content.Context;
import android.content.SharedPreferences;

public class UserLocalStore {

    public static final String SP_NAME = "userDetails";
    SharedPreferences userLocalDatabase;

    public UserLocalStore(Context context){
        this.userLocalDatabase = context.getSharedPreferences(SP_NAME, 0);
    }

    public void storeUserData(User user){

        SharedPreferences.Editor userEditor = userLocalDatabase.edit();
        userEditor.putString("name", user.name);
        userEditor.putString("country", user.country);
        userEditor.putString("emal", user.email);
        userEditor.putString("password", user.password);
        userEditor.commit();
    }

    public User getLoggedInUser(){
        String name = this.userLocalDatabase.getString("name", "");
        String country = this.userLocalDatabase.getString("country", "");
        String email = this.userLocalDatabase.getString("email", "");
        String password = this.userLocalDatabase.getString("password", "");

        User storedUser = new User(name, country, email, password);
        return storedUser;
    }

    public void setUserLoggedIn(boolean loggedIn){
        SharedPreferences.Editor userEditor = userLocalDatabase.edit();
        userEditor.putBoolean("loggedIn", loggedIn);
        userEditor.commit();
    }

    public void clearUserData(){
        SharedPreferences.Editor userEditor = userLocalDatabase.edit();
        userEditor.clear();
        userEditor.commit();
    }


}
