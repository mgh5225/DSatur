public class Algorithm {
    public static int ColorierDsatur(IGraphe g) {
        // step 1
        g.SortNodes();
        // step 2
        g.getNode(0).setColor(0);

        int numColors = 1;

        // step 3 4 5
        while (true) {
            var node = g.getNode();
            if (node == null)
                break;

            var arcs = g.Adjacents(node.getNo());
        }

        return numColors;
    }
}
