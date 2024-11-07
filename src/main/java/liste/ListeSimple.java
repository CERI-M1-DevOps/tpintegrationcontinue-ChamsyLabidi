package liste;

public class ListeSimple {
    private long size;
    Noeud tete;

    /**
     * Retourne la taille de la liste
     * @return la taille de la liste
     */
    public long getSize() {
        return size;
    }

    /**
     * Methode qui permet d'ajouter un element dans la liste
     * @param element
     */
    public void ajout(int element) {
        tete = new Noeud(element, tete);
        size++;
    }

    /**
     * Methode qui modifie le premier element trouvé de la liste avec la nouvelle valeur
     * @param element element a modifier
     * @param nouvelleValeur nouvelle valeur de l'element a modifier
     */
    public void modifiePremier(Object element, Object nouvelleValeur) {
        Noeud courant = tete;
        while (courant != null && courant.getElement() != element)
            courant = courant.getSuivant();
        if (courant != null)
            courant.setElement(nouvelleValeur);
    }

    /**
     * Methode qui modifie tous les elements trouvé de la liste avec la nouvelle valeur
     * @param element
     * @param nouvelleValeur
     */
    public void modifieTous(Object element, Object nouvelleValeur) {
        Noeud courant = tete;
        while (courant != null) {
            if (courant.getElement() == element)
                courant.setElement(nouvelleValeur);
            courant = courant.getSuivant();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ListeSimple(");
        Noeud n = tete;
        while (n != null) {
            sb.append(n);
            n = n.getSuivant();
            if (n != null)
                sb.append(", ");
        }
        sb.append(")");
        return sb.toString();
    }

    public void supprimePremier(Object element) {
        if (tete != null) {
            if (tete.getElement() == element) {
                tete = tete.getSuivant();
                size--;
                return;
            }
            Noeud precedent = tete;
            Noeud courant = tete.getSuivant();
            while (courant != null && courant.getElement() != element) {
                precedent = precedent.getSuivant();
                courant = courant.getSuivant();
            }
            if (courant != null) {
                precedent.setSuivant(courant.getSuivant());
                size--;
            }
        }
    }

    public void supprimeTous(int element) {
       tete = supprimeTousRecurs(element, tete);
    }

    public Noeud supprimeTousRecurs(Object element, Noeud tete) {
        if (tete != null) {
            Noeud suiteListe = supprimeTousRecurs(element, tete.getSuivant());
            if (tete.getElement() == element) {
                size--;
                return suiteListe;
            } else {
                tete.setSuivant(suiteListe);
                return tete;
            }
        } else return null;
    }

    public Noeud getAvantDernier() {
        if (tete == null || tete.getSuivant() == null)
            return null;
        else {
            Noeud courant = tete;
            Noeud suivant = courant.getSuivant();
            while (suivant.getSuivant() != null) {
                courant = suivant;
                suivant = suivant.getSuivant();
            }
            return courant;
        }
    }

    public void inverser() {
        Noeud precedent = null;
        Noeud courant = tete;
        while (courant != null) {
            Noeud next = courant.getSuivant();
            courant.setSuivant(precedent);
            precedent = courant;
            courant = next;
        }
        tete = precedent;
    }

    public Noeud getPrecedent(Noeud r) {
        if (r == tete) {
            return null;
        }
        Noeud precedent = tete;
        Noeud courant = precedent.getSuivant();
        while (courant != null && courant != r) {
            precedent = courant;
            courant = courant.getSuivant();
        }
        if (courant == r) {
            return precedent;
        } else {
            return null;
        }
    }    

    public void echanger(Noeud r1, Noeud r2) {
        if (r1 == r2) return;
    
        Noeud precedentR1 = getPrecedent(r1);
        Noeud precedentR2 = getPrecedent(r2);
    
        if (precedentR1 != null) {
            precedentR1.setSuivant(r2);
        } else {
            tete = r2;
        }
    
        if (precedentR2 != null) {
            precedentR2.setSuivant(r1);
        } else {
            tete = r1;
        }
    
        Noeud temp = r1.getSuivant();
        r1.setSuivant(r2.getSuivant());
        r2.setSuivant(temp);
    }
    

}