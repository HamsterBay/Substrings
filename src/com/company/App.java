package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App {
  public String y = "";
  public String x = "";

  public App() throws FileNotFoundException {
    String fileName = "In0301.txt";
    File inputFile = new File(fileName);
    Scanner scanner = new Scanner(inputFile);
    y = scanner.nextLine();
    x = scanner.nextLine();
  }

  public void substring() throws IOException {

    int xLgh = x.length();
    int yLgh = y.length();
    String substrings = "";

    //generating matrix and do algorithm to find the longest common substring of two words
    int matrix[][] = new int[ xLgh ][ yLgh ];
    int i, j;


    for (i = 0; i < xLgh; i++) {
      matrix[ i ][ 0 ] = 0;
      for (j = 0; j < yLgh; j++)
        matrix[ 0 ][ j ] = 0;
    }

    for (i = 1; i < xLgh; i++) {
      for (j = 1; j < yLgh; j++) {
        if (x.charAt(i) == y.charAt(j)) {
          matrix[ i ][ j ] = matrix[ i - 1 ][ j - 1 ] + 1;
        } else if (matrix[ i - 1 ][ j ] >= matrix[ i ][ j - 1 ]) {
          matrix[ i ][ j ] = matrix[ i - 1 ][ j ];
        } else matrix[ i ][ j ] = matrix[ i ][ j - 1 ];
      }
    }

    // reading the longest common substring of two words
    i = xLgh - 1;
    j = yLgh - 1;

    do if (x.charAt(i) == y.charAt(j)) {
      substrings += x.charAt(i);
      i--;
      j--;
    } else if (matrix[ i - 1 ][ j ] >= matrix[ i ][ j - 1 ]) {
      i--;
    } else {
      j--;
    } while (matrix[i][j] != 0);

    //reverse substrings
    String result = new StringBuilder(substrings).reverse().toString();


    // writing to a file
    String fileName = "Out0301.txt";
    FileWriter save = new FileWriter(fileName, true);

    save.write("   ");
      for (i = 0; i < yLgh; i++) {
        save.write(" " + y.charAt(i) + " ");
      }
      save.write("\n");

      for (i = 0; i < xLgh; i++) {
        save.write(" " + x.charAt(i) + " ");
        for (j = 0; j < yLgh; j++) {
          save.write(" " + matrix[ i ][ j ] + " ");
        }
        save.write("\n");
      }

    save.write("\nNWP : " + result + "\n\n");

    save.close();

    }
  }
