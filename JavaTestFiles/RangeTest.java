package org.jfree.data;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

public class RangeTest {

    private Range exampleRange;
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception { exampleRange = new Range(-1, 1);
    }
    

    @Test
    public void centralValueShouldBeZero() {
        assertEquals("The central value of -1 and 1 should be 0",
        0, exampleRange.getCentralValue(), .000000001d);
    }
    
    @Test
    public void centralValueNonZero() {
    	Range a1 = new Range(4,7);
    	assertEquals("The centre value should return 5!",5.5,a1.getCentralValue(),.000000001d);
    }
    
    
    /** CONSTRAIN TESTS **/
    /* ---------------------------------------------------------------------------------------------------------- */
    
    // Input 1.5 should return 1.5
    @Test
    public void testConstrain_lowerEqualToBoundTest() {
    	Range a1 = new Range(1.5, 3.8);
    	
    	assertEquals("The constrain value should return 1.5", 1.5, a1.constrain(1.5), .000000001d);
    }
    
    // Input 2.0 should return 2.0
    @Test
    public void testConstrain_withinBoundaryTest() {
    	Range a1 = new Range(1.5, 3.8);
    	
    	assertEquals("The constrain value should return 2.0", 2.0, a1.constrain(2.0), .000000001d);
    	assertEquals("The constrain value should return 2.66", 2.66, a1.constrain(2.66), .000000001d);
    }
    
    // Input 7.0 should return 3.8
    @Test
    public void testConstrain_upperBoundaryTest() {
    	Range a1 = new Range(1.5, 3.8);
    	
    	assertEquals("The constrain value should return 3.8", 3.8, a1.constrain(7), .000000001d);
    	assertEquals("The constrain value should return 3.8", 3.8, a1.constrain(999999), .000000001d);
    }
    
    // Input of 0 should return 1.5
    @Test
    public void testConstrain_belowBoundaryTest() {
    	Range a1 = new Range(1.5, 3.8);
    	
    	assertEquals("The constrain value should return 1.5", 1.5, a1.constrain(0), .000000001d);
    	assertEquals("The constrain value should return 1.5", 1.5, a1.constrain(-100), .000000001d);
    }
    
    // Input 3.8 should return 3.8
    @Test
    public void testConstrain_upperEqualToBoundTest() {
    	Range a1 = new Range(1.5, 3.8);
    	
    	assertEquals("The constrain value should return 3.8", 3.8, a1.constrain(3.8), .000000001d);
    }
    
    /** CONTAIN TESTS **/
    /* ---------------------------------------------------------------------------------------------------------- */
    // Input of 0 should return false
    @Test
    public void testContains_belowBoundaryTest() {
    	Range a1 = new Range(1.5, 3.8);
    	
    	assertEquals("The contained value should return false, 0 is not within (1.5, 3.8)", false, a1.contains(0));
    }
    
    // Input 3.79999 should return true
    @Test
    public void testContains_withinBoundaryTest() {
    	Range a1 = new Range(1.5, 3.8);
    	
    	assertEquals("The contained value should return true, 3.79999 is within (1.5, 3.8)", true, a1.contains(3.79999));
    }

    // Input 10 should return false
    @Test
    public void testContains_upperBoundaryTest() {
    	Range a1 = new Range(1.5, 3.8);
    	
    	assertEquals("The contained value should return true, 10 is within (1.5, 3.8)", false, a1.contains(10));
    }

    // Input 1.5 should return true
    @Test
    public void testContains_lowerEqualToBoundTest() {
    	Range a1 = new Range(1.5, 3.8);
    	
    	assertEquals("The contained value should return true, 1.5 is within (1.5, 3.8)", true, a1.contains(1.5));

    }

    // Input 3.8 should return true
    @Test
    public void testContains_upperEqualToBoundTest() {
    	Range a1 = new Range(1.5, 3.8);
    	
    	assertEquals("The contained value should return true, 3.8 is within (1.5, 3.8)", true, a1.contains(3.8));
    }

