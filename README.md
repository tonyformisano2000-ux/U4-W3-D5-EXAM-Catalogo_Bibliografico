Creata la superclasse Catalogo, la estendo con Riviste e Libri, collegate da un legame di tipo Join.
Creo inoltre le classi Utente e Prestito, legate tra loro con un OneToMany 
(un utente compie diversi ordini, un ordine possiede un solo utente)
Tra Prestito e Catalogo ho utilizzato un legame ManyToMany
(lo storico prestiti di un libro da un lato, e la gamma di libri prestati dall'altro)
