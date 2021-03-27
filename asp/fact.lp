answer(environmentallyFriendly(product1)).
product(product1).
sensitiveSlogan(environmentallyFriendly(X)) :- product(X).
%unethical(A) :- sensitiveSlogan(A) , notrelevant(A), answer(A).
notrelevant(A) :- not relevant(A) , answer(A).
notSensitiveSlogan(A) :- not sensitiveSlogan(A) , answer(A).