    // Input -999999 should return false
    @Test
    public void testContains_extremeBoundaryLowerTest() {
    	Range a1 = new Range(1.5, 3.8);
    	
    	assertEquals("The contained value should return false, -999999 is not within (1.5, 3.8)", false, a1.contains(-999999));
    }

    // Input 999999 should return false
    @Test
    public void testContains_extremeBoundaryUpperTest() {
    	Range a1 = new Range(1.5, 3.8);
    	
    	assertEquals("The contained value should return false, 999999 is not within (1.5, 3.8)", false, a1.contains(999999));
    }


    /** GET LENGTH TESTS **/
    /* ---------------------------------------------------------------------------------------------------------- */
    
    // Input (1, 10) should return 9
    @Test
    public void testGetLength_bothValuesPositiveInt() {
    	Range a1 = new Range(1, 10);
    	
    	assertEquals("The length of (1, 10) should be 9", 9, a1.getLength(), .000000001d);
    }
    
    // Input (-10, 10) should return 20
    @Test
    public void testGetLength_oneValueNegativeInt() {
    	Range a2 = new Range(-10, 10);
    	
    	assertEquals("The length of (-10, 10) should be 20", 20, a2.getLength(), .000000001d);
    }
    
    // Input (1.5, 3.8) should return 2.3
    @Test
    public void testGetLength_bothValuesPositiveDouble() {
    	Range a3 = new Range(1.5, 3.8);
    	
    	assertEquals("The length of (1.5, 3.8) should be 2.3", 2.3, a3.getLength(), .000000001d);
    }
    
    // Input (-1.5,4.5) should return 6
    @Test
    public void testGetLength_oneValueNegativeDouble() {
    	Range a4 = new Range(-1.5, 4.5);
    	
    	assertEquals("The length of (-1.5, 4.5) should be 6", 6, a4.getLength(), .000000001d);
    }
    
    
    // Input (0, 0) should return 0
    @Test
    public void testGetLength_bothValueSame() {
    	Range a5 = new Range(0, 0);

    	assertEquals("The length of (0, 0) should be 0", 0, a5.getLength(), .000000001d);
    }
   
    
    /** GET UPPER BOUND TEST **/
    /* ---------------------------------------------------------------------------------------------------------- */
    
    // Input (1, 3) should return 3
    @Test
    public void testGetUpperBound_positiveInt() {
    	Range a1 = new Range(1, 3);
    	
    	assertEquals("The upper bound of (1, 3) should be 3", 3, a1.getUpperBound(), .000000001d);
    }
    
    // Input (-100, -10) should return -10
    @Test
    public void testGetUpperBound_negativeInt() {
    	Range a2 = new Range(-100, -10);
    	
    	assertEquals("The upper bound of (-100, -10) should be -10", -10, a2.getUpperBound(), .000000001d);
    }
    
    // Input (1.5, 3.8) should return 3.8
    @Test
    public void testGetUpperBound_positiveDouble() {
    	Range a3 = new Range(1.5, 3.8);
    	
    	assertEquals("The upper bound of (1.5, 3.8) should be 3.8", 3.8, a3.getUpperBound(), .000000001d);
    }
    
    // Input (-1.5, -0.3) should return -0.3
    @Test
    public void testGetUpperBound_negativeDouble() {
    	Range a4 = new Range(-1.5, -0.3);
    	
    	assertEquals("The upper bound of (-1.5, -0.3) should be -0.3", -0.3, a4.getUpperBound(), .000000001d);
    }
    
    // Input (0, 0) should return 0
    @Test
    public void testGetUpperBound_zero() {
    	Range a5 = new Range(0, 0);
    	
    	assertEquals("The upper bound of (0, 0) should be 0", 0, a5.getUpperBound(), .000000001d);
    }
    
    /** GET LOWER BOUND TESTS **/
    /* ---------------------------------------------------------------------------------------------------------- */
    
    // Input (1, 3) should return 1
    @Test
    public void testGetLowerBound_positiveInt() {
    	Range a1 = new Range(1, 3);
    	
    	assertEquals("The lower bound of (1, 3) should be 1", 1, a1.getLowerBound(), .000000001d);
    }

