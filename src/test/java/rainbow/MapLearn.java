package rainbow;

import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pengfei on 2017/8/31.
 */
@Configuration
public class MapLearn {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();

        String str = "jack";
        System.out.println(str.hashCode());


        int hash = 0;
        String s = "jack";

        for (int i = 0; i < s.length(); i++) {
            hash = hash * 31 + s.charAt(i);
        }

        System.out.println(hash);
        String ip="BEIJING";
        String ip2="2.0.0.10";
        System.out.println(ip.hashCode());
        System.out.println(ip2.hashCode()%11);





    }
}
