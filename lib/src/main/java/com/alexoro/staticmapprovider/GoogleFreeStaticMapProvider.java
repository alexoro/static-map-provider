/*
 * Copyright (C) 2014 Alexander Sorokin (alexoro)
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.alexoro.staticmapprovider;

/**
 * Created by uas.sorokin@gmail.com
 *
 * See https://developers.google.com/maps/documentation/staticmaps/intro
 */
public class GoogleFreeStaticMapProvider extends StaticMapProvider {

    private static final int MAX = 640;
    private static final String DEFAULT_LANG = "EN";

    public GoogleFreeStaticMapProvider() {
        super();
        setZoom(16);
        setLanguage(DEFAULT_LANG);
    }

    @Override
    public int getMaxMapImageWidth() {
        return MAX * 2; // scale by 2
    }

    @Override
    public int getMaxMapImageHeight() {
        return MAX * 2; // scale by 2
    }

    @Override
    public void getMapImageUrl(StringBuilder out) {
        String language = getLanguage();

        if (language == null) {
            language = DEFAULT_LANG;
        }

        int scale = 1;
        int width = getDesiredMapImageWidth();
        int height = getDesiredMapImageHeight();
        if (width > MAX || height > MAX) {
            scale = 2;
            width /= 2;
            height /= 2;
        }

        int rWidth = Math.min(getMaxMapImageWidth()/scale, width);
        int rHeight = Math.min(getMaxMapImageHeight()/scale, height);

        // MASK:
        // http://maps.googleapis.com/maps/api/staticmap?center=%s,%s&zoom=%d&size=%dx%d&sensor=false&scale=%d&language=%s
        out.append("http://maps.googleapis.com/maps/api/staticmap")
                .append('?')
                .append("center=").append(getLatitude()).append(',').append(getLongitude())
                .append('&')
                .append("zoom=").append(getZoom())
                .append('&')
                .append("size=").append(rWidth).append('x').append(rHeight)
                .append('&')
                .append("sensor=false")
                .append('&')
                .append("scale=").append(scale)
                .append('&')
                .append("language=").append(language);
    }

}