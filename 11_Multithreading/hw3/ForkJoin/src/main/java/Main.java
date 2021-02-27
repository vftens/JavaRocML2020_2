import java.io.File;

public class Main {

    public static final boolean ENRU = true;

    public static void main(String[] args) {

        File file = new File("./output.txt");

        int countOfCores = Runtime.getRuntime().availableProcessors();
        if (ENRU) {
            System.out.println("Processors in System:  " + countOfCores);
        } else {
            System.out.println("Процессоров в системе:  " + countOfCores);
        }

        System.out.println("Введите Сайт для анализа: ");

        SiteMap siteMap = new SiteMap("");
    }
}
