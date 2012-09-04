package nl.besuikerd.viewholder;

import android.content.Context;
import android.view.View;

/**
 * This class is used to inflate and update views that are used in a
 * {@link ViewHolderListAdapter}. Implement a ViewHolder class for each type of
 * view you want to display in the list. The reason to use a ViewHolder is to
 * gain better performance since you do not have to inflate a new View each time
 * an item shows up in your list.
 * 
 * @author nicker
 * 
 * @param <E>
 *            The model(info) that you want to include in the view
 */
public interface ViewHolder<E> {

	/**
	 * <p>
	 * This method is called whenever a new View needs to be inflated to fill
	 * the screen. The easiest way is to inflate from an xml file here
	 * </p>
	 * 
	 * <tt>
	 * ((LayoutInflater)
	 * context.getSystemService(Context.LAYOUT_INFLATER_SERVICE
	 * )).inflate(YOUR_LAYOUT_ID, null)
	 * </tt>
	 * 
	 * @param context
	 *            application context
	 * @return
	 */
	public View inflate(Context context);

	/**
	 * <p>
	 * This method is called after a view is inflated. Use this method to bind
	 * your inflated View components to private variables, for increased
	 * performance since you do not need an added View lookup each time a View
	 * is recycled
	 * </p>
	 * 
	 * @param inflatedView
	 */
	public void setFields(View inflatedView);

	/**
	 * <p>
	 * This method is called each time a View needs to be updated (not created).
	 * Use this method to bind information from your model to the View
	 * components
	 * </p>
	 * 
	 * @param context
	 * @param model
	 */
	public void refresh(Context context, E model);
}
