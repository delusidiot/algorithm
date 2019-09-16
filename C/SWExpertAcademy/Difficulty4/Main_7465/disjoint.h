#pragma once
#include<iostream>
class Disjoint
{
public:
	Disjoint(int max_size);
	int find_set(int x);
	void union_set(int x, int y);
	void make_set();
	void print_set();
	int counting();
	~Disjoint();
private:
	int* people;//마을 사람 배열
	int number;//마을 사람 수
	bool* counter;
};