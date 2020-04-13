#include <iostream>
#define MAX 50
using namespace std;
int N = 0;
int M = 0;

char map[MAX][MAX];
int main()
{
    
    cin >> N;
    cin >> M;
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < M; j++)
        {
            cin >> map[i][j];
        }
    }
    cout << N << " " << M << endl;
    
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < M; j++)
        {
            cout << map[i][j];
        }
        cout << endl;
    }
}