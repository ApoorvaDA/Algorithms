/*
 * graph.cpp
 *
 *  Created on: Nov 9, 2014
 *      Author: Apoorva.D.A
 */
#include <iostream>
#include <stddef.h>

using namespace std;

class Graph {
private:
    bool** adj_matrix;
    int vertexCount;

public:
    Graph(int vertexCount) {
        this->vertexCount = vertexCount;
        adj_matrix = new bool *[vertexCount];
        for (int i=0; i<vertexCount; i++){
            adj_matrix[i] = new bool [vertexCount];
            for (int j=0; j<vertexCount; j++){
                adj_matrix[i][j] = false;
            }
        }
    }

    ~Graph() {
        for (int i=0; i<vertexCount; i++)
            delete[] adj_matrix[i];
        delete[] adj_matrix;
    }

    void Edge_insert(int, int);
    void Edge_delete(int, int);
    bool Edge_check(int, int);
    enum vertexState {untraversed, traversed, to_traverse};
    void DFS();
    void runDFS(int u, vertexState state[]);
    void BFS();
};

class queue{
public:
    int rear,front,a[8];

    queue()   // Constructor method
    {
        rear=0;
        front=0;
    }
    void insert(int s) // Function to add the elements to the queue
    {  if(rear==8)
        cout<<"queue is full";
       else
       { a[rear]=s;
        rear=rear+1;
       }
     }
    int remove()    //Function to remove elements from the queue
    {
        if(front==rear)
           return -1;
        else
          return a[front++];
   }
};

void Graph::Edge_insert(int i, int j) {
    if (i>=0 && i<vertexCount && j>=0 && j<vertexCount) {
        adj_matrix[i][j] = true;
        adj_matrix[j][i] = true;
    }
}

void Graph::Edge_delete (int i, int j) {
    if (i>=0 && i<vertexCount && j>=0 && j<vertexCount) {
        adj_matrix[i][j] = false;
        adj_matrix[j][i] = false;
    }
}

bool Graph::Edge_check (int i, int j) {
    if (i>=0 && i<vertexCount && j>=0 && j<vertexCount) {
        return adj_matrix[i][j];
    }
    else
        return false;
}

void Graph::DFS(){
    vertexState *state = new vertexState[vertexCount];
    for (int c=0; c<vertexCount; c++) {
        state[c] = untraversed;
    }
    runDFS(0, state);
    delete [] state;
}

void Graph::runDFS(int u, vertexState state[]){
    state[u] = traversed;
    cout << u << " ";
    for (int v=0; v<vertexCount; v++){
        if (Edge_check(u,v) && state[v] == untraversed)
            runDFS(v, state);
    }
    state[u] = to_traverse;
}

void Graph::BFS()
{
    int visitedNode[8]={0,0,0,0,0,0,0,0},i,node,j;
    queue bfsQueue;
    visitedNode[0]=1;
    bfsQueue.insert(0);
    node=bfsQueue.remove();
    while(node!=-1){
        cout<<node<<" ";
        for(i=node,j=0;j<8;j++)
        {
            if(Edge_check(i,j)==1 && visitedNode[j]==0)
            {
                bfsQueue.insert(j);
                visitedNode[j]=1;
            }
        }
        node=bfsQueue.remove();
 }
}

int main() {

    Graph myGraph(8);

    myGraph.Edge_insert(0,1);
    myGraph.Edge_insert(0,3);
    myGraph.Edge_insert(0,4);
    myGraph.Edge_insert(0,5);
	myGraph.Edge_insert(0,6);
    myGraph.Edge_insert(1,0);
    myGraph.Edge_insert(1,4);
    myGraph.Edge_insert(2,3);
    myGraph.Edge_insert(2,5);
    myGraph.Edge_insert(2,7);
    myGraph.Edge_insert(3,0);
    myGraph.Edge_insert(3,2);
    myGraph.Edge_insert(3,5);
    myGraph.Edge_insert(3,6);
    myGraph.Edge_insert(4,0);
	myGraph.Edge_insert(4,1);
	myGraph.Edge_insert(4,6);
	myGraph.Edge_insert(4,7);
	myGraph.Edge_insert(5,0);
	myGraph.Edge_insert(5,1);
	myGraph.Edge_insert(5,2);
    myGraph.Edge_insert(5,3);
    myGraph.Edge_insert(5,7);
	myGraph.Edge_insert(6,0);
	myGraph.Edge_insert(6,3);
	myGraph.Edge_insert(6,4);
    myGraph.Edge_insert(6,7);
	myGraph.Edge_insert(7,2);
	myGraph.Edge_insert(7,4);
	myGraph.Edge_insert(7,5);
	myGraph.Edge_insert(7,6);

    int a, b;
    for(a=0; a<=7; a++){
        cout<<endl;
        for(b=0; b<=7; b++){
            cout << " " << myGraph.Edge_check(a,b);
        }
    }
    cout << endl << endl;
    cout << "DFS of the tree is: ";
    myGraph.DFS();
    cout << endl << endl;
    cout << "BFS of the tree is: ";
    myGraph.BFS();
    cout << endl;
    return 0;
}