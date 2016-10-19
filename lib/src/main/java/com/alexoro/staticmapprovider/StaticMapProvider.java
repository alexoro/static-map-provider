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
 */
abstract public class StaticMapProvider {

    private String mLanguage;
    private int mZoom;
    private int mDesiredMapImageWidth;
    private int mDesiredMapImageHeight;
    private double mLongitude;
    private double mLatitude;

    public StaticMapProvider() {
        setLanguage(null);
        setZoom(1);
        setDesiredMapImageWidth(getMaxMapImageWidth());
        setDesiredMapImageHeight(getMaxMapImageHeight());
        setLongitude(0);
        setLatitude(0);
    }

    public String getLanguage() {
        return mLanguage;
    }

    public void setLanguage(String language) {
        mLanguage = language;
    }

    public int getZoom() {
        return mZoom;
    }

    public void setZoom(int zoom) {
        if (zoom <= 0) {
            throw new IllegalArgumentException("Invalid zoom value: " + zoom);
        }
        mZoom = zoom;
    }

    public int getDesiredMapImageWidth() {
        return mDesiredMapImageWidth;
    }

    public void setDesiredMapImageWidth(int desiredMapImageWidth) {
        if (desiredMapImageWidth <= 0) {
            throw new IllegalArgumentException("Invalid desiredMapImageWidth value: " + desiredMapImageWidth);
        }
        mDesiredMapImageWidth = desiredMapImageWidth;
    }

    public int getDesiredMapImageHeight() {
        return mDesiredMapImageHeight;
    }

    public void setDesiredMapImageHeight(int desiredMapImageHeight) {
        if (desiredMapImageHeight <= 0) {
            throw new IllegalArgumentException("Invalid desiredMapImageHeight value: " + desiredMapImageHeight);
        }
        mDesiredMapImageHeight = desiredMapImageHeight;
    }

    public double getLongitude() {
        return mLongitude;
    }

    public void setLongitude(double longitude) {
        mLongitude = longitude;
    }

    public double getLatitude() {
        return mLatitude;
    }

    public void setLatitude(double latitude) {
        mLatitude = latitude;
    }

    public String getMapImageUrl() {
        StringBuilder sb = new StringBuilder();
        getMapImageUrl(sb);
        return sb.toString();
    }

    abstract public int getMaxMapImageWidth();
    abstract public int getMaxMapImageHeight();
    abstract public void getMapImageUrl(StringBuilder out);

}