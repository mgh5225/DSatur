import java.util.Comparator;

public class NodeComparator implements Comparator<Node> {
    public int compare(Node a, Node b) {
        var b1 = a.getDsat() < b.getDsat();
        var b2 = a.getDegree() < b.getDegree();
        var b3 = a.getNo() < b.getNo();

        return (b1 || b2 || b3) ? 1 : -1;
    }
}
