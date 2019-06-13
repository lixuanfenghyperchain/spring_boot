//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.hyperchain.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.hyperchain.base.WMap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public class JSONUtil {
    private static final SerializerFeature[] serializerFeatures;

    static {
        serializerFeatures = new SerializerFeature[]{SerializerFeature.QuoteFieldNames, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullNumberAsZero, SerializerFeature.WriteNullListAsEmpty, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteNullBooleanAsFalse};
    }

    protected JSONUtil() {
        throw new UnsupportedOperationException();
    }

    public static <T> String listToJSONString(List<T> list) {
        return JSONObject.toJSONString(list, serializerFeatures);
    }

    public static String objectToJSONString(Object object) {
        return JSONObject.toJSONString(object, serializerFeatures);
    }

    public static String jsonArrayToJSONString(JSONArray jsonArray) {
        return jsonArray.toJSONString();
    }

    public static String jsonObjectToJSONString(JSONObject jsonObject) {
        return jsonObject.toJSONString();
    }

    public static JSONArray toJSONArray(String json) {
        return JSONArray.parseArray(json);
    }

    public static WMap jsonToMap(String json) {
        WMap data = new WMap();
        net.sf.json.JSONObject jsonObject = net.sf.json.JSONObject.fromObject(json);
        Iterator it = jsonObject.entrySet().iterator();
        while (it.hasNext()) {
            Entry<String, Object> entry = (Entry) it.next();
            data.setObject(String.valueOf(entry.getKey()), "null".equals(String.valueOf(entry.getValue())) ? "" : entry.getValue());
        }

        return data;
    }

    public static List<WMap> toArrayList(String json) {
        List<WMap> list = new ArrayList();
        JSONArray jsonArray = JSONArray.parseArray(json);
        Iterator var8 = jsonArray.iterator();

        while (true) {
            Object obj;
            do {
                if (!var8.hasNext()) {
                    return list;
                }

                obj = var8.next();
            } while (obj == null);

            JSONObject jsonObject = (JSONObject) obj;
            WMap map = new WMap();
            Iterator it = jsonObject.entrySet().iterator();

            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                map.put(String.valueOf(entry.getKey()), entry.getValue());
            }

            list.add(map);
        }
    }
}
