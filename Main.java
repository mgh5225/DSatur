public class Main {

    public static void main(String[] args) {

        String[] instances = {
                "./data/instance1.txt",
                "./data/instance2.txt",
                "./data/instance3.txt",
                "./data/instance4.txt" };

        for (String path : instances) {
            System.out.println(String.format("Reading %s", path));

            var g = GrapheListe.readFromFile(path);

            System.out.println(String.format("Total Nodes %d", g.NbNoeuds()));
            System.out.println(String.format("Total Edges %d", g.NbArcs()));

            var startTime = System.currentTimeMillis();

            var totalColors = Algorithm.ColorierDsatur(g);

            var endTime = System.currentTimeMillis();

            System.out.println(String.format("Total colors: %d", totalColors));
            System.out.println(String.format("Execution Time: %d (ms)\n", endTime - startTime));
        }

    }

}
