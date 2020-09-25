#include <iostream>
using namespace std;

int main()
{
    int T = 0;
    cin >> T;
	for (int test_case = 1; test_case <= T; test_case++)
	{
		int l = 0;
		int r = 0;
		char result = '<';
		cin >> l;
		cin >> r;
		if (l > r) {
			result = '>';
		}
		else if (l == r) {
			result = '=';
		}
		cout << "#" << test_case << " " << result << endl;
	}
}