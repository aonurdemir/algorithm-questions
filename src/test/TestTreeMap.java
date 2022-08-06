package test;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TestTreeMap {

    @Test
    public void EditEntry_CheckOrder(){
        TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();

        treeMap.put(5,1);
        treeMap.put(4,2);
        treeMap.put(3,3);
        treeMap.put(2,4);
        treeMap.put(1,5);

        treeMap.put(0,0);

        for(Map.Entry<Integer,Integer> entry : treeMap.entrySet()){
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
