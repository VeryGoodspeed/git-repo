package com.praxis.siho.test.dataprovider;
import org.testng.annotations.DataProvider;
import static com.praxis.siho.test.dataprovider.DataProviderReferencesConstants.*;

public class SmokeTestDP {

	@DataProvider(name = SIGNON)
	public static Object [][] signonProvider(){
		return new Object[][] {
				{"RALA", "12345678"}
		};
	}

	@DataProvider(name = SIGNON_RENTABILIDAD)
	public static Object [][] signonForRentabilidad(){
		return new Object[][] {
				{"ZAAA", "12345678"}
		};
	}
}
