public class Test {
    public static void main(String[] args) {

        // b

        System.out.println("Testing Node Class");
        var node = new Node(7);
        System.out.print(node);
        node.setNo(8);
        node.setColor(5);
        node.setDegree(2);
        node.setDsat(3);
        System.out.print(node);
        System.out.print(String.format("no: %d color: %d degree: %d dsat: %d\n",
                node.getNo(),
                node.getColor(),
                node.getDegree(),
                node.getDsat()));

        System.out.println("\nTesting Arc Class");
        var arc = new Arc(1, 2);
        System.out.print(arc);

        System.out.println("\nTesting GrapheListe Class");
        var g = new GrapheListe(3, false);
        System.out.print(String.format("noeuds: %d\n", g.NbNoeuds()));
        g.Ajouter(arc);
        System.out.print(String.format("nbarcs: %d\n", g.NbArcs()));
        System.out.println("Adjacents of Node 1");
        for (Arc a : g.Adjacents(1)) {
            System.out.println(a);
        }
        System.out.println("Is there a path between nodes 1 and 2?");
        System.out.println(g.Existe(1, 2) ? "Yes" : "No");
        System.out.println("Is there a path between nodes 1 and 3?");
        System.out.println(g.Existe(1, 3) ? "Yes" : "No");
        System.out.println(String.format("Degree of Node 1: %d", g.Degree(1)));

        g.getNodes().add(new Node(1));
        g.getNodes().add(new Node(2));
        g.getNodes().add(new Node(3));
        System.out.println(g);
        // There is no problem here because we are going to use g.Degree method to set
        // the degree of nodes.

        // d
        var g1 = new GrapheListe(3, false);
        g1.Ajouter(new Arc(0, 1));
        g1.Ajouter(new Arc(0, 2));
        g1.Ajouter(new Arc(1, 2));

        var g1_TotalColors = Algorithm.ColorierDsatur(g1);
        System.out.println(String.format("G1 Total Colors: %d", g1_TotalColors));
        System.out.println(g1);

        var g2 = new GrapheListe(5, false);
        g2.Ajouter(new Arc(0, 1));
        g2.Ajouter(new Arc(1, 2));
        g2.Ajouter(new Arc(2, 3));
        g2.Ajouter(new Arc(3, 4));

        var g2_TotalColors = Algorithm.ColorierDsatur(g2);
        System.out.println(String.format("G2 Total Colors: %d", g2_TotalColors));
        System.out.println(g2);

        var g3 = new GrapheListe(8, false);
        g3.Ajouter(new Arc(0, 1));
        g3.Ajouter(new Arc(0, 3));
        g3.Ajouter(new Arc(1, 2));
        g3.Ajouter(new Arc(1, 3));
        g3.Ajouter(new Arc(1, 5));
        g3.Ajouter(new Arc(2, 3));
        g3.Ajouter(new Arc(3, 7));
        g3.Ajouter(new Arc(4, 5));
        g3.Ajouter(new Arc(4, 6));
        g3.Ajouter(new Arc(4, 7));
        g3.Ajouter(new Arc(5, 6));
        g3.Ajouter(new Arc(6, 7));

        var g3_TotalColors = Algorithm.ColorierDsatur(g3);
        System.out.println(String.format("G3 Total Colors: %d", g3_TotalColors));
        System.out.println(g3);

        var g4 = new GrapheListe(10, false);
        g4.Ajouter(new Arc(0, 1));
        g4.Ajouter(new Arc(0, 4));
        g4.Ajouter(new Arc(0, 5));
        g4.Ajouter(new Arc(1, 2));
        g4.Ajouter(new Arc(1, 6));
        g4.Ajouter(new Arc(2, 3));
        g4.Ajouter(new Arc(2, 7));
        g4.Ajouter(new Arc(3, 4));
        g4.Ajouter(new Arc(3, 8));
        g4.Ajouter(new Arc(4, 9));
        g4.Ajouter(new Arc(5, 7));
        g4.Ajouter(new Arc(5, 8));
        g4.Ajouter(new Arc(6, 8));
        g4.Ajouter(new Arc(6, 9));
        g4.Ajouter(new Arc(7, 9));

        var g4_TotalColors = Algorithm.ColorierDsatur(g4);
        System.out.println(String.format("G4 Total Colors: %d", g4_TotalColors));
        System.out.println(g4);
    }
}
