import javax.swing.JOptionPane;

public class Main {
	static int parseInt(String var) {
		int num = -1;
		try {
			num = Integer.parseInt(var);
		} catch (Exception e) {

		}
		return num;
	}

	public static void main(String[] args) {
		String a;
		int int_a;
		do {
			a = JOptionPane.showInputDialog("1 Latviski\n2 English", JOptionPane.INFORMATION_MESSAGE);
			int_a = parseInt(a);
		} while (int_a == -1);

		if (int_a == 1) {
			Lookup.BlackJack.Lang.Latv();
		} // Default=English
		else {
			Lookup.BlackJack.Lang.Eng();
		}
		// NAME?
		MainLogic.GameRule.Player.Name = JOptionPane.showInputDialog(Lookup.BlackJack.Lang.Text.PlayerName,
				JOptionPane.INFORMATION_MESSAGE);
		// SAVE?
		do {
			a = JOptionPane.showInputDialog(
					Lookup.BlackJack.Lang.Text.SaveGame + Lookup.BlackJack.Lang.Text.ConfirmChoice,
					JOptionPane.INFORMATION_MESSAGE);
			int_a = parseInt(a);
		} while (int_a == -1);
		if (int_a == 1) {
			MainLogic.GameRule.Game.Save = true;
		} else {
			MainLogic.GameRule.Game.Save = false;
		}
		
    		MainMenu.show();
	}
}