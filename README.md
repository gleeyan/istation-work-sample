# Work Sample for iStation
> 1) Create a software design for a basic vending machine. What are the functional components of the user interface? What are the possible states of the vending machine, and what are the transitions between those states? What are the functions of the vending machine? Create and submit written descriptions, flowcharts, state diagrams, etc. as necessary to document your design. We’re only interested in the functional design, not the visual/physical design.

The customer needs to be able to add money to the vending machine, order an item, receive change, and request his or her money back without purchasing an item. Requesting the price of an item may also be desirable, and is easily accomplished like a real vending machine: by outputting the item's price when requesting an item you don't have enough money for.

I would not implement the vending machine itself as a state machine. The machine should always be capable of accepting more money, always be capable of (attempting to) order an item/request an item's price, and always be able to return any stored money. Transactions should be completed immediately upon request, returning any change.

That said, it is easy to visualize the input method as being a state machine. A console interface would need a menu to decide what actions to perform: check available items, add cash to the machine, requesting cash back from the machine without spending it, entering an item's key code, and exiting the interface. Both adding money and choosing an item would require a second input prompt, which results in a very small state machine, transitioning between the short states with the stroke of the `Enter` key.

An alternative command line interface would be to use commands, rather than a menu, similar to an operating system's command line. I have not implemented such an interface for my submission, but a sufficiently complicated set of commands can potentially require a sophisticated lexer, which is often a state machine in its own right.

> 2) Write Java code implementing the virtual vending machine you designed. Demonstrate your understanding of object-oriented design and good coding practices.

See [/src](src/) for project source files.

* A `VendingMachine` has a reserve of money, the customer's cash, and zero or more shelves.
* A `Shelf` has zero or more slots
* A `Slot` has a key code, a price, and zero or more items
* A `VendingMachineItem` has a name

These four interfaces and their implementations form the core of the code sample. The remaining classes manipulate them, transport data between them, assist in displaying them, or test them.

> 3) Write a command-line test program that allows a user to test your vending machine. The user should be able to see a list of snacks/prices, select a snack, put money into the machine, receive money back, etc.

See [/src/bshields/istation/tests](src/bshields/istation/tests/) for test program source files. See [/src/bshields/istation/tests/CommandLineTest.java](src/bshields/istation/tests/CommandLineTest.java) for command-line test entry point.
