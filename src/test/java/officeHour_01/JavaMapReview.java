package officeHour_01;

import java.util.*;

public class JavaMapReview {
    public static void main(String[] args) {
        Deque<Integer> integerDeque = new ArrayDeque<>() ;
            integerDeque.add(90);
            integerDeque.add(80);
            integerDeque.add(79);
            integerDeque.add(20);
        //System.out.println("integerDeque.peek() = " + integerDeque.peek());
        System.out.println("integerDeque.poll() = " + integerDeque.poll());
        LinkedHashMap<String, String> map = new LinkedHashMap<>();

        map.put("First name", "Najeeb");
        map.put("Last name", "Sohrabi");
        map.put("Occupation", "Student");
        map.put("Age", "21");

        map.putIfAbsent("First name", "Najeeb");
        System.out.println("map = " + map);

        HashMap<String, String> map2 = new HashMap<>(map);
        System.out.println("map2 = " + map2);

    }
    }