    // Input (-100, -10) should return -100
    @Test
    public void testGetLowerBound_negativeInt() {
    	Range a2 = new Range(-100, -10);
    	
    	assertEquals("The lower bound of (-100, -10) should be -100", -100, a2.getLowerBound(), .000000001d);
    }
    
    
    // Input (1.5, 3.8) should return 1.5
    @Test
    public void testGetLowerBound_positiveDouble() {
    	Range a3 = new Range(1.5, 3.8);

    	assertEquals("The lower bound of (1.5, 3.8) should be 1.5", 1.5, a3.getLowerBound(), .000000001d);
    }
    
    // Input (-1.5, -0.3) should return -1.5
    @Test
    public void testGetLowerBound_negativeDouble() {
    	Range a4 = new Range(-1.5, -0.3);
    	
    	assertEquals("The lower bound of (-1.5, -0.3) should be -1.5", -1.5, a4.getLowerBound(), .000000001d);
    }
    
    // Input (0, 0) should return 0
    @Test
    public void testGetLowerBound_zero() {
    	Range a5 = new Range(0, 0);

    	assertEquals("The lower bound of (0, 0) should be 0", 0, a5.getLowerBound(), .000000001d);
    }
    
    
    // New tests
    @Test (expected = java.lang.IllegalArgumentException.class)
    public void testRangeConstruction() throws java.lang.IllegalArgumentException {
    	Range invalid = new Range(5,-2);
    }
    
    @Test
    public void testIntersectWithinBoundsRange() {
    	Range r1 = new Range(0, 3);

    	assertTrue("Range(0, 3) should intersect -1, 1", r1.intersects(new Range(-1, 1)));
    	assertTrue("Range(0, 3) should intersect 1, 2", r1.intersects(new Range(1, 2)));
    	assertTrue("Range(0, 3) should intersect 2, 4", r1.intersects(new Range(2, 4)));
    	assertTrue("Range(0, 3) should intersect -1, 4", r1.intersects(new Range(-1, 4)));
    }
    
    @Test
    public void testIntersectOutsideBoundsRange() {
    	Range r1 = new Range(0, 3);

    	assertFalse("Range(0, 3) should not intersect -2, -1", r1.intersects(new Range(-2, -1)));
    	assertFalse("Range(0, 3) should not intersect 4, 5", r1.intersects(new Range(4, 5)));
    	assertFalse("Range(0, 3) should not intersect 1, -1", r1.intersects(1, -1));
    }
    
    @Test
    public void testContainsCoverageForNaN() {
    	Range r1 = new Range(1, Double.NaN);
    	Range r2 = new Range(Double.NaN, 1);
    	Range r3 = new Range(Double.NaN, Double.NaN);
    	
    	assertFalse(r1.contains(Double.NaN));
    	assertFalse(r2.contains(Double.NaN));
    	assertFalse(r3.contains(Double.NaN));
    	assertFalse(r1.contains(1));
    	assertFalse(r2.contains(1));
    	assertFalse(r3.contains(1));

    }
   
    
    @Test
    public void testConstrainCoverageForNaN() {
    	Range r1 = new Range(1, Double.NaN);
    	Range r2 = new Range(Double.NaN, 1);
    	Range r3 = new Range(Double.NaN, Double.NaN);
    	
    	assertEquals("Test constrains", Double.NaN, r1.constrain(Double.NaN), .000000001d);
    	assertEquals("Test constrains", Double.NaN, r2.constrain(Double.NaN), .000000001d);
    	assertEquals("Test constrains", Double.NaN, r3.constrain(Double.NaN), .000000001d);
    	assertEquals("Test constrains", 1, r1.constrain(1), .000000001d);
    	assertEquals("Test constrains", 1, r2.constrain(1), .000000001d);
    	assertEquals("Test constrains", 1, r3.constrain(1), .000000001d);
    }
    
    @Test 
    public void testConstrainCoverage() {
    	Range r1 = new Range(0, 3);
    	
    	assertEquals("The constrain of 0 of Range(0,3) should return 0", 0, r1.constrain(0), .000000001d);
    }
    
