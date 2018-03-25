package wekaia;

import java.io.BufferedReader;
import java.io.FileReader;
import weka.core.Instances;
import weka.clusterers.EM;

public class TestWekaSegmentacion {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// load data
		//String ruta= "f://bank-data.arff";
		String ruta= "f://estudiantes.arff";
		Instances data = new Instances(new BufferedReader(new FileReader(ruta)));

		// new instance of clusterer
		EM model = new EM();
		// build the clusterer
		model.buildClusterer(data);
		System.out.println(model);

	}

}
