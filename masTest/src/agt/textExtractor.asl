// Agent textExtractor in project masTest

/* Initial beliefs and rules */

/* Initial goals */



/* Plans */

+!extract: go[source(employee)]<-.print("extracting");.send(trans,tell,goo).
+send : textVal(V) <-.send(trans,tell,say(V)); .print(V).

{ include("$jacamoJar/templates/common-cartago.asl") }
{ include("$jacamoJar/templates/common-moise.asl") }
{ include("$jacamoJar/templates/org-obedient.asl") }


