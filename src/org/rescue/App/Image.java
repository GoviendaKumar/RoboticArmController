package org.rescue.App;

import org.opencv.android.Utils;
import org.opencv.core.Mat;
import org.rescue.App.VideoManager;
import android.app.Activity;
import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
import android.os.Bundle;
//import android.widget.TextView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;



public class Image extends Activity {

	  
	//private Image img;
	public Bitmap bmp;
	private TextView mShowImg;
	
   private VideoManager VideoM = new VideoManager();
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.image);
		/*
		Bundle b= getIntent().getExtras();
		
		TextView name= (TextView) findViewById(R.id.Tv);
		name.setText(b.getCharSequence("Name"));
		*/
	}
	@Override
	public void onResume()
	{
		super.onResume();
	//    img.ConvertFrametoImage(CurrentFrame);
		String CurrentFrame;
		CurrentFrame =VideoM.getframe(); 
		/*
		 bmp= Bitmap.createBitmap(CurrentFrame.cols(),CurrentFrame.rows(),Bitmap.Config.ARGB_8888);
		 try {
			Utils.matToBitmap(CurrentFrame, bmp);
		} catch (Exception e) {
			Log.i("OpenCV", "Failed to Use OpenCV" + e.getMessage());
		}
	    mShowImg = (ImageView) findViewById(R.id.image_one);
		//bmp= BitmapFactory.decodeResource(getResources(), R.drawable.backward);
	    mShowImg.setImageBitmap(bmp);
	    */
		mShowImg = (TextView) findViewById(R.id.Tv);
		mShowImg.setText(CurrentFrame);
	}
	/*
	public void ConvertFrametoImage(Mat frame)
	{
		 bmp= Bitmap.createBitmap(frame.cols(),frame.rows(),Bitmap.Config.ARGB_8888);
		 try {
			Utils.matToBitmap(frame, bmp);
		} catch (Exception e) {
			Log.i("OpenCV", "Failed to Use OpenCV" + e.getMessage());
		}
	}
	*/
	

}
