package nl.besuikerd.imageloader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.SparseArray;

public class DefaultImageLoaderManager implements ImageLoaderManager{
	
	/**
	 * The path to store the images to.
	 */
	public static final String PATH = "nl/besuikerd/imageloader";
	
	/**
	 * Maximum size of the cache
	 */
	public static final int MAXIMUM_CACHE_SIZE = 100;
	
	
	/**
	 * Memory cache for the loaded bitmaps.
	 */
	private static final SparseArray<Bitmap> cache = new SparseArray<Bitmap>();
	
	/**
	 * Map that keeps a reference of the current active tasks.
	 */
	private Map<Object, ImageLoadingTask> loadingTasks;
	
	/**
	 * Reference of the path where the images are saved.
	 */
	private File dir;
	
	
	/**
	 * Constructs a new DefaultImageLoaderManager
	 * @param context the current context
	 */
	public DefaultImageLoaderManager() {
		loadingTasks = new HashMap<Object, ImageLoadingTask>();
	}
	
	public Bitmap retrieveBitmap(String url) throws IOException{
		int hash = url.hashCode();
		Bitmap bmp = null;
		//Check if image is cached
		synchronized(cache){
			if((bmp = cache.get(hash)) != null){
				return bmp;
			}
		}
		if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
			if(dir == null){
				dir = new File(Environment.getExternalStorageDirectory(), PATH);
				if(!dir.exists()){
					dir.mkdirs();
				}
			}
			File f = new File(dir, "" + hash);
			if(f.exists()){
				bmp = BitmapFactory.decodeFile(f.getAbsolutePath());
			} else{
				bmp = BitmapFactory.decodeStream(new URL(url).openStream());
				FileOutputStream fOut = new FileOutputStream(f);
				bmp.compress(CompressFormat.PNG, 100, fOut);
				fOut.flush();
				fOut.close();
			}
		}
		if(bmp != null){
			//ENSURE CACHE IS NOT AT ITS MAX
			if(cache.size() >= MAXIMUM_CACHE_SIZE -1){
				synchronized(cache){
					cache.remove(cache.keyAt(0));
				}
			}
			synchronized(cache){
				cache.put(hash, bmp);
			}
		}
		return bmp;
	}
	
	@Override
	public void postImage(ImageLoadingHandler handler) {
		ImageLoadingTask task = new ImageLoadingTask(this, handler);
		synchronized(loadingTasks){
			ImageLoadingTask prevTask = loadingTasks.put(handler.getReference(), task);
			if(prevTask != null){
				prevTask.cancel(true);
			}
		}
		task.execute();
	}
	
	@Override
	public void flushCache() {
		cache.clear();
	}
}
