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

class stack //a list of links
{
private:
    node* head; //pointer to first link
public:

    stack() //no-argument constructor
    {
        head = NULL;
    } //no first link
    void push(int d); //add data item (one link)
    void display(); //display all link
    int pop();

};

void stack::push(int d) //add data item
{
    node *newNode = new node;
    newNode->data = d;
    newNode->next = head;
    
    head = newNode;
    
    return;
}

int stack::pop() {
    node *tmp;
    int d;
   
    if (head == NULL) {
        cout << "Stack Empty   " << endl;
        return(-1);
    }
    else {
        tmp = head;
        d = head->data;
        head = head->next;
        delete tmp;
       
    }
    return(d);
   
}


void stack::display() //display all links
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
    stack q;
    int ret;
    ret = q.pop();
    if (ret >=0 ) {
        cout << "stack out = " << ret << endl;
    }
    q.push(56);
    q.push(23);
    q.push(87);

    ret = q.pop();
    if (ret >=0 ) {
        cout << "stack out = " << ret << endl;
    }
    
    ret = q.pop();
    if (ret >=0 ) {
        cout << "stack out = " << ret << endl;
    }
   
    q.display();
    
    return 0;
}