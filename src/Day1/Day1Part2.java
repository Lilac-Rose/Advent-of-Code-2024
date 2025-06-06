package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Day1Part2
{
    public static void main(String[] args)
    {
        ArrayList<Integer> leftNumbers = new ArrayList<>();
        ArrayList<Integer> rightNumbers = new ArrayList<>();

        int similarityScore = 0;

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

            for (int i = 0; i < leftNumbers.size(); i++) {
                int similar = 0;

                for (int y = 0; y < rightNumbers.size(); y++) {
                    int leftNumber = leftNumbers.get(i);
                    int rightNumber = rightNumbers.get(y);

                    if (leftNumber == rightNumber) {
                        similar++;
                    }
                }

                similarityScore += leftNumbers.get(i) * similar;
            }

            System.out.println(similarityScore);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}