public class Lookup {
	public class BlackJack {
		public class Lang {
			public class Text {
				// Setup texts
				public static String PlayerName;
				public static String SaveGame;
				public static String ConfirmChoice;
				// Game text
				public static String Bet;
				public static String YOU_LOST;
				public static String PlayerAddsNewCard;
				public static String DealerAddsNewCard;
				public static String PlayerCards;
				public static String Not_Allowed;
				public static String DealersCards;
				public static String DealerHas;
				public static String Points;
				public static String NoSavedResult;
				public static String SavedResult;
				public static String YourCards;
				public static String YouHave;
				public static String Hit;
				public static String Stand;
				public static String Exit;
				public static String ViewResult;
				public static String Play;
				public static String Continue;

				// Winning Text
				public static String Player_Wins;
				public static String Dealer_Wins;
				// Buttons
				public static String Title;
			}

			public static void test() {// delete this before final release
				Text.PlayerAddsNewCard = "Text.PlayerAddsNewCard";
				Text.PlayerCards = "Text.PlayerCards ";
				Text.Not_Allowed = "not allowed";
				Text.DealersCards = "Bob's Cards";
			}

			public static void Eng() {
				// Setup texts
				Text.PlayerName = "Enter your name";
				Text.SaveGame = "Save your score?";
				Text.ConfirmChoice = "\n1 Yes\n2 No";
				// Game Texts
				Text.Bet = "Bet";
				Text.YOU_LOST = "YOU LOST";
				Text.PlayerAddsNewCard = "You picked a new card ";
				Text.DealerAddsNewCard = "Dealer picked a new card";
				Text.PlayerCards = "You now have ";
				Text.Not_Allowed = "not allowed";
				Text.DealersCards = "dealer's cards";
				Text.DealerHas = "Dealer has";
				Text.Points = "Points";
				Text.NoSavedResult = "Your result will not be saved";
				Text.SavedResult = "Your result will be saved";
				Text.YourCards = " Your cards";
				Text.YouHave = "You have";
				Text.Hit = "Hit";
				Text.Stand = "Stand";
				Text.Exit = "Exit";
				Text.ViewResult = "View result";
				Text.Play = "Play";
				Text.Continue = "Continue?\n1 Yes\n2 No";
				// Winning
				Text.Player_Wins = "You Win";
				Text.Dealer_Wins = "Dealer won";
				// Buttons
				Text.Title = "BlackJack";
			}

			public static void Latv() {
				// Spēles teksts
				// Setup texts
				Text.PlayerName = "Ievadiet vārdu";
				Text.SaveGame = "Saglabāt jūsu rezultātu?";
				Text.ConfirmChoice = "\n1 Jā\n2 Nē";
				// Game text
				Text.Bet = "Likme";
				Text.YOU_LOST = "Jūs zaudējāt";
				Text.PlayerAddsNewCard = "Jūs pacēlāt jaunu kārti";
				Text.DealerAddsNewCard = "Dīleris pacēla jaunu kārti";
				Text.PlayerCards = "Jūsu kārtis";
				Text.Not_Allowed = "Darbība nav atļauta";
				Text.DealersCards = "Dīlera kārtis";
				Text.DealerHas = "Dīlerim ir ";
				Text.Points = "Punkti";
				Text.NoSavedResult = "Spēle nesaglabās Jūsu rezultātu";
				Text.SavedResult = "Spēle saglabās Jūsu rezultātu";
				Text.YourCards = "Jūsu kārtis ";
				Text.YouHave = "Jums ir";
				Text.Hit = "Vēl kārtis";
				Text.Stand = "Spēlēt";
				Text.Exit = "Iziet";
				Text.ViewResult = "Skatīt rezultātu";
				Text.Play = "Spēlēt";
				Text.Continue = "Turpināt?\n1 Jā\n2 Nē";
				// Winning
				Text.Player_Wins = "Jūs uzvarējāt";
				Text.Dealer_Wins = "Dīleris uzvarēja";
				// Pogas
				Text.Title = "Laipni lūdzam BlackJack spēlē";

			}
		}

		public class Views {
			public static void FirstPlay() {

			}

			public static void AfterGame() {

			}
		}

		public class GameLogic {
			public static void Hit() {

			}

			public static void Stand() {

			}

			public static void Exit() {

			}
		}
	}
}
