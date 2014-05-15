package test;

import main.PhoneNumber;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PhoneNumberTest {

	private PhoneNumber solution;

	@BeforeMethod
	public void init() {
		solution = new PhoneNumber();
	}

	@Test
	public void incorrectInputRetursErrorMessage() {

		String result;
		solution = new PhoneNumber("12345678999999");
		result = solution.calculate();

		Assert.assertEquals(result, PhoneNumber.errorMessage);
	}

	@Test
	public void allZerosReturnInfoMessage() {
		String result;
		solution = new PhoneNumber("000000000");
		result = solution.calculate();

		Assert.assertEquals(result, PhoneNumber.infoMessage);
	}

	@Test
	public void allZerosLastFive() {
		String result;
		solution = new PhoneNumber("000000005");
		result = solution.calculate();

		Assert.assertEquals(result, "00000000J\n00000000K\n00000000L");
	}

	@Test
	public void sevenZerosFiveAndFive() {
		String result;
		solution = new PhoneNumber("000000055");
		result = solution.calculate();

		Assert.assertEquals(
				result,
				"0000000JJ\n0000000JK\n0000000JL\n0000000KJ\n0000000KK\n0000000KL\n0000000LJ\n0000000LK\n0000000LL");
	}

	@Test
	public void sixZerosThreeFives() {
		String result;
		solution = new PhoneNumber("000000555");
		result = solution.calculate();
		Assert.assertEquals(result, "000000JJJ\n000000JJK\n000000JJL\n"
				+ "000000JKJ\n000000JKK\n000000JKL\n"
				+ "000000JLJ\n000000JLK\n000000JLL\n"
				+ "000000KJJ\n000000KJK\n000000KJL\n"
				+ "000000KKJ\n000000KKK\n000000KKL\n"
				+ "000000KLJ\n000000KLK\n000000KLL\n"
				+ "000000LJJ\n000000LJK\n000000LJL\n"
				+ "000000LKJ\n000000LKK\n000000LKL\n"
				+ "000000LLJ\n000000LLK\n000000LLL");
	}

	@Test
	public void fiveSevenZerosFive() {
		String result;
		solution = new PhoneNumber("500000005");
		result = solution.calculate();

		Assert.assertEquals(
				result,
				"J0000000J\nJ0000000K\nJ0000000L\nK0000000J\nK0000000K\nK0000000L\nL0000000J\nL0000000K\nL0000000L");
	}
}
