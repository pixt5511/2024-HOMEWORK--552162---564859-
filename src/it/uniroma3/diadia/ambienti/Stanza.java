package it.uniroma3.diadia.ambienti;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * 
 * @author docente di POO 
 * @see Attrezzo
 * @version base
 */

public class Stanza {

    static final private int NUMERO_MASSIMO_DIREZIONI = 4;
    static final private int NUMERO_MASSIMO_ATTREZZI = 10;

    private String nome;

    private Attrezzo[] attrezzi;
    private int numeroAttrezzi;

    private Stanza[] stanzeAdiacenti;
    private int numeroStanzeAdiacenti;

    private String[] direzioni;

    /**
     * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
     * @param nome il nome della stanza
     */
    public Stanza(String nome) {
        this.nome = nome;
        this.numeroStanzeAdiacenti = 0;
        this.numeroAttrezzi = 0;
        this.direzioni = new String[NUMERO_MASSIMO_DIREZIONI];
        this.stanzeAdiacenti = new Stanza[NUMERO_MASSIMO_DIREZIONI];
        this.attrezzi = new Attrezzo[NUMERO_MASSIMO_ATTREZZI];
    }

    /**
     * Imposta una stanza adiacente.
     *
     * @param direzione direzione in cui sara' posta la stanza adiacente.
     * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
     */
    public void impostaStanzaAdiacente(String direzione, Stanza stanza) {
        for(int i=0; i<this.numeroStanzeAdiacenti; i++) {
            if (direzione.equals(this.direzioni[i])) {
                this.stanzeAdiacenti[i] = stanza;
                return;
            }
        }
        if (this.numeroStanzeAdiacenti < NUMERO_MASSIMO_DIREZIONI) {
            this.direzioni[numeroStanzeAdiacenti] = direzione;
            this.stanzeAdiacenti[numeroStanzeAdiacenti] = stanza;
            this.numeroStanzeAdiacenti++;
        }
    }

    /**
     * Restituisce la stanza adiacente nella direzione specificata
     * @param direzione
     * @return la stanza adiacente nella direzione specificata
     */
    public Stanza getStanzaAdiacente(String direzione) {
        for(int i=0; i<this.numeroStanzeAdiacenti; i++)
            if (direzioni[i].equals(direzione))
                return stanzeAdiacenti[i];
        return null;
    }

    /**
     * Restituisce il nome della stanza.
     * @return il nome della stanza
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Restituisce la descrizione della stanza.
     * @return la descrizione della stanza
     */
    public String getDescrizione() {
        return this.toString();
    }

    /**
     * Restituisce la collezione di attrezzi presenti nella stanza.
     * @return la collezione di attrezzi nella stanza.
     */
    public Attrezzo[] getAttrezzi() {
        return this.attrezzi;
    }

    /**
     * Mette un attrezzo nella stanza.
     * @param attrezzo l'attrezzo da mettere nella stanza.
     * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
     */
    public boolean addAttrezzo(Attrezzo attrezzo) {
        if (this.numeroAttrezzi < NUMERO_MASSIMO_ATTREZZI) {
            this.attrezzi[numeroAttrezzi] = attrezzo;
            this.numeroAttrezzi++;
            return true;
        }
        return false;
    }

    /**
    * Restituisce una rappresentazione stringa di questa stanza,
    * stampando la descrizione, le uscite e gli eventuali attrezzi contenuti
    * @return la rappresentazione stringa
    */
    public String toString() {
        StringBuilder risultato = new StringBuilder();
        risultato.append(this.nome);
        risultato.append("\nUscite: ");
        for (String direzione : this.direzioni) {
            if (direzione != null) {
                risultato.append(" " + direzione);
            }
        }
        risultato.append("\nAttrezzi nella stanza: ");
        for (Attrezzo attrezzo : this.attrezzi) {
            if (attrezzo != null) {
                risultato.append(attrezzo.toString() + " ");
            }
        }
        return risultato.toString();
    }

    /**
    * Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
    * @return true se l'attrezzo esiste nella stanza, false altrimenti.
    */
    public boolean hasAttrezzo(String nomeAttrezzo) {
        for (Attrezzo attrezzo : this.attrezzi) {
            if (attrezzo != null && attrezzo.getNome().equals(nomeAttrezzo))
                return true;
        }
        return false;
    }

    /**
     * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
     * @param nomeAttrezzo
     * @return l'attrezzo presente nella stanza.
     *         null se l'attrezzo non e' presente.
     */
    public Attrezzo getAttrezzo(String nomeAttrezzo) {
        for (Attrezzo attrezzo : this.attrezzi) {
            if (attrezzo != null && attrezzo.getNome().equals(nomeAttrezzo))
                return attrezzo;
        }
        return null;
    }

    /**
     * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
     * @param nomeAttrezzo
     * @return true se l'attrezzo e' stato rimosso, false altrimenti
     */
    public boolean removeAttrezzo(Attrezzo attrezzo) {
        
        return false;
    }

    public String[] getDirezioni() {
        String[] direzioni = new String[this.numeroStanzeAdiacenti];
        for(int i=0; i<this.numeroStanzeAdiacenti; i++)
            direzioni[i] = this.direzioni[i];
        return direzioni;
    }
}
