package com.test.database.sql.append;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 *
 */
public abstract class SqlAppendAuto {

    private static class Pro{
        static Pattern pattern = Pattern.compile("[a-z]+,[a-zA-Z0-9_$]+");
        static Map roleMap = new HashMap();
    }

    public abstract SqlAppendAuto append(Object obj);


    public void addRule(String ruleName, String v){
        Pro.roleMap.put(ruleName, v);
    }

    static void appendSql(Serializable ser, Object obj, String prefix, String ... os){
        SqlAppend sqlAppend = SqlAppendFactory.createSqlAppend(ser);
        Map<String, String> pm = paramMap(os);
        Method[] methods = obj.getClass().getMethods();
        for (Method method : methods) {
            if(method.getName().startsWith("get") && !method.getName().equals("getClass")){
                String proName = method.getName().substring(3,4).toLowerCase();
                proName += method.getName().substring(4);
                if(pm.get(proName) == null){
                    defaultMethod(sqlAppend, proName, prefix);
                }else{
                    customMethod();
                }
            }
        }
    }

    private static void customMethod() {

    }

    private static void defaultMethod(SqlAppend sqlAppend, String name, String prefix){
        StringBuilder colName = new StringBuilder();
        for(char c : name.toCharArray()){
            if((int)c >= 97 && (int)c <= 122)
                colName.append("");
            System.out.println((int)c);
        }
        System.out.println((int)'a');
        System.out.println((int)'z');
        System.out.println((int)'A');
        System.out.println((int)'Z');
        sqlAppend.append(prefix).append(".").append(name);
    }

    private static Map<String, String>  paramMap(String[] os){
        Map<String, String> map = new HashMap<>(os.length);
        for(String term : os){
            if(!Pro.pattern.matcher(term).matches()){
                throw new RuntimeException("条件格式错误");
            }
            String[] ts = term.split(",");
            map.put(ts[1], ts[0]);
        }
        return map;
    }

}