public class Node implements Comparable<Node> {
    private int no;
    private int color;
    private int degree;
    private int dsat;

    public Node(int no) {
        this.no = no;
        color = -1;
        degree = 0;
        dsat = 0;
    }

    public String toString() {
        return String.format("no: %d\ncolor: %d\ndegree: %d\ndsat: %d\n", no, color, degree, dsat);
    }

    public int getNo() {
        return no;
    }

    public int getColor() {
        return color;
    }

    public int getDegree() {
        return degree;
    }

    public int getDsat() {
        return dsat;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public void setDsat(int dsat) {
        this.dsat = dsat;
    }

    public void incDegree() {
        this.degree++;
    }

    @Override
    public int compareTo(Node node) {
        int degree = ((Node) node).getDegree();

        return degree - this.degree;
    }

}