    @Test 
    public void testConstrainCoverage2() {
    	Range r1 = new Range(0, 3);
    	
    	assertEquals("The constrain of 0 of Range(0,3) should return 0", 0, r1.constrain(-1), .000000001d);
    }
    
    
    @Test
    public void testRangeCombineCoverage() {
    	Range r1 = new Range(0, 3);
    	Range r2 = new Range(2, 5);
    	
    	
    	assertEquals("The combination of (0,3) and (2,5) should be (0,5)", new Range(0, 5), Range.combine(r1, r2));
    	assertEquals("The combination of null and (2,5) should be (2,5)", new Range(2, 5), Range.combine(null, r2));
    	assertEquals("The combination of (0,3) and null should be (0,3)", new Range(0, 3), Range.combine(r1, null));
    }
    
    @Test
    public void testCombineWithNonNull() {
    	Range r1=new Range(1, 3);
    	Range r2=new Range(1.5, 3.5);
    	Range result=new Range(1,3.5);
    	assertEquals("The returned range should be (1,3.5)", result, Range.combine(r1,r2));
    }
    
    @Test
    public void testCombineWithNull() {
    	Range r1=new Range(1, 3);
    	Range r2=new Range(1.5, 3.5);
    	assertEquals("The returned range should be (1.5,3.5)", r2, Range.combine(null,r2));
    	assertEquals("The returned range should be (1,3)", r1, Range.combine(r1,null));
    }
    
    @Test
    public void testCombineIgnoringNaNNonNull() {
    	Range r1=new Range(1, 3);
    	Range r2=new Range(1.5, 3.5);
    	Range result=new Range(1,3.5);
    	assertEquals("The returned range should be (1,3)", result, Range.combineIgnoringNaN(r1,r2));
    }
    
    @Test
    public void testCombineIngnoringNanWithNull() {
    	Range r1=new Range(1, 3);
    	Range r2=new Range(1.5, 3.5);
    	assertEquals("The returned range should be (1.5,3.5)", r2, Range.combineIgnoringNaN(null,r2));
    	assertEquals("The returned range should be (1,3)", r1, Range.combineIgnoringNaN(r1,null));
    }
    
    @Test
    public void testCombineIngnoringNanWithOnlyNull() {
//    	Range r1=new Range(1, 3);
//    	Range r2=new Range(null, 3.5);
    	assertEquals("The returned range should be null", null, Range.combineIgnoringNaN(null,null));
    	assertEquals("The returned range should be null", null, Range.combineIgnoringNaN(null,null));
    }
    
    @Test
    public void testCombineIgnoringNaNWithNan() {
    	Range r1=new Range(Double.NaN, Double.NaN);
    	Range r2=new Range(Double.NaN, Double.NaN);
    	Range result=new Range(1,3.5);
    	Range rNaNLower = new Range(Double.NaN, 1);
    	assertEquals("The returned range should be null", null, Range.combineIgnoringNaN(null,r2));
    	assertEquals("The returned range should be null", null, Range.combineIgnoringNaN(r1,null));
    	assertEquals("The returned range should be (1,3.5)", result, Range.combineIgnoringNaN(result,r1));
    	assertEquals("The returned range should be (1,3.5)", result, Range.combineIgnoringNaN(r1,result));
    	assertEquals("The returned range should be null", null, Range.combineIgnoringNaN(r1,r2));
    	assertEquals("The combination of rNaN and rNaN should be null", 1, Range.combineIgnoringNaN(rNaNLower, rNaNLower).getUpperBound(), 0.000001d);
    }
    
    @Test
    public void testExpandToIncludeCoverage() {
    	assertEquals("Expand (0, 3) to fit 4", new Range(0, 4), Range.expandToInclude(new Range(0, 3), 4));
    	assertEquals("shift of Range(-1,2) with delta -1", new Range(0, 3), Range.expandToInclude(new Range(0, 3), 3));
    	
    	assertEquals("shift of Range(-1,2) with delta -1", new Range(-1, 3), Range.expandToInclude(new Range(0, 3), -1));
    	assertEquals("shift of Range(-1,2) with delta -1", new Range(0, 3), Range.expandToInclude(new Range(0, 3), 0));
    	
    	assertEquals("shift of Range(-1,2) with delta -1", new Range(2, 2), Range.expandToInclude(null, 2));
    }
    
