public class Fraction {
int numerator;
int denominator;
Fraction() {	// numerator = denominator = 1
	numerator = denominator = 1;// default Fraction constructor
}
Fraction(int n, int d) {
	numerator = n / gcd(n,d);
    denominator = d / gcd(n,d);// return the lowest term of Fraction
}
// greatest common divisor:
int gcd(int a, int b) { 
if (b == 0)
return (a);
else
return (gcd(b, a % b));
}

public String toString() {
    return new String(numerator+"/"+denominator);
    // overwrite toString function
}

String toDecimal() {
	double value = (double)this.numerator / this.denominator;
    return Double.toString(value);
	// return decimal format of a Fraction
}

Fraction add(Fraction f) {
	Fraction result = new Fraction();
    result.numerator = this.numerator * f.denominator + this.denominator * f.numerator;
    result.denominator = this.denominator * f.denominator;
    return result;
	// do add minipulation
}
}