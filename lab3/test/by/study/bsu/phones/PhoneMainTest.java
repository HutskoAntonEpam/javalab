package by.study.bsu.phones;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.math.BigDecimal;

import static org.testng.Assert.*;

public class PhoneMainTest {
    public static Logger log = LogManager.getLogger(PhoneMainTest.class.getName());
    @Test
    public void testSortSubs() {
        Phone[] subs = new Phone[3];
        subs[0] = new Phone(2, "B", "B", "", "", 0);
        subs[1] = new Phone(1, "A", "A", "", "", 0);
        subs[2] = new Phone(3, "C", "C", "", "", 0);
        for (Phone sub : subs) {
            sub.setDebit(new BigDecimal(0));
            sub.setCredit(new BigDecimal(0));
            sub.setTownCallsTime(0);
            sub.setDistanceCallsTime(0);
        }

        String[] subsControl = new String[subs.length];
        subsControl[0] = subs[1].toString();
        subsControl[1] = subs[0].toString();
        subsControl[2] = subs[2].toString();

        PhoneMain.sortSubs(subs);
        String[] subsStr = new String[subs.length];
        for (int i = 0; i < subs.length; i++) {
            subsStr[i] = subs[i].toString();
        }

        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        for (int i = 0; i < subs.length; i++) {
            s1.append(subsStr[i]).append("\n");
            s2.append(subsControl[i]).append("\n");
        }
        log.info(s1.toString());
        log.info(s2.toString());
        assertEquals(s1.toString(), s2.toString(), "Test failed as...");
    }
}