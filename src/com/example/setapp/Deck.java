package com.example.setapp;

import java.util.ArrayList;

public class Deck {
	private ArrayList<Card> deck;
	private boolean[] usedCards;
	
	public Deck() {
		//Using the four nested "for" loops provides each unique combination of card
		int counter = 0;
		deck = new ArrayList<Card>();
		for (int a = 0; a < 3; a++) {
			for (int b = 0; b < 3; b++) {
				for (int c = 0; c < 3; c++) {
					for (int d = 0; d < 3; d++) {
						deck.add(new Card(a,b,c,d,counter));
						counter++;
					}
				}
			}
		}
		usedCards = new boolean[81];
		for (int b = 0; b < usedCards.length; b++) {
			usedCards[b] = false;
		}
	}
	
	public void setUsed(int x) {
		usedCards[x] = true;
	}
	
	public boolean checkUsed(int x) {
		return usedCards[x];
	}
	
	public ArrayList<Card> getDeck() {
		return deck;
	}
	
	public Card getCard(int x) {
		return deck.get(x);
	}
	
	public void setUsedCards(boolean[] cards) {
		this.usedCards = cards;
	}
	
	public boolean[] getUsedCards() {
		return this.usedCards;
	}
	
}
