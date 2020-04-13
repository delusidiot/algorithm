#include<stdio.h>
int fibonacci(int);
int main(void) {
	printf("%d", fibonacci(5));
	return 0;
}
int fibonacci(int n) {
	if (n < 2) return n;
	else return fibonacci(n - 1) + fibonacci(n - 2);
}