readMe -- Cecilia Reyes
kcr2118


The Wiki Program is composed of four classes: Article, Library, Menu and LibraryTester. 

The Article class is fairly straightforward: it contains the object article, along with all the relevant attributes associated with it (title, body, references). I opted not to create an ArrayList for the references of each object article, even if they could be inputted in list-form for the sake of simplicity. If I had had to go into them to follow links or something of the sort, then I probably would have made them into an array. I also chose to not have complex methods associated with Article––I wanted to keep its 'integrity' as a stand-alone class, and make it easy for other classes to use it.

The Library class is more complex: it creates only one library, since the assignment only indicated the saving and loading of one library, and its methods involve user actions like adding an article, reading it, deleting it. With the arrayList "articles" comes a method to iterate through them and print them out to the user to see. I also wanted to add a method that told the user when the articles library was empty, so he or she could be prompted to write one instead of being exited from the program. 
I also decided not to include the various constructors for the "articles" arrayList, simply because the way the tester class worked, the user could not have weaseled out of giving a title, body and references to an article when prompted. However, as a way to handle possible errors, it could have been useful to create more constructors. The update and set methods of the Library class go hand in hand with LibraryTester, and I considered adding them directly in the tester class but then figured it made more sense to have such "article-action" methods be found in Library.

Menu was a great idea, which I took from the recitation code, because I had generally not thought to include menus with my past programs, possibly because any text prompts for the user were only one-liners, and never menus proper. The Menu class then became a repository for anything that needed to be presented to the user, and I included some more targeted error handling there as well, which made more sense than having huge try-catch methods. I would also imagine that by isolating Menu, so to speak, from the tester class, it could be easier in the future to both make the user interface prettier and modify any options for the user as the code changes from one Wiki version to another.

LibraryTester was the trickiest to write, perhaps because I did so at the end, with all the components and communicator classes already written. The tester serves as navigation for the user, which hopefully is straight-forward. I made a run() and a separate runLibrary() method because I was unsure as to whether whenever run was called, a new library would be instantiated. I think this is where a static variable would have come in handy, but I wasn't entirely sure this would have the desired effect and run() is, at any rate, not very long.
When I was designing my classes, I also considered breaking off a File class from the tester, because it seemed that it deserved its own, and like tester was already too full of code. However, in the interest of reducing coupling and passing of fileNames or objects, I decided to include the file saving options at the end of Tester.

Lastly, I decided to try all the requirements of the assignment, except for the extra credit, but I didn't have time to fully test the saving/loading. I hope it works!







