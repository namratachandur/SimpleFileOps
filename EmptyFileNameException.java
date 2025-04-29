// This class defines a custom exception for handling empty file names 

public class EmptyFileNameException extends Exception 
{
    public EmptyFileNameException(String message) 
    {
        super(message);
    }
}
