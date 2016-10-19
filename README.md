## Static Map Provider
Android library to generate static-map image url from Google and Yandex.


# How to include in project
Library is distributed via jitpack.io

```gradle
// Add this lines into your roou build.gradle
allprojects {
    repositories {
        jcenter()
        maven { url "https://jitpack.io" }
    }
}
```

```gradle
// Add dependency to library in any target project module
dependencies {
    compile 'com.github.alexoro:static-map-provider:VERSION'
}
```


## Usage (Google based example)
```java
GoogleFreeStaticMapProvider provider = new GoogleFreeStaticMapProvider();
provider.setLanguage("EN");
provider.setZoom(16);
provider.setDesiredMapImageWidth(500);
provider.setDesiredMapImageHeight(500);
provider.setLongitude(0d);
provider.setLatitude(0d);
String mapImageUrl = provider.getMapImageUrl();
```
For Yandex the sample code is the same, because both providers share common base class.


## Future improvements
This library is Android library nowadays, but should be refactored into standalone \*.jar library.