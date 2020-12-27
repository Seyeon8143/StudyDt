import java.util.LinkedList;

 class Hash {
     class Node {
         String key;//검색할 키
         String value;//보여질 결과값

         //노드를 생성할때 key 와 value 값을 받아 할당
         public Node(String key, String value) {
             this.key = key;
             this.value = value;
         }

         //value 를 가져오고
         String value() {
             return value;
         }

         //저장
         void value(String value) {
             this.value = value;
         }
     }

     //data 를 저장할 linkedlist 를 생성
     LinkedList<Node>[] data;

     //해쉬테이블을 생성 할때 해쉬테이블의 크기를 얼마만큼 크기로 만들지 미리 선언
     Hash(int size) {
         this.data = new LinkedList[size];
     }

     //key 를 받아서 hashcode 를 반환하는 해쉬 알고리즘
     int getHashCode(String key) {
         int hashcode = 0;
         //각 글자의 ascii 값을 가져옴?????
         for (char c : key.toCharArray()) {
             hashcode += c;
         }
         return hashcode;
     }

     //해쉬코드를 받아서 배열방의 인덱스로 변환하는 함수
     int convertToIndex(int hashcode) {
         //해쉬코드를 배열방의 크기로 나눈 나머지가 배열방의 index가 됨
         return hashcode % data.length;
     }

     //인덱스로 배열방을 찾은 이후에 배열방에 여러개 노드가 존재한다면 검색 key 를 이용해서 해당Node 를 찾아오는 함수
     Node searchKey(LinkedList<Node> list, String key) {
         if (list == null) return null;
         //배열방에 있는 linkedlist를 돌면서 node 의 키가 검색 key와 같은지를 확인해서 같으면 node 를 반환
         for (Node node : list) {
             if (node.key.equals(key)) {
                 return node;
             }
         }
         return null;
     }

     //data 를 받아와서 저장하는 함수
     void put(String key, String value) {
         //key 를 사용해서 hashcode 를 가져옴
         int hashcode = getHashCode(key);
         //받아온 hash 코드를 이용해서 배열방번호를 받아옴
         int index = convertToIndex(hashcode);
         System.out.println(key+", hashcode(" + hashcode + "),index(" + index +")");
         //배열방번호를 이용해서 기존 배열 방에 있는 data 를 가져옴
         LinkedList<Node> list = data[index];
         if (list == null) {
             list = new LinkedList<Node>();
             //해당 list 를 배열방에 넣어줌
             data[index] = list;
         }
         //배열방에 기존에 해당키로 data를 가지고있는지 node 를 받아옴
         Node node = searchKey(list, key);
         if (node == null) {
             list.addLast(new Node(key, value));
         }//node 가 null 이 아닐때는 해당 node 의 값을 대채해주는 걸로 중복 key 처리
         else {
             node.value(value);
         }
     }

     String get(String key) {
         int hashcode = getHashCode(key);
         int index = convertToIndex(hashcode);
         LinkedList<Node> list = data[index];
         //링크드 리스트 안에 해당 key를 가지는 노드를 검색
         Node node = searchKey(list, key);
         return node == null ? "Not found" : node.value();
     }
 }
    public class HashTable{
     public static void main (String[] args){
         //3으로 고정된 배열방 생성
         Hash h = new Hash(3);
         h.put("sung","She is pretty");
         h.put("jin","She is a model");
         h.put("hee", "She is an angel");
         h.put("min", "Shs is cute");
         //중복 값 처리 pretty 가 없어지도 beautiful 로 대채
         h.put("sung", "she is beautiful");
         System.out.println(h.get("sung"));
         System.out.println(h.get("jin"));
         System.out.println(h.get("hee"));
         System.out.println(h.get("min"));

         //없는 데이터를 입력했을때
         System.out.println(h.get("jae"));



    }


}
