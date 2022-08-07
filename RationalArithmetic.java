import java.util.Scanner;
class Rational{
    private long numerator;
    private long denominator;
    private long integer;
    private boolean negative;
    private boolean zero;
    private long totalNumerator;
    public static long parseNumerator(String s) {
        return Long.parseLong(s.substring(0,s.indexOf('/')));
    }
    public static long parseDenominator(String s) {
        return Long.parseLong(s.substring(s.indexOf('/')+1));
    }
    Rational(long n,long d) {
        if(d==0){
            zero=true;
            return;
        }
        if(n<0){
            negative = true;
        }
        if(d<0){
            negative = !negative;
        }
        integer = n / d;
        numerator = n - integer * d;
        denominator = Math.abs(d);
        if(numerator > 1 || numerator < - 1){
            long gcd = calcGcd(Math.abs(numerator),denominator);
            if(gcd > 0) {
                numerator /= gcd;
                denominator /= gcd;
            }
        }
        totalNumerator = numerator + denominator * integer;
    }
    private long calcGcd(long a,long b){
        if(b == 0){
            return a;
        }
        return calcGcd(b,a%b);
    }
    public Rational add(Rational r){
        long n = totalNumerator * r.denominator + denominator * r.totalNumerator;
        long d = denominator * r.denominator;
        return new Rational(n,d);
    }
    public Rational sub(Rational r){
        long n = totalNumerator * r.denominator - denominator * r.totalNumerator;
        long d = denominator * r.denominator;
        return new Rational(n,d);
    }
    public Rational mul(Rational r){
        long n = totalNumerator * r.totalNumerator;
        long d = denominator * r.denominator;
        return new Rational(n,d);
    }
    public Rational div(Rational r){
        long n = totalNumerator * r.denominator;
        long d = denominator * r.totalNumerator;
        return new Rational(n,d);
    }

    public String toString(){
        StringBuffer s = new StringBuffer();
        if(zero){
            s.append("Inf");
        }else if(integer == 0 && numerator == 0){
            s.append("0");
            return new String(s);
        }
        else{
            if(negative){
                s.append("(-");
            }
            if(0 != integer){
                s.append(Math.abs(integer));
                if(numerator != 0){
                    s.append(" ");
                }
            }
            if(0 != numerator){
                s.append(Math.abs(numerator));
                s.append('/');
                s.append(denominator);
            }
        }
        if(negative){
            s.append(')');
        }
        return new String(s);
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.next();
            Rational r1 = new Rational(Rational.parseNumerator(s),Rational.parseDenominator(s));
            s = in.next();
            Rational r2 = new Rational(Rational.parseNumerator(s),Rational.parseDenominator(s));
            System.out.println(r1 + " + " + r2 + " = " + r1.add(r2));
            System.out.println(r1 + " - " + r2 + " = " + r1.sub(r2));
            System.out.println(r1 + " * " + r2 + " = " + r1.mul(r2));
            System.out.println(r1 + " / " + r2 + " = " + r1.div(r2));
        }
    }
}
