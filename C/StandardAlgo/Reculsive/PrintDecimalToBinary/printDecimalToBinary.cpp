#include<stdio.h>
void printDecimalToBinary(int n);
int main(void) {
	printDecimalToBinary(5);
	return 0;
}
void printDecimalToBinary(int n){
	if (n < 2)
		printf("%d", n);
	else {
		printDecimalToBinary(n / 2);
		printf("%d", n%2);
	}
}