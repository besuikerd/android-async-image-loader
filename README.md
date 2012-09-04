android-asyncimageloader
========================

makes asynchronous image loading possible for android.

##Usage
-   Create a new ImageLoaderManager (DefaultImageLoaderManager is the default implementation)
-   use the ImageLoaderManager's postImage method (you need an ImageLoadingHandler for this method, an implementation for an ImageView is given, ImageViewImageLoadingTask)

Thats it!

##ListView and Viewholder package
This package is used to increase performance for the ListView, you might know about viewholders with static inner classes. This implementation gives you a generalized implementation of the ListAdapter for a ListView, so you do not need to worry about that anymore. All you need to do is implement a ViewHolder class for each View you wish to inflate in your list.

## Example package
The example package shows you what you need to do to implement async image loading and how to use ViewHolders

