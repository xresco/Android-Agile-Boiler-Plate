# Flexi-Image-Gallery
This gallery is used to align photos with different aspect ratios in a fluid way. It tries to keep the aspect ratio of the photos and reduce the crop as much as possible.

Download
--------

Download via Gradle:
- Add the following to the project's build.gralde
```groovy
allprojects {
    repositories {
       jcenter()
    }
}
```
- Add this to your dependencies
```groovy
compile 'com.abed.android:flexiimagegallery:1.0.0'
```





Features
----


- Configurable spacing between the items:

With Spacing               |  Without Spacing 
:-------------------------:|:-------------------------:
![](https://s32.postimg.org/bszn3x10l/device_2016_06_19_132324.png)  |  ![](https://s32.postimg.org/ql81czsqd/device_2016_06_19_132422.png)




- Configurable row height:

Small Height (more dense)              |  Bigger Height (less dense)
:-------------------------:|:-------------------------:
![](https://s31.postimg.org/ttzfsgr4r/device_2016_06_19_132536.png)  |  ![](https://s32.postimg.org/ql81czsqd/device_2016_06_19_132422.png)



Usage
--------

###### xml Code: 

- Add the FlexiGallery to the xml layout file

```groovy
    <com.abed.flexiimagegallery.ui.view.FlexiGallery
        android:id="@+id/flexi_gallery"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        app:gallery_items_vertical_spacing="10dp"
        app:gallery_items_horizontal_spacing="10dp"
        app:gallery_average_row_height="400dp"/>
```
The FlexiGallery has 3 paramters to specify: 
  - gallery_items_horizontal_spacing: (optional. Default 0dp) It specifies the dimension of the horizontal spacing between the photos.
  - gallery_items_vertical_spacing: (optional. Default 0dp) It specifies the dimension of the vertical spacing between the photos.
  - gallery_average_row_height: (optional) This tells the library what is the desired row height and the library will optimize the algorithm to arrange the items in a way were the row height is as close as possible to what you specified.
  

###### Java Code: 
Inside your java code you specify the rest of the parameters that are needed for the gallery to get rendered and function:
- The photos to be presented using the function "configure". Where you pass a list of the object "GalleryPhoto"
- The ImageLoader used. This is a hook to let you use whichever image loading library you like (Picasso, Glide, Universal Image Loader)
- The PhotoClickListener (Optional) in case you want to have click event listener on the photos

```groovy
  List<GalleryPhoto> galleryPhotos 
    .
    .
    
  flexi_gallery.configure(galleryPhotos, new ImageLoader() {
    @Override
    public void loadImage(String url, ImageView imageView) {
      Glide.with(imageView.getContext()).load(url).into(imageView);
    }
  });
  
  flexi_gallery.setPhotoClickListener(new FlexiGalleryAdapter.PhotoClickListener() {
    @Override
    public void onPhotoClick(View view, int position, GalleryPhoto photo) {
      Toast.makeText(view.getContext(), position + "", Toast.LENGTH_SHORT).show();
    }
  });
```


