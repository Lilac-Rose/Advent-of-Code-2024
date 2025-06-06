package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Day2Part1
{
    public static void main(String[] Args)
    {
        int safeReports = 0;

        File input = new File("src/Day2/Day2Input.txt");
        try {
            Scanner fileReader = new Scanner(input);

            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                if (line.isEmpty()) {
                    continue;
                }
                String[] parts = line.split(" ");
                ArrayList<Integer> currentReport = new ArrayList<>();


                for (String part : parts) {
                    currentReport.add(Integer.parseInt(part));
                }

                if (isReportSafe(currentReport) || canBeMadeSafe(currentReport))
                {
                    safeReports++;
                }
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found: " + e.getMessage());
        }

        System.out.println(safeReports);
    }

    private static boolean isReportSafe(ArrayList<Integer> report)
    {
        if (report.size() < 2)
        {
            return true;
        }

        int firstDiff = report.get(1) - report.get(0);
        if (firstDiff == 0)
        {
            return false;
        }

        boolean isIncreasing = firstDiff > 0;

        for (int i = 0; i < report.size()- 1; i++) {
            int current = report.get(i);
            int next = report.get(i + 1);
            int diff = next - current;

            if (diff == 0) {
                return false;
            }

            if ((isIncreasing && diff <= 0) || (!isIncreasing && diff >= 0))
            {
                return false;
            }

            if (Math.abs(diff) < 1 || Math.abs(diff) > 3)
            {
                return false;
            }
        }
        return true;
    }

    private static boolean canBeMadeSafe(ArrayList<Integer> report)
    {
        if(report.size() <= 2)
        {
            return true;
        }

        for(int i = 0; i < report.size(); i++)
        {
            ArrayList<Integer> modifiedReport = new ArrayList<>(report);
            modifiedReport.remove(i);
            i--;
            i++;
            if(isReportSafe(modifiedReport))
            {
                return true;
            }
        }

        return false;
    }
}
