package de.flix29.javaUni;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Diese Klasse zeigte verschiedene Funktionalitäten der Klasse {@link Map}
 * <ul>
 *     <li>{@link #initalizeMaps()} initialisierung von Maps</li>
 * </ul>
 *
 * @author felix
 */
public class Maps {

    private Map<?, ?> hashMap;
    private Map<?, ?> treeMap;

    public Maps() {

    }

    /**
     * Diese Methode zeigt die verschiedenen Möglichkeiten eine Map zu initialisieren
     * <ul>
     *     <li>Die erste Möglichkeit ist sie als {@link HashMap} zu initialisieren</li>
     *     <li>Die zweite Möglichkeit ist sie als {@link TreeMap} zu initialisieren</li>
     * </ul>
     */
    public void initalizeMaps() {
        //initialize a Map as a hashMap
        hashMap = new HashMap<>();

        //initialize a Map as a treeMap
        treeMap = new TreeMap<>();
    }
}
