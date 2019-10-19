package ui;

import java.io.*;
import java.nio.file.*;
import business.Product;

public class ClassDemoApp {

	public static void main(String[] args) {

		String dirString = "c:/bootcamp/java/fileiodemo";
		Path dirPath = Paths.get(dirString);
		if (Files.notExists(dirPath)) {
			try {
				Files.createDirectories(dirPath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		String fileString = "products.txt";
		Path filePath = Paths.get(dirString, fileString);
		if (Files.notExists(filePath)) {
			try {
				Files.createFile(filePath);
				System.out.println("Success");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		System.out.println("File name:     " + filePath.getFileName());
		System.out.println("Absolute path: " + filePath.toAbsolutePath());
		System.out.println("Is writable:   " + Files.isWritable(filePath));

		if (Files.exists(dirPath) && Files.isDirectory(dirPath)) {
			System.out.println("Directory: " + dirPath.toAbsolutePath());
			System.out.println("Files: ");
			DirectoryStream<Path> dirStream;
			try {
				dirStream = Files.newDirectoryStream(dirPath);
				for (Path p : dirStream) {
					if (Files.isRegularFile(p)) {
						System.out.println("     " + p.getFileName());
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// Path productsPath = Paths.get("products.txt");
		File productsFile = filePath.toFile();

		try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(productsFile)))) {

			Product p = new Product("java", "Murach's Java Programming", 57.50);
			Product p2 = new Product("c#", "Murach's C# Programming", 56.50);

			out.print(p.getCode() + "\t");
			out.print(p.getDescription() + "\t");
			out.println(p.getPrice());

			out.print(p2.getCode() + "\t");
			out.print(p2.getDescription() + "\t");
			out.println(p2.getPrice());

		} catch (IOException e) {
			e.printStackTrace();
		}

		try (BufferedReader in = new BufferedReader(new FileReader(productsFile))) {
			String line = in.readLine();
			while (line != null) {
				String[] fields = line.split("\t");
				String code = fields[0];
				String description = fields[1];
				String price = fields[2];
				
				Product p = new Product(code,description,Double.parseDouble(price));
				
				System.out.println(p);
				line = in.readLine();
			}
			

		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("File input error.");
			e.printStackTrace();
		}

	}

}
