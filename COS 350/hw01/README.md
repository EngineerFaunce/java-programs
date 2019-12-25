## The main problem
In one phase of the side-scroller game JJ’s Jolly Jumping Journey,
called J5 for short, the objective is to guide the protagonist, JJ, to an exit door that is *n*
meters away from JJ’s initial position. JJ can move only by using a collection of k pogo
sticks: *p_1* ,*p_2*  ,...,*p_k* . Each pogo stick *p_i* is a precision device that will move JJ exactly *d_i*
meters toward the exit (unless it would overshoot, in which case JJ goes splat against a
wall. To be avoided). The pogo sticks all work in just one (forward) direction. Each pogo
stick may be used any number of times. (JJ carries them in a backpack when they are not
being used.) We would like to enumerate the number of different ways JJ can get to the exit
door, as a function of *n* and the pogo-stick distances *D* = (*d_1* ,*d_2* ,...,*d_k* ). For simplicity, we
assume that *n* and *d_i* are all integers and that the *d_i* are all distinct.