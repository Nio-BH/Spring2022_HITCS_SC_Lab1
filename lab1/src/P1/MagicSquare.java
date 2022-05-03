package P1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MagicSquare {
	public static boolean isLegalMagicSquare(String fileName) {
		ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
		int n=0;
		FileReader fr;
		try {
			fr= new FileReader(fileName);
			String str;
			String[] mystr;
			int count1=0;
			if(fr!=null)try (BufferedReader bf=new BufferedReader(fr)){
				while ((str = bf.readLine()) != null) {
					mystr=str.split("\t");
					ArrayList<Integer> row =new ArrayList<>();
					if(n==0) {
						n=mystr.length;
					}
					if(n!=mystr.length) {
						System.out.println("Wrong form!Size not right!");
						return false;
					}
					for(int i=0;i<mystr.length;i++) {
						row.add(Integer.valueOf(mystr[i])) ;
					}
					count1++;
					if(count1>n) {
						System.out.println("Wrong form!Size not right!");
						return false;
					}
					arrayList.add(row);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println("Wrong form!split not legal!");
				return false;
			}catch(NumberFormatException e) {
				System.out.println("wrong form!Input illegal!");
				return false;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("wrong form!File not found!");
			return false;
		}
		
		int constant=0;
		int i,j,sum=0;
		for( i=0;i<n;i++) {
			for( j=0;j<n;j++) {
				System.out.print(arrayList.get(i).get(j)+"\t");
			}
			System.out.println();
		}
		for( i=0;i<n;i++,sum=0) {
			for( j=0;j<n;j++) {
				sum+=arrayList.get(i).get(j);
			}
			if(constant==0) {
				constant=sum;
			}
			else {
				if(sum!=constant) {
					return false;
				}
			}
		}
		for( j=0;j<n;j++,sum=0) {
			for( i=0;i<n;i++) {
				sum+=arrayList.get(i).get(j);
			}
			if(constant==0) {
				constant=sum;
			}
			else {
				if(sum!=constant) {
					return false;
				}
			}
		}
		
		for(i=0,j=0,sum=0;i<n;i++,j++) {
			sum+=arrayList.get(i).get(j);
		}
		if(sum!=constant) {
			return false;
		}
		for(i=0,j=n-1,sum=0;i<n;i++,j--) {
			sum+=arrayList.get(i).get(j);
		}
		if(sum!=constant) {
			return false;
		}
		
		return true;
	}
	public static boolean generateMagicSquare(int n) {
		//要求输入的n是正奇数
		if(n<0) {
			System.out.println("You input Negative number! ");
			return false;
		}
		if(n%2==0) {
			System.out.println("You input even numbers! ");
			return false;
		}
		int magic[][] = new int[n][n];
		int row = 0, col = n / 2, i, j, square = n * n;

		for (i = 1; i <= square; i++) {
			magic[row][col] = i; //令row col位置的数等于i
			if (i % n == 0)//在斜着的方向上首尾相接，使row加一重启新的斜着一行
				row++;
			else {
				if (row == 0)	//如果赋值遇到了上边界，就再从下边界开始；否则row逐次向上
					row = n - 1;
				else
					row--;
				
				if (col == (n - 1))//如果赋值遇到了右边界，就再从左边界开始；否则col逐次往右
					col = 0;
				else
					col++;
			}
		}

		for (i = 0; i < n; i++) {
			for (j = 0; j < n; j++)
				System.out.print(magic[i][j] + "\t");
			System.out.println();
		}

		FileWriter fw;
		try {
			fw=new FileWriter("src/P1/txt/6.txt");
			for(i=0;i<n;i++) {
				for(j=0;j<n;j++) {
					fw.write(String.valueOf(magic[i][j]));
					
					if(j!=n-1) {fw.write("\t");}
					else {
						if(i==n-1)break;
						fw.write("\n");
					}
				}
			}
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
return true;
}
	public static void main (String[] args) {
		int i=1,n=19;
		String Name = null;
		Scanner scan=new Scanner(System.in);
		generateMagicSquare(n);
		for(;i<=5;i++) {
					
				Name=scan.next();
			boolean key=isLegalMagicSquare(Name);
			System.out.println("The file "+Name+" is "+key);
		}
		scan.close();
	}
}
