package edu.clark.ctec.cse224.hw7.b_longbons;

@SuppressWarnings("serial")
public class Random extends java.util.Random {
	double norm(double mean, double sigma) {
		return super.nextGaussian() * sigma + mean;
	}

	public int fuzz(int i) {
		return (int) norm(i, i/8);
	}
}
