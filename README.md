# Circle Progress Bar

## Overview
A customizable Circle Progress Bar for Android applications. This library allows you to add a circular progress indicator to your Android app with various customization options.

## Features
- Draw a circular progress bar with customizable colors, sizes, and progress values.
- Supports animation and customizable progress increments.
- Add custom attributes for advanced customization.

## Getting Started

### Gradle Dependency

Add the following dependency to your `build.gradle` file:

```gradle
implementation 'com.github.yourusername:CircleProgressBar:1.0.0'

Usage
Add the CircleProgressBar to your XML layout:
<com.example.CircleProgressBar
    android:id="@+id/circleProgressBar"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    app:progressColor="#FF0000"
    app:progressWidth="10dp"
    app:circleColor="#CCCCCC"
    app:circleWidth="5dp"
    app:progress="50" />


Update the progress programmatically:
CircleProgressBar progressBar = findViewById(R.id.circleProgressBar);
progressBar.setProgress(75);


Custom Attributes
progressColor: Color of the progress bar.
progressWidth: Width of the progress line.
circleColor: Color of the background circle.
circleWidth: Width of the background circle.
progress: Initial progress value (0-100).

License
This project is licensed under the MIT License - see the LICENSE file for details.
