package com.app.isb_bs2.bs;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.app.isb_bs2.bs.databinding.ActivityLoginBinding;
import com.app.isb_bs2.bs.handler.LoginHandler;
import com.nifty.cloud.mb.core.DoneCallback;
import com.nifty.cloud.mb.core.NCMBException;
import com.nifty.cloud.mb.core.NCMBObject;

import io.realm.Realm;
import io.realm.SyncCredentials;
import io.realm.SyncUser;

import static android.R.attr.password;

/**
 * Created by sayi65 on 2017/10/01.
 */

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "Login";
    private ActivityLoginBinding binding;
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        binding.setHandler(new LoginHandler(this));
    }
}
