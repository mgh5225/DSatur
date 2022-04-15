/*
	Representation d'un graphe sous la forme 
	de listes d'adjacence
	
	Chaque noeud a une liste chainee qui contient
	les arcs sortant
*/

import java.lang.Iterable;
import java.util.ArrayList;

public class GrapheListe implements IGraphe {
	private int nbnoeuds, nbarcs;
	private boolean est_dirige;
	private ArrayList<ListeChainee<Arc>> arcs;

	public GrapheListe(int noeuds, boolean dir) {
		nbnoeuds = noeuds;
		est_dirige = dir;
		arcs = new ArrayList<ListeChainee<Arc>>();
		for (int i = 0; i < nbnoeuds; i++)
			arcs.add(new ListeChainee<Arc>());
	}

	public int NbNoeuds() {
		return nbnoeuds;
	}

	public int NbArcs() {
		return nbarcs;
	}

	public boolean EstDirige() {
		return est_dirige;
	}

	public void Ajouter(Arc a) {
		arcs.get(a.de).Ajouter(a);
		nbarcs++;
		if (!est_dirige) {
			arcs.get(a.vers).Ajouter(new Arc(a.vers, a.de));
			nbarcs++;
		}
	}

	// retour vrai si l'arc de i a j existe
	public boolean Existe(int i, int j) {
		for (Arc a : arcs.get(i)) {
			if (a.vers == j) {
				return true;
			}
		}
		return false;
	}

	// retourne un objet contenant tous les arcs sortant de i
	public Iterable<Arc> Adjacents(int i) {
		return arcs.get(i);
	}
}
