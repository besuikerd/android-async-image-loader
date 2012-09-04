package nl.besuikerd.imageloader;

import android.graphics.Bitmap;

/**
 * this class contains hooks that are called during an asynchronous fetch of a
 * Bitmap.
 * 
 * @author nicker
 * 
 */
public interface ImageLoadingHandler {
	/**
	 * This method should return an object where this handler can be referenced
	 * to. This is needed so that older tasks with the same reference get
	 * cancelled before a new asynchronous task is started.
	 * 
	 * @return a reference object
	 */
	public Object getReference();

	/**
	 * This method returns the remote Url for the Bitmap to be loaded
	 * @return
	 */
	public String getUrl();

	/**
	 * Hook that gets called before the asynchronous task is started
	 */
	public void onPreExecute();
	
	/**
	 * Hook that gets called after a Bitmap is succesfully retrieved.
	 * @param bmp
	 */
	public void onBitmapLoaded(Bitmap bmp);

	/**
	 * Hook that gets called after a Bitmap failed to be retrieved
	 */
	public void onFailure();

}
