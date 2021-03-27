// Agent employee in project masTest

/* Initial beliefs and rules */

/* Initial goals */


/* Plans */


+!response : start[source(client)] <- .send(client,tell,yes);.send(textExtractor,tell,go).

+send : textVal(V) <-.send(client,tell,V); .send(textExtractor,tell,say(V)); .print(V).

+note(V)[source(monitor)]:true<- .print("received from monitor: ",V).


{ include("$jacamoJar/templates/common-cartago.asl") }
{ include("$jacamoJar/templates/common-moise.asl") }
{ include("$jacamoJar/templates/org-obedient.asl") }


