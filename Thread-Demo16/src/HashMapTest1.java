import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapTest1 {
    public static void main(String []args){

        Map<String,String> map = new HashMap<String,String>();
        map.put("1","value1");
        map.put("2","value2");
        map.put("3","value3");

        //普遍使用，二次取值
        for(String key : map.keySet()) {
            System.out.println("key=" + key + "value" + map.get(key));
        }

        //第二种
        Iterator<Map.Entry<String,String>> it = map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String,String> entry = it.next();
            System.out.println("key=" + entry.getKey() + "value" + entry.getValue());
        }

        //第三种适合在大容量时
        for(Map.Entry<String,String> entry : map.entrySet()){
            System.out.println("key=" + entry.getKey() + "value" + entry.getValue());
        }

        //第四种
        for(String v : map.values()){
            System.out.println("value="+ v);
        }

    }
}
