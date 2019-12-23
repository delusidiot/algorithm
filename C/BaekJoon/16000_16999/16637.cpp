#include <iostream>
using namespace std;
int max = -2147483648;
void cal(int length, char string[], int start, int result);
int main()
{
	::max = -2147483648;
	int length = 0;
	cin >> length;
	char *method = new char[length];
	cin >> method;
	
	int result = 0;
	result = method[0] - '0';
	cal(length, method, 1, method[0] - '0');
	cout << ::max << endl;
	return 0;
}
void cal(int length, char string[], int start, int result)
{
	if (start >= length) {
		if (::max < result) {
			::max = result;
		}
		return;
	}
	int result1 = result;
	switch (string[start])
	{
	case '+':
		result1 += string[start + 1] - '0';
		break;
	case '-':
		result1 -= string[start + 1] - '0';
		break;
	case '*':
		result1 *= string[start + 1] - '0';
		break;
	default:
		break;
	}
	cal(length, string, start+2, result1);
	
	if (start + 2 >= length) return;

	int result2 = string[start+1]-'0';
	switch (string[start+2])
	{
	case '+':
		result2 += string[start + 3] - '0';
		break;
	case '-':
		result2 -= string[start + 3] - '0';
		break;
	case '*':
		result2 *= string[start + 3] - '0';
		break;
	default:
		break;
	}
	switch (string[start])
	{
	case '+':
		cal(length, string, start + 4, result + result2);
		break;
	case '-':
		cal(length, string, start + 4, result - result2);
		break;
	case '*':
		cal(length, string, start + 4, result * result2);
		break;
	default:
		break;
	}
	
}
