package com.example.setapp;

public class Card {
	private int CODE;
	//0 = 1 card,  1 = 2 cards, 2 = 3 cards
	private final int NUMBER_OF_CARDS;
	//0 = Red, 1 = Purple, 2 = Green
	private final int COLOR;
	//0 = Empty, 1 = Striped, 2 = Filled
	private final int FILLING;
	//0 = Cylinder,  1= Squiggle, 2 = Diamond
	private final int SHAPE;
	
	
	
	public Card(int number_of_cards, int color, int filling, int shape, int code) {
		NUMBER_OF_CARDS = number_of_cards;
		COLOR = color;
		FILLING = filling;
		SHAPE = shape;
		CODE = code;
	}
	
	public int getNUMBER_OF_CARDS() {
		return NUMBER_OF_CARDS;
	}

	public int getCOLOR() {
		return COLOR;
	}

	public int getFILLING() {
		return FILLING;
	}

	public int getSHAPE() {
		return SHAPE;
	}
	
	public int getCODE() {
		return CODE;
	}
}
