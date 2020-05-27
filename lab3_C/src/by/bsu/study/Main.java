package by.bsu.study;

import java.io.Console;

/*Определить класс Точка в пространстве, координаты которой задаются с помощью Рациональной Дроби.
 Создать методы по определению расстояния между точками и расстояния до начала координат.
 Проверить для трех точек возможность нахождения на одной прямой.*/
public class Main {
    public static void main(String[] args) {
        int num = 4;
        Point3D[] pt = new Point3D[num];
        pt[0] = new Point3D(1, 1, 1, 1, 1, 1);
        pt[1] = new Point3D(2, 1, 2, 1, 2, 1);
        pt[2] = new Point3D(6, 2, 3, 1, 3, 1);
        pt[3] = new Point3D(1, 1, 1, 1, 6, 1);

        startTest(pt);
    }

    public static void startTest(Point3D[] pt){
        int num = pt.length;

        System.out.println("All points (x, y, z): ");
        for (int i = 0; i < num; i++) {
            System.out.println((i + 1) + ". " + pt[i].toString() + ";");
        }

        System.out.println("\nDistance between: ");
        for (int i = 0; i < num; i++) {
            for (int j = i + 1; j < num; j++) {
                String str = (i+1) + " and " + (j + 1) + " is " + pt[i].getDistanceTo(pt[j]) + ";";
                System.out.println(str);
            }
        }

        System.out.println("\nDistance between every point and center of coordinates: ");
        for (int i = 0; i < num; i++) {
            System.out.println((i + 1) + ". " + pt[i].getDistanceToZero() + ";");
        }

        System.out.println("\nPoints 1, 2 and 3 are on one line: " + Point3D.isOnOneLine(pt[0], pt[1], pt[2]));
        System.out.println("Points 1, 2 and 4 are on one line: " + Point3D.isOnOneLine(pt[0], pt[1], pt[3]));
    }
}
