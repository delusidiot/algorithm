#include<iostream>
#include<string>
using namespace std;

int main() {
	int N = 0;
	cin >> N;
	string N_s = to_string(N);
	N = 0;
	for (int i = 0; i < N_s.length(); i++)
	{
		N += N_s[i]-'0';
	}
	cout << N << endl;
}