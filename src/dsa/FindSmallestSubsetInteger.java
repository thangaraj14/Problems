package dsa;

/*https://www.geeksforgeeks.org/find-smallest-value-represented-sum-subset-given-array/*/
class FindSmallestSubsetInteger {

    int findSmallest(int arr[], int n) {
        int result = 1;

        // Traverse the array and increment 'result' if arr[i] is
        // smaller than or equal to 'result'.
        for (int i = 0; i < n && arr[i] <= result; i++) {
            System.out.println("Result :" + result + ":: arr[" + i + "]" + arr[i]);
            result = result + arr[i];
        }

        return result;
    }

    public static void main(String[] args) {
        FindSmallestSubsetInteger small = new FindSmallestSubsetInteger();
        int arr1[] = { 1, 3, 4, 5 };
        int n1 = arr1.length;
        System.out.println(small.findSmallest(arr1, n1));

        int arr2[] = { 1, 2, 6, 10, 11, 15 };
        int n2 = arr2.length;
        System.out.println(small.findSmallest(arr2, n2));

        int arr3[] = { 1, 1, 1, 1 };
        int n3 = arr3.length;
        System.out.println(small.findSmallest(arr3, n3));

        int arr4[] = { 1, 1, 3, 4 };
        int n4 = arr4.length;
        System.out.println(small.findSmallest(arr4, n4));

    }
}