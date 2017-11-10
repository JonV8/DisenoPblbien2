package com.example.peperoni.disenopbl.fragapp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.peperoni.disenopbl.R;

/**
 * Created by Kristian on 26/10/2017.
 */

public class FragGaleria extends Fragment{

    private Integer[] images={R.drawable.tienda1,R.drawable.tienda2,R.drawable.tienda3,
            R.drawable.tienda4,R.drawable.tienda5,R.drawable.tienda6};
    private ImageView imageview;
    private View miVista;
    private Gallery imgGallery;
    private Context contexto;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.fragmentogaleria);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        miVista = inflater.inflate(R.layout.fragmentogaleria,container,false);
        imgGallery = (Gallery) miVista.findViewById(R.id.gallery);

        contexto = miVista.getContext().getApplicationContext();

        return miVista;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        imgGallery.setAdapter(new ImageAdapter(contexto));
        imageview = (ImageView) miVista.findViewById(R.id.imageView);
        imgGallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3) {
                Toast.makeText(contexto, "Image " + arg2,Toast.LENGTH_SHORT).show();
                imageview.setImageResource(images[arg2]);
            }
        });
        super.onViewCreated(view, savedInstanceState);
    }

    public class ImageAdapter extends BaseAdapter {
        private Context context;
        int imageBackground;

        public ImageAdapter(Context context) {

            this.context = context;
        }

        @Override
        public int getCount() {

            return images.length;
        }

        @Override
        public Object getItem(int arg0) {

            return arg0;
        }

        @Override
        public long getItemId(int arg0) {

            return arg0;
        }

        @Override
        public View getView(int arg0, View arg1, ViewGroup arg2) {

            ImageView imageView = new ImageView(context);
            imageView.setImageResource(images[arg0]);
            return imageView;
        }
    }
}