package org.jfree.data;
import org.junit.*;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.jfree.data.DataUtilities;
import org.junit.Test;

import org.jmock.Mockery;
import org.jmock.Expectations;

import org.jfree.data.Values2D;
import org.jfree.data.KeyedValues;
import org.jfree.data.DefaultKeyedValues;

import java.util.Arrays;
import java.util.List;

public class DataUtilitiesTest{
	Mockery mockingContext;
	Values2D values;

	@Before
	public void setUp() {
		mockingContext = new Mockery();
		values = mockingContext.mock(Values2D.class);
		
	}
	
	//Valid input
	@Test
	public void calculateColumnTotalForTwoValues() {
		mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(2));
	            one(values).getValue(0, 0);
	            will(returnValue(7.5));
	            one(values).getValue(1, 0);
	            will(returnValue(2.5));
	        }
	    });
	    double result =  DataUtilities.calculateColumnTotal(values, 0);
	    assertEquals(result, 10.0, .000000001d);    
	}
	
//	//Negative Col size
//		@Test(timeout=1000)
//		public void calculateColumnTotalForNegativeColoumnSize() {
//			mockingContext.checking(new Expectations() {
//		        {
//		            one(values).getRowCount();
//		            will(returnValue(-2));
//		            one(values).getValue(0, 0);
//		            will(returnValue(7.5));
//		            one(values).getValue(1, 0);
//		            will(returnValue(2.5));
//		        }
//		    });
//		    double result =  DataUtilities.calculateColumnTotal(values, 0);
//		    assertEquals(result, 10.0, .000000001d);    
//		}
	
	@Test
	public void calculateColumnTotalForMultiplePosNegValues() {
		mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(5));
	            one(values).getValue(0, 0);
	            will(returnValue(-1.0));
	            one(values).getValue(1, 0);
	            will(returnValue(-2.0));
	            one(values).getValue(2, 0);
	            will(returnValue(-3.2));
	            one(values).getValue(3, 0);
	            will(returnValue(4.55));
	            one(values).getValue(4, 0);
	            will(returnValue(-4.3));
	        }
	    });
		
	    double result =  DataUtilities.calculateColumnTotal(values, 0);
	    assertEquals(result, -5.95, .000000001d);
	}
	
	//Invalid Input
	@Test
	public void calculateColumnTotalForEmpty() {
		mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(0));
	        }
	    });
		 double result =  DataUtilities.calculateColumnTotal(values, 0);
		   assertEquals(result, 0.0, .000000001d);
	}
	
	//Valid Input
	@Test
	public void calculateColumnTotalForTwoValues2() {
		mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(2));
	            one(values).getValue(0, 0);
	            will(returnValue(7.5));
	            one(values).getValue(1, 0);
	            will(returnValue(2.5));
	        }
	    });
		int[] validRows = {0,1};
	    double result =  DataUtilities.calculateColumnTotal(values, 0, validRows);
	    assertEquals(result, 10.0, .000000001d);    
	}
	
	//Valid Rows more than actual rows Input
	@Test
	public void calculateColumnTotalForDiffValidRows() {
		mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(2));
	            one(values).getValue(0, 0);
	            will(returnValue(7.5));
	            one(values).getValue(1, 0);
	            will(returnValue(2.5));
	        }
	    });
		int[] validRows = {0,1,2};
	    double result =  DataUtilities.calculateColumnTotal(values, 0, validRows);
	    assertEquals(result, 10.0, .000000001d);    
	}
	
	//Null Row marked as valid
		@Test
		public void calculateColumnNullValidRow() {
			mockingContext.checking(new Expectations() {
		        {
		            one(values).getRowCount();
		            will(returnValue(2));
		            one(values).getValue(0, 0);
		            will(returnValue(null));
		            one(values).getValue(1, 0);
		            will(returnValue(2.5));
		        }
		    });
			int[] validRows = {0,1,2};
		    double result =  DataUtilities.calculateColumnTotal(values, 0, validRows);
		    assertEquals(result, 2.5, .000000001d);    
		}
		
		//Valid input
				@Test
				public void calculateRowTotalForTwoValues2() {
					mockingContext.checking(new Expectations() {
				        {
				            one(values).getColumnCount();
				            will(returnValue(2));
				            one(values).getValue(0, 0);
				            will(returnValue(7.5));
				            one(values).getValue(0, 1);
				            will(returnValue(2.5));
				        }
				    });
					int[] validCols = {0,1};
				    double result =  DataUtilities.calculateRowTotal(values, 0, validCols);
				    assertEquals(result, 10.0, .000000001d);    
				}
				
			
				
			//Valid Rows larger than row count
				@Test
				public void calculateRowTotalForNullvalidRow() {
					mockingContext.checking(new Expectations() {
				        {
				            one(values).getColumnCount();
				            will(returnValue(2));
				            one(values).getValue(0, 0);
				            will(returnValue(null));
				            one(values).getValue(0, 1);
				            will(returnValue(2.5));
				        }
				    });
					int[] validCols = {0,1};
				    double result =  DataUtilities.calculateRowTotal(values, 0, validCols);
				    assertEquals(result, 2.5, .000000001d);    
				}
				
				//Null row value
				@Test
				public void calculateRowTotalForDiffvalidRow() {
					mockingContext.checking(new Expectations() {
				        {
				            one(values).getColumnCount();
				            will(returnValue(2));
				            one(values).getValue(0, 0);
				            will(returnValue(7.5));
				            one(values).getValue(0, 1);
				            will(returnValue(2.5));
				        }
				    });
					int[] validCols = {0,1,2};
				    double result =  DataUtilities.calculateRowTotal(values, 0, validCols);
				    assertEquals(result, 10.0, .000000001d);    
				}
				

	
	//Valid input
		@Test
		public void calculateRowTotalForTwoValues() {
			mockingContext.checking(new Expectations() {
		        {
		            one(values).getColumnCount();
		            will(returnValue(2));
		            one(values).getValue(0, 0);
		            will(returnValue(7.5));
		            one(values).getValue(0, 1);
		            will(returnValue(2.5));
		        }
		    });
		    double result =  DataUtilities.calculateRowTotal(values, 0);
		    assertEquals(result, 10.0, .000000001d);    
		}
		
		@Test
		public void calculateRowTotalForMultiplePosNegValues() {
			mockingContext.checking(new Expectations() {
		        {
		            one(values).getColumnCount();
		            will(returnValue(5));
		            one(values).getValue(0, 0);
		            will(returnValue(-1.0));
		            one(values).getValue(0, 1);
		            will(returnValue(-2.0));
		            one(values).getValue(0, 2);
		            will(returnValue(-3.2));
		            one(values).getValue(0, 3);
		            will(returnValue(4.55));
		            one(values).getValue(0, 4);
		            will(returnValue(-4.3));
		        }
		    });
			
		    double result =  DataUtilities.calculateRowTotal(values, 0);
		    assertEquals(result, -5.95, .000000001d);
		}
		
		@Test
		public void calculateRowTotalForAllPosValues() {
			mockingContext.checking(new Expectations() {
		        {
		            one(values).getColumnCount();
		            will(returnValue(5));
		            one(values).getValue(0, 0);
		            will(returnValue(1));
		            one(values).getValue(0, 1);
		            will(returnValue(2));
		            one(values).getValue(0, 2);
		            will(returnValue(4));
		            one(values).getValue(0, 3);
		            will(returnValue(4));
		            one(values).getValue(0, 4);
		            will(returnValue(2314123));
		        }
		    });
			
		    double result =  DataUtilities.calculateRowTotal(values, 0);
		    assertEquals(result, 2314134, .000000001d);
		}
		
		@Test
		public void calculateRowTotalForAllNegValues() {
			mockingContext.checking(new Expectations() {
		        {
		            one(values).getColumnCount();
		            will(returnValue(5));
		            one(values).getValue(0, 0);
		            will(returnValue(-1));
		            one(values).getValue(0, 1);
		            will(returnValue(-2));
		            one(values).getValue(0, 2);
		            will(returnValue(-4));
		            one(values).getValue(0, 3);
		            will(returnValue(-4));
		            one(values).getValue(0, 4);
		            will(returnValue(-2314123));
		        }
		    });
			

		    double result2 =  DataUtilities.calculateRowTotal(values, 0);
		    assertEquals(result2, -2314134, .000000001d);
		}
		
		@Test
		public void calculateRowTotalForNegColInput() {
			mockingContext.checking(new Expectations() {
		        {
		            one(values).getColumnCount();
		            will(returnValue(-5));
		            one(values).getValue(0, 0);
		            will(returnValue(-1));
		            one(values).getValue(0, 1);
		            will(returnValue(-2));
		            one(values).getValue(0, 2);
		            will(returnValue(-4));
		            one(values).getValue(0, 3);
		            will(returnValue(-4));
		            one(values).getValue(0, 4);
		            will(returnValue(-2314123));
		        }
		    });
			

		    double result =  DataUtilities.calculateRowTotal(values, 0);
		    assertEquals(result, 0, .000000001d);
		}
		
		@Test
		public void calculateRowTotalForAllZero() {
			mockingContext.checking(new Expectations() {
		        {
		            one(values).getColumnCount();
		            will(returnValue(2));
		            one(values).getValue(0, 0);
		            will(returnValue(0));
		            one(values).getValue(0, 1);
		            will(returnValue(0));

		        }
		    });
			
		    double result =  DataUtilities.calculateRowTotal(values, 0);
		    assertEquals(result, 0, .000000001d);
		}
		
		//Invalid Input
		@Test
		public void calculateRowTotalForEmpty() {
			mockingContext.checking(new Expectations() {
		        {
		            one(values).getColumnCount();
		            will(returnValue(0));
		        }
		    });
			 double result =  DataUtilities.calculateRowTotal(values, 0);
			 
			 assertEquals(result, 0.0, .000000001d);
		}
		
		//valid doulbe array
		@Test
		public void cloneTestWithValidArray() {
			double [][]src = {{2,2}};
			
			 double[][] result =  DataUtilities.clone(src);
			 
			 assertArrayEquals("Array did not copy correctly", src, result);
		}
		
		@Test
		public void cloneTestWithNaNArray() {
			double [][]src = {{Double.NaN}};
			
			 double[][]result =  DataUtilities.clone(src);
			 
			 assertArrayEquals("Array did not copy correctly", src, result);
		}
		
		@Test
		public void testCloneNullArray() {
			double[][] arr2 = new double[1][1];
			arr2[0] = null;

			assertTrue(java.util.Arrays.deepEquals(arr2, DataUtilities.clone(arr2)));
		}
		
		@Test
		public void testcalculateColumnTotalwithNullRow() {
			mockingContext.checking(new Expectations() {
		        {
		            one(values).getRowCount();
		            will(returnValue(2));
		            one(values).getValue(0, 0);
		            will(returnValue(-1.0));
		            one(values).getValue(1, 0);
		            will(returnValue(null));
		        }
		    });
			
		    double result =  DataUtilities.calculateColumnTotal(values, 0);
		    assertEquals(result, -1.0, .000000001d);
		} 
		
		@Test
		public void testcalculateColumnTotalInvlidMockNull() {
			mockingContext.checking(new Expectations() {
		        {
		        	 one(values).getRowCount();
			            will(returnValue(-1));
			            one(values).getValue(0, 0);
			            will(returnValue(null));
		        }
		    });
			
		    double result =  DataUtilities.calculateColumnTotal(values, 0);
		    assertEquals(result, 0, .000000001d);
		    
		}
		
		
