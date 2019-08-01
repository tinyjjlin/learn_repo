package com.tiny.java8.collection;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author tiny lin
 * @date 2019/6/26
 */
public class ListSort {

    // 使用 java 7 排序
    private void sortUsingJava7(List<String> names){
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });
    }
    /**
     * 排序
     * @param names
     */
    public void sortUsingJava8(List<String> names){
        Collections.sort(names,(s1,s2)->s1.compareTo(s2) );
    }

    public static void test(){
           System.out.println("test");
              String[] arr = {"jslkdfj", "sds", "ss", "dd", "nn", "mm", "nn", "mm"};
              List<String>arr1= new ArrayList <>();
            List<String> list = arr1.stream().collect(Collectors.toList());
            list.forEach(System.out::println);
    }

    public void spendingStr(){
        String str ="";
        String[] arrs = str.split(";|,|；|，");
        Arrays.asList(arrs).stream().forEach(System.out::println);
//        String[] arr = {"jslkdfj", "sds", "ss", "dd", "nn", "mm", "nn", "mm"};
//        // 方案二：（利用java8新特性去重）
//        StringBuffer stringBuffer  = new StringBuffer();
//        Arrays.asList(arr).stream().distinct().forEach(i->stringBuffer.append(i+";"));
        String output =  Arrays.asList(arrs).stream().distinct().collect(Collectors.joining(";"));
    }

    public static void main(String[] args){
        test();
    }

}
