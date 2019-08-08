public class Entry<K, V> {

  int hash;
  K key;
  V value;

  public Entry(K key, V value) {
    this.key = key;
    this.value = value;
    this.hash = key.hashCode();
  }

  public boolean equals(Entry other) {
    if (hash != other.hash) return false;
    return key.equals(other.key);
  }

  public int getHash(){
    return this.hash;
  }

  public K getKey(){
    return this.key;
  }

  public V getValue(){
    return this.value;
  }

  // We will assume that the objects are being compared by value and that that value is an integer.
  //    THIS IS AN ASSUMPTION 
  // left = -1
  // equal or right = 0
  
  public int compareTo(Entry nodeEntry){

    if( (int) this.value < (int) nodeEntry.value){
      return -1;
    }
    
    return 0;

  }

  @Override
  public String toString() {
    return key + " (" + value + ")";
  }
}
