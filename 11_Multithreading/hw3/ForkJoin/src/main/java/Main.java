import java.io.File;
import java.util.Scanner;

public class Main {

    public static final boolean ENRU = true;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        File file = new File("./output.txt");

        int countOfCores = Runtime.getRuntime().availableProcessors();
        if (ENRU) {
            System.out.println("Processors in System:  " + countOfCores);
        } else {
            System.out.println("Процессоров в системе:  " + countOfCores);
        }

        System.out.println("Введите Сайт для анализа: ");
        String url = sc.nextLine();

        System.out.println("Давайте сканируем наш сайт.");

        long start = System.currentTimeMillis();

        SiteMap siteMap = new SiteMap(url);
        siteMap.solve(countOfCores);

    }
}
