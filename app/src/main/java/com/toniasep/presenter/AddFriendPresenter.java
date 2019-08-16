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
import com.toniasep.model.Friend;

import io.realm.Realm;

public class AddFriendPresenter {
    public void btnAddClicked(Context context,
                              EditText inputNim,
                              EditText inputName,
                              EditText inputKelas,
                              EditText inputTlp,
                              EditText inputIg,
                              EditText inputEmail
    ){
        if(!(inputNim.getText().toString().equals("") ||
                inputName.getText().toString().trim().equals("") ||
                inputKelas.getText().toString().trim().equals("") ||
                inputTlp.getText().toString().trim().equals("") ||
                inputIg.getText().toString().trim().equals("") ||
                inputEmail.getText().toString().trim().equals("")
        )){
                Realm.init(context);
                Realm realm = Realm.getDefaultInstance();
                realm.beginTransaction();
                Number num = realm.where(Friend.class).max("id");
                int nextID;
                if(num == null) {
                    nextID = 1;
                } else {
                    nextID = num.intValue() + 1;
                }
                Friend friend = realm.createObject(Friend.class,nextID);
                friend.setNim(inputNim.getText().toString());
                friend.setNama(inputName.getText().toString());
                friend.setKelas(inputKelas.getText().toString());
                friend.setTelepon(inputTlp.getText().toString());
                friend.setInstagram(inputIg.getText().toString());
                friend.setEmail(inputEmail.getText().toString());
                realm.commitTransaction();
                Toast.makeText(context, "Berhasil menambah teman", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                context.startActivity(intent);
        }else{
            Toast.makeText(context, "Form harus di isi", Toast.LENGTH_SHORT).show();
        }
    }
}
