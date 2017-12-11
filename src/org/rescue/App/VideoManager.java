
package org.rescue.App;


import java.util.Date;
import java.text.SimpleDateFormat;

import org.opencv.android.BaseLoaderCallback;

import org.opencv.android.CameraBridgeViewBase;
//import org.opencv.android.CameraBridgeViewBase.CvCameraViewFrame;
import org.opencv.android.CameraBridgeViewBase.CvCameraViewListener;
//import org.opencv.android.CameraBridgeViewBase.CvCameraViewListener2;
import org.opencv.android.LoaderCallbackInterface;
import org.opencv.android.OpenCVLoader;
import org.opencv.core.Mat;
//import org.opencv.android.CameraBridgeViewBase;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;


//import android.graphics.Bitmap;
import android.view.View.OnTouchListener;

import android.view.MotionEvent;
import android.os.Bundle;
import android.os.Environment;
//import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;

//import android.widget.ImageView;

import android.widget.Toast;

public class VideoManager extends Activity  implements CvCameraViewListener , OnTouchListener{
    /** Called when the activity is first created. */
   
     
    private static final String TAG = "OCVSample::Activity";
   // private Button mCameraButton;

    private Picture imageP;
 //   private CameraBridgeViewBase MyCameraView;
    
   private boolean              mIsJavaCamera = true;
         public String Frame ="Hammad";
   private MenuItem             mItemStartAutomaticMode= null,mItemConnecttoArduino=null,mItemConnecttoLaptop=null,mItemImage=null;
  // private MenuItem             mItemSwitchCamera = null;
    private BaseLoaderCallback mLoaderCallback = new BaseLoaderCallback(this) {
        @Override
        public void onManagerConnected(int status) {
            switch (status) {
                case LoaderCallbackInterface.SUCCESS:
                {
                    Log.i(TAG, "OpenCV loaded successfully");
                 //  MyCameraView.enableView();
                  //MyCameraView.setOnTouchListener(VideoManager.this);
                   imageP.enableView();
                    imageP.setOnTouchListener(VideoManager.this);
                    break;
                }
                default:
                {
                    super.onManagerConnected(status);
                   break;
                }
            }
        }
    };

    public VideoManager()
    {
    	Log.i(TAG, "Instantiated new " + this.getClass());
    }

    
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.main);
        
       // if (mIsJavaCamera)
       //     MyCameraView = (CameraBridgeViewBase) findViewById(R.id.JavaCameraView);
        imageP = (Picture) findViewById(R.id.Immage);
        /*
        else
           MyCameraView = (CameraBridgeViewBase) findViewById(R.id.NativeCameraView);
        */
       // MyCameraView.setVisibility(SurfaceView.VISIBLE);
       // MyCameraView.setCvCameraViewListener(this);
         imageP.setVisibility(SurfaceView.VISIBLE);
        imageP.setCvCameraViewListener(this);
       
   
      
      
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
    	mItemStartAutomaticMode = menu.add("Start Automatic Mode");
    	mItemConnecttoArduino = menu.add("Connect to Arduino");
    	mItemConnecttoLaptop= menu.add("Connect to Laptop");
    	mItemImage= menu.add("Take Image");
    	return true;
    }
    
   
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
    	if(item==mItemStartAutomaticMode)
    	{
    		Toast.makeText(getApplicationContext(), "Automatic mode Started", Toast.LENGTH_LONG).show();
    	}
    	else if(item==mItemConnecttoArduino)
    	{
    		Toast.makeText(getApplicationContext(), "Bluetooth ON", Toast.LENGTH_LONG).show();
    	}
    	else if(item==mItemConnecttoLaptop)
    	{
    		Toast.makeText(getApplicationContext(), "Wi-Fi ON", Toast.LENGTH_LONG).show();
    	}
    	else if(item==mItemImage)
    	{
    		// How to pass data from one activity to another.
    		Intent ResuceIntent = new Intent(VideoManager.this,Image.class);
    		 /*
    		Bundle b = new Bundle();
             b.putString("Name","Hammad");
             ResuceIntent.putExtras(b);
    		
    		//onCameraFrame(Image);  
    		 * 		
    		 */
    		 startActivity(ResuceIntent);
    		
    	    
    		
    	}
    	return true;
    }
    
  
	@Override
    public void onPause()
    {
		
		/*
        if (MyCameraView != null)
        	MyCameraView.disableView();
        */
		if (imageP != null)
        	imageP.disableView();
		super.onPause();
    }
    
    @Override
    public void onResume()
    {
        super.onResume();
        OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION_2_4_3, this, mLoaderCallback);
    }

    public void onDestroy() {
        
        /*if (MyCameraView != null)
        	MyCameraView.disableView();*/
    	super.onDestroy();
    	if (imageP != null)
        	imageP.disableView();
       
    }
    
  
    public void onCameraViewStarted(int width, int height)
    {

    }
    public void onCameraViewStopped()
    {

    }
    public Mat onCameraFrame(Mat inputFrame)
    {
        
    	return inputFrame;
    	
    }
    @SuppressLint("SimpleDateFormat")
  @Override
    public boolean onTouch(View v, MotionEvent event) {
        Log.i(TAG,"onTouch event");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String currentDateandTime = sdf.format(new Date());
        String fileName = Environment.getExternalStorageDirectory().getPath() +
                "/sample_picture_" + currentDateandTime + ".jpg";
    //	myImagePicture= (Picture) findViewById(R.id.JavaCameraView); 
      
   
    imageP.takePicture(fileName);
        Toast.makeText(this, fileName + "saved successfully", Toast.LENGTH_SHORT).show();
        return false;
    }
   
    public void SettingsButtonClick(View v)
    {
    	openOptionsMenu();
        	
    }
    public String getframe()
    {

    	return Frame;
    }
    
   
    /*
    public void takePicture(final String fileName) {
        Log.i(TAG, "Tacking picture");
        };
        
        }
        */
   
    /*
    public void MattoBitmap(Mat Incoming_Image, String name)
    {
    	Bitmap bmp = Bitmap.createBitmap(Incoming_Image.cols(), Incoming_Image.rows(), Bitmap.Config.ARGB_8888);
    	Utils.matToBitmap(Incoming_Image, bmp);
    	 
    }
    */
   
}