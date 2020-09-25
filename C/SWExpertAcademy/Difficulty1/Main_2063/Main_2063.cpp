#include<iostream>
using namespace std;
void quick_sort(int*, int, int);

int main() {
	int N;
	cin >> N;
	int* arr = new int[N];
	int result = 0;
	for (int i = 0; i < N; i++)
	{
		cin >> arr[i];
	}
	quick_sort(arr, 0, N);
	N = N / 2 + 1;
	cout << arr[N] << endl;
}
void quick_sort(int* data, int start, int end) {
	if (start >= end) {
		return;
	}
	int pivot = start;	
	int l = pivot + 1;
	int r = end;
	int temp;
	while (l <= r)
	{
		while (l <= end && data[l] <= data[pivot]) {
			l++;
		}
		while (r > start && data[r] >= data[pivot]) {
			r--;
		}
		if (l > r) {
			temp = data[r];
			data[r] = data[pivot];
			data[pivot] = temp;
		}
		else {
			temp = data[l];
			data[l] = data[r];
			data[r] = temp;
		}
	}
	quick_sort(data, start, r - 1);
	quick_sort(data, r+1, end);
}