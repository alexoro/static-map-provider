## Static Map Provider
Android library to generate static-map image url from Google and Yandex.


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