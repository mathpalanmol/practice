package prac.graph;

public class Test {
    long id;
    String name;

    public Test(final long id, final String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hashCode = 7;
        hashCode += 31 * hashCode + name == null ? 0 : name.hashCode();
        hashCode += 31 * hashCode + id;
        return hashCode;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        return name.equals(((Test) obj).name);
    }
}
