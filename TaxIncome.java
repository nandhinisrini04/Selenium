import java.util.Scanner;

public class TaxIncome {

	public static double taxrate;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		double taxableincome=sc.nextDouble();
		double TaxPaidPerYear=0;
		double TaxPayPerMonth=0;
		double result[]=TaxCalculate(taxableincome,TaxPaidPerYear,TaxPayPerMonth);
		System.out.println("Tax Per Year: "+result[0]);
		System.out.println("Tax Per Month: "+result[1]);
	}	
	
	public static double[] TaxCalculate(double income,double Peryear,double Permonth) {
		double arr[]=new double[2];
		if(income <=25000) {
			taxrate=0;
			Peryear=taxrate*income;
			Permonth=Peryear/12;
			arr[0]=Peryear;
			arr[1]=Permonth;
		}
		else if (income>25000 && income<=50000) {
			taxrate=0.1;
			Peryear=taxrate*income;
			Permonth=Peryear/12;
			arr[0]=Peryear;
			arr[1]=Permonth;
		}
		else if (income>50000 && income<=75000) {
			taxrate=0.2;
			Peryear=taxrate*income;
			Permonth=Peryear/12;
			arr[0]=Peryear;
			arr[1]=Permonth;
		}
		else if (income>75000) {
			taxrate=0.3;
			Peryear=taxrate*income;
			Permonth=Peryear/12;
			arr[0]=Peryear;
			arr[1]=Permonth;
		}
		return arr;
	}
	
}
