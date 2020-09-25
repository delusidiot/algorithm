#include<iostream>
using namespace std;
const int LENGTH = 10;

int main() {
	int T;
	cin >> T;
	for (int test_case = 1; test_case <= T; test_case++)
	{
		int max = 0;
		int input = 0;
		for (int i = 0; i < LENGTH; i++)
		{
			cin >> input;
			max = max > input ? max : input;
		}
		cout << "#" << test_case << " " << max << endl;
	}
}