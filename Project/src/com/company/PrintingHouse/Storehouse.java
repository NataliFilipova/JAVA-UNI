package com.company.PrintingHouse;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class Storehouse {

    private int[] normalStorage = new int[4];
    private int[] glossyStorage = new int[4];
    private int[] printsNewPaperStorage = new int[4];

    public Storehouse(int[] normalStorage, int[] glossyStorage, int[] printsNewPaperStorage) {
        this.normalStorage = normalStorage;
        this.glossyStorage = glossyStorage;
        this.printsNewPaperStorage = printsNewPaperStorage;
    }

    public int[] getNormalStorage() {
        return normalStorage;
    }

    public void setNormalStorage(int[] normalStorage) {
        this.normalStorage = normalStorage;
    }

    public int[] getGlossyStorage() {
        return glossyStorage;
    }

    public void setGlossyStorage(int[] glossyStorage) {
        this.glossyStorage = glossyStorage;
    }

    public int[] getPrintsNewPaperStorage() {
        return printsNewPaperStorage;
    }

    public void setPrintsNewPaperStorage(int[] printsNewPaperStorage) {
        this.printsNewPaperStorage = printsNewPaperStorage;
    }

    @Override
    public String toString() {
        return "Storehouse{" +
                "normalStorage=" + Arrays.toString(normalStorage) +
                ", glossyStorage=" + Arrays.toString(glossyStorage) +
                ", printsNewPaperStorage=" + Arrays.toString(printsNewPaperStorage) +
                '}';
    }
}
