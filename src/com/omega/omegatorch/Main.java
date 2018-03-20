package com.omega.omegatorch;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.hardware.Camera;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

public class Main extends Activity {
	
	public static int i = R.drawable.b_off;
	ImageButton b;
	Camera cam=Camera.open();
    Camera.Parameters params = cam.getParameters();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
         
         b = (ImageButton) findViewById(R.id.ImageButton1);
        b.setBackgroundResource(R.drawable.b_off);
       //  b.setImageResource(R.drawable.b_off);
        b.setOnClickListener(new OnClickListener(){
			@SuppressWarnings("deprecation")
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(i==R.drawable.b_off){
					 torchOn();
					 i=R.drawable.b_on;
					  b.setBackgroundResource(R.drawable.b_on);
				     
					} else {
					  torchOff();
						 i=R.drawable.b_off;
						  b.setBackgroundResource(R.drawable.b_off);
						
						}
			}});
	     
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		  // Inflate the menu items for use in the action bar
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.menubar, menu);
	    return super.onCreateOptionsMenu(menu);
	
	}
	
	public final void up(){
		  Context c=this;
			// On crée un utilitaire de configuration pour cette animation
		    Animation animation =
		    AnimationUtils.loadAnimation(c, R.anim.torch);
		    // On l'affecte au widget désiré, et on démarre l'animation
		    b.startAnimation(animation);
		    animation.setDuration(3000);
		} 

	public final void down(){
		  Context c=this;
			// On crée un utilitaire de configuration pour cette animation
		    Animation animation =
		    AnimationUtils.loadAnimation(c, R.anim.down);
		    // On l'affecte au widget désiré, et on démarre l'animation
		    b.startAnimation(animation);
		    animation.setDuration(3000);
	  	}
	
	public void torchOn(){
		 params.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
	     cam.setParameters(params);
	     Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
	    v.vibrate(150);
	}
	public void torchOff(){
		params.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
		 cam.setParameters(params);
		 Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		    v.vibrate(150);
	}


}
