import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void sort(int[] numbers) {
        quickSort(numbers, 0, numbers.length - 1);
    }

    private static void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = array[right];
        int leftPointer = left;
        int rightPointer = right;

        //while traversing from left to right but not crossing over
        while (leftPointer < rightPointer) {
            //find the number on the left side of the array larger than pivot
            while (array[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }
            //find the number on the right side of the array smaller than pivot
            while (array[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }
            //swap bigger# on left with smaller# on right
            swap(array, leftPointer, rightPointer);
        }
        //swap the pivot into place //either left or right work
        swap(array, leftPointer, right);
        //recursive LEFT SIDE
        quickSort(array, left, leftPointer - 1);
        //recursive RIGHT SIDE
        quickSort(array, leftPointer + 1, right);
    }

    private static void swap(int[] array, int num1, int num2) {
        int temp = array[num1];
        array[num1] = array[num2];
        array[num2] = temp;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        String[] values = scanner.nextLine().split("\\s+");
        int[] numbers = Arrays.stream(values)
                .mapToInt(Integer::parseInt)
                .toArray();
        sort(numbers);
        Arrays.stream(numbers).forEach(e -> System.out.print(e + " "));
    }
}