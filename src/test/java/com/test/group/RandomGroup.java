package com.test.group;

import com.sys.util.AssertUtils;
import com.sys.util.NumUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * 将集合中的数据分组, 每次都不能重复
 */
public class RandomGroup<T> {

    public Collection collection;
    private int groupNum;//分成几个组
    private int groupCount;//每组最大数量
    private int count;//一共分几次
    private List[][] list;
    private int index;
    private Random random;

    public RandomGroup(Collection<T> collection, int groupNum){
        this(collection, groupNum, groupNum);
    }

    public RandomGroup(Collection<T> collection, int groupNum, int count){
        this(collection,groupNum,count,NumUtils.divideReturnCeil(collection.size(), groupNum));
    }

    public RandomGroup(Collection<T> collection, int groupNum, int count, int groupCount){
        AssertUtils.isTree(count <= groupNum, "次数太多会卡死");
        AssertUtils.isTree(groupCount >= NumUtils.divideReturnCeil(collection.size(), groupNum), "人数太少会卡死");
        this.collection = collection;
        this.groupNum = groupNum;
        this.groupCount = groupCount;
        this.count = count;
        random = new Random();
        startGroup();
    }

    public boolean hasNext(){
        return index < list.length;
    }

    public List<T>[] next(){
        return list[index++];
    }

    private void startGroup() {
        int err  = 0;
        while(true){
            try{
                List<Item> items = toItems();
                list = new ArrayList[count][];
                for (int i = 0; i < count; i++) {
                    group(items);
                    list[i] = print(items);
                }
                break;
            }catch (Exception e){
                err ++;
                System.out.println("失败次数: " + err);
            }
        }
    }

    public List[] print(List<Item> items){
        List[] lists = new ArrayList[groupNum];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i < items.size(); i++) {
            lists[items.get(i).curr].add(items.get(i).obj);
        }
        return lists;
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