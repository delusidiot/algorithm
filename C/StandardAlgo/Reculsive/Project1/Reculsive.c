#include<stdio.h>
void reculsive(int);
int main(void) {
	reculsive(10);
	return 0;
}
void reculsive(int n) {
	if (n == 0)return;
	else {
		printf("Hello Reculsive\n");
		reculsive(n - 1);
	}
}