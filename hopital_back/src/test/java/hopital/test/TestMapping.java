package hopital.test;

import hopital.context.Singleton;
import hopital.model.Visite;

public class TestMapping {

	public static void main(String[] args) {
		
		
		for(Visite f : Singleton.getInstance().getDaoVisite().findAllByIdPatient(1)) 
		{
			System.out.println(f);
		}
		
	}

}
