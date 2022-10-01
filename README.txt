Interface Segregation Principle
I implemented the Interface Segregation Principle within my Player classes. Because there are two different game types of war where the player either puts the cards they win in their current deck or puts the cards they win in a seperate storage deck I implemented two different interfaces of Players. The first Player interface includes all the default methods that every single player class will use, no matter which game type, and the second Player class StorablePlayer includes the methods required to store the cards they win in a seperate deck.

Single Responsibility Principle
An example of how I implemented the single responsibility principle lies within my Card class. The class simply serves as a way to store a suit and value of a card and retrieve those values. The implementation of the Card class is short and does not include any methods beyond what a playing card should be responsible for.

Open Closed Principle
An example of how I implemented the Open / Close principle would be my War interface and War implementations of that interface. The War interface provides default methods for the classic mode of war and defines the methods that must be implemented that are different based on game mode. Any new war game that implements the interface can overide any default methods or use them. The implementation is not set in stone and can be changed by any new classes by overide or extension. The source code for war does not need to be changed for new war games to be implemented.

Liskov Substitution Principle
In my implentation of my war subclasses that implement the War interface, you can see in my Main class you can use any subclass of War in the definition of the War object. This means that we are properly implementing the Liskov Substitution Principle as either subclass can be used without causing an error. All implentations of the War interface follow the same rules so each implementation can be used interchangably.