import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class ArraySorter {
    private Scanner scanner = new Scanner(System.in);
    private int capacity;
    private int counter = 0;

    public int[] getIntegers(int capacity) {
        this.capacity = capacity;
        int[] array = new int[capacity];
        System.out.println("Enter " + capacity + " integer numbers. If invalid (non-integer) character is entered, the loop will be broken.\n");

        for(int i = 1; i <= capacity; i++) {
            System.out.print("Enter number " + i + ": ");
            if(scanner.hasNextInt()) {
                array[i -1] = scanner.nextInt();
                counter++;
            } else {
                System.out.println("An invalid value \"" + scanner.nextLine() + "\" has been entered, therefore the loop is now breaking at " + counter + " entered values out of " + capacity + " possible");
                break;
            }
        }

        return array;

    }
}
