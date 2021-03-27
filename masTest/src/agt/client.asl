// Agent client in project masTest

/* Initial beliefs and rules */

/* Initial goals */


/* Plans */

+!request    : focused(jacamo,gui1,ArtId) <- .send(employee,tell,start).

+send : textVal(V) <- .send(employee,tell,V);.print(V).

{ include("$jacamoJar/templates/common-cartago.asl") }
{ include("$jacamoJar/templates/common-moise.asl") }
{ include("$jacamoJar/templates/org-obedient.asl") }

