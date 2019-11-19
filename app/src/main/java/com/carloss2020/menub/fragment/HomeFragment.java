package com.carloss2020.menub.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.carloss2020.menub.Adapter.RecyclerViewAdapter;
import com.carloss2020.menub.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private static final String TAG = "HomeFragment";

    private ArrayList<String> nNames=new ArrayList<>();
    private ArrayList<String> mImagenesURL=new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_home, container, false);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
         recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext(),LinearLayoutManager.HORIZONTAL,false));
        getImages();
        RecyclerViewAdapter adapter=new RecyclerViewAdapter(getContext(),nNames,mImagenesURL);
        recyclerView.setAdapter(adapter);
        return rootView;

    }

    private void getImages(){

        mImagenesURL.add("https://cdn.vox-cdn.com/thumbor/vLvtzdYojBac5j4PUN0YhsAjEBw=/0x0:1280x720/1200x800/filters:focal(422x254:626x458)/cdn.vox-cdn.com/uploads/chorus_image/image/63366012/maxresdefault.0.jpg");
        nNames.add("Tio W");

        mImagenesURL.add("http://www.cavsi.com/preguntasrespuestas/images/que-es-usuario.jpg");
        nNames.add("Tio W");

        mImagenesURL.add("https://img.culturacolectiva.com/cdn-cgi/image/f=auto,w=1600,q=80,fit=contain/featured_image/2017/12/20/1513813253402/captura-de-pantalla-2017-12-20-a-las-4-55-13-p-m.png");
        nNames.add("Tio W");

        mImagenesURL.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQdrlgU-ahQiN42t4PN34GSwWlK_0EkNZFI8jfS5fP7gC5I6BGJ&s");
        nNames.add("Tio W");
        Log.d(TAG,"lleno.");

    }

}
