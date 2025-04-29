import java.io.*;
import java.util.Scanner;

public class FileAnalyzer 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in); 
        System.out.print("Enter a filename: ");
        String filename = input.nextLine();

        try 
        {
            // Check if filename is empty
            if (filename.trim().isEmpty()) 
            {
                throw new EmptyFileNameException("Filename cannot be empty");
            }

            File file = new File(filename);
            if (!file.exists()) 
            {
                // Check if file exists
                throw new FileNotFoundException("File not found: " + filename);
            }

            // Read and analyze file
            int lineCount = 0;
            int wordCount = 0;
            int charCount = 0;

            try (BufferedReader reader = new BufferedReader(new FileReader(file))) 
            {
                String line;
                while ((line = reader.readLine()) != null) 
                {
                    lineCount++;
                    charCount += line.length() + 1; // +1 for newline character
                    String[] words = line.split("\\s+");
                    wordCount += words.length;
                }
            }

            // Display results to console
            System.out.println("File analysis results:");
            System.out.println("Lines: " + lineCount);
            System.out.println("Words: " + wordCount);
            System.out.println("Characters: " + charCount);

            System.out.println("\nAnalysis results written to analysis_output.txt!");
            System.out.println("File analysis completed successfully!");

            // Write results to output file
            try (PrintWriter writer = new PrintWriter("analysis_output.txt")) 
            {
                writer.println("File analysis results:");
                writer.println("\nLines: " + lineCount);
                writer.println("Words: " + wordCount);
                writer.println("Characters: " + charCount);

                writer.println("\nFile analysis completed successfully!");
            }

        } 
        // Handle custom exception for empty filename
        catch (EmptyFileNameException e) 
        {
            System.err.println("Error: " + e.getMessage());
        }
        // Handle file not found exception 
        catch (FileNotFoundException e) 
        {
            System.err.println("Error: " + e.getMessage());
        } 
        // Handle IO exceptions for file reading
        catch (IOException e) 
        {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
