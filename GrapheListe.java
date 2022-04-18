/*
	Representation d'un graphe sous la forme 
	de listes d'adjacence
	
	Chaque noeud a une liste chainee qui contient
	les arcs sortant
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.Iterable;
import java.util.ArrayList;
import java.util.Scanner;

public class GrapheListe implements IGraphe {
	private int nbnoeuds, nbarcs;
	private boolean est_dirige;
	private ArrayList<ListeChainee<Arc>> arcs;
	private ArrayList<Node> nodes;

	public GrapheListe(int noeuds, boolean dir) {
		nbnoeuds = noeuds;
		est_dirige = dir;
		arcs = new ArrayList<ListeChainee<Arc>>();
		nodes = new ArrayList<Node>();
		for (int i = 0; i < nbnoeuds; i++) {
			arcs.add(new ListeChainee<Arc>());
		}
	}

	public static IGraphe readFromFile(String path, boolean dir) {
		GrapheListe g = null;

		try {
			var scanner = new Scanner(new File(path));

			while (scanner.hasNext()) {

				var type = scanner.next();

				if (type.equals("p")) {
					scanner.next();

					var nodes = scanner.nextInt();

					scanner.next();

					g = new GrapheListe(nodes, dir);

				} else {
					var de = scanner.nextInt() - 1;
					var vers = scanner.nextInt() - 1;
					if (g != null)
						g.Ajouter(new Arc(de, vers));
				}

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return g;
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

	public ArrayList<Node> getNodes() {
		return nodes;
	}

	public int Degree(int i) {
		return arcs.get(i).Compte();
	}

	public String toString() {
		String str = "";
		for (Node node : nodes) {
			str += node;
		}

		return str;

	}
}
