/*
 *  node_delete.cpp
 *
 *  Created on: Sep 30, 2014
 *  Author: Apoorva.D.A
 */
#include <cstdlib>
#include <iostream>

using namespace std;

struct node { //Struct Node definition for Binary Tree
	int value;
	node* left;
	node* right;
};

class Bintree{
private:
	node* rootNode;
public:
	Bintree()	//no-argument constructor
	{
		rootNode = NULL;
	}
	node *insert(node *s, int key);
	node *min_element(node *s);
	void preTraverse(node *s);
	node *delete_node(node *s,int key);
	void postTraverse(node *s);
	void inTraverse(node *s);
};

//Function to find the minimum element in the tree
node *Bintree::min_element(node *rootNode){
	if(rootNode == NULL){
		cout << "Empty tree\n";
	}
	else if(rootNode->left == NULL){
		return rootNode;
	}
	return min_element(rootNode->left); //recursively traverse left subtree
}

//Function to insert a node while creating the Binary Search tree
node *Bintree::insert(node *rootNode,int key) {
	// Creates new node
	if(rootNode==NULL) {
		rootNode=new node;
		rootNode->value=key;
		rootNode->left=NULL;
		rootNode->right=NULL;
	} else if (key > rootNode->value) {
			rootNode->right = insert(rootNode->right,key);
	} else {
			rootNode->left = insert(rootNode->left,key);
	}
	return (rootNode);
}

//Function to display pre order Traversal to verify the results of tree modification
void Bintree::preTraverse(node *rootNode){
	if (rootNode != NULL ){
		cout << rootNode->value << "->";
		preTraverse(rootNode->left);
		preTraverse(rootNode->right);
	}
}

//Function to display post order Traversal 
void Bintree::postTraverse(node *rootNode){
	if (rootNode != NULL ){
		postTraverse(rootNode->left);
		postTraverse(rootNode->right);
		cout << rootNode->value << "->";
	}
}

//Function to display in order Traversal 
void Bintree::inTraverse(node *rootNode){
	if (rootNode != NULL ){
		inTraverse(rootNode->left);
		cout << rootNode->value << "->";
		inTraverse(rootNode->right);
	}
}

//Function to find the maxDepth
int Bintree::maxDepth(node *node){
	if(node == NULL){
		return 0;
	}
	if ((node->left==NULL) && (node->right==NULL))
	{
		return 0;
	}
	int leftDepth = maxDepth(node->left);
	int rightDepth = maxDepth(node->right);

	if(leftDepth > rightDepth){
		return(leftDepth+1);
	} else {
		return(rightDepth+1);
	}
}

//Function to find treeSize
int Bintree::treeSize(Node *rootNode){
	if (rootNode == NULL)
	{
		return 0;
	} else {
		return treeSize(rootNode -> left) + 1 + treeSize(rootNode -> right);
	}
}

//Function to display Breadth First Search



//Function to delete a node from the tree
node* Bintree::delete_node(node *rootNode, int key){
	node *tmp;
	if (rootNode == NULL) {
		return rootNode;
	}
	//Traverse left if the key is less than rootNode
	else if (key < rootNode->value){
		rootNode->left = delete_node(rootNode->left,key);
	}
	//Traverse right if the key is greater than rootNode
	else if (key > rootNode->value){
		rootNode->right = delete_node(rootNode->right,key);
	}
	else {
		//case1 : leaf node with no children
		if (rootNode->left == NULL && rootNode->right == NULL){
			delete rootNode;
			rootNode = NULL;
		}
		//case2 : If there is only one child ; if the left child is NULL
		else if (rootNode->left == NULL){
			tmp = rootNode;
			rootNode = rootNode->right; //link the parent node to right child
			delete tmp;
		}
		// If there is only one child; if right child is NULL
		else if (rootNode->right == NULL){
			tmp = rootNode;
			rootNode = rootNode->left; //link the parent node to left child
			delete tmp;
		}
		// case3 : If there are two children
		else {
			tmp = min_element(rootNode->right);//get the minimum element of the right subtree
			rootNode->value = tmp->value; //swap it with the node to be deleted
			rootNode->right = delete_node(rootNode->right,tmp->value); //delete the node
		}
	}
	return rootNode;
}

//Main function
int main() {
	Bintree bt;
	node *start = NULL;
	node *min;
	//Creating the binary tree by inserting given elements
	start = bt.insert(start,12);
	start = bt.insert(start,54);
	start = bt.insert(start,34);
	start = bt.insert(start,76);
	start = bt.insert(start,46);
	start = bt.insert(start,2);
	start = bt.insert(start,18);
	start = bt.insert(start,38);
	start = bt.insert(start,23);
	start = bt.insert(start,11);
	start = bt.insert(start,9);
	start = bt.insert(start,87);
	start = bt.insert(start,33);
	start = bt.insert(start,65);
	//Displaying the Binary subtree
	cout << "Given Binary Search Tree\n";
	bt.preTraverse(start);
	//Deleting node 54
	start = bt.delete_node(start,54);
	cout << "\nAfter deleting node 54\n";
	bt.preTraverse(start);
}
