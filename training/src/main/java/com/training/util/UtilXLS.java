package com.training.util;


import com.training.domain.Ftth;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

public class UtilXLS {

  public void makeXLSByFtth(HttpServletResponse response, List<Ftth> ftths) {
    makeXLS(response, ftths);
  }

  public void makeXLSByFtthArray(List<Ftth> ftthList) {

  }

  List<String> makeRows(Ftth ftth) {
    String s = ftth.toString();
    String[] strings = s.split(", ");
    List<String> strings1 = new ArrayList<>();
    Arrays.stream(strings).forEach(s1 -> strings1.add(s1.substring(0, s1.indexOf("="))));
    strings1.remove(0);
    return strings1;
  }

  List<String> makeData(Ftth ftth) {
    String s = ftth.toString();
    String[] strings = s.split(", ");
    List<String> strings1 = new ArrayList<>();
    Arrays.stream(strings).forEach(s1 -> strings1.add(s1.substring(s1.indexOf("=") + 1)));
    String stringToReplace = strings1.get(strings1.size()-1).substring(0, strings1.get(strings1.size()-1).length()-1);
    strings1.set(strings1.size()-1, stringToReplace);


    strings1.remove(0);
    return strings1;
  }


  public void makeXLS(HttpServletResponse response, List<Ftth> ftths) {
    try {
      response.setContentType("application/vnd.ms-excel");
      String reportName = "Ftth_Raport.xls";
      response.setHeader("Content-disposition", "attachment; filename=" + reportName);
      ArrayList<String> rows = new ArrayList<>();
      makeRows(new Ftth()).forEach(s -> {
        rows.add(s);
        rows.add("\t");
      });
      rows.add("\n");

      for (Ftth ftth: ftths){
        List<String> data = makeData(ftth);
        data.forEach(s -> {
          rows.add(s);
          rows.add("\t");
        });
        rows.add("\n");
      }
//      for (int i = 0; i < 5; i++) {
//        rows.add("Java");
//        rows.add("\t");
//        rows.add("Honk");
//        rows.add("\t");
//        rows.add("Success");
//        rows.add("\n");
//      }
      Iterator<String> iter = rows.iterator();
      while (iter.hasNext()) {
        String outputString = (String) iter.next();
        response.getOutputStream().print(outputString);
      }

      response.getOutputStream().flush();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}


