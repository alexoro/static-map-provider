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

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by uas.sorokin@gmail.com
 *
 * See https://www.npmjs.com/package/static-yandex-map
 */
public class YandexFreeStaticMapProvider extends StaticMapProvider {

    private static final String DEFAULT_LANG = "en-US";
    private static final List<String> SUPPORTED_LANGS = Arrays.asList("ru-RU", "tr-TR", "en-US", "uk-UA");
    private static final Map<String, String> MAP_LANG;

    static {
        MAP_LANG = new HashMap<>();
        MAP_LANG.put("ru", "ru-RU");
        MAP_LANG.put("RU", "ru-RU");
        MAP_LANG.put("en", "en-US");
        MAP_LANG.put("EN", "en-US");
        MAP_LANG.put("us", "en-US");
        MAP_LANG.put("US", "en-US");
    }

    public YandexFreeStaticMapProvider() {
        super();
        setZoom(17);
        setLanguage(DEFAULT_LANG);
    }

    @Override
    public int getMaxMapImageWidth() {
        return 650;
    }

    @Override
    public int getMaxMapImageHeight() {
        return 450;
    }

    @Override
    public void getMapImageUrl(StringBuilder out) {
        String language = getLanguage();
        if (language == null) {
            language = DEFAULT_LANG;
        } else if (!SUPPORTED_LANGS.contains(language)) {
            language = MAP_LANG.containsKey(language) ? MAP_LANG.get(language) : DEFAULT_LANG;
        }

        int rWidth = Math.min(getMaxMapImageWidth(), getDesiredMapImageWidth());
        int rHeight = Math.min(getMaxMapImageHeight(), getDesiredMapImageHeight());

        // MASK:
        // http://static-maps.yandex.ru/1.x/?ll=%s,%s&z=%d&l=map&size=%d,%d&lang=%s
        out.append("http://static-maps.yandex.ru/1.x/")
                .append('?')
                .append("ll=").append(getLongitude()).append(',').append(getLatitude())
                .append('&')
                .append("z=").append(getZoom())
                .append('&')
                .append("l=map")
                .append('&')
                .append("size=").append(rWidth).append(',').append(rHeight)
                .append('&')
                .append("lang=").append(language);
    }

}