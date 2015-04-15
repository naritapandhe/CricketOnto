import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintStream;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.ontology.OntResource;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.ResultSetFormatter;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.util.FileManager;
import com.hp.hpl.jena.util.iterator.ExtendedIterator;

public class CricketRDF {

	File f=new File("/Users/admin/Documents/workspace/Project3/src/CricketOntology.owl");
	/**
	 * This method retrieves information of all the players
	 * 
	 */
	public void getAllPlayers() {
		try {

			InputStream in = new FileInputStream(this.f);
			Model model = ModelFactory.createMemModelMaker().createDefaultModel();
			model.read(in, null);
			in.close();

			String queryString = 
					"  PREFIX rdf: 	<http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
					+ "PREFIX owl: 	<http://www.w3.org/2002/07/owl#> "
					+ "PREFIX xsd: 	<http://www.w3.org/2001/XMLSchema#> "
					+ "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
					+ "PREFIX my: 	<http://www.semanticweb.org/admin/ontologies/2015/2/11/cricket#> "
					+ "SELECT ?sub ?PlayerName ?PlayerType "
					+ "		WHERE{"
					+ "		?sub rdf:type my:Player . "
					+ "		?sub my:PlayerName ?PlayerName ."
					+ "		?sub my:PlayerType ?PlayerType ." 
					+ "		}";

			com.hp.hpl.jena.query.Query q = QueryFactory.create(queryString);
			QueryExecution qe = QueryExecutionFactory.create(q, model);
			ResultSet results = qe.execSelect();
			while (results.hasNext()) {
				
				ResultSetFormatter.out(System.out, results, q);

			}

			qe.close();
		} catch (Exception e) {

		}

	}
	
	/**
	 * Retrieves all the teams from the Ontology
	 * 
	 */
	public void getAllTeams(){
		try{

			InputStream in = new FileInputStream(this.f);
			Model model = ModelFactory.createMemModelMaker().createDefaultModel();
			model.read(in, null);
			in.close();

			String queryString = 
					"  PREFIX rdf: 	<http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
					+ "PREFIX owl: 	<http://www.w3.org/2002/07/owl#> "
					+ "PREFIX xsd: 	<http://www.w3.org/2001/XMLSchema#> "
					+ "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
					+ "PREFIX my: 	<http://www.semanticweb.org/admin/ontologies/2015/2/11/cricket#> "
					+ " SELECT ?Teams"
					+ "		WHERE { "
					+ "		?Teams rdf:type my:Team . "
					+ "		}";

			com.hp.hpl.jena.query.Query q = QueryFactory.create(queryString);
			QueryExecution qe = QueryExecutionFactory.create(q, model);
			ResultSet results = qe.execSelect();
			while (results.hasNext()) {
				
				ResultSetFormatter.out(System.out, results, q);

			}

			qe.close();
			
		}catch(Exception e){
			
		}
	}

	/**
	 * Retrieves players of each team
	 * 
	 */
	public void getPlayersOfTeam(){
		try{
			
			InputStream in = new FileInputStream(this.f);
			Model model = ModelFactory.createMemModelMaker().createDefaultModel();
			model.read(in, null);
			in.close();

			String queryString = 
					"  PREFIX rdf: 	<http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
					+ "PREFIX owl: 	<http://www.w3.org/2002/07/owl#> "
					+ "PREFIX xsd: 	<http://www.w3.org/2001/XMLSchema#> "
					+ "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
					+ "PREFIX my: 	<http://www.semanticweb.org/admin/ontologies/2015/2/11/cricket#> "
					+ "	select * " 
					+ " where " 
					+ " { "
					+ "		?s rdf:type my:Team ."
					+ "		OPTIONAL { ?s my:hasPlayer ?o  } . " 
					+ "	} " ;


			com.hp.hpl.jena.query.Query q = QueryFactory.create(queryString);
			QueryExecution qe = QueryExecutionFactory.create(q, model);
			ResultSet results = qe.execSelect();
			while (results.hasNext()) {
				
				ResultSetFormatter.out(System.out, results, q);

			}

			qe.close();

			
		}catch(Exception e){
			
		}
	}

