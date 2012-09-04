package nl.besuikerd.viewholder;

/**
 * Factory class for ViewHolders. Implement one of these for each ViewHolder,
 * since you need a way to instantiate new ViewHolders, or you can simply use a
 * {@link DefaultViewHolderFactory}, just make sure the ViewHolder has an empty
 * constructor for this implementation.
 * 
 * @author nicker
 * 
 * @param <E> model for the ViewHolder class
 */
public interface ViewHolderFactory<E> {
	/**
	 * Creates a new ViewHolder<E>
	 * @return new instance of a ViewHolder<E>
	 */
	public ViewHolder<E> newInstance();
}
