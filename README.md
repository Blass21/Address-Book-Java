# Java-Swing-Address-Book
Functional Address Book GUI in Java

Base Tutorial:
http://www.wideskills.com/java-tutorial/java-swing-address-book



# Description:
  This is a Java Application that acts like an Agenda for personal contacts. It has a graphical interface that uses Swing objects. Its main purpose is to allow user to save their contacts without ever having to open the Ms-Access Database. It is posible to connect it to any tipe of database, but I have chosen Ms-Access because it can be stored locally.
  In order to connect Java with MS-Access, I have used UCanAccess and packed the required jars into the final application.
  The GUI containts text fields that correpsond to table names (name, address, phone, email), with name being compulsory.
  
#Instructions:

The application comes with an Access Database("contacts.accdb") that has to implicitly be stored on Desktop. (this is to make sure that the data is consistent and the user doesn't accidentaly use other files). An option would be to have the user select the location of the file.

After introducing the desired data, the user can press the button SAVE to add a new contact to the database.
The user can insert a name and use the button Search by name. The user will then be presented an option list with all the matching results. After selecting the desired one, he will be able to see the contact details associated with that name.
After Searching and selecting a contact, the user can edit the details and press UPDATE or simply press DELETE to erase all data.


  

