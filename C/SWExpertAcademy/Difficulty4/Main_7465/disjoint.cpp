#include "disjoint.h"

Disjoint::Disjoint(int max_size)
{
	number = max_size + 1;
	people = new int[max_size + 1];
	counter = new bool[max_size + 1];
	make_set();
}

Disjoint::~Disjoint() {
	delete[] people;
	delete[] counter;
}

int Disjoint::find_set(int x)
{
	if (people[x] == x) return x;
	int idx = find_set(people[x]);
	return idx;
}

void Disjoint::union_set(int x, int y)
{
	int dx = find_set(people[x]);
	int dy = find_set(people[y]);
	people[dy] = dx;
}

void Disjoint::make_set()
{
	for (int i = 1; i < number; i++)
	{
		people[i] = i;
	}
}

void Disjoint::print_set()
{
	for (int i = 1; i < number; i++)
	{
		std::cout << people[i] << std::endl;
	}
}

int Disjoint::counting()
{
	int count = 0;
	for (int i = 1; i < number; i++)
	{
		counter[i] = false;
	}
	for (int i = 1; i < number; i++)
	{
		counter[find_set(people[i])] = true;
	}
	for (int i = 1; i < number; i++)
	{
		if (counter[i])count++;
	}
	return count;
}