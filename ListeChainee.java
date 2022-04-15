import java.util.Iterator;
import java.lang.Iterable;

public class ListeChainee<Item> implements Iterable<Item> {
	private class Node<Item> {
		Item item;
		Node<Item> suivant;

		public Node(Item it) {
			item = it;
		}
	}

	private Node<Item> tete;
	int nb_nodes = 0;

	public void Ajouter(Item item) {
		Node<Item> n = new Node<Item>(item);
		n.suivant = tete;
		tete = n;
		nb_nodes++;
	}

	public int Compte() {
		return nb_nodes;
	}

	@Override
	public Iterator<Item> iterator() {
		return new ListeChaineeIterator();
	}

	class ListeChaineeIterator implements Iterator<Item> {
		Node<Item> cur = tete;

		@Override
		public boolean hasNext() {
			return cur != null;
		}

		@Override
		public Item next() {
			Item v = cur.item;
			cur = cur.suivant;
			return v;
		}
	}
}
