#include<stdio.h>
int length(char*, int);
int main(void) {
	char s[10] = "tests";
	printf("%s\n", &s);
	printf("%d", length(&s, 0));
	return 0;
}
int length(char* s, int n) {
	if (s[n] == '\0')return 0;
	else return 1 + length(s, n + 1);
}