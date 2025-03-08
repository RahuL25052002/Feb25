import objectexplorer.ObjectGraphMeasurer;

public class Measurer {

  public static void main(String[] args) {
    Set<Integer> hashset = new HashSet<Integer>();
    Random random = new Random();
    int n = 10000;
    for (int i = 1; i <= n; i++) {
      hashset.add(random.nextInt());
    }
    System.out.println(ObjectGraphMeasurer.measure(hashset));
  }
}
