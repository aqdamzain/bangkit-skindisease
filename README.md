# Skin Disease Android Application

With various researches that have been done regarding the role or potential of Deep Learning in the field of Dermatology, we hope to create a solution in the form of mobile application, that is able to detect and classify, at a certain confidence level, a potential skin disease from photographs taken and uploaded to the app. The aim is to help the user be more aware of their skin condition or disease they may have suffered from and the mobile app will provide information to the user regarding the disease and recommendation for further treatment.

## Table of contents
<!--ts-->
   * [Tittle](#skin-disease-android-application)
   * [Table of contents](#table-of-contents)
   * [Installation](#installation)
   * [Configuration](#configuration)
      * [Programming Language](#programming-language)
      * [Android Studio](#android-studio)
      * [Minimum Specification](#minimum-specification-to-run-android-studio)
   * [Dependencies Used](#dependencies-used)
<!--te-->

## Installation

Clone this repository and import into **Android Studio**

```bash
git clone https://github.com/aqdamzain/bangkit-skindisease.git
```

## Configuration
### Programming Language:
- kotlin
### Android Studio:
- version 4.1.3
- runtime version using jdk 8
- compile sdk version 30
- build tool version 29.0.3
- minimum sdk version for android is 23
### Minimum Specification to run Android Studio:
- Intel i3 Processor (Core i5 and above Recommended).
- 4GB RAM (8GB Recommended).

## Dependencies Used
### Room
The **Room** persistence library provides an abstraction layer over SQLite to allow fluent database access. It is used to save data in a local database.  <br />
[more about room](https://developer.android.com/training/data-storage/room)
### Retrofit
**Retrofit** is a type-safe REST client for Android. It is a class through which your API interfaces are turned into callable objects. <br />
[more about retrofit](https://square.github.io/retrofit/)
### Glide
**Glide** is an Image Loader Library for Android. Glide's primary focus is on making scrolling any kind of a list of images as smooth and fast as possible, but Glide is also effective for almost any case where you need to fetch, resize, and display a remote image. <br />
[more about glide](https://bumptech.github.io/glide/)
### Android Image Cropper
Image Cropping Library for Android, optimized for Camera / Gallery. <br />
[more about Image Cropper](https://github.com/ArthurHub/Android-Image-Cropper/wiki)
## License
[Apache License 2.0](https://choosealicense.com/licenses/apache-2.0/)