//		@Test (expected = java.security.InvalidParameterException.class)
//		  public void createNumberArrayWithInvalidData() throws java.security.InvalidParameterException {
//		      DataUtilities.createNumberArray(null);
//		  }
		  
		  @Test
		  public void createNumberArrayWithEmptyData() {
			  double[] data = {};
		      Number[] actual = DataUtilities.createNumberArray(data);
		      Number[] expected = {};
		      assertArrayEquals("Number array from empty data should be empty", expected, actual);
		  }

		  
		  @Test
		  public void createNumberArrayWithNonEmptyData() {
			  double[] data = {1.1, 2.2, 3.3, 4.4, 5.5};
		      Number[] actual = DataUtilities.createNumberArray(data);
		      Number[] expected = {1.1, 2.2, 3.3, 4.4, 5.5};
		      assertArrayEquals(expected, actual);
		  }
		  
//		  @Test (expected = java.security.InvalidParameterException.class)
//		  public void createNumberArray2DWithInvalidData() throws java.security.InvalidParameterException {
//		      DataUtilities.createNumberArray2D(null);
//		  }
		  
		  @Test
		  public void createNumberArray2DWithEmptyData() {
			  double[] data = {};
		      Number[] actual = DataUtilities.createNumberArray(data);
		      Number[] expected = {};
		      assertArrayEquals("2D Number array from empty data should be empty",expected, actual);
		  }
		 
		  @Test
		  public void createNumberArray2DWithNonEmptyData() {
			  double[][] data = {
					  {1.1, 2.2, 3.3},
					  {4.4, 5.5, 6.6},
					  {7.7, 8.8, 9.9},
					  };
		      Number[][] actual = DataUtilities.createNumberArray2D(data);
		      Number[][] expected = {
					  {1.1, 2.2, 3.3},
					  {4.4, 5.5, 6.6},
					  {7.7, 8.8, 9.9},
					  };
		      assertArrayEquals("Valid double[][] data should be converted to Number[][]",expected, actual);
		  }
		  
