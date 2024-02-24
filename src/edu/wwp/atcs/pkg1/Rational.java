package edu.wwp.atcs.pkg1;

public class Rational implements Comparable<Rational>
{
	private int numer;
	private int denom;
	
	public Rational(int n, int d)
	{
		numer = n;
		denom = d;
	}
	
	public Rational()
	{
		this (8, 12);
	}
	
	public int getNumer()
	{
		return numer;
	}
	
	public int getDenom()
	{
		return denom;
	}
	
	public void setNumer(int numerator)
	{
		numer = numerator;
	}
	
	public void setDenom(int denominator)
	{
		denom = denominator;
	}
	
	public String toString()
	{
		return getNumer() + "/" + getDenom();
	}
	
	public double getValue()
	{
		return (double) getNumer() / (double) getDenom();
	}
	
	public boolean equals(Rational other)
	{
		if (compareTo(other) == 0)
		{
			return true;
		}
	
		else
		{
			return false;
		}
	}
	
	public int compareTo(Rational other)
	{
		int left = getNumer() * other.getDenom();
		int right = getDenom() * other.getNumer();
		
		if (left < right)
		{
			return -1;
		}
		
		else if (right < left)
		{
			return 1;
		}
		
		else
		{
			return 0;
		}
	}
	
	private void simplify()
	{
		if(getDenom() < 0)
		{
			setDenom(denom *= -1);
			setNumer(numer *= -1);
		}
	}
	
	private void reduce()
	{
		int gcf = getGCF(getNumer(), getDenom());
		
		numer /= gcf;
		denom /= gcf;
	}
	
	private static Rational reciprocal(Rational x)
	{
		return new Rational(x.getDenom(), x.getNumer());
	}
	
	public static Rational add(Rational one, Rational two)
	{
		int numerator = (one.getNumer() * two.getDenom() + two.getNumer() * one.getDenom());
		int denominator = (one.getDenom() * two.getDenom());
		
		Rational n = new Rational(numerator, denominator);
		
		n.reduce();
		n.simplify();
		
		return n;
	}

	public static Rational subtract (Rational one, Rational two)
	{
		int numerator = (one.getNumer() * two.getDenom() - two.getNumer() * one.getDenom());
		int denominator = (one.getDenom() * two.getDenom());
		
		Rational n = new Rational(numerator, denominator);
		
		n.reduce();
		n.simplify();
		
		return n;
	}

	public static Rational multiply (Rational one, Rational two)
	{
		int numerator = (one.getNumer() * two.getNumer());
		int denominator = (one.getDenom() * two.getDenom());
		
		Rational n = new Rational(numerator, denominator);

		n.reduce();
		n.simplify();
		
		return n;
	}

	public static Rational divide (Rational one, Rational two)
	{
		int numerator = (one.getNumer() * two.getDenom());
		int denominator = (one.getDenom() * two.getNumer());
		
		Rational n = new Rational(numerator, denominator);

		n.reduce();
		n.simplify();
		
		return n;
	}
	
	private static int getGCF(int a, int b)
	{
		for(int i = Math.abs(a); i >= 1; i--)
		{
			if(a % i == 0 && b % i == 0)
			{
				return i;
			}
		}
		
		return 1;
	}
	
	public static void main(String[] args)
	{
		Rational a = new Rational(9, 12);
		System.out.println(a);
						
		Rational b = new Rational(4, -6);
		System.out.println(b);

		Rational c = new Rational(3, -9);
		System.out.println(c);
		
		System.out.println("Value of rational a: " + a.getValue());
		System.out.println("Value of rational b: " + b.getValue());
		System.out.println("Value of rational c: " + c.getValue());
		System.out.println("Rational a equal to rational b? " + a.equals(b));
		System.out.println("Rational b equal to rational c? " + b.equals(c));
		System.out.println("Rational a greater than, less than, or equal to rational b? " + a.compareTo(b));
		System.out.println("Rational b greater than, less than, or equal to rational c? " + b.compareTo(c));
		
		a.simplify();
		System.out.println("Simplify rational a: " + a.toString());
		b.simplify();
		System.out.println("Simplify rational b: " + b.toString());
		c.simplify();
		System.out.println("Simplify rational c: " + c.toString());
		a.reduce();
		System.out.println("Reduce rational a: " + a.toString());
		b.reduce();
		System.out.println("Reduce rational b: " + b.toString());
		c.reduce();
		System.out.println("Reduce rational c: " + c.toString());
		
//		System.out.println("Reciprocal a: " + Rational.reciprocal(a));
//		System.out.println("Reciprocal c: " + Rational.reciprocal(c));
//		System.out.println("Sum of rationals a and b: " + Rational.add(a, b));
//		System.out.println("Sum of rationals b and c: " + Rational.add(b, c));
//		System.out.println("Difference of rationals a and b: " + Rational.subtract(a, b));
//		System.out.println("Difference of rationals b and c: " + Rational.subtract(b, c));
//		System.out.println("Product of rationals a and b: " + Rational.multiply(a, b));
//		System.out.println("Product of rationals b and c: " + Rational.multiply(b, c));
//		System.out.println("Quotient of rationals a and b: " + Rational.divide(a, b));
//		System.out.println("Quotient of rationals b and c: " + Rational.divide(b, c));
	}
}

