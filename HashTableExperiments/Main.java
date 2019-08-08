import java.util.HashMap;

class Main {

  public static void main(String[] args) {
    
    /*String[] arr = generateNames();

    HashMap<String, Integer> map = new HashMap<String, Integer>() {
      {
        for (String x : arr) {
          put(x, (int) Math.floor(Math.random() * 50));
        }
      }
    };

    for (String x : map.keySet()) {
      System.out.println(x + ", " + map.get(x));
    }

    
    BenaryTree<String, Integer> benTree = new BenaryTree<>();

    for (String key : map.keySet()){
      Entry toEnter = new Entry<String, Integer>(key, map.get(key));
      benTree.insert(toEnter);
    }

    benTree.treePrint();
    

    BenTable<String, Integer> table = new BenTable<>();

    for (String key : map.keySet()){
      table.insert(key, map.get(key));
    }    

    table.printTable();*/
   
  }

  public static String[] generateNames(){
    String[] nameList = {"Bob", 
      "Ann", 
      "Ben", 
      "Allison", 
      "Billie", 
      "Jeff", 
      "Rick", 
      "Jennifer", 
      "Josh", 
      "Alex",
      "Celinda",
      "Jeramy",
      "Ardis",
      "Un",
      "Pete",
      "Georgann",
      "Camie",
      "Roger",
      "Homer",
      "Mose",
      "Danette",
      "Raguel",
      "Darcey",
      "Wesley",
      "Terrell",
      "Peter",
      "Elyse",
      "Rhea",
      "Sol",
      "Brooke",
      "Jani",
      "Rebbeca",
      "Jeanine",
      "Judson",
      "Twana",
      "Dominique",
      "Marleen",
      "Sheena",
      "Peg",
      "Maritza",
      "Jadwiga",
      "Celestina",
      "Nelia",
      "Phuong",
      "Tanisha",
      "Bobby",
      "Lucile",
      "Jennine",
      "Pat",
      "Leland",
      "Ji",
      "Angelina",
      "Lucy",
      "Dania",
      "Clarine",
      "Quyen",
      "Susanne",
      "Mignon",
      "Danica",
      "Elene"};

    return nameList;
  }
}