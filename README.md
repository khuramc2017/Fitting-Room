## An app that assists users with their fashion choices

This app allows users to upload a photo of an outfit for users to rate by swiping left or right to show their thoughts. This way, the user can always go out knowing that they have an amazing outfit that is approved by people who know style.

### To do:
 * Put app on Google play
 * Create tests
 * Create Terms of Service
 * Refactor code
     * Take deep look and delete ALL non-necessary code (including things that are not commented out and/or listed as unused by Android Studio)
* Add comments section to each photo
     * make comments viewable by original poster
     * Perhaps make a my activity section in user profile section of app
* Add badges
     * x amount of photos uploaded
     * x amount of photos rated
     * x amount positive rated photos (both sent and received)
     * x amount negative rated photos (both sent and received)
     * Surpassed x% positive and negative rating on a photo.
 * Add analytics

### Done
 * Set up swipe card layout
 * Set up sign in and sign out using Firebase AUTH and Firebase UI
 * Choose Material Design Color Scheme
 * Add native ads, banner ads, and interstitial ads
 * Have photo upload to Firebase storage
 * Set up Firebase database
   * Db structure
    * [user|photo urls]
    * [photo urls|likes|dislikes|reports|usernames]
 * Set up photo functionality
 * Create layout for new photo creation
 * Create photo reporting functionality
 * Have my account section with photos
 * Set up rating system for user likes or dislikes
 * Create catchy launcher icon 
 * Make a progress bar for user to see photo upload progress
 * Decreased image size by up to 33 times with no noticeable image quality loss in order to reduce:
     * Server storage space
     * Server bandwidth usage
     * User upload time
     * Time it takes user to view photos

### Known bugs/ to fix:
* Improve layout
   * Make it nice
   * Decide what to do with add photo fab
   * Make tablet layout
* Improve looks of native ads
* Increase app performance
* Reinstate report and voting functionality
* Localize all strings
* The following line crashed a Samsung s8+ (API 24) with a can not divide by 0 error (only once after dozens of photos were uploaded)
    * BIG CHANCE IT WAS DUE TO A FAULTY UPLOAD. 
```java
 if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        prog = toIntExact(100* taskSnapshot.getBytesTransferred()/taskSnapshot.getTotalByteCount());
                    }
                    else{
                        prog = (int)(100* taskSnapshot.getBytesTransferred()/taskSnapshot.getTotalByteCount());

                    }
```


### Possible features:
* Make a sort of timeline view like facebook/instagram?
* If enough users are not being rated then allow for only one photo to be uploaded/ rated for free and then future photos will be on a per-rate basis where 1 rate = 1 new photo uploaded
* Allow following other users
   * This will add a field to the user part of the database which will be followed users. Possibilities for this are:
     * The app will push photos from the followed users to the front of the list of photos to rate.
     * Dedicated section to followed users (like with youtube subscriptions)
   * Add number of followers to user part of database
   * Add animations/transitions
   * Add search user
   * Add profile photos
 * Add option to skip or indifferent view of style
 * Have local database so that "my photos" section will load faster
 * Make text dynamically size to view



###### Credit to

* Janishar for Placeholderview Library
* Google for the Google Libraries used
* Ben Manes for the Dependency Updates library
