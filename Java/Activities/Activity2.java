package Activities;

public class Activity2 {

    public static void main(String[] args) {

        int[] arr = new int[]{10, 77, 10, 54, -11, 10};
        int sum = GetSumOfTensInArray(arr);
        if(sum==30)
        {
            System.out.println("Sum of 10's in array is equal to 30");
        }
        else
        {
            System.out.println("Sum of 10's in array is not equal to 30");
        }
    }

    public static int GetSumOfTensInArray(int[] arr) {

        int sum = 0;
        for (int i = 0; i <= arr.length - 1; i++) {
            if (arr[i] == 10) {
                sum += arr[i];
            }

        }
        return sum;
    }
}
