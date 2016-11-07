/* 
 * File:   main.cpp
 * Author: ngupta94
 *
 * Created on January 21, 2014, 11:53 AM
 */

#include <cstdlib>
#include <iostream>

using namespace std;

struct node //one element of stack
{
    int data; //data item
    node* next; //pointer to next link
};

class queue //a list of links
{
private:
    node* head; //pointer to first link
public:

    queue() //no-argument constructor
    {
        head = NULL;
    } //no first link
    void enqueue(int d); //add data item (one link)
    void display(); //display all link
    int dequeue();

};

void queue::enqueue(int d) //add data item
{
    node *newNode = new node;
    newNode->data = d;
    newNode->next = head;
    
    head = newNode;
    
    return;
}

int queue::dequeue() {
    node *tmp, *cur;
    int d;
   
    if (head == NULL) {
        cout << "List Empty   " << endl;
        return(-1);
	} else {
		cur = head; 
		while (head != NULL) {
			tmp = head;
			d = head->data;
			head = head->next;
		}
		delete tmp;
		head = cur;
	}	
    return(d);
   
}


void queue::display() //display all links
{
    node* current = head; //set ptr to first link
    while (current != NULL) //quit on last link
    {
        cout << current->data << endl; //print data
        current = current->next; //move to next link
    }
}
/*
 * 
 */
int main(int argc, char** argv) {
    queue q1;
    int ret;

    q1.enqueue(56);
	ret = q1.dequeue();
    if (ret >=0 ) {
        cout << "dequeue = " << ret << endl;
    }
    
    ret = q1.dequeue();
    if (ret >=0 ) {
        cout << "dequeue = " << ret << endl;
    }
	
	q1.enqueue(17);
	q1.enqueue(54);
    q1.enqueue(23);
    q1.enqueue(87);

    ret = q1.dequeue();
    if (ret >=0 ) {
        cout << "dequeue = " << ret << endl;
    }
    
    ret = q1.dequeue();
    if (ret >=0 ) {
        cout << "dequeue = " << ret << endl;
    }
   
    q1.display();
    
    return 0;
}