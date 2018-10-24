import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestMyPoint {

    MyPoint p1;

    @Before
    public void setUp() {
        p1 = new MyPoint();
    }

    @Test
    public void testConstructeur1() {
        //p1 = new MyPoint();
        assertEquals(0d, p1.getX(), 0.001);
        assertEquals(0d, p1.getY(), 0.001);
    }

    @Test
    public void testConstructeur2() {
        p1 = new MyPoint(7, 2);
        assertEquals(7d, p1.getX(), 0.001);
        assertEquals(2d, p1.getY(), 0.001);
    }

    @Test
    public void testGetSetX() {
        MyPoint p3 = new MyPoint();
        p3.setX(7d);
        assertEquals(7d, p3.getX(), 0.001);
    }

    @Test
    public void testGetSetY() {
        MyPoint p4 = new MyPoint();
        p4.setY(12d);
        assertEquals(p4.getY(), 12d, 0.001);
    }

    @Test
    public void testGetSetXNaN() {
        MyPoint p5 = new MyPoint(8d, 6d);
        p5.setX(Double.NaN);
        assertEquals(p5.getX(), 8d, 0.05);
    }

    @Test
    public void testGetSetYNaN() {
        MyPoint p6 = new MyPoint(8d, 12);
        p6.setY(Double.NaN);
        assertEquals(p6.getY(), 12d, 0.05);
    }

    @Test
    public void testConstructor3Null() {
        MyPoint p7 = null;
        MyPoint p8 = new MyPoint(p7);
        assertEquals(p8.getX(), 0d, 0.001);
        assertEquals(p8.getY(), 0d, 0.001);
    }

    @Test
    public void testConstructor3() {
        MyPoint p7 = null;
        MyPoint p8 = new MyPoint(1, 6);
        p7 = new MyPoint(p8);
        assertEquals(p7.getX(), 1d, 0.001);
        assertEquals(p7.getY(), 6d, 0.001);
    }

    @Test
    public void testScale0() {
        MyPoint p8 = new MyPoint(0, 0);
        MyPoint p9 = p8.scale(5);
        assertEquals(p9.getX(), 0d, 0.001);
        assertEquals(p9.getY(), 0d, 0.001);
    }

    @Test
    public void testScale() {
        MyPoint p8 = new MyPoint(3, 5);
        MyPoint p9 = p8.scale(2);
        assertEquals(p9.getX(), 6d, 0.001);
        assertEquals(p9.getY(), 10d, 0.001);
    }

    @Test
    public void testMiddle(){
        MyPoint p8 = new MyPoint(3, 5);
        MyPoint p9 = new MyPoint(5,7);
        MyPoint p10 = p8.getMiddlePoint(p9);
        assertEquals(p10.getX(), 4d, 0.001);
        assertEquals(p10.getY(), 6d, 0.001);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testHorizontalSymmetryNull() {
        MyPoint p10 = new MyPoint(2, 3);
        MyPoint p11 = p10.horizontalSymmetry(null);
        //should not reach here
    }

    @Test
    public void testHorizontalSymmetry() {
        MyPoint p10 = new MyPoint(2, 3);
        MyPoint p11 = new MyPoint(3, 3);
        MyPoint p12 = p10.horizontalSymmetry(p11);
        assertEquals(p12.getX(), 4, 0.001);
        assertEquals(p12.getX(), 4, 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCentralSymmetryNULL() {
        new MyPoint(1.0, 2.0).centralSymmetry(null);
    }

    @Test
    public void testMock(){
        Random rMockX = mock(Random.class);
        Random rMockY = mock(Random.class);
        when(rMockX.nextInt()).thenReturn(5);
        when(rMockY.nextInt()).thenReturn(12);
        p1.setPoint(rMockX,rMockY);
        assertEquals (5d, p1.getX(), 0.0001);
        assertEquals (12d, p1.getY(), 0.0001);
    }
}
