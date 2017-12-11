package org.rescue.App;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
//import android.view.View.OnClickListener;
import android.widget.Button;

public class Home extends Activity {
	public Button CameraButton,ManualButton;
	
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.homescreen);
		//addButtonListener();
		
		
	}
	public void StartVideoButtonClick(View v)
	{
        		Intent ResuceIntent = new Intent(Home.this,VideoManager.class);

		        startActivity(ResuceIntent);
		
	}
	public void ManualButtonClick(View v)
	{
		/*
		ManualButton = (Button) findViewById(R.id.ManualButton);
		
		setContentView(R.layout.manualcontrol);
	*/
		Intent ManualIntent = new Intent(Home.this,ManualControl.class);

		startActivity(ManualIntent);
		
		
	}
	public void HelpButtonClick(View v)
	{
		/*
		ManualButton = (Button) findViewById(R.id.ManualButton);
		
		setContentView(R.layout.manualcontrol);
	*/
		Intent HelpIntent = new Intent(Home.this,Help.class);

		startActivity(HelpIntent);
		
		
	}

}
