package nl.besuikerd.imageloader;

import java.io.IOException;

import android.graphics.Bitmap;

public interface ImageLoaderManager {

	/**
	 * Fetches a Bitmap from a remote location and returns it. This method isn't
	 * asynchronous, for async image loading you should use
	 * {@link #postImage(ImageReference)} instead.
	 * 
	 * @param url
	 * @return
	 * @throws IOException
	 */
	public Bitmap retrieveBitmap(String url) throws IOException;

	/**
	 * Empties the Manager's cache, if any
	 */
	public void flushCache();
	
	/**
	 * Asynchronous method to load an image.
	 * @param handler
	 * @see ImageLoadingHandler
	 */
	public void postImage(ImageLoadingHandler handler);
}
