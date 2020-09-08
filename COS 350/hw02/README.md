# Description
This program builds on the previous one, JJ's Jolly Jumping Journey (J5), by adding new twists.

### Twist 1
Each pogo stick p_i has an associated cost c_i , which is a positive integer.
Using p_i for one jump (covering distance d_i ) incurs a cost of c_i . As before, we would like to
enumerate the number of different ways JJ can get to the exit door, as a function of n and
the pogo-stick distances D = (d_1, d_2, ..., d_k ). However, we would also like to keep track of
the cost of each option, given the additional data on costs: C = (c_1, c_2, ..., c_k ). We would
also like to determine if a minimum-cost journey can be computed efficiently. A journey is
way for JJ to travel from the initial position to the exit door. The cost of a journey is the
sum of the costs of the pogo-stick jumps it uses. (Each jump using a pogo stick p_i contributes
c_i to the cost.)

### Twist 2
The pogo-sticks have gone coin-op. Before JJ can use a pogo-stick p_i to cover its jump distance 
d_i , coins totaling c_i must be deposited into the pogo stick.
Luckily, at some points on JJ’s path toward the exit door, there are piles of coins. If a
pogo-stick jump lands exactly on such a pile’s location, JJ gets to pick up all the coins in
that pile. There may also be a pile of coins in JJ’s initial position, which are picked up
automatically. As in the first twist, we would like to enumerate the journeys and associated
costs, and to compute a minimum-cost journey efficiently. The difference is that costs may
now be negative (net profit) as a result of coins picked up along the way. The locations and
values of the piles of coins are specified as a list of pairs G = ((l_1, v_1 ),(l_2, v_2 ), ..., (l_m, v_m)).
JJ always has enough cash on hand to use any pogo stick.
