package com.carloss2020.menub.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.carloss2020.menub.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> nNames=new ArrayList<>();
    private ArrayList<String> mImageneURL=new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapter( Context mContext,ArrayList<String> nNames, ArrayList<String> mImageneURL) {
        this.nNames = nNames;
        this.mImageneURL = mImageneURL;
        this.mContext=mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {


        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list_item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        Log.d(TAG,"onBindViewHolder:called.");
        Glide.with(mContext)
                .asBitmap()
                .load(mImageneURL.get(i))
                .into(viewHolder.image);

        viewHolder.name.setText(nNames.get(i));
        viewHolder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"onClick: clicked on an image :"+nNames.get(i));
                Toast.makeText(mContext,nNames.get(i),Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return mImageneURL.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView image;
        TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.image_view);
            name=itemView.findViewById(R.id.name_view);
        }
    }



}
