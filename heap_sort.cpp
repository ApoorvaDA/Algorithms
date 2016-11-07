/*
 * heap_sort.cpp
 *
 *  Created on: Oct 15, 2014
 *  Author: Apoorva.D.A
 */
#include <cstdlib>
#include <iostream>

using namespace std;

class Heap
{
public:
	void print_array(int *a, int n);
	void max_heapify(int *a,int i,int n);
	void build_heap(int *a,int n);
	void heap_sort(int *a, int n);
};

void Heap::print_array(int *a, int n){
	int i;
	cout << "The elements of the array are :" << endl;
	for(i = 0; i < n; i++){
		cout << a[i] << "->";
	}
	cout << "\n\n" ;
}
void Heap::max_heapify(int *a,int i,int n){
	int l,r,largest,tmp;
	l = (2 * i);
	r = (2 * i) + 1;
	if (l<=n && a[l-1]>a[i-1]){
		largest = l;
	} else {
		largest = i;
	}
	if (r<=n && a[r-1]>a[largest-1]){
		largest = r;
	}
	if (largest != i){
		tmp = a[i-1];
		a[i-1] = a[largest-1];
		a[largest-1]=tmp;
	} else {
		return;
	}
	max_heapify(a,largest,n);
}

void Heap::build_heap (int *a, int n){
	int i;
	cout << "Building the heap" << endl;
	for(i = n/2 ; i >= 1 ; i--){
		max_heapify(a,i,n);
	}
}

void Heap::heap_sort ( int *a, int n){
	int i, tmp;
	cout << "Performing Heap sort" << endl;
	for ( i = n-1; i >= 1; i--){
		tmp = a[0];
		a[0] = a[i];
		a[i] = tmp;
		max_heapify(a,1,i);
	}
}

int main (){
	Heap h;
	int i;
	int n=12;
	int a[12];
	cout << "Enter the elemnts of the array\n" << endl;
	for (i=0; i<n; i++){
		cin>>a[i];
	}
	h.print_array(a,n);
	h.build_heap(a,n);
	h.print_array(a,n);
	h.heap_sort(a,n);
	h.print_array(a,n);
}
