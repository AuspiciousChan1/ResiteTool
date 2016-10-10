package Function;

import Data.Constant;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class MyInformationHandler {
    //按照规范将文本文件中的数据存入键值对
    public static HashMap<String, String> getInformationFromBookBufferedReader(BufferedReader bufferedReader) throws IOException {
        String key = "";
        HashMap<String, String> hashMap = new HashMap<String, String>();
        while((key = bufferedReader.readLine()) != null) {
            String value = bufferedReader.readLine();
            value = value.substring(value.indexOf('\t') + 1);
            hashMap.put(key, value);
            //System.out.println("key：" + key + "\tvalue：" + value);
        }
        return hashMap;
    }
    //遍历哈希表
    public static<K, V> void ergodicHashMap(HashMap<K, V> hashMap) {
        Iterator iter = hashMap.entrySet().iterator();
        StringBuffer stringBuffer = new StringBuffer("");
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            K key = (K) entry.getKey();
            V val = (V) entry.getValue();
            System.out.println("{" + key + " : " + val + "}\t");
            stringBuffer.append("{" + key + " : " + val + "}" + Constant.IntervalCharacter);
        }
        stringBuffer.delete(stringBuffer.length() - Constant.IntervalCharacter.length(), stringBuffer.length() - 1);

    }
}
