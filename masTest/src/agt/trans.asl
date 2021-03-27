// Agent trans in project masTest

/* Initial beliefs and rules */


/* Initial goals */



/* Plans */
+!translate : goo[source(textExtractor)]<-.print("translating started!").

+say(V)[source(textExtractor)] : true <-setValue1(V); .print(say(V)).

+textVal1(V): not .empty(V) <- translatex(V).

+textVal2(V2):not .empty(V2) & .string(V2)<- .print("translation:",V2);.term2string(X,V2);.send(ethicalEvaluator, tell, gooo); .send(ethicalEvaluator, tell, say(X)).


{ include("$jacamoJar/templates/common-cartago.asl") }
{ include("$jacamoJar/templates/common-moise.asl") }
{ include("$jacamoJar/templates/org-obedient.asl") }


