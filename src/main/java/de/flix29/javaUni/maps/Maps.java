package de.flix29.javaUni.maps;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Diese Klasse zeigte verschiedene Funktionalitäten der Klasse {@link Map}
 * <ul>
 *     <li>{@link #initializeMaps()} initialisierung von Maps</li>
 * </ul>
 *
 * @author felix
 */
@SuppressWarnings({"unused", "FieldCanBeLocal", "MismatchedQueryAndUpdateOfCollection"})
public class Maps {

    //declare two Maps with keys from type String and values from type Integer
    private Map<String, Integer> hashMap;
    private Map<String, Integer> treeMap;

    public Maps() {

    }

    /**
     * Diese Methode zeigt die verschiedenen Möglichkeiten eine Map zu initialisieren
     * <ul>
     *     <li>Die erste Möglichkeit ist sie als {@link HashMap} zu initialisieren</li>
     *     <li>Die zweite Möglichkeit ist sie als {@link TreeMap} zu initialisieren</li>
     * </ul>
     */
    public void initializeMaps() {
        //initialize a Map as a hashMap
        hashMap = new HashMap<>();

        //initialize a Map as a treeMap
        treeMap = new TreeMap<>();

        Map<?, ?> tempHashMap = new HashMap<>(hashMap);
        Map<?, ?> tempTreeMap = new TreeMap<>(hashMap);
    }

    /**
     *
     */
    public void addEntriesToMap() {
        //fügt Schlüssel-Werte Paare hinzu
        Integer eins = hashMap.put("eins", 1);
        hashMap.put("zwei", 2);
        hashMap.put("drei", 3);

        //null Werte auch erlaubt
        hashMap.put(null, 0);

        Map<String, Integer> tempMap = new HashMap<>();
        tempMap.put("vier", 4);
        tempMap.put("fünf", 5);
        //Alle Paare einer Map können in einem hinzugefügt werden
        hashMap.putAll(tempMap);

        //fügt Paare nur hinzu, wenn der Schlüssel noch nicht vorhanden ist
        hashMap.putIfAbsent("vier", 5); // wird nicht hinzugefügt
        hashMap.putIfAbsent("sechs", 6); // wird hinzugefügt
    }

    public void getValuesFromMap() {
        Integer eins = hashMap.get("eins"); // wird gefunden
        Integer nullValueAsKey = hashMap.get(null); //wird gefunden; null
        Integer nichtGefunden = hashMap.get("abc"); // wird nicht gefunden

        // wird nicht gefunden; default value
        Integer nichtGefundenDefault = hashMap.getOrDefault("abc", 1);
    }

    public void checkIfKeyOrValueIsInMap() {
        boolean eins = hashMap.containsKey("eins"); //true
        boolean nichtInMap = hashMap.containsKey("abc"); //false

        boolean zwei = hashMap.containsValue(2); //true
        boolean valueNichtInMap = hashMap.containsValue(9); //false
    }

    public void removeEntries() {
        // entfernt den Eintrag mit dem Key eins und returnt den Value
        Integer eins = hashMap.remove("eins");
        // tut nichts und returnt null
        Integer nichtGefunden = hashMap.remove("abc");

        hashMap.clear(); // löscht alle Einträge
    }
}
