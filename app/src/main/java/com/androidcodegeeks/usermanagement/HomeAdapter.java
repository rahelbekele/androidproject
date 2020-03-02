package com.androidcodegeeks.usermanagement;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.androidcodegeeks.user.R;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeHolder>  {
    ArrayList<Home> homeArrayList;
    Context context;
    Home home;
    public HomeAdapter(ArrayList<Home> homeArrayList, Context context) {
        this.homeArrayList = homeArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public HomeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.listuser,null);
        return new HomeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final HomeHolder holder, final int position) {
        final Home home = homeArrayList.get(position);
        holder.fullname.setText(home.getFullname());
//        holder.email.setText(home.getEmail());
//        holder.phone.setText(Integer.toString(home.getPhoneN()));
//        holder.username.setText(home.getUsername());
//        holder.password.setText(home.getPassword());
//        holder.gender.setText(home.getGender());

        holder.setItemClickListner(new ItemClickListner() {
            @Override
            public void itemOnClickListener(View view, int postion) {
                    Intent intent = new Intent(context, ViewDetailActivity.class);
                    String fullnameTitle = homeArrayList.get(postion).getFullname();
                    String email = homeArrayList.get(postion).getEmail();
                    String username = homeArrayList.get(postion).getUsername();
                    String password = homeArrayList.get(postion).getPassword();
                    String gender = homeArrayList.get(postion).getGender();

                    intent.putExtra("fullname", fullnameTitle);
                    intent.putExtra("email",email);
                    intent.putExtra("username",username);
                    intent.putExtra("password",password);
                    intent.putExtra("gender",gender);
                    context.startActivity(intent);
                }
        });
        holder.setItemLongListner(new ItemLongListner() {
            @Override
            public void itemOnLongListener(View view, int postion) {
              removeItem(home);
            }
        });
    }

    private void removeItem(Home home) {
        int curPosition = homeArrayList.indexOf(home);
        homeArrayList.remove(curPosition);
        notifyItemRemoved(curPosition);
    }

    @Override
    public int getItemCount() {
        return homeArrayList.size();
    }

}
