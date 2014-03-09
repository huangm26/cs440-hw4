package run;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import weka.core.Instances;

public class Main {
	
	public void readData()
	{
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("/User/huangm26/git/cs440-hw4/bin/DataSet1.arff"));
		}
		catch (FileNotFoundException e)
		{
			System.out.println(e);
		}
		catch (IOException e1)
		{
			System.out.println(e1);
		}
	}
	
	public static void main(String[] args)
	{
		
	
	}

}
