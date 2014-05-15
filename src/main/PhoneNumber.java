package main;

//nazewnictwo!!!

import java.util.Scanner;

public class PhoneNumber {
	public static final String errorMessage = "ERROR";
	public static final String infoMessage = "NOTHING TO DISPLAY.";

	private String input;
	private int clearAllOnRight;
	private int[] indexTab;
	private char[][] inputTable;
	private char[][] asciiBoard;
	String newLine = "";
	String testResult = "";
	String result;

	// constructor for testing
	public PhoneNumber(String input) {
		this.initAsciiBoard();
		this.setInput(input);
		this.setInputTable();
		this.initIndexTable();
	}

	public PhoneNumber() {
		initAsciiBoard();
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	@SuppressWarnings("resource")
	public void setInput() {
		System.out.println("Write nine digit number and press enter.");
		input = new Scanner(System.in).nextLine();
	}

	public String calculate() {
		if (!isInputCorrect()) {
			System.out.println(errorMessage);
			return errorMessage;
		}
		if (isAllZerosOrOnes()) {
			System.out.println(infoMessage);
			return infoMessage;
		}

		// get first result
		getResult();
		do {
			next();
			System.out.println("zeroIndex: " + clearAllOnRight);
			zeroIndexTab(clearAllOnRight);
			getResult();
		} while (!isGameOver());
		return testResult;
	}

	private void next() {
		for (int i = 8; i >= 0; i--) {
			if (indexTab[i] < 2) {
				increment(i);
				clearAllOnRight = i;
				return;
			}
		}
	}

	public void zeroIndexTab(int index) {
		if (index < 8) {
			for (int i = index + 1; i < 9; i++) {
				if (indexTab[i] < 3)
					indexTab[i] = 0;
			}
		}
	}

	private void getResult() {
		testResult += newLine;
		newLine = "\n";
		result = "";
		result = readResult();
		System.out.println(result);
		testResult += result;
	}

	private boolean isGameOver() {
		for (int i = 0; i < 9; i++) {
			if (indexTab[i] < 2)
				return false;
		}
		return true;
	}

	public void increment(int i) {
		indexTab[i]++;
	}

	private String readResult() {
		String result = "";
		for (int i = 0; i < 9; i++) {
			result += inputTable[i][indexTab[i]];
		}
		return result;
	}

	public void setInputTable() {
		int index;
		if (isInputCorrect()) {
			inputTable = new char[9][4];
			for (int i = 0; i < 9; i++) {
				index = Integer.parseInt(this.getInput().substring(i, i + 1));
				if (index < 2) {
					inputTable[i][3] = (char) (index + 48);
				} else {
					inputTable[i][3] = 45;
				}
				for (int j = 0; j < 3; j++) {
					inputTable[i][j] = asciiBoard[index][j];
				}
			}
		}
	}

	public void initIndexTable() {
		if (isInputCorrect()) {
			indexTab = new int[9];
			for (int i = 0; i < 9; i++) {
				if (!Character.isDigit(inputTable[i][0])) {
					indexTab[i] = 0;
				} else {
					indexTab[i] = 3;
				}
			}
		}
	}

	public void initAsciiBoard() {
		asciiBoard = new char[10][3];
		asciiBoard[0][0] = 48;
		asciiBoard[0][1] = 48;
		asciiBoard[0][2] = 48;
		asciiBoard[1][0] = 49;
		asciiBoard[1][1] = 49;
		asciiBoard[1][2] = 49;
		char dec = 65;
		for (int i = 2; i < 10; i++) {
			for (int j = 0; j < 3; j++) {
				asciiBoard[i][j] = dec++;
			}
		}
	}

	public boolean isInputCorrect() {
		if (input.length() != 9)
			return false;
		for (int i = 0; i < 9; i++) {
			if (!Character.isDigit(input.charAt(i)))
				return false;
		}
		return true;
	}

	public boolean isAllZerosOrOnes() {
		for (int i = 0; i < 9; i++) {
			if (Character.getNumericValue(inputTable[i][0]) > 1)
				return false;
		}
		return true;
	}
}
