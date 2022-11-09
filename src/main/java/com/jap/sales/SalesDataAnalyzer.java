package com.jap.sales;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SalesDataAnalyzer {
    // Read the data from the file and store in a List
   public List<SalesRecord> readFile(String fileName) throws NumberFormatException,IOException {
       List<SalesRecord> recordList=recordList = new ArrayList<>();;

           FileReader fileReader = new FileReader(fileName);
           BufferedReader bufferedReader = new BufferedReader(fileReader);
           int line = 0;
           String lines;
           while ((lines = bufferedReader.readLine()) != null) {
               line++;
           }
           fileReader = new FileReader(fileName);
           bufferedReader = new BufferedReader(fileReader);
           bufferedReader.readLine();
           while ((lines = bufferedReader.readLine()) != null) {
               SalesRecord salesRecord = new SalesRecord();
               String[] split = lines.split(",");
               salesRecord.setDate(split[0]);
               salesRecord.setCustomer_id(Integer.parseInt(split[1]));
               salesRecord.setProduct_category(Integer.parseInt(split[2]));
               salesRecord.setPayment_method(split[3]);
               salesRecord.setAmount(Double.parseDouble(split[4]));
               salesRecord.setTime_on_site(Double.parseDouble(split[5]));
               salesRecord.setClicks_in_site(Integer.parseInt(split[6]));
               recordList.add(salesRecord);
           }
       for (SalesRecord salesRecord : recordList) {
           System.out.println(salesRecord);
       }

        return recordList;
    }

    // Sort the customers based on purchase amount
    public List<SalesRecord> getAllCustomersSortedByPurchaseAmount(List<SalesRecord> salesData, AmountComparator amountComparator){
       Collections.sort(salesData,amountComparator);

       return salesData;
    }

    // Find the top customer who spent the maximum time on the site
    public SalesRecord getTopCustomerWhoSpentMaxTimeOnSite(List<SalesRecord> salesData,TimeOnSiteComparator timeOnSiteComparator){

       Collections.sort(salesData,timeOnSiteComparator);
        SalesRecord salesRecord=salesData.get(0);
        return salesRecord;
    }
    public static void main(String[] args) {
        SalesDataAnalyzer salesDataAnalyzer = new SalesDataAnalyzer();

        try {
            List<SalesRecord> list = salesDataAnalyzer.readFile("src/main/resources/purchase_details.csv");
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
