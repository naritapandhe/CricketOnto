#!/bin/bash
echo -e "\n ** This program performs different queries on the Cricket Ontology **";
echo -e "\n";
echo -e "Following is the high-level structure of Cricket Ontology: ";
echo -e "Sport\t\t\t(Class)\t\t-->\t\thasInstanceOf\t(Object Property)\t\t-->\t\tMatch(Class)";
echo -e "Match\t\t\t(Class)\t\t-->\t\tIndividual\t\t\t\t\t-->\t\tSouthAfricVSIndia";
echo -e "SouthAfricVSIndia\t(Class)\t\t-->\t\thasMatchBetween\t(Object Property)\t\t-->\t\tSouthAfrica, India";
echo -e "SouthAfricVSIndia\t(Class)\t\t-->\t\thasFieldUmpire\t(Object Property)\t\t-->\t\tAleem Dar, RA Kettleborough";
echo -e "SouthAfricVSIndia\t(Class)\t\t-->\t\thasTVUmpire\t(Object Property)\t\t-->\t\tSJ Davis";
echo -e "SouthAfricVSIndia\t(Class)\t\t-->\t\thasMatchType\t(Object Property)\t\t-->\t\t50OversMatch";
echo -e "South Africa\t\t(Class)\t\t-->\t\thasPlayer\t(Object Property)\t\t-->\t\tPlayer1...Player11";
echo -e "India\t\t\t(Class)\t\t-->\t\thasPlayer\t(Object Property)\t\t-->\t\tPlayer1...Player11";
echo -e "\n";
echo -e "Please select any one of the options to query Cricket OWL:";

while :
do

echo "1. Match details";
echo "2. Players' Info";
echo "3. Teams";
echo "4. Players according to Teams";
echo "5. List of all batsman";
echo "6. List of all bowlers";
echo "7. List of all allrounders";
echo "8. Top 3 batsman from Teams(i.e. batsman with highest runs)";
echo "9. Top 3 bowlers from Teams(i.e. bowlers with highest wickets)";
echo "10. Exit";

  
echo -e "Enter your choice:\c";
read CHOICE
echo -e "\n";
case $CHOICE in
		1) echo "Following are the match details: ";
		   /opt/jena-2.10/bin/sparql --data=CricketOntology.owl --query=getMatchDetails.rq
		   echo -e "\n";
		   ;;

		2) echo "Retrieving all players' information:";
		   /opt/jena-2.10/bin/sparql --data=CricketOntology.owl --query=getAllPlayers.rq
		   echo -e "\n";
		   ;;

		3) echo "Retrieving all teams' information:";
		  /opt/jena-2.10/bin/sparql --data=CricketOntology.owl --query=getAllTeams.rq
		   echo -e "\n";
		   ;;

		4) echo "Following are the players according to their teams: ";
		   /opt/jena-2.10/bin/sparql --data=CricketOntology.owl --query=getPlayersOfTeam.rq
		   echo -e "\n";
		   ;;

		5) echo "List of Batsmen: ";
		   /opt/jena-2.10/bin/sparql --data=CricketOntology.owl --query=getAllBatsmen.rq
		   echo -e "\n";
		   ;;

		6) echo "List of Bowlers: ";
		   /opt/jena-2.10/bin/sparql --data=CricketOntology.owl --query=getAllBowlers.rq
		   echo -e "\n";
		   ;;

		7) echo "List of Allrounders: ";
		   /opt/jena-2.10/bin/sparql --data=CricketOntology.owl --query=getAllAllRounders.rq
		   echo -e "\n";
		   ;;

		8) echo "List of Top 3 Batsmen: ";
		   /opt/jena-2.10/bin/sparql --data=CricketOntology.owl --query=getTop3Batsmen.rq
		   echo -e "\n";
		   ;;

		9) echo "List of Top 3 Bowlers: ";
		   /opt/jena-2.10/bin/sparql --data=CricketOntology.owl --query=getTop3Bowlers.rq
		   echo -e "\n";
		   ;;

		*) echo "Exiting...!!!"
		   break;
		   ;;
esac
done


