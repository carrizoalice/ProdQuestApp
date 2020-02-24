package com.amc.prodquestapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> implements View.OnClickListener{

    //para onclick implementar view.concliklistener arriba

    private ArrayList<MainModel> mainModels;
    private Context context;
    private View.OnClickListener listener; //para onclick

    public MainAdapter(Context context, ArrayList<MainModel> mainModels){
        this.context = context;
        this.mainModels = mainModels;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_item, parent, false);

        view.setOnClickListener(this); //escuchar el evento de seleccion

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.imageView.setImageResource(mainModels.get(position).getLangLogo());
    }

    @Override
    public int getItemCount() {
        return mainModels.size();
    }

    ////para onclick crear metodo publico
    public void setOnClickListener(View.OnClickListener listener){
        //que el listener q generamos arriba sea igual al listener q le llega
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if( listener != null){
            listener.onClick(view);
        }

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        private ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image_view);

        }
    }


}
