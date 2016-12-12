package entite;

import entite.Blocage;
import entite.Emprunt;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-12T00:21:37")
@StaticMetamodel(Membre.class)
public class Membre_ { 

    public static volatile SingularAttribute<Membre, Boolean> estAdmin;
    public static volatile SingularAttribute<Membre, String> mail;
    public static volatile CollectionAttribute<Membre, Blocage> blocageCollection;
    public static volatile SingularAttribute<Membre, String> mdp;
    public static volatile SingularAttribute<Membre, Integer> membreId;
    public static volatile SingularAttribute<Membre, String> nom;
    public static volatile SingularAttribute<Membre, String> prenom;
    public static volatile CollectionAttribute<Membre, Emprunt> empruntCollection;

}