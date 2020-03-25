public class ThreeSum {
    public static int threeSum(final int[] array) {
        int result = 0;

        for (int i = 0; i < array.length - 2; i++)
            for (int j = i + 1; j < array.length - 1; j++)
                for (int k = j + 1; k < array.length; k++)
                    if (array[i] + array[j] + array[k] == 0)
                        result++;

        return result;
    }
}
