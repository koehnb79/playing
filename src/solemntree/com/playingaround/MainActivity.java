package solemntree.com.playingaround;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class MainActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		theview seen=new theview(this);
		seen=(theview)findViewById(R.id.surface);


        //	theview blue=new theview(this);
	//	seen=blue;
		
    }
}
