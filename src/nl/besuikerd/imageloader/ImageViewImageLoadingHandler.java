package nl.besuikerd.imageloader;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

/**
 * ImageLoadingHandler used to asynchronously load Bitmaps into an ImageView
 * @author nicker
 * @see ImageLoadingHandler
 */
public class ImageViewImageLoadingHandler implements ImageLoadingHandler{

	/**
	 * Constant for the constructor to indicate there should be no placeholder image.
	 */
	public static final int NO_PLACEHOLDER = Integer.MIN_VALUE;
	
	/**
	 * Imageview reference
	 */
	private ImageView imageView;
	
	/**
	 * Url reference
	 */
	private String url;

	/**
	 * Context reference
	 */
	private Context context;
	
	/**
	 * Placeholder image id reference
	 */
	private int placeholderImage;
	
	/**
	 * Constructs a new ImageViewImageLoadingHandler
	 * @param context application context
	 * @param imageView ImageView to load a Bitmap for
	 * @param url Url to the Bitmap
	 * @param placeholderImage id of a Placeholder image, use NO_PLACEHOLDER if you do not want one.
	 */
	public ImageViewImageLoadingHandler(Context context, ImageView imageView, String url, int placeholderImage) {
		this.imageView = imageView;
		this.url = url;
		this.context = context;
		this.placeholderImage = placeholderImage;
	}
	
	/**
	 * Constructs a new ImageViewImageLoadingHandler
	 * @param context application context
	 * @param imageView ImageView to load a Bitmap for
	 * @param url Url to the Bitmap
	 */
	public ImageViewImageLoadingHandler(Context context, ImageView imageView, String url){
		this(context, imageView, url, NO_PLACEHOLDER);
	}

	@Override
	public void onBitmapLoaded(Bitmap bmp) {
		final Bitmap bitmap = bmp;
		final ImageView iv = imageView;
		((Activity)context).runOnUiThread(new Runnable(){
			public void run() {
				iv.setImageBitmap(bitmap);
			}
		});
	}

	@Override
	public Object getReference() {
		return imageView;
	}

	@Override
	public String getUrl() {
		return url;
	}

	@Override
	public void onPreExecute() {
		if(placeholderImage != NO_PLACEHOLDER){
			imageView.setImageResource(placeholderImage);
		}
	}

	@Override
	public void onFailure() {
		imageView.setImageBitmap(null);
	}
}
