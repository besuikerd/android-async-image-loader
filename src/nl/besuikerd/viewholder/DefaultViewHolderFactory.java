package nl.besuikerd.viewholder;

public class DefaultViewHolderFactory<E> implements ViewHolderFactory<E> {

	private Class<? extends ViewHolder<E>> cls;

	/**
	 * <p>
	 * Constructs a new DefaultViewHolderFactory
	 * </p>
	 * 
	 * IMPORTANT: make sure your ViewHolder class has an empty constructor that
	 * is accesible, else this factory will not work.
	 * 
	 * @param cls ViewHolder class this factory must produce.
	 */
	public DefaultViewHolderFactory(Class<? extends ViewHolder<E>> cls) {
		this.cls = cls;
	}

	/**
	 * <p>Creates a new instance of a ViewHolder<E></p>
	 * 
	 * IMPORTANT: make sure your ViewHolder class has an empty constructor that
	 * is accesible, else this factory will not work.
	 */
	@Override
	public ViewHolder<E> newInstance() {
		ViewHolder<E> holder = null;
		try {
			holder = cls.newInstance();
		} catch (InstantiationException e) {
		} catch (IllegalAccessException e) {
		}
		return holder;
	}
}