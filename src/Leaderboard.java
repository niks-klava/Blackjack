import java.io.*;
import java.util.*;

public class Leaderboard {

    private static final String FILE_NAME = "leaderboard.txt";

    public static class PlayerStats {
        String name;
        int played;
        int wins;
        int losses;
        int maxMoney;
        int endMoney;

        PlayerStats(String name, int played, int wins, int losses, int maxMoney, int endMoney) {
            this.name = name;
            this.played = played;
            this.wins = wins;
            this.losses = losses;
            this.maxMoney = maxMoney;
            this.endMoney = endMoney;
        }

        @Override
        public String toString() {
            return name + ";" + played + ";" + wins + ";" + losses + ";" + maxMoney + ";" + endMoney;
        }
    }

    public static Map<String, PlayerStats> load() {
        Map<String, PlayerStats> map = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] p = line.split(";");
                if (p.length == 6) {
                    PlayerStats ps = new PlayerStats(
                            p[0],
                            Integer.parseInt(p[1]),
                            Integer.parseInt(p[2]),
                            Integer.parseInt(p[3]),
                            Integer.parseInt(p[4]),
                            Integer.parseInt(p[5])
                    );
                    map.put(ps.name, ps);
                }
            }
        } catch (IOException e) {

        }

        return map;
    }

    public static void save(Map<String, PlayerStats> map) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (PlayerStats ps : map.values()) {
                pw.println(ps.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void updatePlayer(String name, boolean win, int maxMoney, int endMoney) {
        Map<String, PlayerStats> map = load();
        PlayerStats ps = map.get(name);

        if (ps == null) {
            ps = new PlayerStats(name, 0, 0, 0, maxMoney, endMoney);
        }

        ps.played++;
        if (win) ps.wins++;
        else ps.losses++;

        if (maxMoney > ps.maxMoney) {
            ps.maxMoney = maxMoney;
        }

        ps.endMoney = endMoney;

        map.put(name, ps);
        save(map);
    }
}
