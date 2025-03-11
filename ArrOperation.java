
import java.util.*;

/*
 * class for the finding the following functionalities
 * 1) finding the largest subArray whose reverse is present in the array
 * 2) finding the count of clumps whose cnt is >= 2
 * 3) rearranging the array, Y after X and returning the updated
 * 4) spliting the array, when both the halfs having the same sum
*/


class ArrOperation {

    // finding the largest subarry having the reverse in the array
    static int largestMirror(int[] arr) {

        // Exception handling
        if (arr.length == 0) {
            throw new AssertionError("Input array is null");
        }
        int maxLength1 = 0;

        // iterating the array from starting
        for (int i = 0; i < arr.length; i++) {
            int j = arr.length - 1, length = 0;
            for (int p = i; p < arr.length; p++) {
                if (arr[p] == arr[j--]) {
                    length++;
                } else {
                    length = 0;
                }
                maxLength1 = Math.max(maxLength1, length);
            }
        }

        // reversing the array
        int maxLength2 = 0;
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }

        // again iterating the array from starting
        for (int i = 0; i < arr.length; i++) {
            int j = arr.length - 1, length = 0;
            for (int p = i; p < arr.length; p++) {
                if (arr[p] == arr[j--]) {
                    length++;
                } else {
                    length = 0;
                }
                maxLength2 = Math.max(maxLength2, length);
            }
        }

        return Math.max(maxLength1, maxLength2);  
    }

    // method for finding the count of clumps having elemets >= 2
    static int clumps(int[] arr) {

        // Exception handling
        if (arr.length == 0) {
            throw new AssertionError("input array length is null");
        }
        int count = 1, ans = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                count++;
            } else {
                if (count >= 2) {
                    ans++;
                }
                count = 1;
            }
        }

        if (count >= 2) {       // count if it is a valid clump
            ans++;
        }

        return ans;
    }

    // rearranging the array having Y after X 
    static int[] fixXY(int[] arr, int X, int Y) {

        // Exception handling
        int xCount = 0, yCount = 0;

        if (arr.length == 0) {
            throw new AssertionError("Input array is null");
        }

        if(arr[arr.length - 1] == X) {
            throw new AssertionError("last element should not be X");
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] == X && arr[i] == X) {
                throw new AssertionError("the two X can't be adjacent");
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == X) {
                xCount++; 
            }else if (arr[i] == Y) {
                yCount++;
            }
        }

        if (xCount != yCount) {
            throw new AssertionError("count of X and Y is not same");
        }

        Queue<Integer> q = new LinkedList<>();

        // storing the indexes of Y in queue in the array
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == Y) {
                q.offer(i);
            }
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] == X) {
                int index = q.poll();

                // code for swaping
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;

            }
        }

        return arr ;
    }

    // splitting the array into two halfs having the equal sum
    static int splitArray(int[] arr) {

        // Exception handling
        if (arr.length == 0) {
            throw new AssertionError("Input array is null");
        }
        int sum = 0, ans = 0;

        for (int i : arr) {
            sum += i;
        }

        if (sum % 2 != 0) {
            return -1;
        }

        int temp = 0;

        for (int i = 0; i < arr.length; i++) {
            if (temp == sum / 2) {
                ans = i;
            }
            temp += arr[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the system: ");

        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("1) largestMirror");
                System.out.println("2) clumps");
                System.out.println("3) findXY ");
                System.out.println("4) split the array");
                System.out.println("5) Exit the program");

                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();

                if (choice == 1) {
                    System.out.print("Enter the size of the arr: ");
                    int size = sc.nextInt();

                    int[] arr = new int[size];
                    System.out.print("Enter the array: ");

                    for (int i = 0; i < arr.length; i++) {
                        arr[i] = sc.nextInt();
                    }

                    int ans = largestMirror(arr);

                    System.out.println("Answer is: " + ans);
                } else if (choice == 2) {
                    System.out.print("Enter the size of the arr: ");
                    int size = sc.nextInt();

                    int[] arr = new int[size];
                    System.out.print("Enter the array: ");

                    for (int i = 0; i < arr.length; i++) {
                        arr[i] = sc.nextInt();
                    }

                    int ans = clumps(arr);

                    System.out.println("Answer is: " + ans);

                } else if (choice == 3) {
                    try {
                        System.out.print("Enter the size of the arr: ");
                        int size = sc.nextInt();

                        int[] arr = new int[size];

                        System.out.print("Enter the array: ");

                        for (int i = 0; i < arr.length; i++) {
                            arr[i] = sc.nextInt();
                        }

                        System.out.print("Enter the X: ");
                        int X = sc.nextInt();

                        System.out.print("Enter the Y: ");
                        int Y = sc.nextInt();

                        int[] ans = fixXY(arr, X, Y);

                        System.out.print("The output array is: ");

                        for (int i : arr) {
                            System.out.print(i + " ");
                        }
                    } catch (AssertionError e) {
                        System.out.println("Assertion error came");
                    }

                } else if (choice == 4) {
                    System.out.print("Enter the size of the arr: ");
                    int size = sc.nextInt();

                    int[] arr = new int[size];

                    System.out.print("Enter the array: ");
                    for (int i = 0; i < arr.length; i++) {
                        arr[i] = sc.nextInt();
                    }

                    int ans = splitArray(arr);

                    System.out.println("Answer is: " + ans);

                } else {
                    break;
                }

            } catch (Exception e) {
                System.out.println("Enter the correct data: ");
                sc.nextLine();
            }

            System.out.println("************************");

        }

        sc.close();
    }
}


