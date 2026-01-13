import java.util.Arrays;

import javax.swing.JOptionPane;

public class MainLogic {

	static int maxMoney;

	static int parseInt(String var) {
		int num = -1;
		try {
			num = Integer.parseInt(var);
		} catch (Exception e) {

		}
		return num;
	}

	public class TextLog {
		static String[] Log = new String[0];

		static String[] Log_Delete(String[] Array) {
			Array = new String[0];
			return Array;
		}

		static String[] Log_Append(String[] Array, String item) {
			String[] Temp = new String[(Array.length)];
			for (int i = 0; i < (Array.length); i++) {
				Temp[i] = Array[i];
			}
			Array = new String[Temp.length + 1];
			for (int i = 0; i < (Temp.length); i++) {
				Array[i] = Temp[i];
			}
			Array[Temp.length] = item;
			return Array;

		}
	}

	public class GameRule {
		public class Game {
			// Ar spēli saistīti iestatījumi
			static int MaxGamePoints;// maksimālais punktu skaits default = 21
			static int DeclareWin;
			static boolean Save;// vai saglabāt
		}

		public class Dealer {
			// Dealer iestatījumi
			static int WhenStop;// punktu skaits, zem kura dealer ņems vēl kārtis
		}

		public class Player {//
			// Spēlētāja iestatījumi
			static int Score;// GameRule.Player.Score
			static int money;
			static int Points;
			static String Name;// GameRule.Player.Name
		}
	}

	public class Player_Action {
		static void New_Card() {
			if (GameRule.Player.Points < (GameRule.Game.MaxGamePoints)) {
				JOptionPane.showMessageDialog(null,
						Lookup.BlackJack.Lang.Text.PlayerAddsNewCard + " " + cards.card_deck[cards.current],
						"BlackJack", JOptionPane.INFORMATION_MESSAGE);
				TextLog.Log_Append(TextLog.Log,
						Lookup.BlackJack.Lang.Text.PlayerAddsNewCard + " " + cards.card_deck[cards.current]);
				GameRule.Player.Points = GameRule.Player.Points + cards.card_value[cards.current];
				cards.current = cards.current + 1;
				JOptionPane
						.showMessageDialog(null,
								Lookup.BlackJack.Lang.Text.PlayerCards + " " + GameRule.Player.Points + " "
										+ Lookup.BlackJack.Lang.Text.Points,
								"BlackJack", JOptionPane.INFORMATION_MESSAGE);
				TextLog.Log_Append(TextLog.Log, Lookup.BlackJack.Lang.Text.PlayerCards + " " + GameRule.Player.Points
						+ " " + Lookup.BlackJack.Lang.Text.Points);
			} else {
				JOptionPane.showMessageDialog(null, Lookup.BlackJack.Lang.Text.Not_Allowed);
			}
		}
	}

	public class cards {
		static String[] card_deck = { // Starting deck of cards
				"1♠️", "2♠️", "3♠️", "4♠️", "5♠️", "6♠️", "7♠️", "8♠️", "9♠️", "10♠️", "J♠️", "Q♠️", "K♠️", "A♠️",
				"1♥️", "2♥️", "3♥️", "4♥️", "5♥️", "6♥️", "7♥️", "8♥️", "9♥️", "10♥️", "J♥️", "Q♥️", "K♥️", "A♥️",
				"1♦️", "2♦️", "3♦️", "4♦️", "5♦️", "6♦️", "7♦️", "8♦️", "9♦️", "10♦️", "J♦️", "Q♦️", "K♦️", "A♦️",
				"1♣️", "2♣️", "3♣️", "4♣️", "5♣️", "6♣️", "7♣️", "8♣️", "9♣️", "10♣️", "J♣️", "Q♣️", "K♣️", "A♣️",
				"1♠️", "2♠️", "3♠️", "4♠️", "5♠️", "6♠️", "7♠️", "8♠️", "9♠️", "10♠️", "J♠️", "Q♠️", "K♠️", "A♠️",
				"1♥️", "2♥️", "3♥️", "4♥️", "5♥️", "6♥️", "7♥️", "8♥️", "9♥️", "10♥️", "J♥️", "Q♥️", "K♥️", "A♥️",
				"1♦️", "2♦️", "3♦️", "4♦️", "5♦️", "6♦️", "7♦️", "8♦️", "9♦️", "10♦️", "J♦️", "Q♦️", "K♦️", "A♦️",
				"1♣️", "2♣️", "3♣️", "4♣️", "5♣️", "6♣️", "7♣️", "8♣️", "9♣️", "10♣️", "J♣️", "Q♣️", "K♣️", "A♣️"

		};
		static int[] card_value = { // Value of the cards
				1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 1,
				1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 1,
				1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 1,
				1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 1,
				1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 1,
				1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 1,
				1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 1,
				1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 1
		};
		static int current = 0;
		static int size = 56;
	}

