// Agent ethicalEval in project masTest

/* Initial beliefs and rules */

/* Initial goals */

/* Plans */

+!evaluate : gooo[source(trans)] <- .print("evaluating").

+say(V)[source(trans)] <- reasoner(V);.print("from trans:",V).

+textVal(V1): not .empty(V1) <- .send(monitor, tell,start);.send(monitor,tell,say(V1)).
+learn(X) : .empty(X) <- startLearning(X); .print("v1 is empty",X).
+rievaluate : say(Xt)[source(trans)] <- reasoner(Xt);.print("rievaluate:",Xt).


{ include("$jacamoJar/templates/common-cartago.asl") }
{ include("$jacamoJar/templates/common-moise.asl") }
{ include("$jacamoJar/templates/org-obedient.asl") }


