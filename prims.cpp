#include <iostream>
#include <conio.h>
#define ROW 12
#define COL 12
#define infi 5000  //infi for infinity class prims

using namespace std;

class prims{
   int graph[ROW][COL],nodes;
   public:
   prims();
   int createGraph();
   void printGraph(int nodes);
   void primsAlgo(int nodes);
};

prims :: prims(){
     for(int i=0;i<ROW;i++)
       for(int j=0;j<COL;j++)
     graph[i][j]=0;
}

int prims :: createGraph(){
    int i,j, nodes;
    cout<<"Enter Total Nodes : ";
    cin>>nodes;
    cout<<"\n\nEnter Adjacency Matrix : \n";
    for(i=0;i<nodes;i++){
    	// cout<<nodes<<endl;
        for(j=0;j<nodes;j++){
        	cout<<"Enter graph["<<i<<"]["<<j<<"]"<<endl;
        	cin>>graph[i][j];
        }
    }

    //Assign infinity to all graph[i][j] where weight is 0.
    for(i=0;i<nodes;i++){
    	for(j=0;j<nodes;j++){
    		if(graph[i][j]==0)
    			graph[i][j]=infi;
    	}
    }
    return nodes;
}

void prims :: printGraph(int nodes){
	int i,j;
	for(i=0;i<nodes;i++)
		for(j=0;j<nodes;j++)
			if(graph[i][j] != infi){
				cout<<"graph["<<i<<"]["<<j<<"]="<<graph[i][j]<<endl;
			}

}
void prims :: primsAlgo(int nodes){
    int selected[ROW],i,j,ne; //ne for no. of edges
    int false=0,true=1,min,x,y;

    //cout<<"Nodes:"<<nodes<<endl;
    for(i=0;i<nodes;i++)
       selected[i]=false;

    selected[0]=true;
    ne=0;

    while(ne <= nodes-1){
    	min=infi;

       for(i=0;i<nodes;i++)
       {
          if(selected[i]==true){
        	  for(j=0;j<nodes;j++){
        		  if(selected[j]==false){
        			  if(min > graph[i][j])
        			  {
        				  min=graph[i][j];
        				  x=i;
        				  y=j;
        			  }
        		  }
        	  }
          }
       }
       selected[y]=true;
       cout<<"\n"<<x+1<<" --> "<<y+1<<endl;
       cout<<"graph["<<x+1<<"]["<<y+1<<"]:"<<min<<endl;
       ne=ne+1;
    }
}

int main(){
    prims MST;
    int nodes;
    cout<<"\nEnter the inputs to create the graph\n";
    nodes=MST.createGraph();
    cout<<"\nGraph created"<<endl;
    cout<<"\nPrinting the input graph\n";
    MST.printGraph(nodes);
    cout<<"\nPrims Algorithm to find Minimum Spanning Tree\n";
    MST.primsAlgo(nodes);
    getch();
}
