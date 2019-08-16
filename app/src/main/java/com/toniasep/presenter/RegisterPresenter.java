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

import com.toniasep.model.User;
import com.toniasep.view.LoginActivity;

import io.realm.Realm;

public class RegisterPresenter {
    public void btnRegisterClicked(Context context,
                                   EditText inputName,
                                   EditText inputEmail,
                                   EditText inputPassword,
                                   EditText inputRepassword){
        if(!(inputName.getText().toString().equals("") ||
                inputEmail.getText().toString().trim().equals("") ||
                inputPassword.getText().toString().trim().equals("") ||
                inputRepassword.getText().toString().trim().equals("")
        )){
            if(!inputPassword.getText().toString().equals(inputRepassword.getText().toString())){
                Toast.makeText(context, "Password tidak sama", Toast.LENGTH_SHORT).show();

            }else{
                Realm.init(context);
                Realm realm = Realm.getDefaultInstance();
                realm.beginTransaction();
                Number num = realm.where(User.class).max("id");
                int nextID;
                if(num == null) {
                    nextID = 1;
                } else {
                    nextID = num.intValue() + 1;
                }
                User user = realm.createObject(User.class,nextID);
                user.setName(inputName.getText().toString());
                user.setEmail(inputEmail.getText().toString());
                user.setPassword(inputPassword.getText().toString());
                realm.commitTransaction();
                Toast.makeText(context, "Berhasil register", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                context.startActivity(intent);

            }
        }else{
            Toast.makeText(context, "Form harus di isi", Toast.LENGTH_SHORT).show();
        }
    }
}
