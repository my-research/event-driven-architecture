package com.wonit;

import com.google.gson.Gson;

public class Serializer {
    private static final Gson gson = new Gson();

    public static String toJson(Object obj) {
        return gson.toJson(obj);
    }
}
