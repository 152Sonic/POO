

public class Main {

    public static void main(String[] args) {
        GPS g1 = new GPS(-81.554855, 84.01756);
        GPS g2 = new GPS(-81.89932, 81.5264);
        double r = 80;

        double d = g1.distancia(g2);
        boolean v = g1.isNear(g2, r);

        System.out.println(d);
        System.out.println(v);
    }



}
