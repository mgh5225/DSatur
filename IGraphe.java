import java.lang.Iterable;

interface IGraphe {
	int NbNoeuds(); // retourne le nombre de noeuds

	int NbArcs(); // retourne le nombre d'arcs

	boolean EstDirige();

	void Ajouter(Arc a); // ajoute l'arc a au graphe

	void SortNodes();

	Node getNode(int no);

	Node getNode();

	// retour vrai si l'arc de i a j existe
	boolean Existe(int i, int j);

	// retourne un objet pour iterer sur les arcs sortant de i
	Iterable<Arc> Adjacents(int i);

	String toString();
}
