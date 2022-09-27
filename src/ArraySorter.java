import java.util.Scanner;

public class ArraySorter {
    private Scanner scanner = new Scanner(System.in);
    private int capacity;
    int actualNumberOfElements = 0;   // for optimization purposes
    private int[] initialArray;
    private int[] sortedArray;

    public void getIntegers(int capacity) {
        this.capacity = capacity;
        initialArray = new int[capacity];
        int counter = 0;
        System.out.println("Enter " + capacity + " integer numbers. If invalid (non-integer) character is entered, the loop will be broken.\n");

        for(int i = 1; i <= capacity; i++) {
            System.out.print("Enter number " + i + ": ");
            if(scanner.hasNextInt()) {
                initialArray[i -1] = scanner.nextInt();
                actualNumberOfElements++;
            } else {
                System.out.println("An invalid value \"" + scanner.next() + "\" has been entered, therefore the loop is now breaking at " + counter + " entered values out of " + capacity + " possible");
                break;
            }
        }

        sortArray();
    }

    public void printArray() {
        if(initialArray == null) {
            System.out.println("The array is empty. Fill it in with integers first.");
            return;
        }
        int[] arrayToPrint;
        String chosenArray;
        System.out.print("\nWhich array do you want to print? The basic (1) or the sorted one (2)? ");
        if(scanner.hasNextInt()) {
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    arrayToPrint = initialArray;
                    chosenArray = "The initial ";
                    break;
                case 2:
                    arrayToPrint = sortedArray;
                    chosenArray = "The sorted ";
                    break;
                default:
                    System.out.println("Invalid choice value");
                    return;
            }
        } else {
            System.out.println("Invalid choice value");
            return;
        }



        System.out.println("\n\n" + chosenArray + "array is as follows: ");

        for (int i = 1; i <= actualNumberOfElements; i++) {
            System.out.print(arrayToPrint[i - 1] + "\t");
        }
        System.out.println("\n*************************\n");
    }
    
    public void sortArray() {
        boolean allSorted;
        sortedArray = new int[actualNumberOfElements];
        
        for(int i = 0; i < actualNumberOfElements; i++) {
            sortedArray[i] = initialArray[i];
        }
        
        while(true) {
            int temp;
            allSorted = true;
            
            for(int i = 0; i < actualNumberOfElements - 1; i++) {
                if(sortedArray[i] > sortedArray[i + 1]) {
                    temp = sortedArray[i + 1];
                    sortedArray[i + 1] = sortedArray[i];
                    sortedArray[i] = temp;
                    allSorted = false;
                }
            }
            
            if(allSorted) {
                break;
            }
        }
    }
}
