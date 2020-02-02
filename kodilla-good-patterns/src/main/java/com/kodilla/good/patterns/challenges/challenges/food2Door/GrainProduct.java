package com.kodilla.good.patterns.challenges.challenges.food2Door;

public class GrainProduct extends Product {
    private boolean isBIO;

    public GrainProduct(String productName, boolean isBIO) {
        super(productName);
        this.isBIO = isBIO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        GrainProduct that = (GrainProduct) o;

        return isBIO == that.isBIO;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (isBIO ? 1 : 0);
        return result;
    }
}
