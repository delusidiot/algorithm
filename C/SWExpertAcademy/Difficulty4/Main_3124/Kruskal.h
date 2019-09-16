#pragma once
#include<iostream>
class Kruskal {
public:
	Kruskal();
	Kruskal(int first, int second, int distance);
	~Kruskal();
	bool operator<(const Kruskal &a);
	int getDistance() const;
	void toString();
	
	

private:
	int first;
	int second;
	int distance;
};