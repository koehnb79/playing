package solemntree.com.playingaround;

import android.content.*;
import android.graphics.*;
import android.view.*;
import android.util.*;
import android.graphics.drawable.shapes.*;

public class theview extends SurfaceView implements SurfaceHolder.Callback
{
    private SurfaceHolder hold;
	private boolean done=false;
    public theview(Context con)
	{
		super(con);
		init();
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
		while (!done)
		{
	   can.drawColor(Color.GREEN);
			
			can.drawColor(Color.RED);
			
			can.drawColor(Color.BLUE);
	   //Shape circle=new Shape(
	   }
	}
	public void surfaceCreated(SurfaceHolder holder)
	{
		Log.d("Solemntree", "Made it here!");
		 Canvas canvas = null;
        try {
            canvas = holder.lockCanvas();
			final Canvas bill=canvas;
            synchronized(holder) {
                new Thread(new Runnable() {

						public void run()
						{
							
							onDraw(bill);
							// TODO: Implement this method
						}
						
					
				}).start();
				new Thread(new Runnable() {

						public void run()
						{
							
							Paint painter=new Paint();
							Circles billy=new Circles(bill, painter);
							done=true;
							
							// TODO: Implement this method
						}
						
					
				}).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (canvas != null) {
                holder.unlockCanvasAndPost(canvas);
            }
		}
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
		this.setBackgroundColor(Color.BLUE);
		
		this.hold = this.getHolder();
		this.hold.addCallback(this);
		this.hold.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
	}
    private class Circles extends Shape 
	{
        public Circles(Canvas can, Paint paint)
		{
			draw(can, paint);
		}
		public void draw(Canvas can, Paint painter)
		{
			can.drawCircle((can.getWidth()-10)/2, (can.getHeight()-10)/2, 20, painter);
			// TODO: Implement this method
		}
		
		
	}
}
