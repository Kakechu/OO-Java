public class Main {
    public static void main(String[] args) {
        for (WorkDay day : WorkDay.values()) {
            System.out.println(day + " " + day.getHoursOfWOrk() + ", " + day.getWorkLocation());
        }
    }
}