package fesva.core;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

//import MyMoscowMetroReadings.getmyJsonFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/*
Цель задания

Потренироваться в работе с библиотекой jsoup и формированием JSON-файлов.

Что нужно сделать

Пропарсите и записывайте в JSON-файл переходы между станциями в дополнение к линиям и станциям (коллекции имя станции, номер линии, между которым есть переходы).
Выведите в консоль количество переходов в метро.
Критерии оценки

«Зачёт» — в консоль выводится количество переходов в московском метро.
 */
public class Interconnections {  // доп задание


    private static void connectionsFromJSON(String path, StationIndex stationIndex2)
            throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONObject jsonData = (JSONObject) parser.parse(getJsonFile(path));

        JSONArray connsArray = (JSONArray) jsonData.get("connections");
        parseConnectionsFromJSON(connsArray, stationIndex2);


        //connectionsToJSON();
    }

    private static void parseConnectionsFromJSON(JSONArray linesArray, StationIndex stationIndex2) {

    }

    private static String getJsonFile(String path) throws IOException {
        StringBuilder builder = new StringBuilder();
        List<String> lines = Files.readAllLines(Paths.get(path));
        lines.forEach(builder::append);
        return builder.toString();
    }
}
