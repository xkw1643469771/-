package com.test.ks;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 *
 */
public class RandomGroup {

    public Collection collection;
    private int groupNum;//分成几个组
    private int groupCount;//每组最大数量
    private int number;//第几次
    private Random random;

    public static void main(String[] args) {
        List list = new ArrayList();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        RandomGroup group = new RandomGroup(list, 4, 25);
    }

    public RandomGroup(Collection collection, int groupNum, int groupCount){
        this.collection = collection;
        this.groupNum = groupNum;
        this.groupCount = groupCount;
        this.number = groupNum;
        random = new Random();
    }

    public boolean hasGroup(){
        return this.number > 0;
    }

    private void startGroup() {
        int err  = 0;
        while(true){
            try{
                List<Item> items = toItems();
                for (int i = 0; i < groupNum; i++) {
                    group(items);
                }
                break;
            }catch (Exception e){
                err ++;
            }
        }
        number --;
        System.out.println("失败次数: " + err);

    }

    public void print(List<Item> items){
        List[] lists = new ArrayList[groupNum];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i < items.size(); i++) {
            lists[items.get(i).curr].add(items.get(i).obj);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < groupNum; i++) {
            String str = i + " " + lists[i].toString();
            sb.append(str);
            for (int j = 0; j < 100 - str.length(); j++)
                sb.append(" ");
        }
        System.out.println(sb);
    }

    private List<Item> toItems(){
        List<Item> items = new ArrayList<>(collection.size());
        for(Object obj : collection){
            Item item = new Item();
            item.obj = obj;
            item.used = new HashSet<>();
            items.add(item);
        }
        return items;
    }

    private void group(List<Item> items){
        int[] groupCounts = new int[groupNum];
        for (int i = 0; i < items.size(); i++){
            Item item = items.get(i);
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < groupCounts.length; j++) {
                if(item.used.contains(j))
                    continue;
                if(groupCounts[j] < groupCount)
                    list.add(j);
            }
            //System.out.println(list + "\t" + Arrays.toString(as));
            item.curr = list.get(random.nextInt(list.size()));
            item.used.add(item.curr);
            groupCounts[item.curr] ++;
        }
    }

    private static class Item{
        Object obj;
        Set<Integer> used;
        Integer curr;
    }

}