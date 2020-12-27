import java.util.Stack;

public class StackSt {
    public static void main (String[] args){
        Stack<Integer>s1 = new Stack<Integer>();
        s1.push(3);
        s1.push(5);
        s1.push(1);
        s1.push(6);
        sort(s1);
        System.out.println(s1.pop());

    }
    private static void sort(Stack<Integer> s1){
        //두번째 스텍
        Stack<Integer> s2 = new Stack<Integer>();
        while (!s1.isEmpty()){
            //정렬이 안되있는 함수를 하나씩 돌면서 pop 한 data 를 임시로 저장
            int tmp = s1.pop();
            //s2의 값이 s1보다 클때
            while (!s2.isEmpty()&&s2.peek() > tmp){
            //s2를 pop 해서 s1에 옮김
                s1.push(s2.pop());
            }
            //s2가 s1보다 작을때
            s2.push(tmp);
        }
        //첫번째 stack 은 비어있고 두번째 stack 에 정렬된 data 들이 들어가있음
        //다시 s1에 부으기
        while (!s2.isEmpty()){
            s1.push(s2.pop());
        }
    }
}
