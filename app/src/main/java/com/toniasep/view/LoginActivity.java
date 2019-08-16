/**
 * TONI App.
 * Tanggal Pengerjaan: 16 Agustus 2019
 * NIM: 10116308
 * Nama: Asep Toni
 * Kelas: IF-7
 */

package com.toniasep.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.toniasep.MainActivity;
import com.toniasep.R;
import com.toniasep.model.Login;
import com.toniasep.presenter.LoginPresenter;

import io.realm.Realm;
import io.realm.RealmResults;

public class LoginActivity extends AppCompatActivity{
    private EditText inputEmail,inputPassword;
    private Button btnLogin,btnRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Realm.init(this);
        Realm realm = Realm.getDefaultInstance();
        RealmResults<Login> login = realm.where(Login.class).findAll();
        if(login.size() > 0){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        inputEmail = (EditText) findViewById(R.id.input_email);
        inputPassword = (EditText) findViewById(R.id.input_password);
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnRegister = (Button) findViewById(R.id.btn_register);
        // Created by 10116296 Mochamad Hijul M

        final LoginPresenter loginPresenter = new LoginPresenter();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.btnLoginClicked(getBaseContext(),inputEmail,inputPassword);
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), RegisterActivity.class);
                startActivity(intent);

            }
        });
    }
}
