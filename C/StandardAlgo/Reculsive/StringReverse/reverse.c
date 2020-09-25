#include<stdio.h>
void reverse(char* s, int n);
int main(void) {
	char s[10] = "test";
	reverse(&s, 0);
	return 0;
}
void reverse(char* s, int n) {
	if (s[n] == '\0')return;
	else { 
		reverse(s, n + 1);
		printf("%c", s[n]);
	}
}