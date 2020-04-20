
public class BinaryGap {
    public int solution(int N) {
        String binaryString = Integer.toBinaryString(N);
        if (!binaryString.startsWith("1")) {
            return 0;
        }
        int binaryGap = 0;
        int index = 0;
        int binaryLength = binaryString.length();
        while (index == -1 || index < binaryLength - 1) {
            int nextIndex = binaryString.indexOf("1", index + 1);
            if ((nextIndex - index) > 1 && binaryGap < (nextIndex - index)) {
                binaryGap = nextIndex - index-1;
            }
            index = nextIndex;
        }
        return binaryGap;
    }

    public static void main(String[] args) {
        BinaryGap binaryGap = new BinaryGap();
        int solution = binaryGap.solution(5);

        System.out.println("solution = " + solution);
    }
}
