package mbr.targeting;

/**
 * Created by mustafa on 17.09.16.
 */
public class Pair<L, R> {

    private L l;
    private R r;

    public Pair(L l, R r) {

        this.l = l;
        this.r = r;
    }

    public L getL() {
        return l;
    }

    public void setL(L l) {
        this.l = l;
    }

    public R getR() {
        return r;
    }

    public void setR(R r) {
        this.r = r;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof Pair))
            return false;

        return this.getL().equals(((Pair) obj).getL());
    }

    @Override
    public String toString() {
        return "Pair{" + l + " , " + r + '}';
    }
}

