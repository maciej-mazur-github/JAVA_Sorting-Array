import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class ArraySorter {
    private Scanner scanner = new Scanner(System.in);
    private int capacity;
    int actualNumberOfElements;
    private int[] array;
    private int[] sortedArray;

    public int[] getIntegers(int capacity) {
        this.capacity = capacity;
         array = new int[capacity];
        int counter = 0;
        System.out.println("Enter " + capacity + " integer numbers. If invalid (non-integer) character is entered, the loop will be broken.\n");

        for(int i = 1; i <= capacity; i++) {
            System.out.print("Enter number " + i + ": ");
            if(scanner.hasNextInt()) {
                array[i -1] = scanner.nextInt();
                counter++;
            } else {
                System.out.println("An invalid value \"" + scanner.next() + "\" has been entered, therefore the loop is now breaking at " + counter + " entered values out of " + capacity + " possible");
                break;
            }
        }

        actualNumberOfElements = counter < capacity ? counter : capacity;
        return array;
    }

    public void printArray() {
        int[] arrayToPrint;
        System.out.print("\nWhich array do you want to print? The basic (1) or the sorted one (2)? ");
        if(scanner.hasNextInt()) {
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    arrayToPrint = array;
                    break;
                case 2:
                    arrayToPrint = sortedArray;
                    break;
                default:
                    System.out.println("Invalid choice value");
                    return;
            }
        } else {
            System.out.println("Invalid choice value");
            return;
        }

        if(arrayToPrint == null) {
            System.out.println("The array is empty. Fill it in with integers first.");
            return;
        }

        System.out.println("\n\nThe array earlier entered is as follows: ");

        for (int i = 1; i <= actualNumberOfElements; i++) {
            System.out.print(arrayToPrint[i - 1] + "\t");
        }
        System.out.println("\n*************************\n");
    }
    
    public int[] sortIntegers() {
        boolean allSorted;
        sortedArray = new int[capacity];
        
        for(int i = 0; i < actualNumberOfElements; i++) {
            sortedArray[i] = array[i];
        }
        
        while(true) {
            int temp;
            allSorted = true;
            
            for(int i = 0; i < actualNumberOfElements - 1; i++) {
                if(sortedArray[i + 1] > sortedArray[i]) {
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

        return sortedArray;
    }
}
