#include<stdio.h>
int power(int, int);
int main(void) {
	printf("%d\n", power(5, 2));
	return 0;
}
int power(int x, int n) {
	if (n == 0)return 1;
	else return x * power(x, n - 1);
}