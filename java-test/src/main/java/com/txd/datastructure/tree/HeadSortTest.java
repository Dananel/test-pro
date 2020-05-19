package com.txd.datastructure.tree;

import java.util.Arrays;

/**
 * 堆排序
 */
public class HeadSortTest {

    public static void main(String[] args) {
        int[] arr = {13,12,15,10,11,7,14,9,8,6,5,1,2,3,4};
        getAesArr(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static int[] getAesArr(int[] arr){
        //1.构建大顶堆:arr.length/2-1 从倒数第二层开始，从右往左
        // length = 15
        for(int i=arr.length/2-1;i>=0;i--){
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr,i,arr.length);
        }

        // 构建升序数组
        /*
         * 1：根节点和尾节点数据交换，然后剩余的0-13的继续构建大堆
         */
        int temp;
        for (int j =  arr.length-1; j > 0; j--) {
            // 交换首尾
            temp=arr[j];
            arr[j] = arr[0];
            arr[0] = temp;

            // 此时除了第一个元素外已经是大顶堆了，只需要调整第一个元素,所以从0开始调整
            adjustHeap(arr,0,j);
        }

        return arr;
    }

    /**
     * 将非叶子节点作为根节点所对应的树调整成大顶堆 （从下往上（堆二叉树的倒2层开始），从右往左）
     *
     * @param arr    待构建的数组
     * @param i      非叶子节点索引
     * @param length 整个数组长度（每次从大顶堆选出最大值后，重新构建大顶堆，数组长度减1）
     */
    public static void adjustHeap(int[] arr, int i, int length) {
        // 当前节点的数值
        int temp = arr[i];

        // 从当前节点的2个子节点比较开始。
        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {

            // k指向左右子节点中较大的那个
            if (k + 1 < length && arr[k + 1] > arr[k]) {
                k++;
            }

            // 比较节点k和根节点i的值
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }

        // 1： 循环执行完成后，当前节点肯定拿到了最大值
        // 2：最后一次比较之后发现当前循环的左右子节点比原始子节点数值小，所以直接设置到当前节点上
        arr[i] = temp;
    }
}
