package Utility;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pengfei on 2017/9/12.
 */
public class CacheUtils {

    public static String toJsonString(Object key) {

        if (key instanceof String)
            return (String) key;
        else
            return JSON.toJSONString(key);
    }

    public static <V> V parseJsonObj(String str) {
        V result = (V) JSON.parse(str);
        return result;
    }


    public static void main(String[] args) {
        User user = new User("rainbow", 18);
        String jsonObj = toJsonString(user);
        System.out.println(jsonObj);

        Map<String, String> map = new HashMap<String, String>();
        map.put("a", "aa");
        map.put("b", "bb");

        System.out.println(map);

        int a = 16;
        int b = 4;

        int c = a >> 2;
        int d = a << 2;
        byte[] by = new byte[88];
        char[] ch = new char[88];

        System.out.println(c + " " + d);

        String str = "jakk bai";
        System.out.println(JSON.toJSONString(str));
    }
}

class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
