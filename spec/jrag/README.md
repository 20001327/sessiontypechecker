#struttura dei packages
- print: contiene il codice per la pretty print del codice, dei session types e dei global types
- erlangtyping: contiene il codice per derivare il tipo dei processi erlang
- subtyping: contiene il codice per il subtyping del codice derivato. Qui si capisce se il codice derivato contiene tutti i session types nel tipo che stiamo checkando (sia esso proiettato dal tipo globale o annotato nel codice)
- projection: contiene il codice per la proiezione dal tipo globale ai session types
- validation: contiene il codice per verificare la buona formatezza di External ed Internal Choice
