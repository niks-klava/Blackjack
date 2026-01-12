import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		String a;
		a=JOptionPane.showInputDialog("1 Latviski\n2 English",JOptionPane.INFORMATION_MESSAGE);
		int int_a=Integer.parseInt(a);
		if(int_a==1) {Lookup.BlackJack.Lang.Latv();}
		else {Lookup.BlackJack.Lang.Eng();}
		MainLogic.setup();
		MainLogic.play();
	}
}