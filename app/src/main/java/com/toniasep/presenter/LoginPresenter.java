/**
 * TONI App.
 * Tanggal Pengerjaan: 16 Agustus 2019
 * NIM: 10116308
 * Nama: Asep Toni
 * Kelas: IF-7
 */


package com.toniasep.presenter;

import android.content.Context;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

import com.toniasep.MainActivity;
import com.toniasep.model.Login;
import com.toniasep.model.User;

import io.realm.Realm;
import io.realm.RealmResults;

public class LoginPresenter{
    public void btnLoginClicked(Context context, EditText inputEmail, EditText inputPassword){
        if(inputEmail.getText().toString().equals("") || inputPassword.getText().toString().trim().equals("")){
            Toast.makeText(context, "Email dan password harus diisi", Toast.LENGTH_SHORT).show();
        }else{
            Realm.init(context);
            Realm realm = Realm.getDefaultInstance();
            RealmResults<User> users = realm.where(User.class)
                    .contains("email",inputEmail.getText().toString()).and()
                    .contains("password",inputPassword.getText().toString()).findAll();
            if(users.size() > 0){
                realm.beginTransaction();
                Login login = realm.createObject(Login.class,1);
                login.setEmail(inputEmail.getText().toString());
                login.setPassword(inputPassword.getText().toString());
                login.setLoginStatus(true);
                realm.commitTransaction();
                Intent intent = new Intent(context, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                context.startActivity(intent);
            }else{
                Toast.makeText(context, "email atau password salah", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
