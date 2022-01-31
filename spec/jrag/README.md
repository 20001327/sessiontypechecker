#struttura dei packages
- print: contiene il codice per la pretty print del codice, dei session types e dei global types
- erlangtyping: contiene il codice per derivare il tipo dei processi erlang
- subtyping: contiene il codice per il subtyping del codice derivato. Qui si capisce se il codice derivato contiene tutti i session types nel tipo che stiamo checkando (sia esso proiettato dal tipo globale o annotato nel codice)
- projection: contiene il codice per la proiezione dal tipo globale ai session types
- validation: contiene il codice per verificare la buona formatezza di External ed Internal Choice
- utils/nameAnalisys: codice per creare la symbol table
- utils/equals.jrag: utility di equals per fare il typechecking

#TypeChecking.jadd
codice che deriva e fa partire il checking con il tipo annotato/proiettato
