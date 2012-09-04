package nl.besuikerd.viewholder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

@SuppressWarnings({ "serial", "unchecked" })
public class ViewHolderListAdapter<T> extends BaseAdapter implements
		Serializable {

	/**
	 * List holding the model.
	 */
	protected List<T> list;

	/**
	 * context reference.
	 */
	protected Context context;

	/**
	 * ViewHolderFactory to use
	 */
	protected ViewHolderFactory<T> holderFactory;

	/**
	 * Constructs a new ViewHolderListAdapter
	 * 
	 * @param context
	 *            application context
	 * @param holderFactory
	 *            ViewHolderFactory to produce ViewHolders with
	 * @param list
	 *            model to use
	 */
	public ViewHolderListAdapter(Context context,
			ViewHolderFactory<T> holderFactory, List<T> list) {
		this.context = context;
		this.holderFactory = holderFactory;
		this.list = list;
	}

	/**
	 * Constructs a new ViewHolderListAdapter
	 * 
	 * @param context
	 *            application context
	 * @param holderFactory
	 *            ViewHolderFactory to produce ViewHolders with
	 */
	public ViewHolderListAdapter(Context context,
			ViewHolderFactory<T> holderFactory) {
		this(context, holderFactory, new ArrayList<T>());
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			ViewHolder<T> holder = holderFactory.newInstance();
			convertView = holder.inflate(context);
			holder.setFields(convertView);
			holder.refresh(context, list.get(position));
			convertView.setTag(holder);
		} else {
			((ViewHolder<T>) convertView.getTag()).refresh(context,
					list.get(position));
		}
		return convertView;
	}

	/**
	 * adds the given model to the list and notifies the dataset is changed and
	 * the ListView should refresh itself
	 * 
	 * @param item item to add to the current list
	 */
	public void add(T item) {
		list.add(item);
		notifyDataSetChanged();
	}

	/**
	 * adds the given list to the current list and notifies the dataset is
	 * changed
	 * 
	 * @param list list to add
	 */
	public void addAll(List<T> list) {
		list.addAll(list);
		notifyDataSetChanged();
	}

	/**
	 * Replace the current list with the given list and notifies the dataset is changed
	 * @param list list to replace the current list with
	 */
	public void setList(List<T> list) {
		this.list = list;
		notifyDataSetChanged();
	}

	/**
	 * clears the current list and notifies the dataset has been changed.
	 */
	public void clear() {
		list.clear();
		notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}
	
	/**
	 * getter for the current list.
	 * @return the current list this adapter has
	 */
	public List<T> getList() {
		return list;
	}
}
