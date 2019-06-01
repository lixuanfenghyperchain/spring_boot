/**
 * Copyright (C), 2016-2019, 趣链科技有限有限公司
 * FileName: MyAarray
 * Author:   lixuanfeng
 * Date:     2019/5/29 下午6:57
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.javase.datastruct;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2019/5/29
 * @since 1.0.0
 */
public class MyAarray {
    private int[] a;
    private int size; //数组的大小
    private int nElem; //数组中有多少项

    public MyAarray(int max) { //初始化数组
        this.a = new int[max];
        this.size = max;
        this.nElem = 0;
    }

    public boolean find(int searchNum) { //查找某个值
        int j;
        for (j = 0; j < nElem; j++) {
            if (a[j] == searchNum)
                break;
        }
        if (j == nElem)
            return false;
        else
            return true;
    }

    public boolean insert(int value) { //插入某个值
        if (nElem == size) {
            System.out.println("数组已满！");
            return false;
        }
        a[nElem] = value;
        nElem++;
        return true;
    }

    public boolean delete(int value) {//删除某个值
        int j;
        for (j = 0; j < nElem; j++) {
            if (a[j] == value) {
                break;
            }
        }
        if (j == nElem)
            return false;
        if (nElem == size) {
            for (int k = j; k < nElem - 1; k++) {
                a[k] = a[k + 1];
            }
        } else {
            for (int k = j; k < nElem; k++) {
                a[k] = a[k + 1];
            }
        }
        nElem--;
        return true;
    }

    public void display() {
        //打印整个数组
        for (int i = 0; i < nElem; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        MyAarray myAarray = new MyAarray(3);
        myAarray.insert(1);
        myAarray.insert(2);
        myAarray.insert(3);
        myAarray.insert(4);
        //目前数组中有多少项
        System.out.println(myAarray.nElem);
        //数组容量
        System.out.println(myAarray.size);
    }
}