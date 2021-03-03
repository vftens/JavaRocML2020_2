//import java.io.File;

import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;
//import java.util.concurrent.ForkJoinTask;

public class Main {

    public static final boolean ENRU = false;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int countOfCores = Runtime.getRuntime().availableProcessors();
        if (ENRU) {
            System.out.println("Processors in System:  " + countOfCores);
        } else {
            System.out.println("Процессоров в системе:  " + countOfCores);
        }

        System.out.println("Введите Сайт для анализа: ");
        String url = sc.nextLine();
        System.out.println("Введите количество создаваемых потоков - 0 установит значение по умолчанию.");
        int numThreads=sc.nextInt();

        url = url.trim();

        System.out.println("Давайте сканируем наш сайт.");

        long start = System.currentTimeMillis();

        SiteMap siteMap = new SiteMap(url, url);
        String siteMap1 = numThreads == 0 ? new ForkJoinPool().invoke(siteMap)
                : new ForkJoinPool(numThreads).invoke(siteMap);

        String msMap = frk(countOfCores, siteMap);
        siteMap.solve(countOfCores);
        System.out.println("Завершено.");
        System.out.println("Время сканирования Сайта " + ((System.currentTimeMillis() - start) / 1000.0) + " секунд.");

        MioResult mioResult = new MioResult();
        mioResult.write(siteMap1);
        mioResult.write(msMap);
    }

    public static String frk(int numThreads, SiteMap siteMap) {
        if (numThreads == 0) {
            return new ForkJoinPool().invoke(siteMap);
        } else {
            return new ForkJoinPool(numThreads).invoke(siteMap);
        }
    }
}
