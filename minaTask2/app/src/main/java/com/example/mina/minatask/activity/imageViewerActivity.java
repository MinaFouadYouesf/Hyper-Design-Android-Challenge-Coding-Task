package com.example.mina.minatask.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.mina.minatask.model.productObject;
import com.example.mina.minatask.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class imageViewerActivity extends AppCompatActivity {

    ImageView imageView;
    Button next, last;
    List<productObject> data = new ArrayList<>();
    int postion;
    int x = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_viewer);
        Intent i = getIntent();
        Bundle b = i.getBundleExtra("bundle");
        data = b.getParcelableArrayList("image");
        postion = b.getInt("postion");
        imageView = (ImageView) findViewById(R.id.imageViewer);
        next = (Button) findViewById(R.id.next);
        last = (Button) findViewById(R.id.last);

        Log.d("ffffffffff", String.valueOf(postion) + "  " + String.valueOf(data.size()));
        Picasso.with(imageViewerActivity.this)
                .load(data.get(postion).getImage().getUrl())
                .resize(50, 100)
                .into(imageView);
        x = postion;
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x++;
                if (x < data.size()) {
                    Picasso.with(imageViewerActivity.this)
                            .load(data.get(x).getImage().getUrl())
                            .resize(50, 100)
                            .into(imageView);
                } else {
                    x = data.size();
                }
            }
        });
        last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x--;
                if (x >= 0) {
                    Picasso.with(imageViewerActivity.this)
                            .load(data.get(x).getImage().getUrl())
                            .resize(50, 100)
                            .into(imageView);
                } else {
                    x = 0;
                }
            }
        });
    }
}
