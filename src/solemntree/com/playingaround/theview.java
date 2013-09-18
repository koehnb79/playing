package solemntree.com.playingaround;

import android.content.*;
import android.graphics.*;
import android.os.Handler;
import android.view.*;
import android.util.*;
import android.graphics.drawable.shapes.*;

import java.util.Random;

public class theview extends SurfaceView implements SurfaceHolder.Callback
{
    private DrawingThread drawingthread;
    private SurfaceHolder hold;
	private boolean done=false;
    private Canvas theCanvas;
    public Circles circle;
    public Circles circle2;
    private Paint painter;
    private int color;
    public theview(Context con)
	{
		super(con);
		init();


	}

    public void moveCircle(int x, int y)
    {

        //Paint painter=new Paint();
        //Circles billy=new Circles(theCanvas, painter);
    }
	public theview(Context con, AttributeSet attr)
	{
		super(con, attr);
		init();
	}
	public theview(Context con, AttributeSet attr , int defStyle)
	{
		super(con, attr, defStyle);
		init();
	}
	public void onDraw(Canvas can)
	{
            //Log.d("Solemntree", "in onDraw");
			can.drawColor(color);

            circle.draw(can, painter);
            circle2.draw(can,painter);

	}
	public void surfaceCreated(SurfaceHolder holder)
	{
		Log.d("Solemntree", "Made it here!");
		/* Canvas canvas = null;
        try {
            canvas = holder.lockCanvas();

            synchronized(holder) {
            	onDraw(canvas);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (canvas != null) {
                holder.unlockCanvasAndPost(canvas);
            }
		}*/
        drawingthread = new DrawingThread(getHolder(), this);
        drawingthread.setRunning(true);
        drawingthread.start();
        setFocusable(true);
		// TODO: Implement this method
	}

	public void surfaceChanged(SurfaceHolder p1, int p2, int p3, int p4)
	{
		// TODO: Implement this method
	}

	public void surfaceDestroyed(SurfaceHolder p1)
	{
		// TODO: Implement this method
	}
	
	public void init()
	{

        circle2=new Circles();
        circle=new Circles();
        painter=new Paint();
        color=Color.CYAN;
        circle.move(5,5);
        circle2.move(100,100);
        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Log.d("Solemntree", "made it to the touch!");
                synchronized (getHolder()) {
                for (int x=0; x<100; x++) {
                    circle.move(x,5);

                }
                    color=Color.RED;
                    invalidate();

                }
                return false;
            }
        });
        final Handler billers=new Handler();
		this.setBackgroundColor(Color.BLUE);

        new Thread(new Runnable() {
            public void run()
            {
                synchronized (theview.this.getHolder()) {
                Random number=new Random();
                int x=number.nextInt(200)+1;
                int y=number.nextInt(200)+1;


                circle2.move(x,y);
                invalidate();
                }
                billers.postDelayed(this, 1000);
            }
        }).start();
		this.hold = this.getHolder();
		this.hold.addCallback(this);
		this.hold.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
	}
    private class Circles extends Shape 
	{
        private int X;
        private int Y;
        private Canvas canvas;
        private Paint painter;
        public Circles()
		{
           // canvas=can;
           // X=(can.getWidth()-10)/2;
           // Y=(can.getHeight()-10)/2;
			//draw(can, paint);
		}
		public void draw(Canvas can, Paint painter)
		{
            Log.d("Solemntree", "made it to the circle draw");
			can.drawCircle(X, Y, 20, painter);
			// TODO: Implement this method
		}

        public void move(int x, int y)
        {
            X=x;
            Y=y;
          //  draw(canvas, painter);
        }
		
	}
}
