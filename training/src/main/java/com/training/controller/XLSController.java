package com.training.controller;

import com.training.domain.Ftth;
import com.training.util.UtilXLS;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class XLSController {

  @GetMapping(value = "/xls")
  public void makeXLS(HttpServletResponse response) {
    UtilXLS utilXLS = new UtilXLS();

    Ftth ftth = new Ftth();
    ftth.setDistrict("Przeworsk");
    ftth.setId(1L);
    ftth.setStreetName("Horny");
    ftth.setCreatedOn(new Date());
    ftth.setLeasingNumber(1554);

    Ftth ftth2 = new Ftth();
    ftth2.setDistrict("Pantal");
    ftth2.setId(1L);
    ftth2.setStreetName("The best");
    ftth2.setCreatedOn(new Date());
    ftth2.setLeasingNumber(1234);

    List<Ftth> ftths = Arrays.asList(ftth,ftth2);

    utilXLS.makeXLS(response,ftths);
  }
}
