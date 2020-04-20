import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class OddOccurrencesInArray {
    public int solution(int[] A) {
        if (A.length % 2 == 0) {
            return 1;
        }
        //collect will return map of number and its count
        final HashMap<Integer, Integer> collect = Arrays.stream(A).collect(HashMap::new, this::accumulate, (r1, r2) -> {});
        return collect.entrySet().stream().filter(a -> a.getValue() % 2 != 0).map(Map.Entry::getKey).findAny().orElse(0);
    }

    private void accumulate(Map<Integer, Integer> r, int i) {
        if (r.containsKey(i)) {
            r.put(i, r.get(i) + 1);
        } else {
            r.put(i, 1);
        }
    }
}
