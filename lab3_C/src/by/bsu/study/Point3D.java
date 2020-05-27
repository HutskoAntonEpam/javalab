package by.bsu.study;

import org.jetbrains.annotations.NotNull;

public class Point3D {
    //Easier to use as an open structure
    public Fraction x;
    public Fraction y;
    public Fraction z;

    Point3D(){
        x = new Fraction();
        y = new Fraction();
        z = new Fraction();
    }
    Point3D(@NotNull Fraction x, @NotNull Fraction y, @NotNull Fraction z){
       this.x = new Fraction(x.getNumerator(), x.getDenominator());
        this.y = new Fraction(y.getNumerator(), y.getDenominator());
        this.z = new Fraction(z.getNumerator(), z.getDenominator());
    }
    Point3D(int x1, int x2, int y1, int y2, int z1, int z2){
        x = new Fraction(x1, x2);
        y = new Fraction(y1, y2);
        z = new Fraction(z1, z2);
    }

    public double getDistanceTo(@NotNull Point3D pt){
        Fraction dx = x.minus(pt.x), dy = y.minus(pt.y), dz = z.minus(pt.z);
        Fraction sum = (dx.multiplyBy(dx)).plus(dy.multiplyBy(dy)).plus(dz.multiplyBy(dz));
        return Math.sqrt((double)sum.getNumerator()/(double)sum.getDenominator());
    }
    public double getDistanceToZero(){
        Point3D pt = new Point3D();
        pt.x.setNumerator(0);
        pt.y.setNumerator(0);
        pt.z.setNumerator(0);
        return getDistanceTo(pt);
    }
    public String toString(){
        String str = "(" + (double)x.getNumerator()/x.getDenominator()
                + ", " + (double)y.getNumerator()/y.getDenominator()
                + ", " + (double)z.getNumerator()/z.getDenominator() + ")";
        return str;
    }

    public static boolean isOnOneLine(@NotNull Point3D pt1, @NotNull Point3D pt2, @NotNull Point3D pt3){
        Fraction zero = (new Fraction()).minus(new Fraction());
        Fraction dx = (pt2.x).minus(pt1.x), dy = (pt2.y).minus(pt1.y), dz = (pt2.z).minus(pt1.z);
        /*if (dx.isEquals(zero) && dx.isEquals(dy) && dx.isEquals(dz)){
            return false;
        }
        if (dx.isEquals(zero) && dx.isEquals(dy)){
            if(pt3.x.isEquals(pt1.x) && pt3.y.isEquals(pt1.y)){
                return true;
            }
            return false;
        }
        if (dx.isEquals(zero) && dx.isEquals(dz)){
            if(pt3.x.isEquals(pt1.x) && pt3.z.isEquals(pt1.z)){
                return true;
            }
            return false;
        }
        if (dy.isEquals(zero) && dx.isEquals(dz)){
            if(pt3.y.isEquals(pt1.y) && pt3.z.isEquals(pt1.z)){
                return true;
            }
            return false;
        }*/

        Fraction num1 = ((pt3.x).minus(pt1.x)).divideBy((pt2.x).minus(pt1.x)); //(x - x1)/(x2 - x1)
        Fraction num2 = ((pt3.y).minus(pt1.y)).divideBy((pt2.y).minus(pt1.y)); //(y - y1)/(y2 - y1)
        Fraction num3 = ((pt3.z).minus(pt1.z)).divideBy((pt2.z).minus(pt1.z)); //(z - z1)/(z2 - z1)
        // (x - x1)/(x2 - x1) == (y - y1)/(y2 - y1) == (z - z1)/(z2 - z1) --- canonical equation of line
        /*if (dx.isEquals(zero)){
            if(num2.isEquals(num3)){
                return true;
            }
            return false;
        }
        if (dy.isEquals(zero)){
            if(num1.isEquals(num3)){
                return true;
            }
            return false;
        }
        if (dz.isEquals(zero)){
            if(num1.isEquals(num2)){
                return true;
            }
            return false;
        }*/
        if (num1.isEquals(num2) && num1.isEquals(num3)){
            return true;
        }
        return false;
    }
}