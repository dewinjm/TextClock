<h1 align="center">TextClock</h1> 
<h4 align="center">Android Library</h4>	
<p align="center">
<a target="_blank" href="https://android-arsenal.com/api?level=16">
 <img src="https://jitpack.io/v/dewinjm/TextClock.svg">
</a>
<a target="_blank" href="https://android-arsenal.com/api?level=16"><img src="https://img.shields.io/badge/API-16%2B-blue.svg?style=flat">
</a>
</p>

<p align="center">Android custom digital clock.</p>
<p align="center">
<img src="https://raw.githubusercontent.com/dewinjm/TextClock/master/art/clock_example.png">
</p>

## How to include
Add the repository to your project **build.gradle**:
```Javascript
repositories {
	jcenter()
	maven {
		url "https://jitpack.io"
	}
}
```
And add the library to your module **build.gradle**:
```Javascript
dependencies {
	 compile 'com.github.dewinjm:TextClock:1.0'
}
```

## Usage
Simply add the view to your design. You have color attribute, to set the color you want.
like this:
```xml
<com.github.dewinjm.textclock.TextClock
      android:layout_width="wrap_content"
      android:layout_height="wrap_content"
      app:color="@color/textColor"/>
```
 

## License
	Copyright 2017 Dewin J. Martínez
	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at

	   http://www.apache.org/licenses/LICENSE-2.0

	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.
