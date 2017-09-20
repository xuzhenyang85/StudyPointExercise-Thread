##Week 5 -Thread

###[DAY 1]Exercise 1 (create, start and end threads) GREEN 

a) Forkert rækkeføgle under eksekvering, tråd 2 og 3 blev kaldt skiftevis og stykkevis mens tråd 1 var i gang med at eksekvere. Det viser at hver tråde får en del af cpu tid, programmet printer forskellige tal ud hver mange det ekserverer, hvor resultatet bliver forskellige og ukontrolleret.

b) Der er 3 muligheder for dette: Synchronized Block, Volatile og Lock. Lock keyword kan vi får lov til at låse en af de tråde fast og gemfører tråden færdig, derefter unlock den og videre til de næste tråde.

c) Jeg har valgt at bruge Lock metode til at undgå disse fejler, det sikker sig at trådene kører efter hvad jeg har forventet. Nu er dette kun en test kode, hvor jeg ret sikker på at der blev ikke kastet noget exception midt i nogen af den. Lock metode har løst denne opgave, hvor alle tråde eksekverer som de børt være. 


###Exercise 2 (race condition)

a) Jeg har være meget heldig, efter 3. gange har jeg fået noget forskellige nummer, hvor tråd 1 får to i resultatet, og tråd 2 stadig får 4. Dette er en race condition, hvor flere tråde tilgå i en samme variabel, den variabels opdatering blev tabt.

b) Dette probleme sker meget ofte, når flere tråde blev kørt af den samme variabel.

c) Det fixet ved at brug synchronized Lock i next() metode.

d) Race condition er væk efter jeg har sat synchronized Lock til at låse next() metode. Programmmet kører efter forventningen.  

Exercise 3 (Blocking the GUI-thread)

Der blev lagt en Extends Thread i Ball.java, derefter ændret ball.run() til ball.start(), hvor den starter en tråd for sig selv, og ikke længere blokerer main tråd. Problemet er fixet.


###EExercise 4

###Exercise 5

a) Nope, det endelige resultat er 36369, meget mindre end 40000.

b) count variable gik i tabt.

c) Tilføjet synchronized ved incr() i TurnstileCounter, problemet er løst.

###Exercise 6 (race condition) RED

Der blev tilføjet synchronized i deposit() i BankAccountUnsynchronized.java, og inde i den har jeg tilføjet lock()

###Exercise 1 - Day 2

a) Når vi trækker noget fra andre hjemmesider, samtidlig bruger run-metode er der stort risiko for at blokere vores main tråd, det skal vi helst undgå. 

b) Det er bare en linie kode extends Thread 

c) 
- Her brugt jeg start() i sted for run(), så blev der startet 3 nye tråde op, på denne måde undgå ventetid fra andre hjemmesider. 
- Lige nu returnerer system.out's null eller 0, fordi vi forsøger at printer værdierne ud mens tråde var måske lige startet med eksekving, eller måske kun nået lige blev oprettet. 

- Der mangler bare join() efter tcX.start(). 

d) Den endelige resultatet er performance efter brugt thread, blev resultatet halveret. 


###EExercise 2(Producer-Consumer) 



# StudyPointExercise-Thread