




# MARLEY SPOON TAKE HOME TEST
This repository contains an ANDROID app that is the subject of a Take home test  provided by Marley Spoon.
# OVERVIEW

<p align="center">

  <img src="http://achraf.fps-platform.com/marleyspoon/screen1.gif" width="250">
  <img src="http://achraf.fps-platform.com/marleyspoon/screen3.png" width="250">
  <img src="http://achraf.fps-platform.com/marleyspoon/screen2.png" width="250">
</p>
<br>
<br>

# Project Structure
![Structure](http://achraf.fps-platform.com/marleyspoon/architecture.jpg)
<br>

# MVP ARCHITECTURE
![enter image description here](http://achraf.fps-platform.com/marleyspoon/MVP2.jpg)
#### The app has following packages:
1. **data**: It contains all the data accessing and manipulating components.
2. **di**: Dependency providing classes using Dagger2.
3. **ui**: View classes along with their corresponding Presenters.
4. **utils**: Utility classes.

#### Classes have been designed in such a way that it could be inherited and maximize the code reuse.

### Library reference resources:
1. Dagger2: [https://github.com/google/dagger](https://github.com/google/dagger)
2. Contentful: [https://github.com/contentful/contentful.java](https://github.com/amitshekhariitbhu/Fast-Android-Networking)
3. Gson : [https://github.com/google/gson](https://github.com/google/gson)
4. Glide : [https://github.com/bumptech/glide](https://github.com/bumptech/glide)
5. PlaceHolderView: https://github.com/janishar/PlaceHolderView
6. ButterKnife: http://jakewharton.github.io/butterknife/
7. RxJava2: [https://github.com/amitshekhariitbhu/RxJava2-Android-Samples](https://github.com/amitshekhariitbhu/RxJava2-Android-Samples)
8. FlexBox : [https://github.com/google/flexbox-layout](https://github.com/google/flexbox-layout)
9. Calligraphy :  [https://github.com/chrisjenx/Calligraphy](https://github.com/chrisjenx/Calligraphy)

# App features
```
1. Launching the App
2. Getting list of recipes
3. Show recipes in a list
4. User  click on any recipe
5. Recipe informations appears
```

# TESTING
Using the MVP architecture makes doing unit test an easy task, i used JUnit and MOCKITO to test  Presenters :
<p align="center">
  <img src="http://achraf.fps-platform.com/marleyspoon/unit.png" width="250">
</p>

ESPRESSO was used for UI tests :
<p align="center">
  <img src="http://achraf.fps-platform.com/marleyspoon/ui.png" width="250">
</p>

# TODO
Add some unit tests for the Contentful API.