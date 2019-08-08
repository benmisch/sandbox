import java.util.*;

//Here I simulate the use of multiple machines via separated list objects. After objects are mapped, they are sorted to new lists depending on the hash of their keys. 

class Main {

  public static void main(String[] args) {

    String[] arr = { "deer", "bear", "river", "car", "car", "river", "deer", "bear", "car", "bear", "river", "car", "car", "river", "deer", "bear", "car" };
    HashMap<String, Integer> wordCount = mapReduceToy(arr);
    Iterator it = wordCount.entrySet().iterator();
      while (it.hasNext()) {
        Map.Entry<String, Integer> pair = (Map.Entry) it.next();
        System.out.println(pair.getKey() + ": " + pair.getValue());
    }

  }

  public final static int arbitrarySlicerValue = 3;
  public static int inputLength;

  public static HashMap<String, Integer> mapReduceToy(String[] arr) {

    return collater(reducer(shuffler(mapper(arr))));

  }

  public static LinkedList<LinkedList<String>> mapper(String[] arr) {

    inputLength = arr.length;
    LinkedList<LinkedList<String>> lists = new LinkedList<LinkedList<String>>();
    for (int i = 0; i < arbitrarySlicerValue; i++) {
      lists.add(new LinkedList<String>());
    }

    for (int i = 0; i < inputLength; i++) {
      lists.get(i % arbitrarySlicerValue).add(arr[i]);
    }

    return lists;

  }

  public static HashMap<String, LinkedList<Integer>> shuffler(LinkedList<LinkedList<String>> lists) {

    HashMap<String, LinkedList<Integer>> maps = new HashMap<String, LinkedList<Integer>>();
    String key;

    for (int i = 0; i < lists.size(); i++) { // this would be the parallelized part
      for (int j = 0; j < lists.get(i).size(); j++) {
        key = lists.get(i).get(j);
        if (maps.get(key) == null) { // this hash mimics sending each key to its own machine for processing... (though here it is stored in a single map).
          LinkedList<Integer> temp = new LinkedList<Integer>();
          temp.add(1);
          maps.put(key, temp);
        } else {
          maps.get(key).add(1);
        }

      }
      

    }

    return maps;

  }

  public static HashMap<String, Integer> reducer(HashMap<String, LinkedList<Integer>> maps) {

    HashMap<String, Integer> newMaps = new HashMap<String, Integer>();

    Iterator it = maps.entrySet().iterator();
    while (it.hasNext()) {
      Map.Entry<String, LinkedList<Integer>> pair = (Map.Entry) it.next();
      newMaps.put((String) pair.getKey(), (Integer) pair.getValue().size()); // reducing... (but still kinda cheating since it's all in a hashmap)
      it.remove();

    }

    return newMaps;

  }

  public static HashMap<String, Integer> collater(HashMap<String, Integer> maps) {

    // this step is automatically done because we've cheated and stored all our
    // partitions in a single hashmap.
    // the hashmap does faithfully represent the idea... though it makes the
    // collating step unnecessary here.

    return maps;

  }

}
