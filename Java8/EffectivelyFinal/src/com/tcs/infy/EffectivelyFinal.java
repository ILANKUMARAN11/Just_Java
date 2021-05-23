package com.tcs.infy;

public class EffectivelyFinal {

	int j = 0;

	public static void main(String[] args) {

		String effectiveFinal1 = "TEST1";
		Runnable r = new Runnable() {

			@Override
			public void run() {
				// effectiveFinal1="ALL";
				System.out.println(effectiveFinal1);

			}
		};

		String effectiveFinal2 = "TEST2";
		final String effectiveFinal3 = "TEST2";
		Runnable r1 = () -> {
			// effectiveFinal2="ALL";
			System.out.println(effectiveFinal2);
			System.out.println(effectiveFinal3);
		};

	}

}
