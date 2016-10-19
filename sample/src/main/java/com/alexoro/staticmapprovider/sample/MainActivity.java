package com.alexoro.staticmapprovider.sample;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.alexoro.staticmapprovider.GoogleFreeStaticMapProvider;
import com.alexoro.staticmapprovider.YandexFreeStaticMapProvider;

/**
 * Created by uas.sorokin@gmail.com
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        TextView textView = (TextView) findViewById(R.id.text);

        GoogleFreeStaticMapProvider googleProvider = new GoogleFreeStaticMapProvider();
        YandexFreeStaticMapProvider yandexProvider = new YandexFreeStaticMapProvider();

        textView.setText(
                googleProvider.getMapImageUrl()
                + "\r\n\r\n"
                + yandexProvider.getMapImageUrl()
        );
    }

}