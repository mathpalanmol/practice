import java.util.HashMap;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        pracHashMap();
        pracArrayList();
        }

    private static void pracArrayList() {

    }

    private static void pracHashMap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("a","x");
        map.put("b","y");
        map.put("c","z");

        System.out.println(map.get("b"));
        System.out.println(map.containsKey("b"));
        System.out.println(map.containsValue("b"));
        System.out.println(map.containsValue("y"));

        for(Map.Entry<String,String> entry: map.entrySet()){
            System.out.println("key:" + entry.getKey());
            System.out.println("key:" + entry.getValue());
        }
        System.out.println(map.remove("a"));
        System.out.println(map.remove("a"));
    }

}
}