import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;

class unitTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	/**
	 * test method: AccountingSystem.Arr()
	 * test data: tokens
	 */
	@Test
	void test_Arr_0() {
		String[] tokens= {"15317546","20210301","150"};
		int i=0;
		String[] person = new String[51];
		String[] date = new String[51];
		long[] money = new long[51];
		AccountingSystem.Arr(tokens, person, date, money, i);
		
		assertEquals("15317546",person[i]);
		assertEquals("20210301",date[i]);
		assertEquals(150, money[i]);
	}
	
	/**
	 * test method: AccountingSystem.Arr()
	 * test data: tokens
	 */
	@Test
	void test_Arr_1() {
		String[] tokens= {"18501179","20200422","399"};
		int i=1;
		String[] person = new String[51];
		String[] date = new String[51];
		long[] money = new long[51];
		AccountingSystem.Arr(tokens, person, date, money, i);
		
		assertEquals("18501179",person[i]);
		assertEquals("20200422",date[i]);
		assertEquals(399, money[i]);
	}
	
	/**
	 * test function: AccountingSystem.input()
	 * test data: Scanner
	 */
	@Test
	void test_Input_0() {
		String[] person = new String[51];
		String[] date = new String[51];
		long[] money = new long[51];
		String keyIn = "Q";
		ByteArrayInputStream testIn = new ByteArrayInputStream(keyIn.getBytes());
		System.setIn(testIn);
		boolean flag;
		int i = 1; //18501179 20200422 399
		person[i] = "18501179";
		date[i] = "20200422";
		money[i] = 399;
		flag = AccountingSystem.input(person, date, money);
		assertFalse(flag);
	}
	
	/**
	 * test function: AccountingSystem.input()
	 * test data: Scanner
	 */
	@Test
	void test_Input_1() {
		String[] person = new String[51];
		String[] date = new String[51];
		long[] money = new long[51];
		String keyIn = "15317546";  //15317546 20210301 150
		String keyIn2 = "Q";
		ByteArrayInputStream testIn = new ByteArrayInputStream(keyIn.getBytes());
		ByteArrayInputStream testIn2 = new ByteArrayInputStream(keyIn2.getBytes());
		System.setIn(testIn);
		System.setIn(testIn2);
		boolean flag;
		int i = 0;
		person[i] = "15317546";
		date[i] = "20210301";
		money[i] = 150;
		flag = AccountingSystem.input(person, date, money);
		assertFalse(flag);
	}
	
	/**
	 * test function: AccountingSystem.checkID()
	 * test data: userID
	 */
	@Test
	void test_CheckID_0() {
		String[] person = new String[51];
		String[] date = new String[51];
		long[] money = new long[51];
		String keyIn = "Q";
		ByteArrayInputStream testIn = new ByteArrayInputStream(keyIn.getBytes());
		System.setIn(testIn);
		String userID = "15317546"; //15317546 20210301 150
		int i = 0;
		boolean flag;
		person[i] = "15317546";
		date[i] = "20210301";
		money[i] = 150;
		flag = AccountingSystem.checkID(person, date, money, userID);
		assertTrue(flag);		
	}
	/**
	 * test function: gradeSystem.checkID()
	 * test data: userID
	 */
	
	@Test
	void test_CheckID_1() {
		String[] person = new String[51];
		String[] date = new String[51];
		long[] money = new long[51];
		String userID = "18501000";  //18501179 20200422 399
		int i = 1;
		boolean flag;
		person[i] = "18501179";
		date[i] = "20200422";
		money[i] = 399;
		flag = AccountingSystem.checkID(person, date, money, userID);
		assertFalse(flag);		
	}
	
	/**
	  * test method: AccountingSystem.showExpense()
	  * test account: 17111563
	  */ 
	 @Test
	 void test_showExpense_0(){
	  int t = 10;
	  int[] index = {2, 7, 14, 17, 21, 26, 31, 34, 41, 45};
	  long[] money = {150, 399, 87, 1674, 10, 85, 239, 215, 1000, 33,
			  81000, 130, 999, 229, 1000000, 1, 1399, 123, 889, 50, 3000, 449,
			  4999, 1212, 10000, 357, 20, 180, 1024, 157, 36, 999, 4000, 1001,
			  102, 1111111111, 166, 128000000, 4096, 800, 650, 875, 383, 49,
			  22000, 125, 1500, 830000, 27, 3650};
	  long total = AccountingSystem.showExpense(money, index, t);
	  assertEquals(1002995,total);
	 }
	 
	 /**
	  * test method: AccountingSystem.showExpense()
	  * test account: 13501324
	  */ 
	 @Test
	 void test_showExpense_1(){
	  int t = 5;
	  int[] index = {4, 10, 19, 43, 47};
	  long[] money = {150, 399, 87, 1674, 10, 85, 239, 215, 1000, 33,
			  81000, 130, 999, 229, 1000000, 1, 1399, 123, 889, 50, 3000, 449,
			  4999, 1212, 10000, 357, 20, 180, 1024, 157, 36, 999, 4000, 1001,
			  102, 1111111111, 166, 128000000, 4096, 800, 650, 875, 383, 49,
			  22000, 125, 1500, 830000, 27, 3650};
	  long total = AccountingSystem.showExpense(money, index, t);
	  assertEquals(911109,total);
	 }
	 
	 /**
	  * test method: AccountingSystem.showTransaction()
	  * test account: 10000001
	  */ 
	 @Test
	 void test_showTransaction_0(){
	  int t = 5;
	  int index[] = {6, 15, 28, 32, 44};
	  String[] transaction = {"19961001 239", "19980228 1", "20000123 1024", "20040229 4000", "19980228 22000"};
	  String[] date = {"20210301", "20200422", "20210124", "20181225", "20191111",
			  "20200713", "19961001", "20210102", "20181225", "20200618", "20191111",
			  "20200713", "30000101", "20200229", "20211002", "19980228", "20200714",
			  "20210102", "20201225", "20191121", "20200422", "20210123", "20180925",
			  "20121212", "20191105", "20201120", "20210101", "20181223", "20000123",
			  "20191101", "20200422", "20210130", "20040229", "20181201", "20211102",
			  "11111111", "20191114", "20200421", "20191231", "20191121", "20200404",
			  "20210104", "20181125", "20191101", "19980228", "20210124", "20200928",
			  "20191003", "20200712", "20200303"};
	  long[] money = {150, 399, 87, 1674, 10, 85, 239, 215, 1000, 33,
			  81000, 130, 999, 229, 1000000, 1, 1399, 123, 889, 50, 3000, 449,
			  4999, 1212, 10000, 357, 20, 180, 1024, 157, 36, 999, 4000, 1001,
			  102, 1111111111, 166, 128000000, 4096, 800, 650, 875, 383, 49,
			  22000, 125, 1500, 830000, 27, 3650};
	  String[] test = new String[t+1];
	  
	  test = AccountingSystem.showTransaction(date, money, index, t);
	  for(int i = 0; i < t; i++) {
		  assertEquals(transaction[i],test[i]);
	   }
	 }
	 
	 /**
	  * test method: AccountingSystem.showTransaction()
	  * test account: 11254730
	  */ 
	 @Test
	 void test_showTransaction_1(){
	  int t = 4;
	  int index[] = {5, 11, 16, 48};
	  String[] transaction = {"20200713 85", "20200713 130", "20200714 1399", "20200712 27"};
	  String[] date = {"20210301", "20200422", "20210124", "20181225", "20191111",
			  "20200713", "19961001", "20210102", "20181225", "20200618", "20191111",
			  "20200713", "30000101", "20200229", "20211002", "19980228", "20200714",
			  "20210102", "20201225", "20191121", "20200422", "20210123", "20180925",
			  "20121212", "20191105", "20201120", "20210101", "20181223", "20000123",
			  "20191101", "20200422", "20210130", "20040229", "20181201", "20211102",
			  "11111111", "20191114", "20200421", "20191231", "20191121", "20200404",
			  "20210104", "20181125", "20191101", "19980228", "20210124", "20200928",
			  "20191003", "20200712", "20200303"};
	  long[] money = {150, 399, 87, 1674, 10, 85, 239, 215, 1000, 33,
			  81000, 130, 999, 229, 1000000, 1, 1399, 123, 889, 50, 3000, 449,
			  4999, 1212, 10000, 357, 20, 180, 1024, 157, 36, 999, 4000, 1001,
			  102, 1111111111, 166, 128000000, 4096, 800, 650, 875, 383, 49,
			  22000, 125, 1500, 830000, 27, 3650};
	  String[] test = new String[t+1];
	  
	  test = AccountingSystem.showTransaction(date, money, index, t);
	  for(int i = 0; i < t; i++) {
		  assertEquals(transaction[i],test[i]);
	   }
	 }
	
	 /**
	  * test method: AccountingSystem.showSpecExp()
	  * test account: 18501179
	  */ 
	 @Test
	 void test_showSpecExp_0(){
	  int t = 9;
	  int index[] = {1, 13, 20, 25, 27, 30, 37, 38, 40};
	  String[] date = {"20210301", "20200422", "20210124", "20181225", "20191111",
			  "20200713", "19961001", "20210102", "20181225", "20200618", "20191111",
			  "20200713", "30000101", "20200229", "20211002", "19980228", "20200714",
			  "20210102", "20201225", "20191121", "20200422", "20210123", "20180925",
			  "20121212", "20191105", "20201120", "20210101", "20181223", "20000123",
			  "20191101", "20200422", "20210130", "20040229", "20181201", "20211102",
			  "11111111", "20191114", "20200421", "20191231", "20191121", "20200404",
			  "20210104", "20181125", "20191101", "19980228", "20210124", "20200928",
			  "20191003", "20200712", "20200303"};
	  long[] money = {150, 399, 87, 1674, 10, 85, 239, 215, 1000, 33,
			  81000, 130, 999, 229, 1000000, 1, 1399, 123, 889, 50, 3000, 449,
			  4999, 1212, 10000, 357, 20, 180, 1024, 157, 36, 999, 4000, 1001,
			  102, 1111111111, 166, 128000000, 4096, 800, 650, 875, 383, 49,
			  22000, 125, 1500, 830000, 27, 3650};
	  String KeyIn = "20200422";
	  ByteArrayInputStream testIn = new ByteArrayInputStream(KeyIn.getBytes());
	  System.setIn(testIn);
	  long ans = AccountingSystem.showSpecExp(date, money, index, t);
	  assertEquals(3435, ans);
	 }
	 
	 /**
	  * test method: AccountingSystem.showSpecExp()
	  * test account: 13501324
	  */ 
	 @Test
	 void test_showSpecExp_1(){
	  int t = 5;
	  int index[] = {4, 10, 19, 43, 47};
	  String[] date = {"20210301", "20200422", "20210124", "20181225", "20191111",
			  "20200713", "19961001", "20210102", "20181225", "20200618", "20191111",
			  "20200713", "30000101", "20200229", "20211002", "19980228", "20200714",
			  "20210102", "20201225", "20191121", "20200422", "20210123", "20180925",
			  "20121212", "20191105", "20201120", "20210101", "20181223", "20000123",
			  "20191101", "20200422", "20210130", "20040229", "20181201", "20211102",
			  "11111111", "20191114", "20200421", "20191231", "20191121", "20200404",
			  "20210104", "20181125", "20191101", "19980228", "20210124", "20200928",
			  "20191003", "20200712", "20200303"};
	  long[] money = {150, 399, 87, 1674, 10, 85, 239, 215, 1000, 33,
			  81000, 130, 999, 229, 1000000, 1, 1399, 123, 889, 50, 3000, 449,
			  4999, 1212, 10000, 357, 20, 180, 1024, 157, 36, 999, 4000, 1001,
			  102, 1111111111, 166, 128000000, 4096, 800, 650, 875, 383, 49,
			  22000, 125, 1500, 830000, 27, 3650};
	  String KeyIn = "20191111";
	  ByteArrayInputStream testIn = new ByteArrayInputStream(KeyIn.getBytes());
	  System.setIn(testIn);
	  long ans = AccountingSystem.showSpecExp(date, money, index, t);
	  assertEquals(81010, ans);
	 }
	 
	 /**
	  * test method: AccountingSystem.showAvg()
	  * test account: 10000001
	  */ 
	 @Test
	 void test_showAvg_0(){
	  int t = 5;
	  int index[] = {6, 15, 28, 32, 44};
	  String[] date = {"20210301", "20200422", "20210124", "20181225", "20191111",
	    "20200713", "19961001", "20210102", "20181225", "20200618", "20191111",
	    "20200713", "30000101", "20200229", "20211002", "19980228", "20200714",
	    "20210102", "20201225", "20191121", "20200422", "20210123", "20180925",
	    "20121212", "20191105", "20201120", "20210101", "20181223", "20000123",
	    "20191101", "20200422", "20210130", "20040229", "20181201", "20211102",
	    "11111111", "20191114", "20200421", "20191231", "20191121", "20200404",
	    "20210104", "20181125", "20191101", "19980228", "20210124", "20200928",
	    "20191003", "20200712", "20200303"};
	  long[] money = {150, 399, 87, 1674, 10, 85, 239, 215, 1000, 33,
	    81000, 130, 999, 229, 1000000, 1, 1399, 123, 889, 50, 3000, 449,
	    4999, 1212, 10000, 357, 20, 180, 1024, 157, 36, 999, 4000, 1001,
	    102, 1111111111, 166, 128000000, 4096, 800, 650, 875, 383, 49,
	    22000, 125, 1500, 830000, 27, 3650};
	  String KeyIn = "199610";
	  ByteArrayInputStream testIn = new ByteArrayInputStream(KeyIn.getBytes());
	  System.setIn(testIn);
	  long ans = AccountingSystem.showAvg(date, money, index, t);
	  assertEquals(239/31, ans);
	 }
	 
	 /**
	  * test method: AccountingSystem.showAvg()
	  * test account: 10000001
	  */ 
	 @Test
	 void test_showAvg_1(){
	  int t = 5;
	  int index[] = {6, 15, 28, 32, 44};
	  String[] date = {"20210301", "20200422", "20210124", "20181225", "20191111",
	    "20200713", "19961001", "20210102", "20181225", "20200618", "20191111",
	    "20200713", "30000101", "20200229", "20211002", "19980228", "20200714",
	    "20210102", "20201225", "20191121", "20200422", "20210123", "20180925",
	    "20121212", "20191105", "20201120", "20210101", "20181223", "20000123",
	    "20191101", "20200422", "20210130", "20040229", "20181201", "20211102",
	    "11111111", "20191114", "20200421", "20191231", "20191121", "20200404",
	    "20210104", "20181125", "20191101", "19980228", "20210124", "20200928",
	    "20191003", "20200712", "20200303"};
	  long[] money = {150, 399, 87, 1674, 10, 85, 239, 215, 1000, 33,
	    81000, 130, 999, 229, 1000000, 1, 1399, 123, 889, 50, 3000, 449,
	    4999, 1212, 10000, 357, 20, 180, 1024, 157, 36, 999, 4000, 1001,
	    102, 1111111111, 166, 128000000, 4096, 800, 650, 875, 383, 49,
	    22000, 125, 1500, 830000, 27, 3650};
	  String KeyIn = "199802";
	  ByteArrayInputStream testIn = new ByteArrayInputStream(KeyIn.getBytes());
	  System.setIn(testIn);
	  long ans = AccountingSystem.showAvg(date, money, index, t);
	  assertEquals(22001/28, ans);
	 }
}
