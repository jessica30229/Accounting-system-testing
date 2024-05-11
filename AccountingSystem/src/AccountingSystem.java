import java.io.File;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.text.DecimalFormat;


public class AccountingSystem {
	/**
	Read input file.
	@param args.
	Time estimate: O(n)
	*/
	public static void main(String[] args) {
		String[] person = new String[51];
		String[] date = new String[51];
		long[] money = new long[51];
	    try {
	      File filename = new File("src/input.txt");
	      //File filename = new File("/Users/allen/Documents/大學課業/軟工/SE_HW2_<107070039>_ <107070008>/AccountingSystem/bin/input.txt");
	      Scanner myReader = new Scanner(filename);
	      int i = 0;
	      while (myReader.hasNextLine()) {
	        String str = myReader.nextLine();
	        String[] data = str.split("\t");       
	        Arr(data, person, date, money, i);
	        i++;
	      }
	      myReader.close();
	      input(person, date, money);
	    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
	    }
	  }
	/**
	Store input data to array.
	@param tokens one line of input text file.
	@param person an array which store all user ID by order.
	@param date an array which store all consumption dates by order.
    @param money an array which store all expenses by order.
	@param j the index of array.
	@return void.
	Example: 
	Arr(data, person, date, money, i).
	Time estimate: 
	determined by the number of subjects
	time complexity = O(n)
	*/
	public static void Arr(String[] tokens, String[] person, String[] date, long[] money, int j) {
		int i=0;
		for(String token:tokens) {
			if(i == 0) person[j] = token;
			else if(i == 1) date[j] = token;
			else if(i == 2) money[j] = Integer.valueOf(token).intValue();
			i++;
		}
	}
	/**
	Input command (user ID or "Q").
	@param person an array which store all user ID by order.
	@param date an array which store all consumption dates by order.
    @param money an array which store all expenses by order.
	@return false if input command ("Q"), true otherwise.
	Example: 
	input(person, date, money); return true or false.
	Time estimate: O(1)
	*/
	public static boolean input(String[] person, String[] date, long[] money) {
		while(true) {
			System.out.println("輸入 ID 或 Q(結束使用)?");
			Scanner myID = new Scanner(System.in); 
			String userID = myID.nextLine();
			if(userID.equals("Q")) {
				System.out.println("結束使用");
				return false;
			}
			else {
				checkID(person, date, money, userID);
			}
		}
	}
	/**
	Check if input user ID in person array and store the correspondence index.
	@param person an array which store all user ID by order.
	@param date an array which store all consumption dates by order.
    @param money an array which store all expenses by order.
    @param userID a string to store input command (user ID).
	@return true if ID exists, false otherwise.
	Example: 
	checkID(15317546, date, money, userID); return true.
	Time estimate:
	determined by the number of subjects
	time complexity = O(n)
	*/
	public static boolean checkID(String[] person, String[] date, long[] money, String userID){
		boolean find = false;
		int[] index = new int[51];
		int t=0;
		for(int i = 0; i < 50; i++) {
			if(userID.equals(person[i])) {
				find = true;
				index[t]=i;
				t++;
			}
		}
		if(find) {
			System.out.println("Welcome "+ person[index[0]]);
			list(date, money, index, t);
			return true;
		}
		System.out.println("查無此 ID!");
		return false;

	}
	/**
	Get the instruction from user input and call correspondence function.
	@param date an array which store all consumption dates by order.
    @param money an array which store all expenses by order.
	@param index the index of the correspondence userID in the money and date array.
    @param t the number of consumption records of the designated userID.
	@return false if if input command ("Q"), true otherwise.
	Example: 
	list(date, money, index, t); return true or false.
	Time estimate: O(1)
	*/
	private static boolean list(String[] date, long[] money, int[] index, int t) {
		while(true) {
			System.out.print("輸入指令：\n"
					+ "1) A 顯示總支出\n"
					+ "2) B 顯示全部消費紀錄\n"
					+ "3) C 顯示特定日期消費金額\n"
					+ "4) D 顯示特定月份日平均消費金額\n"
					+ "5) Q 離開系統\n"
					);
		    Scanner l = new Scanner(System.in);
		    String mylist = l.nextLine();
		    if(mylist.equals("Q"))
		    	break;
		    else if(mylist.equals("A")) {
		    	showExpense(money,index, t);
		    }
		    else if(mylist.equals("B")) 
		    	showTransaction(date, money, index, t);
		    else if(mylist.equals("C")) 
		    	showSpecExp(date, money, index, t);
		    else if(mylist.equals("D"))
		    	showAvg(date, money, index, t);
		    else
		    	System.out.println("指令錯了!");
		}
		System.out.print("離開用戶\n");
		return false;
	}
	/**
	 * Show the total expenses of the designated userID.
	 * @param money an array which store all expenses by order.
	 * @param index the index of the correspondence userID in the money and date array.
	 * @param t the number of consumption records of the designated userID.
	 * @return long total expense of userID.
	 * Example: 
	 * showExpense(money, index, t); return the total expenses of the designated userID.
	 * Time estimate: 
	 * the time complexity determined by the number of consumption records of the designated userID.
	 * for(int i=0 ; i < t ; i++) { ------> O(n)
	 * 	total = total + money[index[i]];
	 * }
	 * time complexity = O(n)  n: # of t
	 */
	public static long showExpense(long[] money, int index[], int t) {
		long total = 0;
		for(int i=0 ; i < t ; i++) {
			total = total + money[index[i]];
		}
		System.out.println("總支出： " + total);
		return total;
	}		
	/**
	 * Show all transactions of the designated userID.
	 * @param date an array which store all consumption dates by order.
	 * @param money an array which store all expenses by order.
	 * @param index the index of the correspondence userID in the money and date array.
	 * @param t the number of consumption records of the designated userID.
	 * @return String[] ans. (an array which store all transactions of the designated userID.)
	 * Example: 
	 * showTransaction(date, money, index, t); return all transactions of the designated userID.
	 * Time estimate: 
	 * the time complexity determined by the number of consumption records of the designated userID.
	 * for(int i=0 ; i < t ; i++) { ------> O(n)
	 *  System.out.println(date[index[i]] + " " + money[index[i]]);
	 * 	String money_str = Long.toString(money[index[i]]);
	 * 	ans[i] = date[index[i]] + " " + money_str;
	 * }
	 * time complexity = O(n)  n: # of t
	 */
	public static String[] showTransaction(String[] date, long[] money, int index[], int t) {
		  String[] ans = new String[t];
		  for(int i=0 ; i < t ; i++) {
		   System.out.println(date[index[i]] + " " + money[index[i]]);
		   String money_str = Long.toString(money[index[i]]);
		   ans[i] = date[index[i]] + " " + money_str;
		  }
		  return ans;
	 }
	/**
	 * Show the expenses on a specific day of the designated userID.
	 * @param date an array which store all consumption dates by order.
	 * @param money an array which store all expenses by order.
	 * @param index the index of the correspondence userID in the money and date array.
	 * @param t the number of consumption records of the designated userID.
	 * @return long total expense of userID on specific day.
	 * Example: 
	 * showSpecExp(date, money, index, t); return total expense of userID on specific day.
	 * Time estimate: 
	 * the time complexity determined by the number of consumption records of the designated userID.
	 * for(int i=0 ; i < t ; i++) { ------> O(n)
	 * 	if(date[index[i]].equals(specdate)) {
	 * 	 total += money[index[i]];
	 * 	}
	 * }
	 * time complexity = O(n) n: # of t
	 */
	public static long showSpecExp(String[] date, long[] money, int index[], int t) {
		System.out.println("請輸入欲查詢日期(格式舉例：20200404)：");
		Scanner inputdate = new Scanner(System.in);
	    String specdate = inputdate.next();
    	long total = 0;
		for(int i=0 ; i < t ; i++) {
			if(date[index[i]].equals(specdate)) {
				total += money[index[i]];
			}
		}
		System.out.println("總消費金額： " + total);
		return total;
	}
	/**
	 * Show the daily average expenses on a specific month of the designated userID.
	 * @param date an array which store all consumption dates by order.
	 * @param money an array which store all expenses by order.
	 * @param index the index of the correspondence userID in the money and date array.
	 * @param t the number of consumption records of the designated userID.
	 * @return long total average expense of userID on specific month.
	 * Example: 
	 * showAvg(date, money, index, t); return the daily average expenses on a specific month of the designated userID.
	 * Time Complexity:
	 * the time compleity determined by the number of consumption records of the designated userID and the length of thirtyList;
	 * for(int i=0 ; i < t ; i++) { ------>  O(n)
	 * 	if(date[index[i]].substring(0,6).equals(spec))
	 * 	sum += money[index[i]];
	 * }
	 * for (int i : thirtydays){ ------>  O(m)
	 * thirtyList.add(i);
	 * }
	 * time complexity = O(n) + O(m)
	 */
	public static long showAvg(String[] date, long[] money, int index[], int t) {
		System.out.println("請輸入欲查詢月份(格式舉例：202005)：");
		Scanner input = new Scanner(System.in);
		String spec = input.nextLine();
		long sum = 0;
		long avg = 0;
		for(int i=0 ; i < t ; i++) {
			if(date[index[i]].substring(0,6).equals(spec))
				sum += money[index[i]];
		}
		int[] thirtydays = {4, 6, 9, 11};
		List<Integer> thirtyList = new ArrayList<Integer>(thirtydays.length);
		for (int i : thirtydays){
			thirtyList.add(i);
		}
		int intmonth = Integer.parseInt(spec.substring(4));
		if(intmonth == 2) {
			int intyear = Integer.parseInt(spec.substring(0,4));
			if(intyear%4 == 0 && intyear%100 != 0) avg = sum/29;
			else if(intyear%400 == 0) avg = sum/29;
			else avg = sum/28;
		} else if(thirtyList.contains(intmonth)) avg = sum/30;
		else avg = sum/31;
		//avg = Double.parseDouble(df.format(avg));
		System.out.println("日平均消費金額： " + avg);
		return avg;
	}
}

