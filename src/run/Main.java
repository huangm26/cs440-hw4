package run;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import weka.classifiers.functions.MultilayerPerceptron;
import weka.core.Instances;
//import weka.core.Instances;

public class Main {
	static Instances data;
	static MultilayerPerceptron mp;
	public static void readData() throws IOException
	{

		File file = new File("DataSet1.arff");
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		data = new Instances(br);

		br.close();

	}
	
	public static void set_classification_index()
	{
		data.setClassIndex((data.numAttributes()-1));
	}
	
	public static void train_perceptron() throws Exception
	{
		mp = new MultilayerPerceptron();
		Instances trainingData = new Instances(data,0,(int)(data.numInstances()*0.8));
		mp.buildClassifier(trainingData);
	}
	
	public static void test_classifier() throws Exception
	{
		Instances testingData = new Instances(data,(int)(data.numInstances()*0.8),data.numInstances()-(int)(data.numInstances()*0.8));
	    int correct=0;
	    int incorrect=0;
	    for (int i = 0; i < testingData.numInstances(); i++){
	    double assignedClass = mp.classifyInstance(testingData.instance(i));
		double originalClass = testingData.instance(i).classValue();
		if (assignedClass==originalClass)
			correct++;
		else
			incorrect++;
	    }
		System.out.printf("%f\n",100*(double)correct/(correct+incorrect));//Accuracy
	}
	
	public static void main(String[] args) throws Exception
	{
		readData();
		set_classification_index();
		train_perceptron();
		test_classifier();
	
	}

}
