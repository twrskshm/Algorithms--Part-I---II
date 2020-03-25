public class OneSum {
    public static int oneSum(final int[] array) {
        int result = 0;

        for (int number: array)
            if (number == 0)
                result++;

        return result;
    }
}
