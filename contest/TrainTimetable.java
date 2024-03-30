/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contest;

/**
 *
 * @author venka
 */
import java.util.*;

public class TrainTimetable {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int turnaroundTime = scanner.nextInt();
        scanner.nextLine();
        int na = scanner.nextInt();
        int nb = scanner.nextInt();
        scanner.nextLine();
        List<Integer> departuresAtoB = new ArrayList<>();
        List<Integer> arrivalsAtoB = new ArrayList<>();
        List<Integer> departuresBtoA = new ArrayList<>();
        List<Integer> arrivalsBtoA = new ArrayList<>();
        for (int i = 0; i < na; i++) {
            String[] times = scanner.nextLine().split(" ");
            departuresAtoB.add(convertToMinutes(times[0]));
            arrivalsAtoB.add(convertToMinutes(times[1]));
        }
        for (int i = 0; i < nb; i++) {
            String[] times = scanner.nextLine().split(" ");
            departuresBtoA.add(convertToMinutes(times[0]));
            arrivalsBtoA.add(convertToMinutes(times[1]));
        }
        int trainsAtA = calculateTrainsRequired(departuresAtoB, arrivalsBtoA, turnaroundTime);
        int trainsAtB = calculateTrainsRequired(departuresBtoA, arrivalsAtoB, turnaroundTime);
        System.out.println("Total trains needed at A: " + trainsAtA);
        System.out.println("Total trains needed at B: " + trainsAtB);
        scanner.close();
    }
    private static int convertToMinutes(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }
    private static int calculateTrainsRequired(List<Integer> departures, List<Integer> arrivals, int turnaroundTime) {
        int trainsRequired = 0;
        int[] platforms = new int[24 * 60 + 1];
        for (int arrival : arrivals) {
            platforms[arrival]++;
        }
        for (int departure : departures) {
            boolean trainAvailable = false;
            for (int i = departure - turnaroundTime; i < departure && !trainAvailable; i++) {
                if (platforms[i] > 0) {
                    trainAvailable = true;
                    platforms[i]--;
                }
            }
            if (!trainAvailable) {
                trainsRequired++;
            }
        }
        return trainsRequired;
    }
}
