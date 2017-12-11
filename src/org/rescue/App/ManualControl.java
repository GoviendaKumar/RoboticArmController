package org.rescue.App;

import android.app.Activity;
import android.os.Bundle;
//import android.util.Log;
//import android.view.Gravity;
//import android.widget.Toast;

public class ManualControl extends Activity 
{
	
	//Toast t =new Toast(ManualControl.this);
	
	
	public void  onCreate(Bundle savedInstanceState)
	{
		/*
		Toast toast= Toast.makeText(getApplicationContext(),"Manual Controlling" , Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.CLIP_VERTICAL,0,0);
		toast.show();
		*/
		//Log.i(TAG, "called onCreateOptionsMenu");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.manualcontrol);
	}

}
