import java.util.Scanner;
// import javax.swing.JOptionPane;

public class MainLogic {
	public static Scanner scanner = new Scanner(System.in);

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

		public class Player {
			// Spēlētāja iestatījumi
			static int Score;
			static int money;
			static int Points;
			static String Name;

		}
	}

	public class Player_Action {
		static void New_Card() {
			if (GameRule.Player.Points <= (GameRule.Game.MaxGamePoints)) {
				System.out.print(Lookup.BlackJack.Lang.Text.PlayerAddsNewCard + " " + cards.card_deck[cards.current]);
				GameRule.Player.Points = GameRule.Player.Points + cards.card_value[cards.current];
				cards.current = cards.current + 1;
				System.out.println(Lookup.BlackJack.Lang.Text.PlayerCards + " " + GameRule.Player.Points + " "
						+ Lookup.BlackJack.Lang.Text.Points);
			} else {
				System.out.println(Lookup.BlackJack.Lang.Text.Not_Allowed);
			}
		}
	}

	public class cards {
		static String[] card_deck = { // Starting deck of cards
				"1♠️", "2♠️", "3♠️", "4♠️", "5♠️", "6♠️", "7♠️", "8♠️", "9♠️", "10♠️", "J♠️", "Q♠️", "K♠️", "A♠️",
				"1♥️", "2♥️", "3♥️", "4♥️", "5♥️", "6♥️", "7♥️", "8♥️", "9♥️", "10♥️", "J♥️", "Q♥️", "K♥️", "A♥️",
				"1♦️", "2♦️", "3♦️", "4♦️", "5♦️", "6♦️", "7♦️", "8♦️", "9♦️", "10♦️", "J♦️", "Q♦️", "K♦️", "A♦️",
				"1♣️", "2♣️", "3♣️", "4♣️", "5♣️", "6♣️", "7♣️", "8♣️", "9♣️", "10♣️", "J♣️", "Q♣️", "K♣️", "A♣️",

		};
		static int[] card_value = { // Value of the cards
				1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 1,
				1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 1,
				1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 1,
				1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 1
		};
		static int current = 0;
		static int size = 56;
	}

	public static void shuffle() {
		// Card deck shuffle script // bogo sorts card deck
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
			if (cards.current == cards.size) {
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
		GameRule.Game.Save = false;
	}

	public static void play() {
		if (GameRule.Game.Save == true) {
			System.out.println(Lookup.BlackJack.Lang.Text.NoSavedResult);
		} else {
			System.out.println(Lookup.BlackJack.Lang.Text.SavedResult);
		}
		shuffle();
		int stop = 1;
		int temp_int = 0, a, score = 0;
		int dealer_points = 0, player_points = 0;
		do {
			dealer_points = 0;
			player_points = 0;
			// dealer's hand
			System.out.println(Lookup.BlackJack.Lang.Text.DealersCards);
			for (int i = 0; i < 1; i++) {
				System.out.println(cards.card_deck[temp_int]);
				dealer_points = dealer_points + cards.card_value[temp_int];
				temp_int = temp_int + 1;
			}
			System.out.println(Lookup.BlackJack.Lang.Text.DealerHas + " " + dealer_points + " "
					+ Lookup.BlackJack.Lang.Text.Points);
			// player's hand
			System.out.println(Lookup.BlackJack.Lang.Text.YouHave);
			for (int i = 0; i < 2; i++) {
				System.out.println(cards.card_deck[temp_int]);
				player_points = player_points + cards.card_value[temp_int];
				temp_int = temp_int + 1;
			}
			System.out.println(
					Lookup.BlackJack.Lang.Text.YouHave + " " + player_points + " " + Lookup.BlackJack.Lang.Text.Points);
			a = 1;// game logic
			while (a == 1) {
				System.out.println("1)" + Lookup.BlackJack.Lang.Text.Hit + "\n2)" + Lookup.BlackJack.Lang.Text.Stand);
				a = scanner.nextInt();
				if (a == 1) {
					Player_Action.New_Card();
				}
			}
			if (player_points <= GameRule.Game.MaxGamePoints) {
				while (dealer_points < GameRule.Dealer.WhenStop) {
					System.out.println(Lookup.BlackJack.Lang.Text.DealerAddsNewCard + " " + cards.card_deck[temp_int]);
					dealer_points = dealer_points + cards.card_value[temp_int];
					temp_int = temp_int + 1;
				}
				if (dealer_points > GameRule.Game.MaxGamePoints) {
					System.out.println(Lookup.BlackJack.Lang.Text.Player_Wins + "\n\n");
					score = score + 1;
				} else {
					if (dealer_points >= player_points) {
						System.out.println(Lookup.BlackJack.Lang.Text.Dealer_Wins + "\n\n");
						score = score - 1;
					} else {
						System.out.println(Lookup.BlackJack.Lang.Text.Player_Wins + "\n\n");
						score = score + 1;
					}
				}
			} else {
				System.out.println(Lookup.BlackJack.Lang.Text.Dealer_Wins + "\n\n");
				score = score - 1;
			}
			System.out.println(Lookup.BlackJack.Lang.Text.Continue);

		} while (stop == 1);
	}
}