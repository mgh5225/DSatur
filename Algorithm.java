import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public final class Algorithm {
    private Algorithm() {
    }

    public static int ColorierDsatur(IGraphe g) {
        ArrayList<Boolean> used = new ArrayList<Boolean>();
        ArrayList<Integer> colors = new ArrayList<Integer>();
        ArrayList<Integer> degrees = new ArrayList<Integer>();
        ArrayList<Set<Integer>> colorSet = new ArrayList<Set<Integer>>();

        var nodes = g.getNodes();

        for (int i = 0; i < g.NbNoeuds(); i++) {
            var node = new Node(i);
            node.setDegree(g.Degree(i));
            nodes.add(node);
            colors.add(node.getColor());
            degrees.add(node.getDegree());

            colorSet.add(new HashSet<Integer>());
            used.add(false);
        }

        while (!nodes.isEmpty()) {
            var node = nodes.poll();

            for (Arc arc : g.Adjacents(node.getNo())) {
                if (colors.get(arc.vers) != -1) {
                    used.set(colors.get(arc.vers), true);
                }
            }

            int minColor;
            for (minColor = 0; minColor < g.NbNoeuds(); minColor++) {
                if (used.get(minColor) == false)
                    break;
            }

            for (Arc arc : g.Adjacents(node.getNo())) {
                if (colors.get(arc.vers) != -1) {
                    used.set(colors.get(arc.vers), false);
                }
            }

            colors.set(node.getNo(), minColor);

            for (Arc arc : g.Adjacents(node.getNo())) {
                if (colors.get(arc.vers) == -1) {
                    nodes.remove(new Node(arc.vers));
                    colorSet.get(arc.vers).add(minColor);

                    degrees.set(arc.vers, degrees.get(arc.vers) - 1);

                    var newNode = new Node(arc.vers);
                    newNode.setDegree(degrees.get(newNode.getNo()));
                    newNode.setDsat(colorSet.get(newNode.getNo()).size());

                    nodes.add(newNode);
                }
            }
        }

        for (int i = 0; i < colors.size(); i++) {
            if (colors.get(i) == -1)
                return i;
        }

        return 0;
    }
}
