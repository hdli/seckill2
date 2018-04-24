package org.seckill.test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hdli on 2018-3-5.
 */
public class test {

    static class Jiao {

        @Override
        public int hashCode() {
            return 2;
        }
    }

    static int aaaa(){
        int a;
        try {
            a=1;
            System.out.println(0);
            return a;
        }finally {
            a=3;
            System.out.println(a);
        }
    }


    public static void main(String[] args) {
        HashMap<Jiao,Integer> map =new HashMap();
        map.put(new Jiao(),1);
        map.put(new Jiao(),2);
        map.put(new Jiao(),3);
        for(Map.Entry<Jiao,Integer> entry : map.entrySet()){
            System.out.println("key:"+entry.getKey()+" value:"+entry.getValue());
        }
//        System.out.println(aaaa());

    }
}
