package se.is.agriculturalequipment.login;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/**
 * Created by BlackClover on 3/18/2018.
 */

public class UserManager {

    private final String KEY_PREFS = "prefs_user";
    private final String KEY_STATUS = "loginStatus";
    private final String KEY_USERNAME = "username";
    private final String KEY_UserRole = "userRole";


    private SharedPreferences mPrefs;
    private SharedPreferences.Editor mEditor;

    public UserManager(Context context) {
        mPrefs = context.getSharedPreferences(KEY_PREFS, Context.MODE_PRIVATE);
        mEditor = mPrefs.edit();
    }

    public boolean checkLoginValidate(String username,String userRole){
        String realUsername = mPrefs.getString(KEY_USERNAME, "");
        String realUserRole = mPrefs.getString(KEY_UserRole, "");

        if ((!TextUtils.isEmpty(username) && !TextUtils.isEmpty(userRole)) &&
                username.equals(realUsername) &&
                userRole.equals(realUserRole)){
            return true;
        }

        return false;
    }

    public boolean registerUser(String username,String userRole){
        //Save data to local storage.
        if (TextUtils.isEmpty(username) && (TextUtils.isEmpty(userRole))){
            return false;
        }

        mEditor.putBoolean(KEY_STATUS, true);
        mEditor.putString(KEY_USERNAME, username);
        mEditor.putString(KEY_UserRole, userRole);

        return mEditor.commit();
    }

    public void deleteSession(){
        mEditor.clear();
        mEditor.commit();
    }

    public boolean getStatus(){
        return mPrefs.getBoolean(KEY_STATUS, false);
    }

    public String getUsername(){
        return mPrefs.getString(KEY_USERNAME,null);
    }

    public String getUserRole(){
        return mPrefs.getString(KEY_UserRole, null);
    }

}
