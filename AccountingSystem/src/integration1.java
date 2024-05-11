/*
輸入 ID 或 Q(結束使用)?
10000001
Welcome 10000001
輸入指令:
1) A 顯示總支出
2) B 顯示全部消費紀錄
3) C 顯示特定日期消費金額
4) D 顯示特定月份日平均消費金額
5) Q 離開系統
A
總支出共27264元
輸入指令:
1) A 顯示總支出
2) B 顯示全部消費紀錄
3) C 顯示特定日期消費金額
4) D 顯示特定月份日平均消費金額
5) Q 離開系統
B
消費日期   消費金額
19961001  239
19980228  1
20000123  1024
20040229  4000
19980228  22000
輸入指令:
1) A 顯示總支出
2) B 顯示全部消費紀錄
3) C 顯示特定日期消費金額
4) D 顯示特定月份日平均消費金額
5) Q 離開系統
C
請輸入欲查詢日期（YYYYMMDD）：
19980228
您在19980228的消費金額為22001元
輸入指令:
1) A 顯示總支出
2) B 顯示全部消費紀錄
3) C 顯示特定日期消費金額
4) D 顯示特定月份日平均消費金額
5) Q 離開系統
D
請輸入欲查詢月份（YYYYMM）：
199802
您在199802的日平均消費金額為785元
輸入指令:
1) A 顯示總支出
2) B 顯示全部消費紀錄
3) C 顯示特定日期消費金額
4) D 顯示特定月份日平均消費金額
5) Q 離開系統
Q
離開用戶
輸入 ID 或 Q(結束使用)?
Q
結束使用
*/

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;

class integration1 {

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
	void test_Arr() {
		String[] tokens= {"10000001","19961001","239"};
		int i=0;
		String[] person = new String[51];
		String[] date = new String[51];
		long[] money = new long[51];
		AccountingSystem.Arr(tokens, person, date, money, i);
		
		assertEquals("10000001",person[i]);
		assertEquals("19961001",date[i]);
		assertEquals(239, money[i]);
	}
	
	/**
	 * test function: AccountingSystem.input()
	 * test data: Scanner
	 */
	@Test
	void test_Input() {
		String[] person = new String[51];
		String[] date = new String[51];
		long[] money = new long[51];
		String keyIn = "Q";
		ByteArrayInputStream testIn = new ByteArrayInputStream(keyIn.getBytes());
		System.setIn(testIn);
		boolean flag;
		int i = 1; //10000001 19961001 239
		person[i] = "10000001";
		date[i] = "19961001";
		money[i] = 239;
		flag = AccountingSystem.input(person, date, money);
		assertFalse(flag);
	}
	
	/**
	 * test function: AccountingSystem.checkID()
	 * test data: userID
	 */
	@Test
	void test_CheckID() {
		String[] person = new String[51];
		String[] date = new String[51];
		long[] money = new long[51];
		String keyIn = "Q";
		ByteArrayInputStream testIn = new ByteArrayInputStream(keyIn.getBytes());
		System.setIn(testIn);
		String userID = "10000001"; //10000001 19961001 239
		int i = 0;
		boolean flag;
		person[i] = "10000001";
		date[i] = "19961001";
		money[i] = 239;
		flag = AccountingSystem.checkID(person, date, money, userID);
		assertTrue(flag);		
	}
	
	/**
	  * test method: AccountingSystem.showExpense()
	  * test account: 10000001
	  */ 
	 @Test
	 void test_showExpense(){
	  int t = 5;
	  int index[] = {6, 15, 28, 32, 44};
	  long[] money = {150, 399, 87, 1674, 10, 85, 239, 215, 1000, 33,
			  81000, 130, 999, 229, 1000000, 1, 1399, 123, 889, 50, 3000, 449,
			  4999, 1212, 10000, 357, 20, 180, 1024, 157, 36, 999, 4000, 1001,
			  102, 1111111111, 166, 128000000, 4096, 800, 650, 875, 383, 49,
			  22000, 125, 1500, 830000, 27, 3650};
	  long total = AccountingSystem.showExpense(money, index, t);
	  assertEquals(27264,total);
	 }
	 
	 /**
	  * test method: AccountingSystem.showTransaction()
	  * test account: 10000001
	  */ 
	 @Test
	 void test_showTransaction(){
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
	  * test method: AccountingSystem.showSpecExp()
	  * test account: 10000001
	  */ 
	 @Test
	 void test_showSpecExp(){
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
	  String KeyIn = "19980228";
	  ByteArrayInputStream testIn = new ByteArrayInputStream(KeyIn.getBytes());
	  System.setIn(testIn);
	  long ans = AccountingSystem.showSpecExp(date, money, index, t);
	  assertEquals(22001, ans);
	 }
	 
	 /**
	  * test method: AccountingSystem.showAvg()
	  * test account: 10000001
	  */ 
	 @Test
	 void test_showAvg(){
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