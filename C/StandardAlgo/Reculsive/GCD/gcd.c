#include<stdio.h>
int gcd(int, int);
int gcd2(int, int);
int main(void) {
	printf("%d\n", gcd(10, 8));
	printf("%d\n", gcd2(10, 5));
	return 0;
}
int gcd(int m, int n) {
	if (n == 0)return m;
	else gcd(n, m % n);
}
int gcd2(int m, int n) {
	if (m < n) {
		int temp = m; m = n; n = temp;
	}
	if (m % n == 0)
		return n;
	else {
		gcd2(n, m % n);
	}
}