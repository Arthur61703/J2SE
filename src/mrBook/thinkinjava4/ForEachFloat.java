package mrBook.thinkinjava4;

import java.util.Random;

public class ForEachFloat {

	public static void main(String[] args) {
		Random rand = new Random(41);
		float f[] = new float[4];
		
		for(int i = 0; i<f.length; i++){
			f[i] = rand.nextFloat();
		}
		for(float i:f){
			System.out.println(i);
		}
		

	}

}
