# RtlViewPager
Fork of the RtlViewPager. ViewPager that displays items from right to left for RTL locales and behaves like a regular ViewPager otherwise

### Acknowledgment
The repository is a fork of RtlViewPager with some additional fixes. This module was originally developed for Booking.com. With approval from Booking.com, this module was generalized and published on GitHub and jCenter.

### How to use

The library is published to the jcenter repository, thus your *project's* `build.gradle` must contain:

```groovy
repositories {
    jcenter()
}
```

To use this library add following to your *module's* `build.gradle`:

```groovy
dependencies {
    compile 'com.yotadevices.widget:rtlviewpager:1.0.3'
}
```

That is all. You can use RtlViewPager the same way you use android ViewPager.

### License
```Text
Copyright (C) 2017 Yota Devices LLC, Russia
Copyright (C) 2015 Diego Gómez Olvera

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
