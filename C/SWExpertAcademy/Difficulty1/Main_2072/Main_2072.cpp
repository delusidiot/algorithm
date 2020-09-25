#include <iostream>
using namespace std;
const int LENGTH = 10;
int main()
{
	int T = 0;
	cin >> T;
	for (int test_case = 0; test_case < T; test_case++)
	{
		int result = 0;
		int input = 0;
		for (int i = 0; i < LENGTH; i++)
		{
			cin >> input;
			if (input % 2 == 1)result += input;
		}
		cout << "#" << test_case + 1 << " " << result << endl;
	}
}