package resources;

import java.util.HashMap;
import java.util.Map;

public enum GameType {

	X_BOX(7,1.0),
	PS2(7,1.5),
	AMSTRAD(14,.5),
	DEFAULT(28,0);

	private int maxLoanPeriod;
	private double surcharge;

	private static Map<String, GameType> map = new HashMap();

	static {
		map.put("X-Box", X_BOX);
		map.put("PS2", PS2);
		map.put("Amstrad", AMSTRAD);
	}

	GameType(int maxLoanPeriod, double surcharge) {
		this.maxLoanPeriod = maxLoanPeriod;
		this.surcharge = surcharge;
	}

	public static GameType get(String key) {
		return map.containsKey(key) ? map.get(key) : DEFAULT;
	}

	public int getMaxLoanPeriod() {
		return maxLoanPeriod;
	}
	public double getSurcharge() {
		return surcharge;
	}

}
