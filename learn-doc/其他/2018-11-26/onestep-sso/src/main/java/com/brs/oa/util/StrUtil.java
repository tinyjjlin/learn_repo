package com.brs.oa.util;

import com.brs.oa.comm.annotation.Logical;

import java.util.HashSet;
import java.util.List;

public class StrUtil {

    public static boolean isNUll(String str) {
        return null == str || "".equals(str) || "null".equals(str);
    }


    /**
     * List 去除重复元素
     * @param list
     * @return
     */
    public static List removeDuplicate(List list) {
        HashSet h = new HashSet(list);
        list.clear();
        list.addAll(h);
        return list;
    }


    public static Boolean matchPermission(String[]permmisionArr, String[]userPermissionArr, Logical logical){
        int count =0;
        for(int i=0;i<permmisionArr.length;i++){
            for(int j=0;j<userPermissionArr.length;j++){
                if(userPermissionArr[j].equals(permmisionArr[i])){
                    ++count;
                }
            }
        }
        System.out.println("权限匹配个数-------------------------------------->"+count);
        if(logical ==Logical.AND){
            return (count == permmisionArr.length)?true:false;
        }
        if(logical == Logical.OR){
            return(count>0)?true:false;
        }
        return false;
    }

    public static void main(String[] args ){
        String[] permissionArr = new String[]{"view"};
        String[] permissionArr2 = new String[]{"view","edit","add"};
       Boolean result = matchPermission(permissionArr,permissionArr2,Logical.OR );
       System.out.println("result--->"+result);
    }

}