import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String digit = in.nextLine();
        Map<Character, Integer> counts = new HashMap<>();
        for (int i = 0; i < digit.length(); i++) {
            counts.put(digit.charAt(i), counts.getOrDefault(digit.charAt(i), 0) + 1);
        }
        Iterator<Map.Entry<Character, Integer>> iterator = counts.entrySet().iterator();
        boolean needRemove = false;
        List<Character> needRemoves = new ArrayList<>();
        while (iterator.hasNext()) {
            Map.Entry<Character, Integer> next = iterator.next();
            if (next.getValue() > 2) {
                needRemove = true;
                needRemoves.add(next.getKey());
            }
        }
        if (needRemove) {
            String current = digit;
            for (int i = 0; i < needRemoves.size(); i++) {
                current = current.replace(needRemoves.get(i), '_');
                current = findMax(current, needRemoves.get(i));
            }
            System.out.println(current);
            return;
        }
        System.out.println(digit);
    }

    public static String findMax(String s, char c) {
        char[] chars = s.toCharArray();
        List<Integer> results = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int position = s.length() - s.replace("-", "").length();
        int count = position * (position - 1) / 2;
        while (count >= 0) {
            int add = 2;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '_' && add > 0) {
                    chars[i] = c;
                    add--;
                }
                if (chars[i] != '_') {
                    sb.append(chars[i]);
                }
            }
            results.add(Integer.parseInt(sb.toString()));
            count--;
        }
        Object[] objects = results.toArray();
        Arrays.sort(objects);
        return String.valueOf(objects[objects.length - 1]);
    }
}