#include<iostream>
#include <algorithm>
#include <vector>
#include "Kruskal.h"
#include "disjoint.h"
using namespace std;
int main() 
{
	int T(0);
	cin >> T;
	for (int testCase = 1; testCase <= T; testCase++)
	{
		int V(0);//정점의 개수;
		int E(V);//간선의 개수;
		vector<Kruskal> k;
		cin >> V;
		cin >> E;
		for (int i = 0; i < E; i++)
		{
			int first;
			int second;
			int distance;
			cin >> first;
			cin >> second;
			cin >> distance;
			k.push_back(Kruskal(first, second, distance));
		}
		sort(k.begin(),k.end());
		for (int i = 0; i < E; i++)
		{
			cout<<k[i].getDistance()<<endl;
		}
		int* d = new int[E];
		for (int i = 0; i < E; i++)
		{
			d[i] = i;
		}
		int count = 0;
		while (count != E) {
			
		}
		cout << "#" << testCase << " " << endl;
	}

	return 0;
}