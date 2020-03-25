public class BinarySearch {
    public static int binarySearch(final int[] array, final int target) {
        int left = 0, right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] < target)
                left = mid + 1;
            else if (array[mid] > target)
                right = mid - 1;
            else
                return mid;
        }

        return -1;
    }
}
