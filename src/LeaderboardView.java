import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class LeaderboardView {

    private static JFrame frame;
    private static JTable table;

    public static void show() {
        if (frame == null) {
            frame = new JFrame("Leaderboard");
            frame.setSize(650, 400);
            frame.setLocationRelativeTo(null);
            frame.setLayout(new BorderLayout());

            table = new JTable();
            refreshTable();

            JScrollPane scrollPane = new JScrollPane(table);
            frame.add(scrollPane, BorderLayout.CENTER);

            JPanel buttonPanel = new JPanel();

            JButton refreshBtn = new JButton("Refresh");
            JButton closeBtn = new JButton("Close");

            refreshBtn.addActionListener(e -> refreshTable());
            closeBtn.addActionListener(e -> frame.setVisible(false));

            buttonPanel.add(refreshBtn);
            buttonPanel.add(closeBtn);

            frame.add(buttonPanel, BorderLayout.SOUTH);
        }

        refreshTable();
        frame.setVisible(true);
    }

    private static void refreshTable() {
        String[] columns = {
                "Name", "Played", "Wins", "Losses", "Max Money", "End Money"
        };

        Map<String, Leaderboard.PlayerStats> data = Leaderboard.load();

        Object[][] rows = new Object[data.size()][6];
        int i = 0;

        for (Leaderboard.PlayerStats ps : data.values()) {
            rows[i][0] = ps.name;
            rows[i][1] = ps.played;
            rows[i][2] = ps.wins;
            rows[i][3] = ps.losses;
            rows[i][4] = ps.maxMoney;
            rows[i][5] = ps.endMoney;
            i++;
        }

        table.setModel(new javax.swing.table.DefaultTableModel(rows, columns));
    }
}
