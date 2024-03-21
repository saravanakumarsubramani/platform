package Reusability;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class single_mail_id_generator {

	public static String generate_name() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("../io.platform/src/test/java/Reusability/num.txt"));
		String st = "";
		int i = 0;
		while ((st = br.readLine()) != null) {
			i = Integer.parseInt(st);
		}
		st = "superman" + i++ + "@examly.in";

		BufferedWriter bw = new BufferedWriter(new FileWriter("../io.platform/src/test/java/Reusability/num.txt"));
		bw.write(Integer.toString(i));
		bw.close();
		return st;
	}
	public static String generate_qb_name() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("../io.platform/src/test/java/Reusability/qb_name.txt"));
		String st = "";
		int i = 0;
		while ((st = br.readLine()) != null) {
			i = Integer.parseInt(st);
		}
		st = "Demo" + i++;

		BufferedWriter bw = new BufferedWriter(new FileWriter("../io.platform/src/test/java/Reusability/qb_name.txt"));
		bw.write(Integer.toString(i));
		bw.close();
		return st;
	}
	
	public static String generate_test_name() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("../io.platform/src/test/java/Reusability/testname.txt"));
		String st = "";
		int i = 0;
		while ((st = br.readLine()) != null) {
			i = Integer.parseInt(st);
		}
		st = "DemoTest" + i++;

		BufferedWriter bw = new BufferedWriter(new FileWriter("../io.platform/src/test/java/Reusability/testname.txt"));
		bw.write(Integer.toString(i));
		bw.close();
		return st;
	}
	
	public static String generate_section_name() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("../io.platform/src/test/java/Reusability/sectioName.txt"));
		String st = "";
		int i = 0;
		while ((st = br.readLine()) != null) {
			i = Integer.parseInt(st);
		}
		st = "DemoSection" + i++;

		BufferedWriter bw = new BufferedWriter(new FileWriter("../io.platform/src/test/java/Reusability/sectioName.txt"));
		bw.write(Integer.toString(i));
		bw.close();
		return st;
	}
	
	public static String generate_Course_name() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("../io.platform/src/test/java/Reusability/coursename.txt"));
		String st = "";
		int i = 0;
		while ((st = br.readLine()) != null) {
			i = Integer.parseInt(st);
		}
		st = "StudentCourse" + i++;

		BufferedWriter bw = new BufferedWriter(new FileWriter("../io.platform/src/test/java/Reusability/coursename.txt"));
		bw.write(Integer.toString(i));
		bw.close();
		return st;
	}
	
	
}
