package de.flix29.javaUni.maps;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Diese Klasse zeigte verschiedene Funktionalitäten der Klasse {@link Map}
 * <ul>
 *     <li>{@link #initializeMaps()}, initialisierung von Maps</li>
 *     <li>{@link #addEntries()}, einfügen von Einträgen in Maps</li>
 *     <li>{@link #getValues()}, auslesen von Einträgen aus Maps</li>
 *     <li>{@link #replaceValues()}, ersetzen von Values</li>
 *     <li>{@link #checkIfKeyOrValueIsInMap()}, überprüfen ob Einträgen in Maps vorhanden sind</li>
 *     <li>{@link #removeEntries()}, entfernen von Einträgen aus Maps</li>
 *     <li>{@link #setsFromMaps()}, entfernen von Einträgen aus Maps</li>
 *     <li>{@link #forEachMethods()}, möglichkeiten Maps zu durchlaufen mittels for-Schleifen</li>
 * </ul>
 *
 * @author felix
 */
@SuppressWarnings({"unused", "FieldCanBeLocal", "MismatchedQueryAndUpdateOfCollection", "Convert2MethodRef", "UnusedAssignment", "ConstantConditions"})
public class Maps {
    //TODO print out stuff to show methods working

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

        cleanUpMap();
    }

    /**
     * Diese Methode zeigt, welche verschiedenen Möglichkeiten es gibt Einträge in eine Map hinzuzufügen
     * <ul>
     *     <li>Die Methode {@link Map#put(Object, Object)} fügt ein Eintrag der Map hinzu. Der erste Parameter ist
     *      der Key und der zweite der Value. Ist der Key bereits in der Map vorhanden wird der alte Value mit dem des
     *      übergebenen Value überschrieben. Der vorherige Value wird zurückgegeben oder null wenn kein vorheriger Value
     *      existiert.</li>
     *     <li>Die Methode {@link Map#putAll(Map)} fügt alle Elemente, der als Parameter übergebene Map,
     *      der Map hinzu. Auch hier können unter Umständen Values überschrieben.</li>
     *     <li>Die Methode {@link Map#putIfAbsent(Object, Object)} fügt nur einen neuen Eintrag der Map hinzu,
     *      wenn der Key noch nicht in der Map existiert. Der vorherige Value wird zurückgegeben oder null wenn kein
     *      vorheriger Value existiert.</li>
     * </ul>
     */
    public void addEntries() {
        setUpMap();

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
        Integer sechs = hashMap.putIfAbsent("sechs", 6);// wird hinzugefügt

        cleanUpMap();
    }

    /**
     * Diese Methode zeigt, wie Werte aus einer Map ausgelesen werden können.
     * <ul>
     *     <li>Die Methode {@link Map#get(Object)} gibt den Wert, der mit dem, als Parameter übergebenen, Key assoziiert
     *      ist.</li>
     *     <li>Die Methode {@link Map#getOrDefault(Object, Object)} gibt den Wert, der mit dem, als Parameter übergebenen,
     *      Key assoziiert ist oder wenn dieser Key nicht vorhanden ist, wird der Wert der als zweiter Parameter übergeben
     *      wird, zurückgegeben.</li>
     * </ul>
     */
    public void getValues() {
        setUpMap();

        Integer eins = hashMap.get("eins"); // wird gefunden
        Integer nullValueAsKey = hashMap.get(null); //wird gefunden; null
        Integer nichtGefunden = hashMap.get("abc"); // wird nicht gefunden

        // wird nicht gefunden; default value
        Integer nichtGefundenDefault = hashMap.getOrDefault("abc", 1);

        cleanUpMap();
    }

    /**
     * Diese Methode zeigt, wie Werte in einer Map ersetzt werden können.
     * <ul>
     *     <li>Die Methode {@link Map#replace(Object, Object, Object)} bekommt als Parameter den Key und den Value des
     *      Eintrages der ersetzt werden soll. Wenn dieser Eintrag existiert wird der Value mit dem dritten Parameter
     *      ersetzt. Die Methode returnt true oder false je nachdem ob der Wert ersetzt wurde oder nicht.</li>
     *     <li>Die Methode {@link Map#replace(Object, Object)} bekommt als Parameter den Key des Eintrages der ersetzt
     *      werden soll. Wenn dieser Eintrag existiert wird der Value mit dem zweiten Parameter ersetzt. Die Methode
     *      returnt den alten Wert des Eintrages.</li>
     * </ul>
     */
    public void replaceValues() {
        setUpMap();

        boolean vier = hashMap.replace("vier", 4, 5);
        Integer drei = hashMap.replace("drei", 4);

        cleanUpMap();
    }

    /**
     * Diese Methode zeigt, wie geprüft werden kann, ob Keys oder Werte in einer Map vorhanden sind.
     * <ul>
     *     <li>Die Methode {@link Map#containsKey(Object)} gibt true oder false zurück, je nachdem ob der übergebende
     *      Key in der Map vorhanden ist.</li>
     *     <li>Die Methode {@link Map#containsValue(Object)} gibt true oder false zurück, je nachdem ob der übergebende
     *      Value in der Map vorhanden ist.</li>
     * </ul>
     */
    public void checkIfKeyOrValueIsInMap() {
        setUpMap();

        boolean eins = hashMap.containsKey("eins"); //true
        boolean nichtInMap = hashMap.containsKey("abc"); //false

        boolean zwei = hashMap.containsValue(2); //true
        boolean valueNichtInMap = hashMap.containsValue(9); //false

        cleanUpMap();
    }

    /**
     * Diese Methode zeigt, wie Werte aus einer Map entfernt werden könne.
     * <ul>
     *     <li>Die Methode {@link Map#remove(Object)} entfernt den Eintrag mit dem übergebenen Key aus der Map und gibt
     *      den Value zurück. Wenn der Key nicht in der Map existiert wird null zurückgegeben.</li>
     *     <li>Die Methode {@link Map#clear()} entfernt alle Einträge aus der Map.</li>
     * </ul>
     */
    public void removeEntries() {
        setUpMap();

        // entfernt den Eintrag mit dem Key eins und returnt den Value
        Integer eins = hashMap.remove(null);
        // tut nichts und returnt null
        Integer nichtGefunden = hashMap.remove("abc");

        hashMap.clear(); // löscht alle Einträge

        cleanUpMap();
    }

    /**
     * Diese Methode zeigt, welche Möglichkeiten es gibt alle Keys und Values aus der Map zu erhalten
     * <ul>
     *     <li>Die Methode {@link Map#entrySet()} gibt ein {@link Set} mit Eintragen vom Typ {@link java.util.Map.Entry}
     *      zurück. Die Entries in dem Set sind die Entries aus der Map. Ein Entry hat zwei Attribute, einen Key und den
     *      Value.</li>
     *     <li>Die Methode {@link Map#keySet()} gibt ein {@link Set} mit allen Keys der Map zurück.</li>
     *     <li>Die Methode {@link Map#values()} gibt eine {@link Collection} mit allen Values der Map zurück.</li>
     * </ul>
     */
    public void setsFromMaps() {
        setUpMap();

        //set mit entries aus der Map
        Set<Map.Entry<String, Integer>> entries = hashMap.entrySet();
        //set mit Keys aus der Map
        Set<String> strings = hashMap.keySet();
        //collection mit values aus der Map
        Collection<Integer> values = hashMap.values();

        cleanUpMap();
    }

    /**
     * Diese Methode zeigt, welche Möglichkeiten es gibt mittels for-Schleifen durch Maps zu iterieren
     * <ul>
     *     <li>Die erste for-Schleife iteriert über das EntrySet {@link Map#entrySet()}.</li>
     *     <li>Die zweite for-Schleife iteriert über das KeySet {@link Map#keySet()}.</li>
     *     <li>Die dritte for-Schleife iteriert über die Values {@link Map#values()}.</li>
     *     <li>Die vierte for-Schleife nutzt die Methode {@link Map#forEach(BiConsumer)} um über den definierten key,
     *      und Value zu iterieren.</li>
     * </ul>
     */
    public void forEachMethods() {
        setUpMap();

        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if(key != null && key.equals("eins")) {
                entry.setValue(2); //setzt den Value vom Key 'eins' zu 2
            }
        }

        boolean containsDreiKey = false;
        for (String key : hashMap.keySet()) {
            if (key != null && key.equals("drei")) {
                containsDreiKey = true;
                break;
            }
        }

        boolean containsDreiValue = false;
        for (Integer value : hashMap.values()) {
            if (value != null && value == 3) {
                containsDreiValue = true;
                break;
            }
        }

        hashMap.forEach((key, value) -> {
            hashMap.put(key, ++value); // überschreibt alle Werte mit dem Value + 1
        });

        cleanUpMap();
    }

    /**
     * Diese Methode zeigt, wie die {@link Map#merge(Object, Object, BiFunction)} Methode funktioniert. Sie bekommt als
     * Input den Key eines Entries der Map und einem Value. Wenn der Key nicht in der Map vorhanden ist, wird er gemeinsam
     * mit dem Value als neuer Entry in die Map eingefügt. Wenn der Key in der Map vorhanden ist, wird die, als dritter
     * Parameter, übergebene Funktion auf den alten Value und den übergebenen Value angewendet. Ist das Ergebnis der Funktion
     * null, wird der Entry aus der Map gelöscht. Andernfalls wird der alte Value mit dem neuen überschrieben. In jedem
     * Fall wird der neue Value zurückgegeben.
     */
    public void mergeMethods() {
        setUpMap();

        Integer drei = hashMap.merge("drei", 1, Integer::sum);
        hashMap.merge("drei", 1, (value, newValue) -> value + newValue);

        cleanUpMap();
    }

    /**
     * Diese Methode zeigt, wie compute-Methoden der Klasse {@link Map} funktionieren.
     * <ul>
     *     <li>Die Methode {@link Map#compute(Object, BiFunction)} bekommt als Parameter den Key und eine Funktion, die
     *      den key und value verarbeitet und einen neuen Value returnt. Ist der neue Value null wird der Eintrag entfernt
     *      und null returnt. Ist der neue Value nicht null wird er eingefügt oder geupdatet und returnt.</li>
     *     <li>Die Methode {@link Map#computeIfAbsent(Object, Function)} funktioniert genauso wie die
     *      {@link Map#compute(Object, BiFunction)} nur dass sie nur ausgeführt wird, wenn der Key noch nicht in der Map
     *      vorhanden ist oder einen null Value hat.</li>
     *     <li>Die Methode {@link Map#computeIfAbsent(Object, Function)} funktioniert genauso wie die
     *      {@link Map#compute(Object, BiFunction)} nur dass sie nur ausgeführt wird, wenn der Key in der Map
     *      vorhanden ist und einen nicht null Value hat.</li>
     * </ul>
     */
    public void computeMethods() {
        setUpMap();

       hashMap.compute("zwei", (key, value) -> ++value);
       hashMap.putIfAbsent("zwei", 2);
       hashMap.computeIfPresent("zwei", (key, value) -> ++value);

       cleanUpMap();
    }

    private void setUpMap() {
        Map<String, Integer> map =  Map.ofEntries(
                Map.entry("eins", 1),
                Map.entry("zwei", 2),
                Map.entry("drei", 3),
                Map.entry("vier", 4),
                Map.entry("fünf", 5),
                Map.entry("sechs", 6)
        );
        hashMap = new HashMap<>(map);
        treeMap = new TreeMap<>(map);
    }

    private void cleanUpMap() {
        hashMap.clear();
        treeMap.clear();
    }
}