    @Test
    public void testExpandToIncludeCoverageWithNull() {
    	assertEquals("shift of Range(-1,2) with delta -1", new Range(2, 2), Range.expandToInclude(null, 2));
    }
    
    @Test
    public void testExpandCoverage() {
    	assertEquals("Expand", new Range(3, 12), Range.expand(new Range(0, 3), -1, 3));
    	assertEquals("Expand", new Range(21, 21), Range.expand(new Range(0, 3), -10, 3));
    }
    
    @Test
    public void testshiftCoverage() {
    	assertEquals("shift of Range(-1,2) with delta -1", new Range(-1, 2), Range.shift(new Range(0, 3), -1));
    	assertEquals("shift of Range(-4,-2) with delta -1", new Range(-4, -2), Range.shift(new Range(-3, -1), -1));
    }
    
    @Test
    public void testshiftWithCrossingCoverage() {
    	assertEquals("shift of Range(-1,2) with delta -1", new Range(-1, 2), Range.shift(new Range(0, 3), -1, true));
    	assertEquals("shift of Range(-4,-2) with delta -1", new Range(-4, -2), Range.shift(new Range(-3, -1), -1, true));
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testScaleCoverage() throws IllegalArgumentException {
    	assertEquals("Scale", new Range(0, 9), Range.scale(new Range(0, 3), 3));
    	assertEquals("Scale", new Range(0, 9), Range.scale(new Range(0, 3), -1));
    }
    
    @Test
    public void testEqualsCoverage() {
    	Range r1 = new Range(0, 3);
    	Range r2 = new Range(2, 5);
    	Range r3 = new Range(0, 5);
    	assertFalse("equals should produce false when given different obj", r1.equals(new String()));
    	assertFalse("r1 does not equal r2", r1.equals(r2));
    	assertFalse("r1 does not equal r3", r1.equals(r3));
    }
    
    @Test
    public void testIsNaNRangeCoverage() {
    	Range r1 = new Range(0, 3);
    	Range r2 = new Range(Double.NaN, 3);
    	Range r3 = new Range(0, Double.NaN);
    	Range r4 = new Range(Double.NaN, Double.NaN);
    	
    	assertFalse("r1 is not NaN Range", r1.isNaNRange());
    	assertFalse("r2 is not NaN Range", r2.isNaNRange());
    	assertFalse("r3 is not NaN Range", r3.isNaNRange());
    	assertTrue("r4 is NaN Range", r4.isNaNRange());
    	
    }
    

    
    @Test
    public void testToStringCoverage() {
    	Range r1 = new Range(0, 3);
    	Range r2 = new Range(100, 223);
    	
    	assertEquals("to string should print correct range", "Range[0.0,3.0]", r1.toString());
    	assertEquals("to string should print correct range", "Range[100.0,223.0]", r2.toString());
    }
    
    @Test
    public void intersectionTest() {
    	Range r1 = new Range (3,11);
    	assertEquals("Intersects should be true!",false, r1.intersects(1, 3));
    	
    }
    
    @Test
    public void intersectionTest2() {
    	Range r1 = new Range (3,11);
    	assertEquals("Intersects should be true!",true, r1.intersects(2, 11));
    	
    }
    
    @Test
    public void intersectionTest3() {
    	Range r1 = new Range (3,11);
    	assertEquals("Intersects should be true!",true, r1.intersects(3, 10));
    	
    }
    
    @Test
    public void intersectionTest4() {
    	Range r1 = new Range (3,11);
    	assertEquals("Intersects should be true!",false, r1.intersects(11, 12));
    	
    }
    
    @Test
    public void intersectionTest5() {
    	Range r1 = new Range (3,11);
    	assertEquals("Intersects should be true!",true, r1.intersects(4, 4));
    	
    }
    
    @Test
    public void intersectionTest6() {
    	Range r1 = new Range (1,1);
    	assertEquals("Intersects should be true!",true, r1.intersects(1, 3));
    	
    }
   
    
    @Test 
    public void testExpandtoInclude(){
    	Range r1 = new Range(3,11);
    	Range r2 = Range.expandToInclude(r1, 3);
    	assertEquals("Intersects expand to include",11,r2.getUpperBound(),0.000001d);	
    	assertEquals("Intersects expand to include",3,r2.getLowerBound(),0.000001d);
    	
    }
    
    @Test 
    public void testExpandtoInclude2(){
    	Range r1 = new Range(3,11);
    	Range r2 = Range.expandToInclude(r1, -1);
    	assertEquals("Intersects expand to include",11,r2.getUpperBound(),0.000001d);	
    	assertEquals("Intersects expand to include",-1,r2.getLowerBound(),0.000001d);
    	
    }
    
    @Test 
    public void testExpandtoInclude3(){
    	Range r1 = new Range(3,11);
    	Range r2 = Range.expandToInclude(r1, 12);
    	assertEquals("Intersects expand to include",12,r2.getUpperBound(),0.000001d);	
    	assertEquals("Intersects expand to include",3,r2.getLowerBound(),0.000001d);
    	
    }
    
    @Test 
    public void expandTest1() {
    	Range r1 = new Range(3,11);
    	Range r2 = Range.expand(r1, 1, 12);
    	assertEquals("Intersects expand to include",107,r2.getUpperBound(),0.000001d);	
    	assertEquals("Intersects expand to include",-5,r2.getLowerBound(),0.000001d);
    	
    }
    
    @Test 
    public void expandTest2() {
    	Range r1 = new Range(3,11);
    	Range r2 = Range.expand(r1, 12, 12);
    	assertEquals("Intersects expand to include",107,r2.getUpperBound(),0.000001d);	
    	assertEquals("Intersects expand to include",-93.0,r2.getLowerBound(),0.000001d);
    	
    }
    
    @Test 
    public void shiftTest1(){
    	Range r1= new Range(3, 11);
    	Range r2 = Range.shift(r1, -1);
    	assertEquals("lower bound should be 10",10,r2.getUpperBound(),0.000001d);
    	assertEquals("upper should be 2",2,r2.getLowerBound(),0.000001d);
    	
    }
    
    @Test 
    public void shiftTestzero1(){
    	Range r1= new Range(3, 11);
    	Range r2 = Range.shift(r1, -4, false);
    	assertEquals("lower bound should be 7",7,r2.getUpperBound(),0.000001d);
    	assertEquals("upper should be 0",0,r2.getLowerBound(),0.000001d);
    	
    }
    
    @Test 
    public void shiftTestzero2(){
    	Range r1= new Range(3, 11);
    	Range r2 = Range.shift(r1, -4, true);
    	assertEquals("lower bound should be 7",7,r2.getUpperBound(),0.000001d);
    	assertEquals("upper should be -1",-1,r2.getLowerBound(),0.000001d);
    	
    }
    
    @Test 
    public void shiftTestzero3(){
    	Range r1= new Range(0, 11);
    	Range r2 = Range.shift(r1, -4, false);
    	assertEquals("lower bound should be 7",7,r2.getUpperBound(),0.000001d);
    	assertEquals("upper should be -4",-4,r2.getLowerBound(),0.000001d);
    	
    }
    
    @Test
    public void RangescaleTest1() {
    	Range r1 = new Range(3,11);
    	Range r2 = Range.scale(r1, 2);
    	assertEquals("lower bound should be 22",22,r2.getUpperBound(),0.000001d);
    	assertEquals("upper should be 6",6,r2.getLowerBound(),0.000001d);
    }
    
    @Test
    public void hashCodeTest() {
    	Range r1 = new Range(3,11);
    	assertEquals("Hash code should be-2129788928",-2129788928, r1.hashCode());
    }
    
   

    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
    
    

}
