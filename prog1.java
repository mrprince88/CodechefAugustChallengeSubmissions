import java.io.*;
import java.util.*;

class prog1 {

	static class MyReader {
		BufferedReader br;
		StringTokenizer st;

		public MyReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}


	static private final String INPUT = "./input.txt";
	static private final String OUTPUT = "./output.txt";

	public static void main(String[] args) {

		long startTime = System.nanoTime() / 1000000000;
		FileInputStream instream = null;
		PrintStream outstream = null;

		try {
			instream = new FileInputStream(INPUT);
			outstream = new PrintStream(new FileOutputStream(OUTPUT));
			System.setIn(instream);
			System.setOut(outstream);
		} catch (Exception e) {
			System.err.println("Error");
		}

		MyReader s = new MyReader();
		int t = s.nextInt();
		while (t-- > 0) {
			int n = s.nextInt();
			long k = s.nextLong();
			int i;
			long a, sm = Long.MAX_VALUE, pos = -1;
			for (i = 0; i < n; i++) {
				a = s.nextLong();
				if (k % a == 0 && sm > (k / a)) {
					sm = k / a;
					pos = a;
				}
			}
			System.out.println(pos);
		}


		double endTime   = System.nanoTime() / 1000000000;
		double totalTime = endTime - startTime;
		System.err.format("%.8f\n", totalTime);
		return;
	}
}