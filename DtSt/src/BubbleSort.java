public class BubbleSort {
    private static void bubbleSort(int[] arr){
        //재귀함수 호출 배열의 주소와 배열의 정렬이 안된부분의 마지막 index를 인자로 받음
        bubbleSort(arr,arr.length-1);

    }
    private static void bubbleSort(int[] arr, int last){
        //마지막 index 가 0보다 클때까지 재귀호출
        if(last > 0){
            for(int i = 1; i <= last; i++){
                //앞에있는 값 과 나보다 큰지 비교
                if(arr[i-1] > arr[i]){
                    swap(arr,i-1,i);
                }
            }
            //맨마지막 하나는 정렬이 되었기 때문에 다시 호출할때 마지막 인덱스는 빼고정렬
            bubbleSort(arr, last-1);
        }
    }
    private static void swap(int [] arr, int source,int target){
        int tmp = arr[source];
        arr[source] = arr[target];
        arr[target] = tmp;
    }
    private static void printArray(int[]arr){
        for(int data : arr){
            System.out.print(data + ",");
        }
        System.out.println();

    }
    public static void main(String[] args){
        int [] arr = {3,5,4,2,1};
        printArray(arr);
        bubbleSort(arr);
        printArray(arr);
    }
}
