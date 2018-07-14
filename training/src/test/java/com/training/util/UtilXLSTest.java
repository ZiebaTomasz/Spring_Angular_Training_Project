package com.training.util;

import static org.junit.Assert.*;

import com.training.domain.Ftth;
import java.util.Date;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UtilXLSTest {

  private static final Logger logger = LoggerFactory.getLogger(UtilXLSTest.class);

  UtilXLS utilXLS;
  Ftth ftth;

  @Before
  public void setUp() {
    utilXLS = new UtilXLS();
    ftth = new Ftth();
    ftth.setDistrict("Przeworsk");
    ftth.setId(1L);
    ftth.setStreetName("Horny");
    ftth.setCreatedOn(new Date());
    ftth.setLeasingNumber(1554);
  }

  @Test
  public void whenFtthThenArrayOfPool() {
    logger.info(ftth.toString());
    List<String> s = utilXLS.makeRows(ftth);
    for (String str : s) {
      logger.info(str);
    }
    assertTrue(s.size()==4);
  }

  @Test
  public void whenFtthThanArrayData() {
    List<String> strings = utilXLS.makeData(ftth);

    strings.forEach(logger::info);
  }

}