//		  @Test (expected = java.security.InvalidParameterException.class)
//		  public void getCumulativePercentagesForInvalidData() throws java.security.InvalidParameterException {
//		      DataUtilities.getCumulativePercentages(null);
//		  }
		  
			@Test
			public void getCumulativePercentagesForEmptyData() {
			    Mockery mockingContext = new Mockery();
			    final KeyedValues values = mockingContext.mock(KeyedValues.class);
			    mockingContext.checking(new Expectations() {{
		            atLeast(1).of(values).getItemCount();
		            will(returnValue(0));
			    }});
			    
			    // exercise
			    KeyedValues result = DataUtilities.getCumulativePercentages(values);
			    
			    // verify
			    assertEquals("Empty KeyedValues should produce empty cumulative percentages", 0, result.getItemCount());
			}
		  
			
			@Test
			public void getCumulativePercentagesForNonEmptyData() {
			    Mockery mockingContext = new Mockery();
			    final KeyedValues values = mockingContext.mock(KeyedValues.class);
			    mockingContext.checking(new Expectations() {
			        {
		              atLeast(1).of(values).getItemCount();
		              will(returnValue(3));
		              
		              atLeast(1).of(values).getKey(0);
		              will(returnValue(0));
		              atLeast(1).of(values).getValue(0);
		              will(returnValue(5));
		              
		              atLeast(1).of(values).getKey(1);
		              will(returnValue(1));
		              atLeast(1).of(values).getValue(1);
		              will(returnValue(9));
		              
		              atLeast(1).of(values).getKey(2);
		              will(returnValue(2));
		              atLeast(1).of(values).getValue(2);
		              will(returnValue(2));
			        }
			    });
			    
			    // exercise
			    KeyedValues result = DataUtilities.getCumulativePercentages(values);
			    
			    // verify
			    assertEquals("Input with 3 values should return result with 3 values", 3, result.getItemCount());
			    assertEquals("Input with values [0: 5, 1: 9, 2: 2],  should return result with 0: 0.3125", 0.3125, result.getValue(0));
			    assertEquals("Input with values [0: 5, 1: 9, 2: 2],  should return result with 1: 0.875",0.875, result.getValue(1));
			    assertEquals("Input with values [0: 5, 1: 9, 2: 2],  should return result with 2: 1.0", 1.0, result.getValue(2));
			}
			
