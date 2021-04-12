package org.cuju;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.cuju.date.DateUtils;
import org.junit.Test;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void testGetCalendar(){
        Date date = DateUtils.getCalendar(2020,5,20);
        String dateStr = DateUtils.getDateStr(date,"yyyy-MM-dd HH:mm:ss");
        assertEquals(dateStr,"2020-05-20 00:00:00");
    }

    @Test
    public void testListUtils(){

    }

}
