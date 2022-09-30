/***
 * Functions for the DMV customer scheduling and service application.
 * Interface file.
 ***/
#include <iostream>
#include "DMVSchedule.h"
using namespace std;

//Constructor - initialize data members
// 1. ProTip -- implement contructor and destructor first.
DMV::DMV()
{
	// Initialize the tickNumber and the serviceLines array.
	// Remember that the index to the array is not the same as the priority value.
	//Your code here
	ticketNumber = 0;
	serviceLines[0] = new ServiceLine(priorityA);
	serviceLines[1] = new ServiceLine(priorityB);
	serviceLines[2] = new ServiceLine(priorityC);
}

//Destructor
//Clean up data
// 1. ProTip -- implement contructor and destructor first.
DMV::~DMV()
{
	//Your code here
	delete serviceLines[2];
	delete serviceLines[1];
	delete serviceLines[0];
}

//Takes a priority enum and returns the array index
//This is implemented for you.  Do not change
int DMV::PriorityToIndex(t_priority the_priority)
{
	return ((int)the_priority -1);
}

//Create a new ticket - increments the next ticket number by one
// 4. ProTip -- implement this as the 4th item. Note that this
//    only does ticket numbers -- nothing else.
int DMV::CreateNewTicket()
{
	//Your code here
	ticketNumber++;
	return ticketNumber;
}

//Get the customer count for ALL the service lines. Return the total
//In line is empty, return NO_CUSTOMER
// 3. ProTip -- Implement this method right after implementing the GetCustomerCount(priority)
//    Note -- you may want to do the CheckNextCustomer at this point (Step 9).
//    The unit tests use CheckNextCustomer to verify that the queues are in the
//    correct order.
int DMV::GetCustomerCount()
{
	int count = 0;
	int indexA = PriorityToIndex(priorityA);
	int indexB = PriorityToIndex(priorityB);
	int indexC = PriorityToIndex(priorityC);
	if(serviceLines[indexA] -> GetCustomerCount() == 0){
		return NO_CUSTOMER;
	} else if (serviceLines[indexB] -> GetCustomerCount() == 0){
		return NO_CUSTOMER;
	} else if (serviceLines[indexC] -> GetCustomerCount() == 0){
		return NO_CUSTOMER;
	} else {
		count += GetCustomerCount(priorityA);
		count += GetCustomerCount(priorityB);
		count += GetCustomerCount(priorityC);
	}
	return count;
}

//Get the customer count for the specified service line.  
//If the line is empty, return NO_CUSTOMER
// 2. ProTip -- implement this right after the constructor and destructor
//    then use it to implement the above method.
int DMV::GetCustomerCount(enum t_priority priority)
{
	//Your code here
	int index = PriorityToIndex(priority);
	if(serviceLines[index] -> GetCustomerCount() == 0){
		return NO_CUSTOMER;
	}
	return serviceLines[index] -> GetCustomerCount();	
}


//Serve the next HIGHEST PRIORITY customer.  return the ticket# served
//Remember that priorityA is the highest, priorityC is the lowest
//If no customers in any line, return NO_CUSTOMER
// 6. ProTip -- first this by implementing the NO_CUSTOMER case.
// 8. ProTip -- after implementing the ServeNextCustomer(priority)
//    then add logic to see how many customers are in the highest
//    priority queue and serve that customer.
//    When done with these methods you should not have any memory leaks
//    because the ServiceLine ServeCustomer method frees the object.
int DMV::ServeNextCustomer()
{
	//Your code here
	int total = GetCustomerCount();
	if(total = 0){
		return NO_CUSTOMER;
	} else {
		int indexA = PriorityToIndex(priorityA);
		if(serviceLines[indexA] -> GetCustomerCount() == 0){
			int indexB = PriorityToIndex(priorityB);
			if(serviceLines[indexB] -> GetCustomerCount() == 0){
				return serviceLines[PriorityToIndex(priorityC)] -> ServeCustomer();
			} else {
				return serviceLines[indexB] -> ServeCustomer();
			}
		} else {
			return serviceLines[indexA] -> ServeCustomer();
		}
	}	
}

//Serve the next customer of the specified priority. return the ticket# served
//If no customers in the line, return NO_CUSTOMER
// 7. ProTip Implement this and use it in the ServeNextCustomer() method.
//    Review the methods in ServiceLine when implementing this method.
int DMV::ServeNextCustomer(t_priority the_priority)
{
	//Your code here
	int index = PriorityToIndex(the_priority);
	if(serviceLines[index] -> GetCustomerCount() == 0){
		return NO_CUSTOMER;
	} else {
		return serviceLines[index] -> ServeCustomer();
	}
}

//Add customer to specified line.
// 5. ProTip Implement this after implementing CreateNewTicket.
//    Note that you have methods in ServiceLine that are important
//    for this method -- You will now have memory leaks until you 
//    implement ServeNextCustomer methods.
void DMV::AddNewCustomer(t_priority the_priority)
{
	//Your code here
	int index = PriorityToIndex(the_priority);
	CreateNewTicket();
	serviceLines[index] -> AddNewCustomer(ticketNumber);
} 

//Get ticket # of the customer @ the head of the requested line
//If no customers, return NO_CUSTOMER
// 9. ProTip -- implement this last. I was able to implement the whole
//    solution without this method. 
int DMV::CheckNextCustomer(t_priority the_priority)
{
	//Your code here
	int index = PriorityToIndex(the_priority);
	if(serviceLines[index] -> GetCustomerCount() == 0){
		return NO_CUSTOMER;
	}
	return serviceLines[index] -> GetNextCustomer() -> GetTicketNumber();
}