	public static void shuffle() {
		// Card deck shuffle script
		int a, b, temp_int;
		String temp;
		for (int i = 0; i < 512; i++) {
			a = (int) (Math.random() * cards.size);
			b = (int) (Math.random() * cards.size);
			temp = cards.card_deck[a];
			temp_int = cards.card_value[a];
			cards.card_deck[a] = cards.card_deck[b];
			cards.card_value[a] = cards.card_value[b];
			cards.card_deck[b] = temp;
			cards.card_value[b] = temp_int;
		}
	}

	public class Card_value {
		static String name() {
			return cards.card_deck[cards.current];
		}

		static int value() {
			return cards.card_value[cards.current];
		}

		static void next() {
			if (cards.current > cards.size) {
				shuffle();
				cards.current = 0;
			} else {
				cards.current++;
			}
		}
	}

	public static void setup() {
		GameRule.Game.MaxGamePoints = 21;
		GameRule.Dealer.WhenStop = 14;
		GameRule.Player.money = 10;
		GameRule.Player.Score = 0;
		maxMoney = GameRule.Player.money;
	}

	public static void play() {
		if (GameRule.Game.Save == true) {
			JOptionPane.showMessageDialog(null, Lookup.BlackJack.Lang.Text.SavedResult, "BlackJack",
					JOptionPane.WARNING_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, Lookup.BlackJack.Lang.Text.NoSavedResult, "BlackJack",
					JOptionPane.WARNING_MESSAGE);
		}
		shuffle();
		// for(int i=0;i<cards.card_deck.length;i++)
		// {System.out.println(cards.card_deck[i]+" "+cards.card_value[i]);}//shuffle
		// debug
		int stop = 1;
		int a, score = 0;
		int dealer_points = 0;
		int bet = 0;
		do {
			do {
				TextLog.Log = TextLog.Log_Delete(TextLog.Log);
				bet = parseInt(
						JOptionPane.showInputDialog(GameRule.Player.money + "\n\n" + Lookup.BlackJack.Lang.Text.Bet));
			} while (bet > GameRule.Player.money);
			if (bet > 0) {
				GameRule.Player.Points = 0;

				dealer_points = 0;
				GameRule.Player.Points = 0;
				// dealer's hand
				TextLog.Log = TextLog.Log_Append(TextLog.Log, Lookup.BlackJack.Lang.Text.DealersCards + "\n");
				for (int i = 0; i < 1; i++) {
					TextLog.Log = TextLog.Log_Append(TextLog.Log, cards.card_deck[cards.current] + "\n");
					dealer_points = dealer_points + cards.card_value[cards.current];
					cards.current = cards.current + 1;
				}
				TextLog.Log = TextLog.Log_Append(TextLog.Log, Lookup.BlackJack.Lang.Text.DealerHas + " " + dealer_points
						+ " " + Lookup.BlackJack.Lang.Text.Points + "\n");
				// player's hand
				TextLog.Log = TextLog.Log_Append(TextLog.Log, Lookup.BlackJack.Lang.Text.PlayerCards + "\n");
				for (int i = 0; i < 2; i++) {
					TextLog.Log = TextLog.Log_Append(TextLog.Log, cards.card_deck[cards.current] + "\n");
					GameRule.Player.Points = GameRule.Player.Points + cards.card_value[cards.current];
					cards.current = cards.current + 1;
				}
				TextLog.Log = TextLog.Log_Append(TextLog.Log, Lookup.BlackJack.Lang.Text.YouHave + " "
						+ GameRule.Player.Points + " " + Lookup.BlackJack.Lang.Text.Points + "\n");
				a = 1;// game logic
				while (a == 1) {
					JOptionPane.showMessageDialog(null, Arrays.toString(TextLog.Log), "BlackJack",
							JOptionPane.INFORMATION_MESSAGE);
					a = parseInt(JOptionPane.showInputDialog(
							Arrays.toString(TextLog.Log) + "\n\n1)" + Lookup.BlackJack.Lang.Text.Hit + "\n2)"
									+ Lookup.BlackJack.Lang.Text.Stand + "\n3)" + Lookup.BlackJack.Lang.Text.Exit));
					if (a == 1) {
						Player_Action.New_Card();
					}
					if (a == 3) {
						stop = 3;
						GameRule.Player.Points = 99;
					}
				}
				if (GameRule.Player.Points <= GameRule.Game.MaxGamePoints) {
					while (dealer_points < GameRule.Dealer.WhenStop) {
						TextLog.Log = TextLog.Log_Append(TextLog.Log, Lookup.BlackJack.Lang.Text.DealerAddsNewCard + " "
								+ cards.card_deck[cards.current] + "\n");
						dealer_points = dealer_points + cards.card_value[cards.current];
						cards.current = cards.current + 1;
					}
					JOptionPane.showMessageDialog(null, Arrays.toString(TextLog.Log), "BlackJack",
							JOptionPane.INFORMATION_MESSAGE);
					if (dealer_points > GameRule.Game.MaxGamePoints) {
						JOptionPane.showMessageDialog(null, Lookup.BlackJack.Lang.Text.Player_Wins + "\n\n");
						score = score + 1;
						GameRule.Player.money = GameRule.Player.money + bet;
						if (GameRule.Player.money > maxMoney) {
							maxMoney = GameRule.Player.money;
						}
					} else {
						if (dealer_points >= GameRule.Player.Points) {
							JOptionPane.showMessageDialog(null, Lookup.BlackJack.Lang.Text.Dealer_Wins + "\n\n");
							score = score - 1;
							GameRule.Player.money = GameRule.Player.money - bet;
							if (GameRule.Player.money > maxMoney) {
								maxMoney = GameRule.Player.money;
							}

						} else {
							JOptionPane.showMessageDialog(null, Lookup.BlackJack.Lang.Text.Player_Wins + "\n\n");
							score = score + 1;
							GameRule.Player.money = GameRule.Player.money + bet;
							if (GameRule.Player.money > maxMoney) {
								maxMoney = GameRule.Player.money;
							}
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, Lookup.BlackJack.Lang.Text.Dealer_Wins + "\n\n");
					score = score - 1;
					GameRule.Player.money = GameRule.Player.money - bet;
					if (GameRule.Player.money > maxMoney) {
						maxMoney = GameRule.Player.money;
					}

				}
				// System.out.println(Lookup.BlackJack.Lang.Text.Continue);
			} else {
				stop = 0;
				JOptionPane.showMessageDialog(null, Lookup.BlackJack.Lang.Text.YOU_LOST);
			}
		} while (stop == 1);

		boolean win = score > 0;

		Leaderboard.updatePlayer(
				GameRule.Player.Name,
				win,
				maxMoney,
				GameRule.Player.money);
	}
}