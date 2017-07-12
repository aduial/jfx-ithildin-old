# ithildin
Front-end JavaFX application for the Eldamo database

This first demo version consists of only one simple screen that searches a view named "simplexicon" created on FORM, GLOSS, 
LANGUAGE and CATEGORY. It searches on either the FORM or GLOSS for a given LANGUAGE; there's a dropdown list in the form to choose 
a language.

TODO for the Omentielva (Roman's presentation): 

- when the user picks a certain entry, retrieve and display additional information about that entry (1) 
- create one or more (probably mocked-up) screens to illustrate how we think the application could also be used to:
-- admin functions for the (curated) central reference database: edit the data, add new entries or correct existing ones (2); 
-- functionality to synchronise the user's database with the central reference database; 
-- functionality to upload suggestions to the central reference database (to be reviewed before adding);
-- for the local user to add their own private entries (reconstructions etc.); 
-- functionality to export / share such private entries with other users;
-- functionality to import such private entries received from others
-- <open for suggestions>

If you want to join this development let me know via the Skype discussion group or on the Languages of Middle-Earth group.

Enjoy!


= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = 

(1) this should be similar to how the entries are displayed on Eldamo.org, but not as extensive. 
This application serves a different goal as the corresponding Eldamo page (e.g. as an aid in writing poetry). 
We can, however, display a link to that page as a referral, because the Eldamo page id is available in the database. 

(2) it is not clear at this point how to implement this central database, or whom should curate this. The easiest possibility 
would be to stick to the Eldamo data set and keep using that as the reference set, but possibly people should want to fork it
and create a separate central database. It's not clear at this point what everybody wants, or what even would be doable. 
Suggestions are more than welcome here as well, and it's probably best to discuss this on the Languages of Middle-Earth Google 
group instead of, say, adding comments here on Github. 
