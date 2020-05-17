# STOCK_Market_version2
## Patterns Chosen

The patterns chosen for this project are Observer, Iterator and Singleton

* Observer Design Pattern

According to Howtodoinjava(2016) the observer pattern defines a one-to-many dependency between objects as a result when one object changes state, all its dependents are notified and updated automatically. 

In observer pattern, there are many observers (subscriber objects) that are observing a particular subject (publisher object). Observers register themselves to a subject to get a notification when there is a change made inside that subject.

A observer object can register or unregister from subject at any point of time. It helps is making the objects objects loosely coupled.

* * For all the caracteristics mentioned above I chose the Observer Pattern for the company, to keep track ok the information that will be updated , also to update and check the updated values for a few fields.



* Iterator Pattern
I chose to have the investor as iterator for the following reasons

As stated by Howtodoinjava(2016) the behavioral design pattern iterator provides a way to access the elements of an aggregate object sequentially without exposing its underlying representation.  iterator helps in traversing the collection of objects in a defined manner which is useful the client applications. During iteration, client programs can perform various other operations on the elements as per requirements.

* * As shown on the code those are the necessary participants of iterator pattern 

Iterator: An interface to access or traverse the elements collection. Provide methods which concrete iterators must implement.
For example the InvestorIteratorInterface

ConcreteIterator: implements the Iterator interface methods. It can also keep track of the current position in the traversal of the aggregate collection.
For example the InvestorIterator that implements the InvestorIteratorInterface

Aggregate: It is typically a collection interface which defines a method that can create an Iterator object.
For example InvestorCollectionInterface

ConcreteAggregate: It implements the Aggregate interface and its specific method returns an instance of ConcreteIterator.
For exampple the InvestorCollection


* Singleton 
Singleton pattern is a design solution where an application wants to have one and only one instance of any class, in all possible scenarios without any exceptional condition





# REFERENCES 
https://howtodoinjava.com/design-patterns/behavioral/
