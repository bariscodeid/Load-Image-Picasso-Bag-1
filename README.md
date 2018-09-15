# Load-Image-Picasso-Bag-1
Load gambar dari URL dan ditampilkan kedalam view dengan teknologi Picasso versi 2.5.2

Requirement yang perlu dipersiapkan, siapkan layout 

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".MainActivity">

    <ImageView
        android:id="@+id/ivLoadingImagePicasso"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:src="@mipmap/ic_launcher"/>

</LinearLayout>
```

Pada bagian build.gradle (Module: App)

```
apply plugin: 'com.android.application'

android {
    compileSdkVersion 26
    defaultConfig {
        applicationId "dev.id.bariscode.picassobag1androidimageloader"
        minSdkVersion 16
        targetSdkVersion 26
        versionCode 1
        versionName "1.0"
        testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
    }
}

dependencies {
    implementation fileTree(include: ['*.jar'], dir: 'libs')
    implementation 'com.android.support:appcompat-v7:26.1.0'
    implementation 'com.android.support.constraint:constraint-layout:1.1.3'
    testImplementation 'junit:junit:4.12'
    androidTestImplementation 'com.android.support.test:runner:1.0.2'
    androidTestImplementation 'com.android.support.test.espresso:espresso-core:3.0.2'

    implementation 'com.jakewharton:butterknife:8.8.1'
    annotationProcessor 'com.jakewharton:butterknife-compiler:8.8.1'

    //Gunakan Versi Picasso 2.5.2
    implementation 'com.squareup.picasso:picasso:2.5.2'

}
```

Karena mengakses gambar dari URL tambahkan `uses-permission` pada bagian AndroidManifest.xml

```
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="dev.id.bariscode.picassobag1androidimageloader">

    <uses-permission android:name="android.permission.INTERNET"/>

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
        <activity android:name=".MainActivity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>
```

Kemudian pada bagian main_class.java deklarasikan seperti dibawah ini

```
package dev.id.bariscode.picassobag1androidimageloader;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.ivLoadingImagePicasso)
    ImageView ivLoadingImagePicasso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Picasso.with(this) 
                // Context diinisialisasikan yaitu Class dimana yang akan meload gambar
                .load("http://192.168.2.50/bariscode.tech/logo-bariscode.png") 
                // URL Gambar
                .placeholder(R.drawable.not_opened) 
                // Sebelum diinflate dengan gambar yang di download dari URL
                .error(R.drawable.error) 
                // Jika URL Salah
                .into(ivLoadingImagePicasso); 
                // Inflate ke ImaveView
    }
}
```
