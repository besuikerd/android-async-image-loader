package nl.besuikerd.imageloader;

import java.io.IOException;

import android.graphics.Bitmap;
import android.os.AsyncTask;

/**
 * AsyncTask to load images
 * @author nicker
 *
 */
public class ImageLoadingTask extends AsyncTask<Object, Object, Bitmap>{
	
	/**
	 * ImageLoaderManager reference
	 */
	private ImageLoaderManager manager;
	
	/**
	 * ImageLoadingHandler reference
	 */
	private ImageLoadingHandler handler;
	
	/**
	 * boolean check wheter or not the task succeeded
	 */
	private boolean succes = false;

	/**
	 * Constructs a new ImageLoadingTask
	 * @param manager manager
	 * @param handler handler
	 */
	public ImageLoadingTask(ImageLoaderManager manager,
			ImageLoadingHandler handler) {
		this.manager = manager;
		this.handler = handler;
	}

	@Override
	public Bitmap doInBackground(Object... params) {
		Bitmap bmp = null;
		try {
			bmp = manager.retrieveBitmap(handler.getUrl());
			succes = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bmp;
	}
	
	@Override
	public void onPreExecute() {
		handler.onPreExecute();
	}
	
	@Override
	public void onPostExecute(Bitmap result) {
		if(!isCancelled()){
			if(succes){
				handler.onBitmapLoaded(result);
				succes = false;
			} else{
				handler.onFailure();
			}
		}
	}
}
