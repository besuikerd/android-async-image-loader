package nl.besuikerd.imageloader.example;

import nl.besuikerd.imageloader.DefaultImageLoaderManager;
import nl.besuikerd.imageloader.ImageLoaderManager;
import nl.besuikerd.imageloader.ImageViewImageLoadingHandler;
import nl.besuikerd.imageloader.R;
import nl.besuikerd.viewholder.ViewHolder;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class TestViewHolder implements ViewHolder<TestReference>{

	private TextView tv;
	private ImageView iv;
	
	@Override
	public void setFields(View inflatedView) {
		tv = (TextView) inflatedView.findViewById(R.id.test_textview);
		iv = (ImageView) inflatedView.findViewById(R.id.test_imageview);
	}

	@Override
	public View inflate(Context context) {
		return ((LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.viewholder_test, null);
	}

	@Override
	public void refresh(Context context, TestReference model) {
		tv.setText(model.getTitle());
		ImageLoaderManager imageLoader = new DefaultImageLoaderManager();
		imageLoader.postImage(new ImageViewImageLoadingHandler(context, iv, model.getUrl()));
	}
}
