package jocelyn_test02.com.creazycatgame;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public abstract class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    Playground p;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        p = new Playground(this);
        p.setOnTouchListener(this);
        setContentView(p);
    }



    @Override
    protected void onPause() {
        super.onPause();
        p.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        p.resume();
    }
    @Override
    public boolean onTouch(View p, MotionEvent me)
    {
        return false;
    }
}