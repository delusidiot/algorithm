#include<stdio.h>
int sum(int n, int* arr);
int main(void) {
	int arr[] = { 1,2,3,4 };
	printf("%d", sum(3, &arr));
	return 0;
}
int sum(int n, int* arr) {
	if (n == 0)return arr[n];
	else return arr[n] + sum(n - 1, arr);
}