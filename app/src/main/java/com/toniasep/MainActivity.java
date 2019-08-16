/**
 * TONI App.
 * Tanggal Pengerjaan: 16 Agustus 2019
 * NIM: 10116308
 * Nama: Asep Toni
 * Kelas: IF-7
 */

package com.toniasep;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.toniasep.view.AccountFragment;
import com.toniasep.view.ContactFragment;
import com.toniasep.presenter.FriendFragment;
import com.toniasep.view.HomeFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new HomeFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener=
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment  = null;
                    switch (menuItem.getItemId()){
                        case R.id.nav_home:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.nav_contact:
                            selectedFragment = new ContactFragment();
                            break;
                        case R.id.nav_friend:
                            selectedFragment = new FriendFragment();
                            break;
                        case R.id.nav_account:
                            selectedFragment = new AccountFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();
                    return true;
                }
            };


    public void Call(View view){
        Intent telepon = new Intent(Intent.ACTION_DIAL);
        telepon.setData(Uri.parse("tel:082283293360"));
        startActivity(telepon);

    }
    public void ig(View view){
        Intent ig = new Intent(Intent.ACTION_VIEW);
        ig.setData(Uri.parse("https://instagram.com/toniiasep"));
        startActivity(ig);

    }
    public void fb(View view){
        Intent fb = new Intent(Intent.ACTION_VIEW);
        fb.setData(Uri.parse("https://facebook.com/toniiasep"));
        startActivity(fb);

    }
    public void yt(View view){
        Intent yt = new Intent(Intent.ACTION_VIEW);
        yt.setData(Uri.parse("https://youtube.com/tonichannel"));
        startActivity(yt);

    }
    public void in(View view){
        Intent in = new Intent(Intent.ACTION_VIEW);
        in.setData(Uri.parse("https://www.linkedin.com/in/toniasep/"));
        startActivity(in);

    }

    public void email(View view){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"toniiasep@gmail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Hai Developer");
        intent.putExtra(Intent.EXTRA_TEXT,"isi pesan email ini dari aplikasi TONI App");
        intent.setType("message/rfc822");
        startActivity(intent);
    }

}
