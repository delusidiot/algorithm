#include <iostream>
using namespace std;
const int LENGTH = 10;
int main()
{
	int T = 0;
	cin >> T;

	for (int test_case = 1; test_case <= T; test_case++)
	{
		int result = 0;
		int input = 0;
		for (int i = 0; i < LENGTH; i++)
		{
			cin >> input;
			result += input;
		}
		if (result % 10 >= 5) {
			result += 10;
		}
		cout << "#" << test_case << " " << result / LENGTH << "\n";
	}
}