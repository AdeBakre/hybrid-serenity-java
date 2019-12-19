package com.gbk.hybrid.core;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.fge.jackson.JsonLoader;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class JsonUtilities {


    public static Object getValueOfKeyFromJson(String key, String json) throws IOException {

        ObjectNode object = (ObjectNode) (JsonLoader.fromString(json));

        JsonNode valueOfKey = object.get(key);
        if (valueOfKey == null) {
            return null;
        }
        else {
            return valueOfKey.asText();
        }
    }

    public static List<String> getArrayValueOfKeyFromJson(String key, String json) throws IOException {

        List<String> list = new ArrayList<>();
        ObjectNode object = (ObjectNode) (JsonLoader.fromString(json));
        JsonNode valueOfKey = object.get(key);
        for(JsonNode obj : valueOfKey){

            list.add(obj.textValue());
        }

        return list;
    }



}
