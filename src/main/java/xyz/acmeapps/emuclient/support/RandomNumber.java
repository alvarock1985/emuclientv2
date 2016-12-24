package xyz.acmeapps.emuclient.support;

import java.util.Random;

public class RandomNumber {

	int value;
	
	public int genInt(){
		
		Random randomGen = new Random();
		value = randomGen.nextInt(15);
		return value;	
	}
}
