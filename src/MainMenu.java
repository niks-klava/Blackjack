import javax.swing.JOptionPane;

public class MainMenu {

    public static void show() {

        String[] options = {
                Lookup.BlackJack.Lang.Text.Play,
                Lookup.BlackJack.Lang.Text.ViewResult,
                Lookup.BlackJack.Lang.Text.Exit
        };

        int choice = JOptionPane.showOptionDialog(
                null,
                Lookup.BlackJack.Lang.Text.Title,
                "BlackJack",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]
        );

        switch (choice) {
            case 0:
                MainLogic.setup();
                MainLogic.play();
                show();
                break;

            case 1:
                LeaderboardView.show();
                break;

            default:
                System.exit(0);
        }
    }
}
