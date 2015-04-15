README

I. File list
------------
Included:
 - All source files (.src, .sh)
 - README
 - Directory Structure
    -- src/ 
         ---- CricketOntology.owl
         ---- *.rq files: Queries
         ---- script.sh
    -- lib/ 
    -- classes/
    -- PDF Files: To help understand the Ontology
        -- ClassesAndSubclass.pdf: This pdf displays all the classes and subclasses used for this ontology
        -- StructureofIndividuals.pdf: This pdf depicts the structure of individuals of the classes
        -- RelationBetweenIndividuals: This pdf depicts the relationships via which the individuals of the 
                                       classes are connected. 


II. About the ontology
----------
- The ontology is about Cricket game. Through this Ontology, I have tried to model the game of cricket.
It depicts the format of the game. Through the ontology Users can get to know how the game is played

- The Ontology consists of Sport as one of the classes. Cricket is an instance of the sport class. Cricket game  has a match between different teams, and so the Match class. As an example, in the ontology, I am using South Africa VS India match.

- SouthAfricaVSIndia is an individual of the Match class. Match class has its data properties such as: the Match Type, Match location, date, Teams between whom the match is being played and its umpires.

- SouthAfricaVSIndia match has relations to:
    - MatchType: 50-50 Overs match
    - Match Between Teams: South Africa, India
    - Match Umpires: Relationships to Field and TV Umpires

- The participating Teams, also have relations to its players:
    - South Africa : Has relations to the individuals of the Player class
    - India : Has relations to the individuals of the Player class
The Teams and Players, both have their data properties.   

- Please refer the PDFs to better understand the Ontology
        -- ClassesAndSubclass.pdf:      This pdf displays all the classes and subclasses used for this ontology
        -- StructureofIndividuals.pdf:  This pdf depicts the structure of individuals of the classes
        -- RelationBetweenIndividuals:  This pdf depicts the relationships via which the individuals of the 
                                        classes are connected. 

    
 
III. To run
----------
- Navigate to the src of program folder
{Eg: /wherever_the_program_is_stored/Project3/src}

- Execute the following command: sh script.sh
  This shell script queries the ontology.  
  Say for example: 
  - We need to find the details of the match. The query which retrieves these details is stored in the getMatchDetails.rq file.

  - In the shell script, for the correponding choice, the sparql query is executed, by invoking it as follows:
  {path to Apache Jena}/bin/sparql --data=CricketOntology.owl --query=getMatchDetails.rq
  
  - In case of UML, the path to Apache Jena was found to be : /opt/jena-2.10   
    If this is not the path, please rectify the path in script.sh for each of the choice.


III. Sample output
----------
{/path to the project src folder/}{user}$ sh script.sh
 ** This program performs different queries on the Cricket Ontology **


Following is the high-level structure of Cricket Ontology: 
Sport               (Class)     -->     hasInstanceOf   (Object Property)        -->     Match(Class)
Match               (Class)     -->     Individual                               -->     SouthAfricVSIndia
SouthAfricVSIndia   (Class)     -->     hasMatchBetween (Object Property)        -->     SouthAfrica, India
SouthAfricVSIndia   (Class)     -->     hasFieldUmpire  (Object Property)        -->     Aleem Dar, RA Kettleborough
SouthAfricVSIndia   (Class)     -->     hasTVUmpire     (Object Property)       -->     SJ Davis
SouthAfricVSIndia   (Class)     -->     hasMatchType    (Object Property)       -->     50OversMatch
South Africa        (Class)     -->     hasPlayer       (Object Property)       -->     Player1...Player11
India               (Class)     -->     hasPlayer       (Object Property)       -->     Player1...Player11


Please select any one of the options to query Cricket OWL:
1. Match details
2. Players' Info
3. Teams
4. Players according to Teams
5. List of all batsman
6. List of all bowlers
7. List of all allrounders
8. Top 3 batsman from Teams(i.e. batsman with highest runs)
9. Top 3 bowlers from Teams(i.e. bowlers with highest wickets)
10. Exit
Enter your choice:1

Following are the match details: 
--------------------------------------------------------------------
| property                | value                                  |
====================================================================
| cricket:MatchDate       | "22 February 2015"^^xsd:string         |
| cricket:MatchLocation   | "Melbourne Cricket Ground"^^xsd:string |
| cricket:hasFieldUmpire  | cricket:AleemDar                       |
| cricket:hasFieldUmpire  | cricket:RA_Kettleborough               |
| cricket:hasMatchBetween | cricket:India                          |
| cricket:hasMatchBetween | cricket:SouthAfrica                    |
| cricket:hasMatchType    | cricket:50Overs                        |
| cricket:hasTVUmpire     | cricket:SJ_Davis                       |
| rdf:type                | cricket:Match                          |
| rdf:type                | owl:NamedIndividual                    |
--------------------------------------------------------------------


1. Match details
2. Players' Info
3. Teams
4. Players according to Teams
5. List of all batsman
6. List of all bowlers
7. List of all allrounders
8. Top 3 batsman from Teams(i.e. batsman with highest runs)
9. Top 3 bowlers from Teams(i.e. bowlers with highest wickets)
10. Exit
Enter your choice:10


Exiting...!!!