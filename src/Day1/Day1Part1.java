package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

/*
Maybe the lists are only off by a small amount! To find out, pair up the numbers and measure how far apart they are. Pair up the smallest number in the left list with the smallest number in the right list, then the second-smallest left number with the second-smallest right number, and so on.

Within each pair, figure out how far apart the two numbers are; you'll need to add up all of those distances. For example, if you pair up a 3 from the left list with a 7 from the right list, the distance apart is 4; if you pair up a 9 with a 3, the distance apart is 6.

*/

public class Day1Part1
{
    public static void main(String[] args)
    {
        ArrayList<Integer> leftNumbers = new ArrayList<>();
        ArrayList<Integer> rightNumbers = new ArrayList<>();
        int distance = 0;

        File input = new File("src/Day1/Day1Input.txt");
        try {
            Scanner fileReader = new Scanner(input);

            while (fileReader.hasNextLine())
            {
                String line = fileReader.nextLine();
                String[] parts = line.split(" {3}");
                leftNumbers.add(Integer.parseInt(parts[0]));
                rightNumbers.add(Integer.parseInt(parts[1]));
            }

            leftNumbers.sort(null);
            rightNumbers.sort(null);

            for(int i = 0; i < leftNumbers.size(); i++)
            {
                distance += Math.abs(leftNumbers.get(i) - rightNumbers.get(i));
            }

            System.out.println(distance);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}