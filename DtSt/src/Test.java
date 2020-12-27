/**
 * 해당 num 의 i 번째 값이 1인지 0 인지 판별하는 함수
 */
public class Test {
    static boolean getBit(int num, int i) {
        return (num & (1 << i)) != 0;

    }

    /**
     * 해당 num 의 i 번째 값을 1로 변경하는 함수
     *
     * @param num
     * @param i
     * @return
     */
    static int setBit(int num, int i) {
        return num | (1 << i);

    }

    /**
     * 해당 index 의 값을 무조건 0으로 바꾸는 함수
     *
     * @param num
     * @param i
     * @return
     */
    static int clearBit(int num, int i) {
        return num & ~(1 << i);
    }

    /**
     * 해당 index 를 기준으로 왼쪽에 있는값들을 전부 0 으로 바꾸는 함수
     *
     * @param
     */
    static int clearLeftsBit(int num, int i) {
        return num & ((1 << i) - 1);

    }

    /**
     * 해당 index 를 포함해서 오른쪽에 있는 값들을 전부 0 으로 바꾸는 함수
     *
     * @param num
     * @param i
     * @return
     */
    static int clearRightBit(int num, int i) {
        return num & (-1 << (i + 1));
    }

    /**
     * 해당 index 에 지정된 값을 넣는 함수
     *
     * @param num
     * @param i
     * @return
     */
    static int updateBit(int num, int i, int val) {
        return (num & ~(1 << i)) | (val << i);

    }


    public static void main(String[] args){
        //1001
        System.out.println("getBit = "+getBit(9,3));
        //0101
        System.out.println("getBit = "+getBit(5,3));
        //0101 -> 1101
        System.out.println("setBit = "+setBit(5,3));
        System.out.println("clearBit = "+clearBit(9,3));
        //10101001 ->169 - > 0000001
        System.out.println("clearLeftBit = "+clearLeftsBit(169,3));
        //10101001 -> 169 -> 1010000 -> 160
        System.out.println("clearRightBit ="+clearRightBit(169,3));
        System.out.println("UpdateBit ="+updateBit(169,3,0));
    }
}

