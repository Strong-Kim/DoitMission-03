package me.blog.sseyoung513.doitmission_03;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView topImage, bottomImage;
    BitmapDrawable bitmap;

    static int imageSwitch=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        topImage = (ImageView)findViewById(R.id.topImage) ;
        bottomImage = (ImageView)findViewById(R.id.bottomImage);

        Resources res = getResources();
        bitmap = (BitmapDrawable)res.getDrawable(R.drawable.image01);

        setImage(null, topImage);
    }
    public void setImage(ImageView oldImageView, ImageView newImageView){
        if (oldImageView != null) {
            oldImageView.setImageDrawable(null);
        }
        newImageView.setImageDrawable(bitmap);
        newImageView.getLayoutParams().width = bitmap.getIntrinsicWidth();
        newImageView.getLayoutParams().height = bitmap.getIntrinsicHeight();
    }

    public void onDownButtonClicked(View v){
        if (imageSwitch == 1){
            setImage(topImage, bottomImage);
            imageSwitch = 2;
        }
    }

    public void onUpButtonClicked(View v){
        if (imageSwitch == 2){
            setImage(bottomImage, topImage);
            imageSwitch = 1;
        }
    }
}
