package by.bsu.study.matrices.service;

import by.bsu.study.matrices.domain.MatrixCell;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class MatrixHandler {
    public ArrayList<MatrixCell> getCycleMatrix(String filePath) throws IOException {
        FileReader fileStream = new FileReader(filePath); // create stream from file
        Scanner fileScanner = new Scanner(fileStream); // wrap up stream by scanner

        ArrayList<ArrayList<Integer>> fullMatrix = new ArrayList<>();
        int k = 0;
        while (fileScanner.hasNextLine()) { // while not all lines are read
            String line = fileScanner.nextLine();
            String[] lineValues = line.split(" ");
            fullMatrix.add(new ArrayList<>());
            for (String value: lineValues){
                fullMatrix.get(k).add(Integer.valueOf(value));
            }
            k++;
        }

        return getCycleMatrixFromFull(fullMatrix);
    }

    public ArrayList<MatrixCell> getCycleMatrixFromFull(ArrayList<ArrayList<Integer>> fullMatrix) {
        ArrayList<MatrixCell> matrix = new ArrayList<>();
        for(int i = 0; i < fullMatrix.size(); i++) {
            for(int j = 0; j < fullMatrix.get(i).size(); j++) {
                int value = fullMatrix.get(i).get(j);
                if (value != 0 || (i == fullMatrix.size() - 1 && j == fullMatrix.get(i).size() - 1)) {
                    matrix.add(new MatrixCell(i, j, value, null));
                }
            }
        }

        int n = matrix.size();
        for (int i = 0; i < n; i++){
            matrix.get(i).next = matrix.get((i + 1) % n);
        }

        return matrix;
    }

    public void writeTextFile(String path, String content) throws IOException {
        FileOutputStream fileOutStream = new FileOutputStream(path);
        byte[] contentBytes = content.getBytes();
        fileOutStream.write(contentBytes, 0, contentBytes.length);
    }

    public ArrayList<MatrixCell> getCycleMatrixSum(ArrayList<MatrixCell> matrix1, ArrayList<MatrixCell> matrix2) {
        ArrayList<ArrayList<Integer>> fullMatrix1 = getFullMatrixFromCycle(matrix1);
        ArrayList<ArrayList<Integer>> fullMatrix2 = getFullMatrixFromCycle(matrix2);
        ArrayList<ArrayList<Integer>> sumMatrix = new ArrayList<>();
        int m = fullMatrix1.get(0).size();
        int n = fullMatrix1.size();

        if (n != fullMatrix2.size() || m != fullMatrix2.get(0).size()) {
            throw new IllegalArgumentException("Wrong matrix sizes");
        }

        for (int i = 0; i < n; i++){
            sumMatrix.add(new ArrayList<>());
            for (int j = 0; j < m; j++) {
                sumMatrix.get(i).add(0);
            }
        }

        for(int i = 0; i < n; i++){
            for (int j = 0; j < m; j++) {
                sumMatrix.get(i).set(j, fullMatrix1.get(i).get(j) + fullMatrix2.get(i).get(j));
            }
        }

        return getCycleMatrixFromFull(sumMatrix);
    }
    public ArrayList<MatrixCell> getCycleMatrixProduct(ArrayList<MatrixCell> matrix1, ArrayList<MatrixCell> matrix2) {
        ArrayList<ArrayList<Integer>> fullMatrix1 = getFullMatrixFromCycle(matrix1);
        ArrayList<ArrayList<Integer>> fullMatrix2 = getFullMatrixFromCycle(matrix2);
        ArrayList<ArrayList<Integer>> prodMatrix = new ArrayList<>();
        int l = fullMatrix1.size(),
                n = fullMatrix2.get(0).size(),
                m = fullMatrix1.get(0).size();

        if (m != fullMatrix2.size()){
            throw new IllegalArgumentException("Wrong matrices sizes");
        }
        
        for (int i = 0; i < n; i++){
            prodMatrix.add(new ArrayList<>());
            for (int j = 0; j < l; j++) {
                prodMatrix.get(i).add(0);
            }
        }
        
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    prodMatrix.get(i).set(j, fullMatrix1.get(i).get(k) * fullMatrix2.get(k).get(j));
                }
            }
        }

        return getCycleMatrixFromFull(prodMatrix);
    }

    ArrayList<ArrayList<Integer>> getFullMatrixFromCycle(ArrayList<MatrixCell> matrix) {
        int iSize = matrix.get(matrix.size() - 1).i + 1;
        int jSize = matrix.get(matrix.size() - 1).j + 1;

        ArrayList<ArrayList<Integer>> fullMatrix = new ArrayList<>();
        for(int i = 0; i < iSize; i++){
            fullMatrix.add(new ArrayList<>());
            for(int j = 0; j < jSize; j++){
                fullMatrix.get(i).add(0);
            }
        }

        for(MatrixCell cell: matrix){
            fullMatrix.get(cell.i).set(cell.j, cell.value);
        }

        return fullMatrix;
    }

    public String getConfigValue(String configPath, String option) throws IOException {
        FileReader configStream = new FileReader(configPath); // create stream from file
        Scanner configScanner = new Scanner(configStream); // wrap up stream by scanner

        String optionContent = ""; // to return empty value if there is no such option
        while(configScanner.hasNextLine()){
            String line = configScanner.nextLine(); // get line of ini file
            if (line.startsWith(option)) { // if line is the option we are looking for
                String[] optionSplit = line.split("="); // split this line on option and value
                if (optionSplit.length == 2) { // if there are value and only one "="
                    optionContent = optionSplit[1]; // gets value after "="
                    break; // stop searching
                }
            }
        }

        return optionContent.trim(); // return value without spaces
    }
}
