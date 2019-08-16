/**
 * TONI App.
 * Tanggal Pengerjaan: 16 Agustus 2019
 * NIM: 10116308
 * Nama: Asep Toni
 * Kelas: IF-7
 */

package com.toniasep.view;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.toniasep.R;
import com.toniasep.model.Friend;

import java.util.ArrayList;

public class FriendListAdaptor extends ArrayAdapter<Friend> {
    private  static final String TAG = "PersonListAdapter";

    private Context mContext;
    int mResource;

    public FriendListAdaptor(Context context, int resource, ArrayList<Friend> objects){
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        String nama = getItem(position).getNama();
        String noTLp = getItem(position).getTelepon();
        final int id = getItem(position).getId();

        Friend person = new Friend(nama,noTLp);
        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource,parent,false);

        TextView tvName = (TextView) convertView.findViewById(R.id.name);
        TextView tvTlp = (TextView) convertView.findViewById(R.id.notlp);
        Button btnMore = (Button) convertView.findViewById(R.id.buttonMore);
        btnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentDetailTemanView = new Intent(getContext(), FriendDetailActivity.class);
                intentDetailTemanView.setFlags(intentDetailTemanView.getFlags()|intentDetailTemanView.FLAG_ACTIVITY_NO_HISTORY);
                intentDetailTemanView.putExtra("data",id);
                getContext().startActivity(intentDetailTemanView);
            }
        });

        tvName.setText(nama);
        tvTlp.setText(noTLp);
        return convertView;
    }


}
