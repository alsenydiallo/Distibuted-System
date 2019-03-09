Author: Alseny Diallo
Email: Alseny.diallo@wsu.edu

Project Overview:
~~~~~~~~~~~~~~~~~

1. File I/O:
---------------------
In this assignment, you will implement a remote procedure interface dictionary application using Java or C++.

1.1. Step 1: Word Validation:
-----------------------------
This file could be downloaded from the class site.

1.2. Application:
-----------------
Step 1: Ask for user’s input
- take a word from user from client application
- send the word to the server application
- search the words file on the server
- tell user whether or not the word is a correctly spelled (consider it correct if you can find it in the words file)
- if the word is not spelled correctly, wait for another input from the user repeat until a correct word is received

logic:
• server provide a remote interface that maintains the data files words.txt and dictionary.txt
• client sends a request which contains a word to server
• upon receiving the request, server performs the same functions as in Assignment 1, i.e., verify the spelling using the words file, and for a valid word, search the dictionary file for the meaning
• server sends the result back to the client (either the description of the word, or simply a message indicating the spelling is wrong)
• server waits for the next request (you may want to design a way to end the application properly)

Step 2: Search MyDictionary
-After the word validation step, use the dictionary.txt file to search for the meaning of the word, and print it out. Check the dictionary_readme file for more information about how to search for words. Both files are available on the course website.


Submitted files:
~~~~~~~~~~~~~~~
MyServer.java:..............(provide remote procedure for client)
MyClient.java:..............(user interface from the rpi from server to look up words from the the dictionary)
MyDictionary.java:..........(interfaces for the dictionary class)
MyDictionaryRemote.java:......(Implement dictionary interface)
client_output.txt:.........(client sample output run)
Readme.txt:...............(This file)

Compile and Run:
~~~~~~~~~~~~~~~~
Import all file.
Including a dictionary.txt and a word.txt file to serve as dictionary

Run application from command line:
First run:
>> rmiregistry &

then start the server
>> javac MyServer.java
>> java Myserver

then start the client
>> javac Myclient.java
>> java Myclient