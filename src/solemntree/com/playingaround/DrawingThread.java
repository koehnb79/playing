package solemntree.com.playingaround;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

/**
 * Created by Brad on 9/14/13.
 */
public class DrawingThread extends Thread {
    private SurfaceHolder drawingHolder;
    private theview drawingSurface;
    private boolean run = false;

    public DrawingThread(SurfaceHolder surfaceholder, theview surfaceview) {
        drawingHolder = surfaceholder;
        drawingSurface = surfaceview;
    }

    public void setRunning(boolean running) {
        run = running;
    }

    @Override
    public void run() {
        Canvas c;
        while (run) {
            c = null;
            try {
                c = drawingHolder.lockCanvas(null);
                if (c != null) {
                    synchronized (drawingHolder) {
                        drawingSurface.onDraw(c);
                    }
                }
            }finally {
                if (c != null)
                    drawingHolder.unlockCanvasAndPost(c);
            }

        }
    }

}