package com.androidcodegeeks.usermanagement;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.androidcodegeeks.user.R;

public class HomeHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

    ItemClickListner itemClickListner;
    ItemLongListner itemLongListner;
    TextView fullname,email,phone,username,password,gender;

    public HomeHolder(@NonNull View itemView) {
        super(itemView);
        fullname = itemView.findViewById(R.id.listfullname);
//        email = itemView.findViewById(R.id.listemail);
//        phone = itemView.findViewById(R.id.listphone);
//        username = itemView.findViewById(R.id.listUserName);
//        password = itemView.findViewById(R.id.listpassword);
//        gender = itemView.findViewById(R.id.listgender);
        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
    }

    @Override
    public void onClick(View v) {
        this.itemClickListner.itemOnClickListener(v,getLayoutPosition());
    }
    public void setItemClickListner(ItemClickListner ic){
        this.itemClickListner = ic;
    }

    public void setItemLongListner(ItemLongListner ic){
        this.itemLongListner = ic;
    }

    @Override
    public boolean onLongClick(View v) {
        this.itemLongListner.itemOnLongListener(v,getLayoutPosition());
        return true;
    }
}
