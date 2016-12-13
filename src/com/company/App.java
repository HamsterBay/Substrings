package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
  public class App {
    public int n;

    public App() throws FileNotFoundException {
      String fileName = "In0301.txt";
      File inputFile = new File(fileName);
      Scanner scanner = new Scanner(inputFile);
      this.n = scanner.nextInt();
    }

    public void start() throws Exception {

    }
  }
}
