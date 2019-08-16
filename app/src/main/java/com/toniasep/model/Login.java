/**
 * TONI App.
 * Tanggal Pengerjaan: 16 Agustus 2019
 * NIM: 10116308
 * Nama: Asep Toni
 * Kelas: IF-7
 */

package com.toniasep.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Login extends RealmObject {
    @PrimaryKey
    private int id;
    private String email;
    private String password;
    private Boolean loginStatus;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getLoginStatus() {
        return loginStatus;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLoginStatus(Boolean loginStatus) {
        this.loginStatus = loginStatus;
    }
}
