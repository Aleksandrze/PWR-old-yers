
public abstract class ListySprawdzian implements List {

	public int hashCode() {
		int hashCode = 0;
		Iterator i = iterator();
		for (i.first(); !i.isDone(); i.next())
			hashCode ^= i.current().hashCode();
		return hashCode;
	}

	public boolean equals(Object object) {
		return object instanceof List ? equals((List) object) : false;
	}

	public boolean equals(List other) {
		if (other == null || size() != other.size())
			return false;
		else {
			Iterator i = iterator();
			Iterator j = other.iterator();
			for (i.first(), j.first(); !i.isDone() && !j.isDone() && i.current().equals(j.current()); i.next(), j
					.next())
				;
			return i.isDone() && j.isDone();
		}
	}

}
