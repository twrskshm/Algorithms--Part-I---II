public class TwoSum {
    public static int twoSum(final int[] array) {
        int result = 0;

        for (int i = 0; i < array.length - 1; i++)
            for (int j = i + 1; j < array.length; j++)
                if (array[i] + array[j] == 0)
                    result++;

        return result;
    }
}
