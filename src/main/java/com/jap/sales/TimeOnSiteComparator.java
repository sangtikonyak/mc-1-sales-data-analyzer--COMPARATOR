package com.jap.sales;


import java.util.Comparator;

public class TimeOnSiteComparator implements Comparator<SalesRecord> {
    @Override
    public int compare(SalesRecord o1,SalesRecord o2)
    {
        return Integer.compare((int) o2.getTime_on_site(), (int) o1.getTime_on_site());
    }
}
