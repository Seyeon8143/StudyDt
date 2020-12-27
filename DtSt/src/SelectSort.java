import java.util.*;

import static java.util.Collections.swap;

public class SelectSort {
    //함수를 선언하고 정렬할 배열을 파라미터로 받음
    private static void selectionSort(int[] arr){
        //재귀함수 ????
        //정렬이 안된 부분에 시작위치를 같이 지정 -> 제일 첫번째 칸이 시작점
        selectionSort(arr,0);
    }
    //재귀 함수가 호출되면 배열과 시작점을 파라미터로 받고
    private static void selectionSort(int [] arr, int start){
        //시작점이 배열의 마지막 방보다 작은 동안 재귀함수를 호출
        if(start < arr.length -1){
            //가장작은 값을 저장하는 변수
            int min_index = start;
            //시작점부터 배열의 마지막 방까지 돌면서 해당 배열방의 값이 min_index의 값보다 더 작으면
            // min_index를 해당배열 방의 index 로 upate
            for (int i = start; i <arr.length; i++){
                if(arr[i] < arr[min_index]) min_index = i;
            }
            //가장 작은값을 찾으면 맨앞에 값과 swap
            swap(arr, start, min_index);
            //시작점을 하나더 증가시켜서 함수다시 호출
            selectionSort(arr,start+1);
        }
    }
    private static void swap(int [] arr, int index1, int index2){
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }
    //배열 출력
    private static void printArray(int [] arr){
        for(int data : arr){
            System.out.println(data +",");
        }
        System.out.println();
    }
    public static void main(String[] args){
        int [] arr = {3,6,1,8,2,4};
        printArray(arr);
        selectionSort(arr);
        printArray(arr);
    }
}
