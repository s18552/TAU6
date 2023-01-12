package zad2;

import org.easymock.EasyMock;
import org.junit.jupiter.api.Test;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    private Car myFerrari = EasyMock.createMock(Car.class);

    @Test
    public void test_instance_car() {
        assertTrue(myFerrari instanceof Car);

    }

    @Test
    public void test_default_behavior_needsFuel() {
        assertFalse(myFerrari.needsFuel(), "New test double should return False as boolean");
    }

    @Test
    public void test_default_behavior_temperature() {
        assertEquals(0.0, myFerrari.getEngineTemperature(), "New test double should return 0.0");
    }

    @Test
    public void test_stubbing_mock() {
        expect(myFerrari.needsFuel()).andReturn(true);
        replay(myFerrari);
        assertTrue(myFerrari.needsFuel());

    }

    @Test
    public void test_exception() {
        expect(myFerrari.needsFuel()).andThrow(new RuntimeException());
        replay(myFerrari);
        assertThrows(RuntimeException.class, () -> {
            myFerrari.needsFuel();
        });
    }

    @Test
    public void testEngineTemperature() {
        expect(myFerrari.getEngineTemperature()).andReturn(40.0);
        replay(myFerrari);
        assertEquals(myFerrari.getEngineTemperature(), 40);
    }

    @Test
    public void testCarIsNotNull() {
        assertNotNull(myFerrari);
    }

    @Test
    public void testIfCarNeedsFuel() {
        EasyMock.expect(myFerrari.needsFuel()).andReturn(false);
        EasyMock.replay(myFerrari);
        assertFalse(myFerrari.needsFuel());
    }

    @Test
    public void testIfCarDoesNotNeedsFuel() {
        EasyMock.expect(myFerrari.needsFuel()).andReturn(true);
        EasyMock.replay(myFerrari);
        assertTrue(myFerrari.needsFuel());
    }

    @Test
    public void testNotTrowExceptionWhileDrivingToSomewhere() {
        assertDoesNotThrow(() -> myFerrari.driveTo("Paris"));
    }


}