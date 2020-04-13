#include <string>
#include <vector>
#include <iostream>

using namespace std;
string solution(string, int);
int main(void)
{
	string result = solution("a B z", 4);
	cout << result;
}
string solution(string s, int n) {
	string answer = "";
	for (char var : s)
	{
		if (var >= 'A' && var <= 'Z')//대문자
		{
			if (var + n > 'Z') {
				var = var + n - 'Z' + 'A'-1;
			}
			else
			{
				var += n;
			}
		}
		else if (var >= 'a' && var <= 'z')//소문자
		{
			if (var + n > 'z') {
				var = var + n - 'z' + 'a'-1;
			}
			else
			{
				var += n;
			}
		}
		answer += var;
	}

	return answer;
}