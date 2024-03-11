package Java;
import java.util.Scanner;

public class MultiDimensionalArrays {
    public static void main(String[] args) {
        int [] arr1 = new int[5];
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter value for 1D array: ");
        for (int i = 0; i < arr1.length; i++) {
            int temp = sc.nextInt();
            arr1[i] = temp;
        }
        System.out.println("The 1D arrays is :");
        for(int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println("");
        System.out.println("Enter value for 2D array: ");
        int[][] arr2 = new int[2][3];
        for(int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                arr2[i][j] = sc.nextInt();
            }
        }
        System.out.println("The 2D array is: ");
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                System.out.print(arr2[i][j] + " ");
            }
            System.out.println("");
        }
        int[][] arr3 = {{1,2,3}, {4,5,6}};
        for(int i = 0; i < arr3.length; i++) {
            for(int j = 0; j < arr3[i].length; j++) {
                System.out.print(arr3[i][j] + " ");
            }
            System.out.println("");
        }
        sc.close();
    }
}