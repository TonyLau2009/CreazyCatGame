package jocelyn_test02.com.creazycatgame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

/**
 * Created by Jocelyn on 23/7/2016.
 */
public class Playground extends SurfaceView implements Runnable{
    Thread t = null;
    SurfaceHolder holder;
    boolean isItOk = false;
    Bitmap ball = BitmapFactory.decodeResource(getResources(), R.drawable.a3);
    float x=0;
    float y =0;
//构造器
    public Playground(Context context) {
        super(context);

        holder = getHolder();

    }

//线程run() 重写
    @Override
    public void run() {

        while (isItOk) {

            if (!holder.getSurface().isValid()) {
                continue;
            }
            Canvas c = holder.lockCanvas();
            c.drawARGB(255, 159, 150, 43);
            c.drawBitmap(ball,x,y,null);
            holder.unlockCanvasAndPost(c);
        }

    }

    public void pause() {
        isItOk = false;

        while (true) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            break;
        }
        t = null;
    }

    public void resume() {
        isItOk = true;
        t = new Thread(this);
        t.start();
    }


}
