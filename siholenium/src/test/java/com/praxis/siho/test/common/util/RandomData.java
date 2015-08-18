package com.praxis.siho.test.common.util;

public class RandomData {

	public static int generateRandomNumberUpTo(int top){
		return (int)(Math.random() * top);
	}
	
	public static int generateRandomNonZeroNumberUpTo(int top){
		return (int)(Math.random() * top) == 0 ? 1 : (int)(Math.random() * top);
	}

	public static int generateRandomNumberFromAToZ(int a, int z){
		return ((int)(Math.random() * (z-a))) + a;
	}
	public static int generateRandomNumberFromAToB(int fromA, int toB){
		if(fromA > toB){
			int permutation = fromA;
			fromA = toB;
			toB = permutation;
		}
		return range((int)(Math.random() * toB), fromA, toB);
	}	
	private static int range(int range, int minimum, int max){
		if (range > max) {
			range = range - max;
		}
		if (range < minimum) {
			range = range(range + minimum, minimum, max);
		}
		return range;
	}

	public static String getRandomLetter(boolean  isVowel){
		String letter = "";
		int random = (int)(26 * Math.random());
		if (isVowel) {
			random = (int)(6 * Math.random());			
		} else {
			if (random >= 0 && random < 6) {
				random += 6;
			}
		}
		
		switch(random){
		case 0:
		case 1: 
			letter = "A";
			break;
		case 2 : 
			letter = "E";
			break;
		case 3 : 
			letter = "I";
			break;
		case 4: 
			letter = "O";
			break;
		case 5: 
			letter = "U";
			break;
		case 6:
			letter = "B";
			break;
		case 7:
			letter = "C";
			break;
		case 8:
			letter = "D";
			break;
		case 9:
			letter = "F";
			break;
		case 10:
			letter = "G";
			break;
		case 11:
			letter = "H";
			break;
		case 12:
			letter = "J";
			break;
		case 13:
			letter = "K";
			break;
		case 14:
			letter = "L";
			break;
		case 15:
			letter = "M";
			break;
		case 16:
			letter = "N";
			break;
		case 17:
			letter = "P";
			break;
		case 18:
			letter = "Q";
			break;
		case 19:
			letter = "R";
			break;
		case 20:
			letter = "S";
			break;
		case 21:
			letter = "T";
			break;
		case 22:
			letter = "V";
			break;
		case 23:
			letter = "W";
			break;
		case 24:
			letter = "X";
			break;
		case 25:
			letter = "Y";
			break;
		case 26: 
			letter = "Z";
			break;
			
		default:
			letter = " Anomaly in random data ";
			break;
		}	
		return letter;
	}
}