	/**
	 * Retrieves details of a particular match
	 * 
	 */
	public void getMatchDetails(){
		try{
			
			InputStream in = new FileInputStream(this.f);
			Model model = ModelFactory.createMemModelMaker().createDefaultModel();
			model.read(in, null);
			in.close();

			String queryString = 
					"  PREFIX rdf: 	<http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
					+ "PREFIX owl: 	<http://www.w3.org/2002/07/owl#> "
					+ "PREFIX xsd: 	<http://www.w3.org/2001/XMLSchema#> "
					+ "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
					+ "PREFIX my: 	<http://www.semanticweb.org/admin/ontologies/2015/2/11/cricket#> "
					+ " select distinct ?property ?value where { "
					+ "	my:Match1 ?property ?value . "
					+ "	} ORDER BY ?property ";


			com.hp.hpl.jena.query.Query q = QueryFactory.create(queryString);
			QueryExecution qe = QueryExecutionFactory.create(q, model);
			ResultSet results = qe.execSelect();
			while (results.hasNext()) {
				
				ResultSetFormatter.out(System.out, results, q);

			}

			qe.close();

			
		}catch(Exception e){
			
		}
	}

	
	/**
	 * Retrieves details of a particular match
	 * 
	 */
	public void getAllBatsmen(){
		try{
			
			InputStream in = new FileInputStream(this.f);
			Model model = ModelFactory.createMemModelMaker().createDefaultModel();
			model.read(in, null);
			in.close();

			String queryString = 
					"  PREFIX rdf: 	<http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
					+ "PREFIX owl: 	<http://www.w3.org/2002/07/owl#> "
					+ "PREFIX xsd: 	<http://www.w3.org/2001/XMLSchema#> "
					+ "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
					+ "PREFIX my: 	<http://www.semanticweb.org/admin/ontologies/2015/2/11/cricket#> "
					+ "	SELECT ?sub ?PlayerName ?PlayerType ?Team " 
					+ "	WHERE { "
					+ "	?sub rdf:type my:Player . " 
					+ "	?sub my:PlayerName ?PlayerName ."
					+ "	?sub my:PlayerType ?PlayerType ."
					+ " ?sub my:isPlayerOf ?Team ."
					+ "	FILTER regex(?PlayerType,'^Batsman','i') "
					+ "	} "
					+ " ORDER BY ?PlayerName ";


			com.hp.hpl.jena.query.Query q = QueryFactory.create(queryString);
			QueryExecution qe = QueryExecutionFactory.create(q, model);
			ResultSet results = qe.execSelect();
			while (results.hasNext()) {
				
				ResultSetFormatter.out(System.out, results, q);

			}

			qe.close();

			
		}catch(Exception e){
			
		}
	}

	/**
	 * Retrieves details of a particular match
	 * 
	 */
	public void getAllBowler(){
		try{
			
			InputStream in = new FileInputStream(this.f);
			Model model = ModelFactory.createMemModelMaker().createDefaultModel();
			model.read(in, null);
			in.close();

			String queryString = 
					"  PREFIX rdf: 	<http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
					+ "PREFIX owl: 	<http://www.w3.org/2002/07/owl#> "
					+ "PREFIX xsd: 	<http://www.w3.org/2001/XMLSchema#> "
					+ "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
					+ "PREFIX my: 	<http://www.semanticweb.org/admin/ontologies/2015/2/11/cricket#> "
					+ "	SELECT ?sub ?PlayerName ?PlayerType ?Team" 
					+ "	WHERE { "
					+ "	?sub rdf:type my:Player . " 
					+ "	?sub my:PlayerName ?PlayerName ."
					+ "	?sub my:PlayerType ?PlayerType ."
					+ " ?sub my:isPlayerOf ?Team ."
					+ "	FILTER regex(?PlayerType,'^Bowler','i') "
					+ "	} "
					+ " ORDER BY ?PlayerName ";


			com.hp.hpl.jena.query.Query q = QueryFactory.create(queryString);
			QueryExecution qe = QueryExecutionFactory.create(q, model);
			ResultSet results = qe.execSelect();
			while (results.hasNext()) {
				
				ResultSetFormatter.out(System.out, results, q);

			}

			qe.close();

			
		}catch(Exception e){
			
		}
	}

