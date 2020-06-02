package by.bsu.study.matrices.presentation;


import by.bsu.study.matrices.domain.MatrixCell;
import by.bsu.study.matrices.service.MatrixHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;

/*Во входном файле хранятся две разреженные матрицы — А и В. Построить
циклически связанные списки СА и СВ, содержащие ненулевые элементы
соответственно матриц А и В. Просматривая списки, вычислить: а) сумму
S = A + B; б) произведение P = A × B.*/
public class ConsoleMenu {
    private static final Logger log = LogManager.getLogger(ConsoleMenu.class.getSimpleName());

    public static void main(String[] args) {
        ConsoleMenu menu = new ConsoleMenu();
        menu.showUI();
    }

    private void showUI(){
        System.out.println("Lab 10 B. Work with lists\n------\n");
        MatrixHandler handler = new MatrixHandler();
        String configPath = "src/main/resources/config.ini";

        try {
            //get paths to input and output files
            String firstMatrixPath = handler.getConfigValue(configPath, "firstMatrixPath");
            String secondMatrixPath = handler.getConfigValue(configPath, "secondMatrixPath");

            ArrayList<MatrixCell> cycleMatrix1 = handler.getCycleMatrix(firstMatrixPath);
            ArrayList<MatrixCell> cycleMatrix2 = handler.getCycleMatrix(secondMatrixPath);

            System.out.println("Matrix1 not zero values:\n" +  cycleMatrix1);
            System.out.println("Matrix2 not zero values:\n" +  cycleMatrix2);

            ArrayList<MatrixCell> matrixSum = handler.getCycleMatrixSum(cycleMatrix1, cycleMatrix2);
            System.out.println("\nMatrix sum:\n" + matrixSum);

            ArrayList<MatrixCell> matrixProd = handler.getCycleMatrixProduct(cycleMatrix1, cycleMatrix2);
            System.out.println("\nMatrix product:\n" + matrixProd);

        } catch (IOException e) {
            log.error(e.getMessage());
        }

        System.out.println("------");
    }
}
