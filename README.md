# Work Sample for iStation
> 1) Create a software design for a basic vending machine. What are the functional components of the user interface? What are the possible states of the vending machine, and what are the transitions between those states? What are the functions of the vending machine? Create and submit written descriptions, flowcharts, state diagrams, etc. as necessary to document your design. We’re only interested in the functional design, not the visual/physical design.

The customer needs to be able to add money to the vending machine, order an item, receive change, and request his or her money back without purchasing an item. Requesting the price of an item may also be desirable.

I would not implement the vending machine as a state machine. The machine should always be capable of accepting more money, always be capable of (attempting to) order an item/request an item's price, and always be able to return any stored money. Transactions should be completed immediately upon request, returning any change.

With a graphical interface, the _keypad_ may need state machine logic, differentiating between pressing a key to continue specifying an item vs. ordering a new item (as well as clearing an order in some fashion), but for a console interface as explored in [CommandLineTest.java](src/bshields/istation/tests/CommandLineTest.java), that extra step is unnecessary; they user simply enters the full key code of a desired item all at once. However, with the use of dependency injection, it should be possible to swap out the console keypad behavior for a graphical keypad using a state machine by adding a class for the new keypad and swapping what constructor is used.

> 2) Write Java code implementing the virtual vending machine you designed. Demonstrate your understanding of object-oriented design and good coding practices.

See [/src](src/) for project source files.

> 3) Write a command-line test program that allows a user to test your vending machine. The user should be able to see a list of snacks/prices, select a snack, put money into the machine, receive money back, etc.

See [/src/bshields/istation/tests](src/bshields/istation/tests/) for test program source files. See [/src/bshields/istation/tests/CommandLineTest.java](src/bshields/istation/tests/CommandLineTest.java) for command-line test entry point.
