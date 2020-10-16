package com.game.service;

import com.game.enumeration.Toss;

public class CoinToss {	
//	public static int number;
//	public int number2;
	
	public static Toss getProbability() {
		if (Math.random() < 0.5) return Toss.HEAD;
		else return Toss.TAIL;
	}
}
