import java.lang.Iterable;
import java.util.ArrayList;

interface IGraphe {
	int NbNoeuds(); // retourne le nombre de noeuds

	int NbArcs(); // retourne le nombre d'arcs

	boolean EstDirige();

	void Ajouter(Arc a); // ajoute l'arc a au graphe

	// retour vrai si l'arc de i a j existe
	boolean Existe(int i, int j);

	// retourne un objet pour iterer sur les arcs sortant de i
	Iterable<Arc> Adjacents(int i);

	ArrayList<Node> getNodes();

	int Degree(int i);

	String toString();
}
