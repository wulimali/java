package exception_catch;

import java.io.*;

public class ExceptionCatch {
	public static void main(String[] args) {

		try {
			new ExceptionCatch().func1();
		} catch (FuckException e) {
			System.out.println(e.st);
		} finally {
			System.out.println("bbbbbb");
		}
	}

	public void func1() throws FuckException {
		int b = 0;
		
		if (b == 0) {
			FuckException e = new FuckException("hahaha!");
			throw e;
		}
	}

	class FuckException extends Exception {

		private String st;

		public FuckException(String st) {
			this.st = st;
		}
		
		public String getst(){
			return st;
		}

	}
}