	/**
	 * Retrieves details of a particular match
	 * 
	 */
	public void getAllRounder(){
		try{
			
			InputStream in = new FileInputStream(this.f);
			Model model = ModelFactory.createMemModelMaker().createDefaultModel();
			model.read(in, null);
			in.close();

			String queryString = 
					"  PREFIX rdf: 	<http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
					+ "PREFIX owl: 	<http://www.w3.org/2002/07/owl#> "
					+ "PREFIX xsd: 	<http://www.w3.org/2001/XMLSchema#> "
					+ "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
					+ "PREFIX my: 	<http://www.semanticweb.org/admin/ontologies/2015/2/11/cricket#> "
					+ "	SELECT ?sub ?PlayerName ?PlayerType ?Team" 
					+ "	WHERE { "
					+ "	?sub rdf:type my:Player . " 
					+ "	?sub my:PlayerName ?PlayerName ."
					+ "	?sub my:PlayerType ?PlayerType ."
					+ " ?sub my:isPlayerOf ?Team"
					+ "	FILTER regex(?PlayerType,'^Allrounder','i') "
					+ "	} "
					+ " ORDER BY ?PlayerName ";


			com.hp.hpl.jena.query.Query q = QueryFactory.create(queryString);
			QueryExecution qe = QueryExecutionFactory.create(q, model);
			ResultSet results = qe.execSelect();
			while (results.hasNext()) {
				
				ResultSetFormatter.out(System.out, results, q);

			}

			qe.close();

			
		}catch(Exception e){
			
		}
	}

	
	/**
	 * Retrieves details of a particular match
	 * 
	 */
	public void test(){
		try{
			 System.out.println("in tets");
			 
		     // create the base model
			 InputStream in = FileManager.get().open(this.f.toString());
				
					     
		    OntModel base = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
		    base.read( in, "RDF/XML" );
		 
		    // create an empty model
		    if (in == null) {
		        throw new IllegalArgumentException("File not found");
		    }

		    String NS = "http://www.semanticweb.org/admin/ontologies/2015/2/11/cricket#";
		    
		    OntClass playerClass = base.getOntClass( NS + "Player" );
		    OntResource teamIndiaClass = base.getOntResource(NS + "India");
		    Individual p1 = base.createIndividual( NS + "AmbatiRayudu", playerClass );
	     
		    ObjectProperty hasPlayerProperty = base.getObjectProperty(NS + "hasPlayer");
		    ObjectProperty isPlayerOf = base.getObjectProperty(NS + "isPlayerOf");
		    
		    Property playerName = base.getDatatypeProperty(NS + "PlayerName");
		    Property playerType = base.getDatatypeProperty(NS + "PlayerType");
		    Property playerRuns = base.getDatatypeProperty(NS + "Runs");
		    
		    
		    p1.addLiteral(playerName, "Ambati Rayudu");
		    p1.addLiteral(playerType, "Batsman");
		    p1.addLiteral(playerRuns, 0);
		    p1.addProperty(isPlayerOf, teamIndiaClass);
		    
		    base.add(teamIndiaClass, hasPlayerProperty, p1);
		    ExtendedIterator instances = base.listIndividuals();
	        while(instances.hasNext())
	        {
	            Individual ind = (Individual) instances.next();
	            String indName = ind.getLocalName().toString();
	            System.out.println("Name: "+indName);
	            System.out.println("Type: "+ind.getRDFType().toString());
	            for (StmtIterator j = ind.listProperties(); j.hasNext(); ) {
                    Statement s = j.next();
                    System.out.print( "    " + s.getPredicate().getLocalName() + " -> " );

                    if (s.getObject().isLiteral()) {
                        System.out.println( s.getLiteral().getLexicalForm() );
                    }
                    else {
                        System.out.println( s.getObject() );
                    }
                }
	        }     
	        
	        base.write( System.out,"RDF/XML");
	      			
		}catch(Exception e){
			
		}
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			CricketRDF cricketRDF=new CricketRDF();
		
			/*System.out.println("All players: ");
			cricketRDF.getAllPlayers();

			System.out.println("All teams: ");
			cricketRDF.getAllTeams();
			
			System.out.println("Players according to the teams: ");
			cricketRDF.getPlayersOfTeam();

			System.out.println("Match details: ");
			cricketRDF.getMatchDetails();
			
			System.out.println("All batsmen ");
			cricketRDF.getAllBatsmen();

			System.out.println("All bowlers: ");
			cricketRDF.getAllBowler();

			System.out.println("All allrounders: ");
			cricketRDF.getAllRounder();*/
			cricketRDF.test();

		} catch (Exception e) {

		}

	}

}
