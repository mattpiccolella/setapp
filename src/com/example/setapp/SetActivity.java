package com.example.setapp;

import java.util.Random;

import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SetActivity extends Activity  {
	private static ImageButton[] hand;
	private static TextView sets;
	private static TextView cards_remaining;
	private static Card[] hand1;
	private static Deck cardDeck;
	private static Button shuffleDeck;
	private int counter = 0;
	private int number_of_sets;
	public static int[] pressed_index;
	private static final String SETKEY = "NUMBEROFSETS";
	private static final String BOOLKEY = "USEDSETS";
	private static final String ARRANGEMENT = "ORDEROFCARDS";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		boolean isSaved = false;
		setContentView(R.layout.activity_set);
		//Starts a new deck of 81 cards, will work with the setImage() method to make sure correct cards are placed
		cardDeck = new Deck();
		//Analogous arrays to keep track of the Images displayed in the current hand and their corresponding Card objects
		hand1 = new Card[12];
		hand = new ImageButton[12];
		int[] arrangement = new int[12];
		number_of_sets = 0;
		if (savedInstanceState != null) {
			number_of_sets = savedInstanceState.getInt(SETKEY);
			cardDeck.setUsedCards(savedInstanceState.getBooleanArray(BOOLKEY));
			arrangement = savedInstanceState.getIntArray(ARRANGEMENT);
			isSaved = true;
		}
		//Initializes the array of the indexes of the pressed cards to dummy variables
		pressed_index = new int[3];
		pressed_index[0]=-1;pressed_index[1]=-1;pressed_index[2]=-1;
		//TextView to show the number of sets, will work with the above variable.
		sets = (TextView)findViewById(R.id.number_of_sets);
		sets.setText("Sets: " + number_of_sets);
		cards_remaining = (TextView)findViewById(R.id.cardsRemaining);
		cards_remaining.setText("Cards Remaining: " + (81 - (3*number_of_sets)));
		//Button that will put down 12 new cards. Used if the user doesn't see or have any sets in his current hand.
		shuffleDeck = (Button)findViewById(R.id.shuffle_deck);
		shuffleDeck.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				for (int i = 0; i < hand.length; i++) {
					setImage(i);
					((ImageView) hand[i]).setColorFilter(Color.argb(0, 0, 0, 0));
				}
				counter=0;
			}
		});
		/* As much as I hate to do it, it seems impossible to pass variables into the anonymous inner class, and changing the listener to an exterior
		 * class would require static methods to set cards, which doesn't seem viable. Leaving the individual definitions for now, will look into 
		 * changing after I get a working prototype
		 */
		hand[0] = (ImageButton)findViewById(R.id.card_1);
		if (isSaved)
			setImage(0, arrangement[0]);
		else 
			setImage(0);
		hand[0].setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				/* Bumps up counter to see how many buttons have been pressed, if 3 checks the set, unpresses the buttons, and discards the correct cards
				 * from the deck if necessary (counter is reset on unpressSet()), pressed_index values are also reset
				 */
				counter++;
					if (counter==3) {
							pressed_index[2] = 0;
							useSet(checkSet());
						}
					else {
					//Sets the current index as one of the pressed_index values, "presses" in the button	
						pressed_index[counter-1] = 0;
						((ImageView) v).setColorFilter(Color.argb(150, 155, 155, 155));
					}
			    }
		});
		hand[1] = (ImageButton)findViewById(R.id.card_2);
		if (isSaved)
			setImage(1, arrangement[1]);
		else 
			setImage(1);
		hand[1].setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				counter++;
					if (counter==3) {
							pressed_index[2] = 1;
							useSet(checkSet());
						}
					else {
						pressed_index[counter-1] = 1;
						((ImageView) v).setColorFilter(Color.argb(150, 155, 155, 155));
					}
			    }
		});
		hand[2] = (ImageButton)findViewById(R.id.card_3);
		if (isSaved)
			setImage(2, arrangement[2]);
		else 
			setImage(2);
		hand[2].setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				counter++;
					if (counter==3) {
							pressed_index[2] = 2;
							useSet(checkSet());
						}
					else {
						pressed_index[counter-1] = 2;
						((ImageView) v).setColorFilter(Color.argb(150, 155, 155, 155));
					}
			    }
		});
		hand[3] = (ImageButton)findViewById(R.id.card_4);
		if (isSaved)
			setImage(3, arrangement[3]);
		else 
			setImage(3);
		hand[3].setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				counter++;
					if (counter==3) {
							pressed_index[2] = 3;
							useSet(checkSet());
						}
					else {
						pressed_index[counter-1] = 3;
						((ImageView) v).setColorFilter(Color.argb(150, 155, 155, 155));
					}
			    }
		});
		hand[4] = (ImageButton)findViewById(R.id.card_5);
		if (isSaved)
			setImage(4, arrangement[4]);
		else 
			setImage(4);
		hand[4].setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
					counter++;
					if (counter==3) {
						pressed_index[2] = 4;
						useSet(checkSet());
					}
					else {
						((ImageView) v).setColorFilter(Color.argb(150, 155, 155, 155));
						pressed_index[counter-1] = 4;
					}
			    }
		});
		hand[5] = (ImageButton)findViewById(R.id.card_6);
		if (isSaved)
			setImage(5, arrangement[5]);
		else 
			setImage(5);
		hand[5].setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
					counter++;
					if (counter==3) {
						pressed_index[2] = 5;
						useSet(checkSet());
					}
					else {
						((ImageView) v).setColorFilter(Color.argb(150, 155, 155, 155));
						pressed_index[counter-1] = 5;
					}
			    }
		});
		hand[6] = (ImageButton)findViewById(R.id.card_7);
		if (isSaved)
			setImage(6, arrangement[6]);
		else 
			setImage(6);
		hand[6].setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
					counter++;
					if (counter==3) {
						pressed_index[2] = 6;
						useSet(checkSet());
					}
					else {
						((ImageView) v).setColorFilter(Color.argb(150, 155, 155, 155));
						pressed_index[counter-1] = 6;
					}
			    }
		});
		hand[7] = (ImageButton)findViewById(R.id.card_8);
		if (isSaved)
			setImage(7, arrangement[7]);
		else 
			setImage(7);
		hand[7].setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
					counter++;
					if (counter==3) {
						pressed_index[2] = 7;
						useSet(checkSet());
					}
					else {
						((ImageView) v).setColorFilter(Color.argb(150, 155, 155, 155));
						pressed_index[counter-1] = 7;
					}
			    }
		});
		hand[8] = (ImageButton)findViewById(R.id.card_9);
		if (isSaved)
			setImage(8, arrangement[8]);
		else 
			setImage(8);
		hand[8].setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
					counter++;
					if (counter==3) {
						pressed_index[2] = 8;
						useSet(checkSet());
					}
					else {
						((ImageView) v).setColorFilter(Color.argb(150, 155, 155, 155));
						pressed_index[counter-1] = 8;
					}
			    }
		});
		hand[9] = (ImageButton)findViewById(R.id.card_10);
		if (isSaved)
			setImage(9, arrangement[9]);
		else 
			setImage(9);
		hand[9].setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
					counter++;
					if (counter==3) {
						pressed_index[2] = 9;
						useSet(checkSet());
					}
					else {
						((ImageView) v).setColorFilter(Color.argb(150, 155, 155, 155));
						pressed_index[counter-1] = 9;
					}
			    }
		});
		hand[10] = (ImageButton)findViewById(R.id.card_11);
		if (isSaved)
			setImage(10, arrangement[10]);
		else 
			setImage(10);
		hand[10].setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
					counter++;
					if (counter==3) {
						pressed_index[2] = 10;
						useSet(checkSet());
					}
					else {
						((ImageView) v).setColorFilter(Color.argb(150, 155, 155, 155));
						pressed_index[counter-1] = 10;
					}
			    }
		});
		hand[11] = (ImageButton)findViewById(R.id.card_12);
		if (isSaved)
			setImage(11, arrangement[11]);
		else 
			setImage(11);
		hand[11].setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
					counter++;
					if (counter==3) {
						pressed_index[2] = 11;
						useSet(checkSet());
					}
					else {
						((ImageView) v).setColorFilter(Color.argb(150, 155, 155, 155));
						pressed_index[counter-1] = 11;
					}
			    }
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.set, menu);
		return true;
	}

	public void onSaveInstanceState(Bundle outstate) {
		super.onSaveInstanceState(outstate);
		outstate.putInt(SETKEY, number_of_sets);
		outstate.putBooleanArray(BOOLKEY, cardDeck.getUsedCards());
		int[] cards = new int[hand1.length];
		for (int x = 0; x < hand1.length; x++) {
			cards[x] = hand1[x].getCODE();
		}
		outstate.putIntArray(ARRANGEMENT,cards);
	}
	//Take an integer index, set the Image at that position to a new, random, unused image
	public void setImage(int x) {
		Random rand = new Random();
		int a = rand.nextInt(81);
		while (cardDeck.checkUsed(a)) {
			a = rand.nextInt(81);
		}
		cardDeck.setUsed(a);
		TypedArray imgs = getResources().obtainTypedArray(R.array.set_imgs);
		hand[x].setImageResource(imgs.getResourceId(a,-1));
		hand1[x] = cardDeck.getCard(a);
	}
	
	public void setImage(int x, int y) {
		cardDeck.setUsed(y);
		TypedArray imgs = getResources().obtainTypedArray(R.array.set_imgs);
		hand[x].setImageResource(imgs.getResourceId(y, -1));
		hand[x].setColorFilter(Color.argb(0,0,0,0));
		hand1[x] = cardDeck.getCard(y);
	}
	
	//Use all of the cards from the set that you collect i.e. mark them as used in the array of booleans in deck only if the set is correct
	//Otherwise unpress the other buttons, reset array and counter
	public void useSet(boolean correctSet) {
		for (int a = 0; a < pressed_index.length; a++) {
			((ImageView) hand[pressed_index[a]]).setColorFilter(Color.argb(0, 0, 0, 0));
			if (correctSet) {
				cardDeck.setUsed(a);
				setImage(pressed_index[a]);
			}
		}
		counter=0;
		pressed_index[0]=-1; pressed_index[1]=-1; pressed_index[2]=-1;
	}
	
	
	//Logic behind checking a set, breaks it down into methods for each of the four attributes
	public boolean checkSet() {
		Card[] cards = new Card[3];
		cards[0] = hand1[pressed_index[0]]; cards[1] = hand1[pressed_index[1]]; cards[2] = hand1[pressed_index[2]];
		if (checkColor(cards) && checkShape(cards) && checkNumber(cards) && checkFilling(cards)) {
			Toast.makeText(SetActivity.this, R.string.correct_set, Toast.LENGTH_SHORT).show();
			number_of_sets++;
			sets.setText("Sets: " + number_of_sets);
			cards_remaining.setText("Cards Remaining: " + (81 - (3*number_of_sets)));
			return true;
		}
		else {
			Toast.makeText(SetActivity.this, R.string.incorrect_set, Toast.LENGTH_LONG).show();
			return false;
		}
	}
	
	private static boolean checkColor(Card[] cards) {
		if (cards[0].getCOLOR()==cards[1].getCOLOR() && cards[1].getCOLOR()==cards[2].getCOLOR()) {
			return true;
		}
		if (cards[0].getCOLOR()!=cards[1].getCOLOR()&&cards[1].getCOLOR()!=cards[2].getCOLOR()&&cards[0].getCOLOR()!=cards[2].getCOLOR()) {
			return true;
		}
		return false;
	}
	
	private static boolean checkShape(Card[] cards) {
		if (cards[0].getSHAPE()==cards[1].getSHAPE() && cards[1].getSHAPE()==cards[2].getSHAPE()) 
			return true;
		if (cards[0].getSHAPE()!=cards[1].getSHAPE()&&cards[1].getSHAPE()!=cards[2].getSHAPE()&&cards[0].getSHAPE()!=cards[2].getSHAPE())
			return true;
		return false;
	}
	
	private static boolean checkNumber(Card[] cards) {
		if (cards[0].getNUMBER_OF_CARDS()==cards[1].getNUMBER_OF_CARDS() && cards[1].getNUMBER_OF_CARDS()==cards[2].getNUMBER_OF_CARDS())
			return true;
		if (cards[0].getNUMBER_OF_CARDS()!=cards[1].getNUMBER_OF_CARDS()&&cards[1].getNUMBER_OF_CARDS()!=cards[2].getNUMBER_OF_CARDS()&&cards[0].getNUMBER_OF_CARDS()!=cards[2].getNUMBER_OF_CARDS()) 
			return true;
		return false;
	}
	
	private static boolean checkFilling(Card[] cards) {
		if (cards[0].getFILLING()==cards[1].getFILLING() && cards[1].getFILLING()==cards[2].getFILLING()) 
			return true;
		if (cards[0].getFILLING()!=cards[1].getFILLING()&&cards[1].getFILLING()!=cards[2].getFILLING()&&cards[0].getFILLING()!=cards[2].getFILLING()) 
			return true;
		return false;
	}
	

}