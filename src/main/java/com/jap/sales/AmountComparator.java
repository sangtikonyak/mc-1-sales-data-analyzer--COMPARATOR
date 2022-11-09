package com.jap.sales;


import java.util.Comparator;

public class AmountComparator implements Comparator<SalesRecord> {

    @Override
    public int compare(SalesRecord o1,SalesRecord o2)
    {
        return (Integer.compare((int) o2.getAmount(), (int) o1.getAmount()));
    }
}
