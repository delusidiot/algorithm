#include "Kruskal.h"

Kruskal::Kruskal() 
{

}
Kruskal::Kruskal(int first, int second, int distance) 
{
	this->first = first;
	this->second = second;
	this->distance = distance;
}
Kruskal::~Kruskal() 
{

}

int Kruskal::getDistance() const
{
	return distance;
}

bool Kruskal::operator<(const Kruskal & a)
{
	return this->getDistance() < a.getDistance();
}
void Kruskal::toString() {
	std::cout << first << " " << second << " " << distance << std::endl;
}