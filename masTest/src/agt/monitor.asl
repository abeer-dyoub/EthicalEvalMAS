// Agent monitor in project masTest

/* Initial beliefs and rules */

/* Initial goals */



/* Plans */

+!monitor: start[source(ethicalEvaluator)] <- .print("Monitoring").
+say(V1)[source(ethicalEvaluator)]:true <- .print(V1);.send(employee,tell,note(V1)).

{ include("$jacamoJar/templates/common-cartago.asl") }
{ include("$jacamoJar/templates/common-moise.asl") }
{ include("$jacamoJar/templates/org-obedient.asl") }