//			@Test
//			public void getCumulativePercentagesForNullIndex() {
//			    Mockery mockingContext = new Mockery();
//			    final KeyedValues values = mockingContext.mock(KeyedValues.class);
//			    mockingContext.checking(new Expectations() {
//			        {
//		              atLeast(1).of(values).getItemCount();
//		              will(returnValue(3));
//		              
//		              atLeast(1).of(values).getKey(0);
//		              will(returnValue(0));
//		              atLeast(1).of(values).getValue(0);
//		              will(returnValue(null));
//		              
//		              atLeast(1).of(values).getKey(1);
//		              will(returnValue(1));
//		              atLeast(1).of(values).getValue(1);
//		              will(returnValue(9));
//		              
//		              atLeast(1).of(values).getKey(2);
//		              will(returnValue(2));
//		              atLeast(1).of(values).getValue(2);
//		              will(returnValue(2));
//			        }
//			    });
//			    
//			    // exercise
//			    KeyedValues result = DataUtilities.getCumulativePercentages(values);
//			    
//			    // verify
//			    assertEquals("Input with 3 values should return result with 3 values", 3, result.getItemCount());
//			    assertEquals("Input with values [0: null, 1: 9, 2: 2],  should return result with 0: 0.0", 0.0, result.getValue(0));
//			    assertEquals("Input with values [0: null, 1: 9, 2: 2],  should return result with 1: 0.818",0.818, result.getValue(1));
//			    assertEquals("Input with values [0: null, 1: 9, 2: 2],  should return result with 2: 0.181", 0.181, result.getValue(2));
//			}

			@Test
			public void testEqualWithNullAAndNonNullB() {
				double[][] b = {{1.1, 2.2, 3.3}};
				boolean actual = DataUtilities.equal(null, b);
				boolean expected = false;
				assertEquals("Null A and non-null B", expected, actual);
			}
			
			@Test
			public void testEqualWithNullAAndNullB() {
				boolean actual = DataUtilities.equal(null, null);
				boolean expected = true;
				assertEquals("Null A and null B", expected, actual);
			}
			
			@Test
			public void testEqualWithNonNullAAndNullB() {
				double[][] a = {{1.1, 2.2, 3.3}};
				boolean actual = DataUtilities.equal(a, null);
				boolean expected = false;
				assertEquals("Non-null A and null B", expected, actual);
			}
			
			@Test
			public void testEqualWithDifferentLengths() {
				double[][] a = {{1.1}};
				double[][] b = {{1.1}, {2.2, 3.3}};
				boolean actual = DataUtilities.equal(a, b);
				boolean expected = false;
				assertEquals("A and B of different lengths", expected, actual);
			}
			
			@Test
			public void testEqualWithPartiallySimilarAAndB() {
				double[][] a = {{1.1}, {2.2}};
				double[][] b = {{1.1}, {3.3, 4.4}};
				boolean actual = DataUtilities.equal(a, b);
				boolean actual2 = DataUtilities.equal(b, a);
				boolean expected = false;
				assertEquals("A and B, similar for first few values", expected, actual);
				assertEquals("A and B, similar for first few values", expected, actual2);
			}
			
			@Test
			public void testEqualWithEqualAAndB() {
				double[][] a = {{1.1}, {3.3}};
				double[][] b = {{1.1}, {3.3}};
				boolean actual = DataUtilities.equal(a, b);
				boolean expected = true;
				assertEquals("Identical A and B", expected, actual);
			}
			
			@Test
			public void testSmaller() {
				double[][] a = {{1}, {3.3}};
				double[][] b = {{1.1}, {3.3}};
				boolean actual = DataUtilities.equal(a, b);
				boolean expected = false;
				assertEquals("Not Identical A and B", expected, actual);
			}
}