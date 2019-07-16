package com.app.isb_bs2.bs.handler;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.app.isb_bs2.bs.LoginActivity;
import com.app.isb_bs2.bs.MainActivity;
import com.app.isb_bs2.bs.MainApplication;
import com.app.isb_bs2.bs.R;

import io.realm.ObjectServerError;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.SyncConfiguration;
import io.realm.SyncCredentials;
import io.realm.SyncUser;
import io.realm.log.RealmLog;

import static android.R.attr.password;
import static com.app.isb_bs2.bs.MainApplication.AUTH_URL;

/**
 * Created by sayi65 on 2017/10/01.
 */

public class LoginHandler implements SyncUser.Callback {

    public LoginActivity loginActivity;
    private View mRootView;
    public SyncUser user;

    public LoginHandler(LoginActivity loginActivity){
        this.loginActivity = loginActivity;
    }

    public void onLogin(View view){
        RealmLog.setLevel(Log.VERBOSE);
        mRootView = view.getRootView();
        EditText inputEmail = (EditText)mRootView.findViewById(R.id.input_email);
        EditText inputPasswd = (EditText)mRootView.findViewById(R.id.input_password);

        if(inputEmail.getText() != null && inputPasswd.getText() != null){
            inputEmail.setText("xxxx@xxxx.com");
            inputPasswd.setText("xxxxx");

            SyncCredentials credentials = SyncCredentials.usernamePassword("xxxx@xxxx.com", "xxxxx", false);
            SyncUser.loginAsync(credentials, MainApplication.AUTH_URL, this );

        }
    }

    @Override
    public void onSuccess(SyncUser syncUser) {

        Toast.makeText(loginActivity, "成功", Toast.LENGTH_LONG).show();
        SyncConfiguration config = new SyncConfiguration.Builder(SyncUser.currentUser(), MainApplication.syncServerURL)
                .build();
        Realm.setDefaultConfiguration(config);

        Intent intent = new Intent(loginActivity, MainActivity.class);
        loginActivity.startActivity(intent);

    }

    @Override
    public void onError(ObjectServerError objectServerError) {
        Toast.makeText(loginActivity, objectServerError.toString(), Toast.LENGTH_LONG).show();
    }

}
