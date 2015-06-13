# AutoInflate

Small Android library to simplify common used patterns in view inflation.

## ListView's header and footer

Using `AutoInflateLayout` header and footer can be added to `ListView` like this:

```xml
<com.kboyarshinov.autoinflate.AutoInflateLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    >

    <!-- Header is above ListView -->
    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="This is header"
        />

    <!-- Header and Footer are automatically added to ListView -->
    <ListView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        />

    <!-- Footer is below ListView -->
    <TextView
        android:layout_width="match_parent"
        android:layout_height="@dimen/list_item_height"
        android:text="This is footer"
        />
</com.kboyarshinov.autoinflate.AutoInflateLayout>
```

Header and footer views are recognized by the relative position to `ListView`. Header is located before `ListView`, footer is after.

`AutoInflateLayout` is typically just `FrameLayout`, so any Views besides footer and header can be added to it.

## Dependency

Include the dependency or [Download (.aar)](http://search.maven.org/remotecontent?filepath=com/kboyarshinov/autoinflate/0.1/autoinflate-0.1.aar) :

```groovy
dependencies {
    compile 'com.kboyarshinov:autoinflate:0.1.1'
}
```

## LICENSE

Copyright 2015 Kirill Boyarshinov

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

<http://www.apache.org/licenses/LICENSE-2.0>

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
